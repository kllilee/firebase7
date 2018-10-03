package com.example.likunlin.firebase7

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_webview.*
import android.webkit.WebViewClient



class webview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        val webview_setting = webview_1.settings
        webview_setting.javaScriptEnabled = true
        webview_1.webViewClient=WebViewClient()
        webview_1.loadUrl("http://www.google.com.tw")


    }
}
