package com.example.textscanner;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class More_Actions extends AppCompatActivity {

    EditText tr;
    TextToSpeech mkspeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_actions);

        tr = findViewById(R.id.edit_data1);
        String toscan = getIntent().getStringExtra("scanned");
        tr.setText(toscan);

        mkspeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR)
                    mkspeech.setLanguage(Locale.ENGLISH);
            }
        });
    }
    public void convert(View view) {
        String tospeak = tr.getText().toString();
        mkspeech.speak(tospeak,TextToSpeech.QUEUE_FLUSH,null);
    }
}
