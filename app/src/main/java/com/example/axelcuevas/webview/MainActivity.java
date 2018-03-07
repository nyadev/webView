package com.example.axelcuevas.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner correos;
    private WebView page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        correos = findViewById(R.id.spinner);
        page = findViewById(R.id.vieww);
        page.getSettings().setBuiltInZoomControls(true);

        ArrayAdapter<CharSequence> data = ArrayAdapter.createFromResource(this,R.array.pages, android.R.layout.simple_spinner_dropdown_item);
        data.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        correos.setAdapter(data);
        correos.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i){
            case 0:
                page.loadUrl("https://www.facebook.com/");
                break;
            case 1:
                page.loadUrl(" https://outlook.live.com");
                break;
            case 2:
                page.loadUrl("https://login.yahoo.com");
                break;
        }
        setContentView(page);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
