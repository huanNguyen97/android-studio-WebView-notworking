package com.example.webviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // initialize data
    WebView simpleWebView;
    Button loadWebPage, loadFromStaticHtml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize buttons and a web view
        loadFromStaticHtml = findViewById(R.id.loadFromStaticHtml);
        loadFromStaticHtml.setOnClickListener(this);
        loadWebPage = findViewById(R.id.loadWebPage);
        loadWebPage.setOnClickListener(this);
        simpleWebView = findViewById(R.id.simpleWebView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loadFromStaticHtml:
                String customHtml =  "<html><body><h1>Hello, AbhiAndroid</h1>" +
                    "<h1>Heading 1</h1><h2>Heading 2</h2><h3>Heading 3</h3>" +
                    "<p>This is a sample paragraph of static HTML In Web view</p>" +
                    "</body></html>";
                simpleWebView.loadData(customHtml, "text/html", "UTF-8");
                break;
            case R.id.loadWebPage:
                simpleWebView.setWebViewClient(new MyWebViewClient());
                String url = "http://abhiandroid.com/ui/";
                simpleWebView.getSettings().setJavaScriptEnabled(true);
                simpleWebView.loadUrl(url);
                break;
        }
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}