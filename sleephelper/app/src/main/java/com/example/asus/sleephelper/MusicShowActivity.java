package com.example.asus.sleephelper;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MusicShowActivity extends AppCompatActivity implements OnSeekBarChangeListener {
    String[] songName={"Born a Stranger","木陰","Dazing","Drip Drip Drip","Floating in the City","dear sleeper","微睡む月の夜のアリア 竖琴ver","夜空的寂静"};
    String[] singer={"Kan R. Gao","いろのみ","音乐治疗","音乐治疗","音乐治疗","Chima","Meandi鸦缺","赵海洋"};
    int [] icons={R.drawable.pone,R.drawable.ptwo,R.drawable.pthree,R.drawable.pthree,R.drawable.pthree,R.drawable.pfour,R.drawable.pfive,R.drawable.psix};
    int [] song={R.raw.music1,R.raw.music2,R.raw.music3,R.raw.music4,R.raw.music5,R.raw.music6,R.raw.music7,R.raw.music8};
    private TextView title,author,tvCurrentTime,tvTotalTime;
    private ImageView songpicture;
    private Button last,onoff,next;
    private Boolean isPause=false;
    private MediaPlayer mediaPlayer;
    private RelativeLayout relativeLayout;
    private Drawable drawableBack,drawableDisc;
    private ObjectAnimator animator;
    int songNum;
    int songCurrentTime,songTotalTime;
    int process=0;
    private int seekWidth=150;
    private int seekHeight=150;
    private SeekBar seekBar;
    Timer timer = new Timer();
    TimerTask task=new MyTimerTask();
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicshow);
        title=(TextView)findViewById(R.id.title);
        author=(TextView)findViewById(R.id.author);
        songpicture=(ImageView)findViewById(R.id.disc);
        last=(Button)findViewById(R.id.last);
        onoff=(Button)findViewById(R.id.onoff);
        next=(Button)findViewById(R.id.next);
        seekBar=(SeekBar)findViewById(R.id.musicSeekBar);
        relativeLayout=(RelativeLayout)findViewById(R.id.rootLayout);
        tvCurrentTime=(TextView)findViewById(R.id.tvCurrentTime);
        tvTotalTime=(TextView)findViewById(R.id.tvTotalTime);
        //滚动条上的点图形
        Drawable drawable = getNewDrawable(MusicShowActivity.this,R.drawable.ic_seekbar_thumb, seekWidth, seekHeight);
        seekBar.setThumb(drawable);
        Intent intent=getIntent();
        songNum=intent.getIntExtra("num",0);
        //播放背景图
        Bitmap  bmp = BitmapFactory.decodeResource(getResources(),icons[songNum]);
        Bitmap backPicture=BlurUtil.doBlur(bmp,20,15);
        drawableBack = new BitmapDrawable(backPicture);
        relativeLayout.setBackground(drawableBack);
        //唱片图
        Bitmap  discBitmap=BitmapFactory.decodeResource(getResources(),R.drawable.ic_disc);
        Bitmap  thumbBitmap=BitmapFactory.decodeResource(getResources(),icons[songNum]);
        Bitmap  bm=MergeImage.mergeThumbnailBitmap(discBitmap,thumbBitmap);
        drawableDisc=new BitmapDrawable(bm);
        songpicture.setBackground(drawableDisc);
        //唱片旋转
        animator = ObjectAnimator.ofFloat(songpicture,"rotation", 0f, 360.0f);
        animator.setDuration(10000);
        animator.setInterpolator(new LinearInterpolator());//匀速
        animator.setRepeatCount(-1);//设置动画重复次数（-1代表一直转）
        animator.setRepeatMode(ValueAnimator.RESTART);//动画重复模式
        animator.start();
        //其他
        title.setText(songName[songNum]);
        author.setText(singer[songNum]);
        seekBar.setOnSeekBarChangeListener(this);
        //播放音乐
        mediaPlayer = MediaPlayer.create(this, song[songNum]);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setVolume(1.0f, 1.0f);
        mediaPlayer.start();
        //滚动条
        songTotalTime=mediaPlayer.getDuration();
        tvTotalTime.setText(duration2Time(songTotalTime));
        tvCurrentTime.setText("00:00");
        timer.schedule(task,0,1000);
        //上一首/下一首/播放暂停
        last.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                last();
            }
        });
        onoff.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                if(isPause) {
                    onoff.setBackgroundResource(R.drawable.ic_pause);
                    ON();
                    isPause=false;
                }
                else
                {
                    onoff.setBackgroundResource(R.drawable.ic_play);
                    OFF();
                    isPause=true;
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                next();
            }
        });
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(progress==500){
           next();
           return;
        }
        songCurrentTime=progress*songTotalTime/500;
        tvCurrentTime.setText(duration2Time(songCurrentTime));
        if(fromUser) {
            mediaPlayer.seekTo(songCurrentTime);
        }
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    private String duration2Time(int duration) {
        int min = duration / 1000 / 60;
        int sec = duration / 1000 % 60;
        return (min < 10 ? "0" + min : min + "") + ":" + (sec < 10 ? "0" + sec : sec + "");
    }

    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer=null;
        timer.cancel();
    }

    public void lastSongNum()
    {
        if(songNum==0) songNum=songName.length-1;
        else songNum=songNum-1;
    }

    public void nextSongNum()
    {
        if(songNum==songName.length-1) songNum=0;
        else songNum=songNum+1;
    }

    public void OFF()
    {
        if(mediaPlayer!=null&&mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            animator.pause();
        }
    }

    public void ON()
    {
        if(mediaPlayer!=null) {
            int position=mediaPlayer.getCurrentPosition();
            mediaPlayer.seekTo(position);
            mediaPlayer.start();
            animator.resume();
        }
    }

    public void last()
    {
        timer.cancel();
        timer=null;
        task.cancel();
        task=null;
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer=null;
        lastSongNum();
        //播放背景图
        Bitmap  bmp = BitmapFactory.decodeResource(getResources(),icons[songNum]);
        Bitmap backPicture=BlurUtil.doBlur(bmp,20,15);
        drawableBack = new BitmapDrawable(backPicture);
        relativeLayout.setBackground(drawableBack);
        //唱片图
        Bitmap  discBitmap=BitmapFactory.decodeResource(getResources(),R.drawable.ic_disc);
        Bitmap  thumbBitmap=BitmapFactory.decodeResource(getResources(),icons[songNum]);
        Bitmap bm=MergeImage.mergeThumbnailBitmap(discBitmap,thumbBitmap);
        drawableDisc=new BitmapDrawable(bm);
        songpicture.setBackground(drawableDisc);
        //唱片旋转
        animator.setDuration(10000);
        animator.setInterpolator(new LinearInterpolator());//匀速
        animator.setRepeatCount(-1);//设置动画重复次数（-1代表一直转）
        animator.setRepeatMode(ValueAnimator.RESTART);//动画重复模式
        animator.start();
        //其他
        title.setText(songName[songNum]);
        author.setText(singer[songNum]);
        onoff.setBackgroundResource(R.drawable.ic_pause);
        isPause=false;
        mediaPlayer=MediaPlayer.create(this,song[songNum]);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setVolume(1.0f, 1.0f);
        mediaPlayer.start();
        //滚动条
        songTotalTime=mediaPlayer.getDuration();
        tvTotalTime.setText(duration2Time(songTotalTime));
        seekBar.setProgress(0);
        timer=new Timer();
        task=new MyTimerTask();
        timer.schedule(task,0,1000);
        tvCurrentTime.setText("00:00");
    }

    public void next()
    {
        timer.cancel();
        timer=null;
        task.cancel();
        task=null;
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer=null;
        nextSongNum();
        //播放背景图
        Bitmap  bmp = BitmapFactory.decodeResource(getResources(),icons[songNum]);
        Bitmap backPicture=BlurUtil.doBlur(bmp,20,15);
        drawableBack = new BitmapDrawable(backPicture);
        relativeLayout.setBackground(drawableBack);
        //唱片图
        Bitmap  discBitmap=BitmapFactory.decodeResource(getResources(),R.drawable.ic_disc);
        Bitmap  thumbBitmap=BitmapFactory.decodeResource(getResources(),icons[songNum]);
        Bitmap bm=MergeImage.mergeThumbnailBitmap(discBitmap,thumbBitmap);
        drawableDisc=new BitmapDrawable(bm);
        songpicture.setBackground(drawableDisc);
        //唱片旋转
        animator.setDuration(10000);
        animator.setInterpolator(new LinearInterpolator());//匀速
        animator.setRepeatCount(-1);//设置动画重复次数（-1代表一直转）
        animator.setRepeatMode(ValueAnimator.RESTART);//动画重复模式
        animator.start();
        //其他
        title.setText(songName[songNum]);
        author.setText(singer[songNum]);
        onoff.setBackgroundResource(R.drawable.ic_pause);
        isPause=false;
        mediaPlayer=MediaPlayer.create(this,song[songNum]);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setVolume(1.0f, 1.0f);
        mediaPlayer.start();
        //滚动条
        songTotalTime=mediaPlayer.getDuration();
        tvTotalTime.setText(duration2Time(songTotalTime));
        seekBar.setProgress(0);
        timer=new Timer();
        task=new MyTimerTask();
        timer.schedule(task,0,1000);
        tvCurrentTime.setText("00:00");
    }

    public BitmapDrawable getNewDrawable(Activity context, int restId, int dstWidth, int dstHeight){
        Bitmap Bmp = BitmapFactory. decodeResource(context.getResources(), restId);
        Bitmap bmp = Bmp.createScaledBitmap(Bmp, dstWidth, dstHeight, true);
        BitmapDrawable d = new BitmapDrawable(bmp);
        Bitmap bitmap = d.getBitmap();
        if (bitmap.getDensity() == Bitmap.DENSITY_NONE) {
            d.setTargetDensity(context.getResources().getDisplayMetrics());
        }
        return d;
    }
    class MyTimerTask extends TimerTask{
        @Override
        public void run() {
            songCurrentTime=mediaPlayer.getCurrentPosition();
            process=(int)(((double)songCurrentTime/(double)songTotalTime)*500);
            seekBar.setProgress(process);
        }
    }

}
