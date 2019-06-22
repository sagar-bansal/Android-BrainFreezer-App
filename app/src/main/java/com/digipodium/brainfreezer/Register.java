package com.digipodium.brainfreezer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class Register extends AppCompatActivity {

    private EditText email2;
    private EditText password2;
    private TextView error2;
    private Button btnregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email2 = findViewById(R.id.email2);
        password2 = findViewById(R.id.password2);
        error2 = findViewById(R.id.error2);
        btnregister = findViewById(R.id.btnregister);


             btnregister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email=email2.getText().toString();
                    String pass=password2.getText().toString();
                    if(!email.isEmpty() && email.contains("@")&&email.contains(".com")&& !pass.isEmpty()&& pass.length()>7) {
                        FirebaseAuth fbase = FirebaseAuth.getInstance();
                        fbase.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.getException()==null){
                                    FirebaseUser user=task.getResult().getUser();
                                    //String username=username2.getText().toString();
                                    //user.updateProfile(new UserProfileChangeRequest.Builder().setDisplayName(username).build());
                                    updateUI(user);
                                }
                                else {
                                    try {
                                        String error = task.getException().getMessage();
                                        error2.setText((error));
                                        updateUI(null);
                                    }
                                    catch(Exception e)
                                    {
                                        Toast.makeText(Register.this, "e", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        });
                    }
                    else
                    {
                        error2.setText("please enter valid email and password");

                    }
                }
            });
        }
        @Override
        protected void onStart() {
            super.onStart();
            FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
            updateUI(user);
        }
        private void updateUI(FirebaseUser user) {
            if(user!=null){
                startActivity(new Intent(this,QuizCategory.class));
                finish();
            }





}}
