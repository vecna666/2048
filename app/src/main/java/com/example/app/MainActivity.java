package com.example.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    private WebView mWebView;
    private WebSettings mWebSettings;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = findViewById(R.id.activity_main_webview);
        mWebSettings = mWebView.getSettings();

        // Configure WebView settings
        configureWebViewSettings();

        // Load the web page
        loadWebPage();

        mWebView.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Lock screen orientation to landscape
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    private void configureWebViewSettings() {
        mWebSettings.setJavaScriptEnabled(true);
        mWebSettings.setDatabaseEnabled(true);
        mWebSettings.setDomStorageEnabled(true);
        mWebSettings.setSupportMultipleWindows(false);
        mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        mWebSettings.setLoadWithOverviewMode(true);
        mWebSettings.setUseWideViewPort(true);
        mWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        mWebSettings.setBuiltInZoomControls(true);
        mWebSettings.setSupportZoom(true);
        mWebSettings.setDisplayZoomControls(false);
        mWebSettings.setSavePassword(true);
        mWebSettings.setSaveFormData(true);
        mWebSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(false);
        mWebSettings.setEnableSmoothTransition(true);
        mWebSettings.setMediaPlaybackRequiresUserGesture(true);

        // Enable hardware acceleration
        mWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
    }

    private void loadWebPage() {
        // REMOTE RESOURCE
        // mWebView.loadUrl("https://github.com");

        // LOCAL RESOURCE
        mWebView.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
