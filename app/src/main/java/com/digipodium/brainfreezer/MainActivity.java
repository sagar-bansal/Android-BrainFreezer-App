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

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button login;
    private TextView signup;
    private TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email2);
        password = findViewById(R.id.password2);
        login = findViewById(R.id.btnlogin);
        signup = findViewById(R.id.signup);
        error = findViewById(R.id.error);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email3=email.getText().toString();
                String pass=password.getText().toString();

                if(!email3.isEmpty() && email3.contains("@")&&email3.contains(".com")&& !pass.isEmpty()&& pass.length()>7) {
                    FirebaseAuth fbase = FirebaseAuth.getInstance();
                    fbase.signInWithEmailAndPassword(email3, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.getException()==null){
                                FirebaseUser user=task.getResult().getUser();
                                updateUI(user);
                            }
                            else {
                                try{
                                    String error3=task.getException().getMessage();
                                    error.setText((error3));
                                    updateUI(null);
                                }
                                catch (Exception e)
                                {
                                    Toast.makeText(MainActivity.this, "gggg", Toast.LENGTH_SHORT).show();
                                }


                            }

                        }
                    });
                }
                else
                {
                    error.setText("please enter valid email and password");

                }
            }
        });




    }
    private void updateUI(FirebaseUser user) {
        //if user object is not null,use intent to take him to home activity
        //else dont do anything
        if(user!=null){
            startActivity(new Intent(this,QuizCategory.class));
            finish();
        }

    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        updateUI(user);
    }



}
