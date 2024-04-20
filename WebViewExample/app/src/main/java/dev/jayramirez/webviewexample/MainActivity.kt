package dev.jayramirez.webviewexample

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the WebView by its id
        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true


        // Load a web page
        val url = "https://www.jayramirez.dev"
        webView.loadUrl(url)
    }
}