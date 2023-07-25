package dev.b3nedikt.restring.example

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.widget.ContentFrameLayout
import androidx.fragment.app.Fragment
import dev.b3nedikt.app_locale.AppLocale
import dev.b3nedikt.restring.Restring
import dev.b3nedikt.reword.Reword


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        AppLocale.supportedLocales.forEach { locale ->
            Restring.putStrings(locale, ExampleStringsGenerator.getStrings(locale))
            Restring.putQuantityStrings(locale, ExampleStringsGenerator.getQuantityStrings(locale))
            Restring.putStringArrays(locale, ExampleStringsGenerator.getStringArrays(locale))
        }

        val webView = view.findViewById<WebView>(R.id.webview)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select")

    }
}