package com.example.anna.translatetry5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    String sourceLang = "en";
    String targetLang = "fr";
    TextView tv_output;
    EditText et_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_output = (TextView) findViewById(R.id.tv_output);
        et_input = (EditText) findViewById(R.id.et_input);
    }

    public void onClick() {
        String text = et_input.getText().toString();

        tv_output.setText(GoogleTranslate.translateText(text, sourceLang, targetLang));
    }
}
