package sg.edu.rp.dmsd.p12rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SecondActivity extends AppCompatActivity {

    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        wv = findViewById(R.id.WebView);
        wv.setWebViewClient(new WebViewClient());
        Intent intent = getIntent();
        String s = intent.getStringExtra("website");
        wv.loadUrl(s);
    }
}
