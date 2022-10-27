package edu.temple.basicbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    lateinit var urlEditText: EditText
    lateinit var goButton: ImageButton
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        urlEditText = findViewById(R.id.urlEditText)
        goButton = findViewById(R.id.goButton)
        webView = findViewById(R.id.webView)

        webView.settings.javaScriptEnabled = true
        // Allow your browser to intercept hyperlink clicks
        webView.webViewClient = WebViewClient()

    }

    // nafire22
    goButton.setOnClickListener() {
        // fix url in address bar
        urlEditText.text = fixUrl(urlEditText.text.toString())
        // load the url
        webView.loadUrl(fixUrl(urlEditText.text.toString()))
    }

    // lduran2
    fun fixUrl(url : String) =
        // if protocol on URL, return URL
        if (url.contains(":"))
            url
        else
            // if not, append https protocol
            StringBuilder()
                .append("https://")
                .append(url)
                .toString()

}