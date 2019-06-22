package com.digipodium.brainfreezer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class history extends AppCompatActivity {

    int score=0;
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);


        Button submit=findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1.getText().toString().equalsIgnoreCase("Malik"))
                score++;
                if(et2.getText().toString().equalsIgnoreCase("geometry"))
                score++;
                if(et3.getText().toString().equalsIgnoreCase("ustad mansur"))
                score++;
                if(et4.getText().toString().equalsIgnoreCase("1858"))
                score++;


                Intent intent=new Intent(history.this,MainActivity.class);
                Toast.makeText(history.this, "Your score is  ::::  "+score, Toast.LENGTH_SHORT).show();


                startActivity(intent);


            }
        });





    }
}
