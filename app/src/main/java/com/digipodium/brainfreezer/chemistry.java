package com.digipodium.brainfreezer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class chemistry extends AppCompatActivity {

    private EditText a;
    private EditText a1;
    private EditText a2;
    private EditText a3;
    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemistry);
        a = findViewById(R.id.a);
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a3);
        a3 = findViewById(R.id.a4);
        Button btnsub=findViewById(R.id.btnsubmit);
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a.getText().toString().equalsIgnoreCase("molality"))
                    score++;
                if(a2.getText().toString().equalsIgnoreCase("fluorine"))
                    score++;
                if(a.getText().toString().equalsIgnoreCase("fe"))
                    score++;
                if(a.getText().toString().equalsIgnoreCase("smelting"))
                    score++;
                Toast.makeText(chemistry.this, "Your Score is"+score, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(chemistry.this,QuizCategory.class));
            }
        });

    }
}
