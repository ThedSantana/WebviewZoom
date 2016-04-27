package com.bluelife.test.webviewzoom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.WebView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView= (WebView) findViewById(R.id.webView);
        initWebView();
    }

    private void initWebView(){
        webView.getSettings().setBuiltInZoomControls(true);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.destroy();
        //this also cause crash.
        //webView.getSettings().setBuiltInZoomControls(false);

        //the right way to destroy webview and release resource.
        /*long timeout = ViewConfiguration.getZoomControlsTimeout();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                webView.destroy();
            }
        }, timeout);*/

    }
}
