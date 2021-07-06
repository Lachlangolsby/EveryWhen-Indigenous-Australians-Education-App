package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {

    //Initialise Variables
    private EditText accountEmail;
    private Button resetPassword;
    private Button cancelReset;
    private ProgressBar resetProgress;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        //Set Page Title
        setTitle("Forgot Password");

        accountEmail = (EditText) findViewById(R.id.accountEmail);
        resetPassword = (Button) findViewById(R.id.resetPassword);
        cancelReset = (Button) findViewById(R.id.cancelReset);
        resetProgress = (ProgressBar) findViewById(R.id.resetProgress);

        mAuth = FirebaseAuth.getInstance();

        //Set OnClickListeners for clickable objects
        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPassword();
            }
        });

        cancelReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }

    private void forgotPassword(){
        //Get Inputs
        String email = accountEmail.getText().toString().trim().toLowerCase();

        //Check for Errors
        //Check that an Email was Provided
        if (email.isEmpty()){
            accountEmail.setError("Email Required");
            accountEmail.requestFocus();
            return;
        }

        //Check that a Valid Email was Provided
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            accountEmail.setError("Valid Email is Required");
            accountEmail.requestFocus();
            return;
        }

        //Show progress bar as processing begins
        resetProgress.setVisibility(View.VISIBLE);
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    //once processing is complete hide progress bar
                    resetPassword.setVisibility(View.GONE);

                    //provide user feedback & instructions
                    Toast.makeText(ResetPassword.this, "Password Reset Email Sent", Toast.LENGTH_LONG).show();

                    //Redirect User to Login Screen
                    Intent intent = new Intent(ResetPassword.this, Login.class);
                    startActivity(intent);
                } else {
                    //once processing is complete hide progress bar
                    resetProgress.setVisibility(View.GONE);

                    //provide user with error message
                    Toast.makeText(ResetPassword.this, "An Error Has Occurred!!! Please Try Again!!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //Direct user back to the login page
    private void cancel(){
        Intent intent = new Intent(ResetPassword.this, Login.class);
        startActivity(intent);
    }
}