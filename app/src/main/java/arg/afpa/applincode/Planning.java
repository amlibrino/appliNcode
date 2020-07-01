package arg.afpa.applincode;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.HashMap;
import java.util.Map;

public class Planning extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        webView = (WebView) findViewById(R.id.webview);

        webView.setWebViewClient(getWebViewClient());
        webView.loadUrl("https://ncode.amorce.org/offre/planning//");
        WebSettings webSettings = webView.getSettings();


    }
    // d'abord créer une méthode, qui sera le retour de vos en-têtes que vous souhaitez ajouter à la demande:
    private Map<String, String> getCustomHeaders()
    {
        Map<String, String> headers = new HashMap<>();
        headers.put("AFPA-TOKEN-API-AUTH", "pcS50ha7RIOUAM3vM3P1Lib0OcZm090ua4qi8hNVtALOcpMapWGSgAXZEYHTJ8ZZLxtJl07ODoSul0nC");
        return headers;
    }

    //Deuxièmement, vous devez créer WebViewClient:

    private WebViewClient getWebViewClient()
    {

        return new WebViewClient()
        {

            @Override
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request)
            {
                view.loadUrl(request.getUrl().toString(), getCustomHeaders());
                return true;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                view.loadUrl(url, getCustomHeaders());
                return true;
            }
        };
    }
}
