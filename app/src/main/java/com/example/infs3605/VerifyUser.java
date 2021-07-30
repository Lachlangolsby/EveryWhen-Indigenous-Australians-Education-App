package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class VerifyUser extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText verifyEmail;
    private EditText verifyPassword;
    private Button verifyDetails;
    private Button cancelVerification;
    private ProgressBar verifyProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_user);

        mAuth = FirebaseAuth.getInstance();
        verifyEmail = findViewById(R.id.verifyEmail);
        verifyPassword = findViewById(R.id.verifyPassword);
        verifyDetails = findViewById(R.id.verify);
        cancelVerification = findViewById(R.id.verifyCancel);
        verifyProgress = findViewById(R.id.verifyProgress);

        //Set Button OnClickListeners
        verifyDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userVerification();
            }
        });

        cancelVerification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backtoProfile = new Intent(VerifyUser.this, Profile.class);
                startActivity(backtoProfile);
            }
        });
    }

    private void userVerification(){

        //Get inputs
        String email = verifyEmail.getText().toString().toLowerCase().trim();
        String password = verifyPassword.getText().toString().trim();

        //Check that Email was Provided
        if (email.isEmpty()){
            verifyEmail.setError("Email is Required");
            verifyEmail.requestFocus();
            return;
        }

        //Check that a Valid Email was Provided
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            verifyEmail.setError("Valid Email is Required");
            verifyEmail.requestFocus();
            return;
        }

        //Check that Password was Provided
        if (password.isEmpty()){
            verifyPassword.setError("Password is Required");
            verifyPassword.requestFocus();
            return;
        }

        //Once required checks are done - show progress bar
        verifyProgress.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser loginUser = FirebaseAuth.getInstance().getCurrentUser();

                    //Once processing is complete hide progress bar
                    verifyProgress.setVisibility(View.GONE);

                    Intent passwordChange = new Intent(VerifyUser.this, PasswordChange.class);
                    startActivity(passwordChange);

                } else{
                    //Once processing is complete hide progress bar
                    verifyProgress.setVisibility(View.GONE);

                    //Display error message
                    Toast.makeText(VerifyUser.this, "Verification Failed!!! Try Again!!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}