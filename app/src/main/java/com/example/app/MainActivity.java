package com.example.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {

    private WebView mWebView;

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = findViewById(R.id.activity_main_webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new MyWebViewClient());
        webSettings.setdatabaseEnabled(true)
        webSettings.domStorageEnabled(true)
        webSettings.setSupportMultipleWindows(false)
        // Zooms out the content to fit on screen by width. For example, showing images.
        webSettings.layoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING)
        webSettings.loadWithOverviewMode(true)
        webSettings.useWideViewPort(true)

        // REMOTE RESOURCE
         mWebView.loadUrl("https://github.com");

        // LOCAL RESOURCE
        // mWebView.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
