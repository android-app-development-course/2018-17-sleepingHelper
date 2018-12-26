package com.example.asus.sleephelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webActivity extends AppCompatActivity{
    private WebView webView;
    public static String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web1);

        webView=(WebView)findViewById(R.id.web_1);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //重写shouldOverrideUrlLoading方法，使点击链接后不使用其他的浏览器打开。
                view.loadUrl(url);
                return true;//如果不需要其他对点击链接事件的处理返回true，否则返回false
            }
        });

        WebSettings settings = webView.getSettings();
        settings.setAllowContentAccess(true);
        settings.setAppCacheEnabled(false);
        settings.setUseWideViewPort(true);//设定支持viewport
        settings.setLoadWithOverviewMode(true);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);//设定支持缩放
        settings.setDomStorageEnabled(true);//开启DOM storage API
        settings.setJavaScriptEnabled(true);//开启js

        //打开的网址
        webView.loadUrl(webActivity.url);
    }
}

