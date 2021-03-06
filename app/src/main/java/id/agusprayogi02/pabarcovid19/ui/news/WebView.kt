package id.agusprayogi02.pabarcovid19.ui.news

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog
import id.agusprayogi02.pabarcovid19.R
import id.agusprayogi02.pabarcovid19.session.CountryData
import id.agusprayogi02.pabarcovid19.util.CustomProgressBar
import id.agusprayogi02.pabarcovid19.util.tampilToast
import kotlinx.android.synthetic.main.activity_web_view.*

class WebView : AppCompatActivity() {
    private val progressBar: CustomProgressBar = CustomProgressBar()
    private var URL:String = ""

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        URL = CountryData["urlNews"]!!
        url_web_view.text = URL
        btn_arrow_back.setOnClickListener {
            finish()
        }
        val webView = webview
        webView.settings.loadWithOverviewMode = true
        webView.settings.javaScriptEnabled = true
        webView.settings.defaultFontSize = 13
        webView.isVerticalScrollBarEnabled = true
        progressBar.show(this,"Memuat...")
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                if (Uri.parse(url).host == CountryData["source"]) {
                    // This is my web site, so do not override; let my WebView load the page
                    return false
                }
                // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
                Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                    startActivity(this)
                }
                finish()
                return true
            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                if(progressBar.dialog!!.isShowing){
                    progressBar.dialog!!.dismiss()
                }
                tampilToast(this@WebView, "Error: Waktu Reload Habis")
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.dialog!!.dismiss()
            }
        }
        webView.loadUrl(URL)
    }
}
