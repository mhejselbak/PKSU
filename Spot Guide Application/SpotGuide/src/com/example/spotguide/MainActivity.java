package com.example.spotguide;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
 
       WebView myWebView = (WebView) findViewById(R.id.webview);
       myWebView.loadUrl("http://kennethchristensen.dk/spotguiden/");
       //myWebView.loadUrl("http://dbw.diku.dk/~hsx578/spotguide/");
       
       WebSettings webSettings =  myWebView.getSettings();
       webSettings.setJavaScriptEnabled(true);
       
       myWebView.setWebViewClient(new WebViewClient());
 
    }
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		 WebView myWebView = (WebView) findViewById(R.id.webview);
		 
	    // Check if the key event was the Back button and if there's history
	    if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
	        myWebView.goBack();
	        return true;
	    }
	    else  if ((keyCode == KeyEvent.KEYCODE_FORWARD) && myWebView.canGoForward()) {
	        myWebView.goForward();
	        return true;
	    }
	    // If it wasn't the Back key or there's no web page history, bubble up to the default
	    // system behavior (probably exit the activity)
	    return super.onKeyDown(keyCode, event);
	}
}
