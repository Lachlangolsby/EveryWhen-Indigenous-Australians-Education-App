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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    //Initialise Variables
    private EditText loginEmail;
    private EditText loginPassword;
    private TextView forgotPassword;
    private TextView signUp;
    private Button loginButton;
    private Button backButton;
    private ProgressBar loginProgress;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Set Page Title
        setTitle("Login");

        //Assign Variables
        mAuth = FirebaseAuth.getInstance();
        loginEmail = (EditText) findViewById(R.id.loginEmail);
        loginPassword = (EditText) findViewById(R.id.loginPassword);
        forgotPassword = (TextView) findViewById(R.id.forgotPassword);
        signUp = (TextView) findViewById(R.id.signUp);
        loginButton = (Button) findViewById(R.id.loginButton);
        backButton = (Button) findViewById(R.id.backButton);
        loginProgress = (ProgressBar) findViewById(R.id.loginProgress);

        //Set OnClickListeners for buttons
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginVerification();
            }
        });

        /*
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain();
            }
        });
         */

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    private void loginVerification(){

        //Get inputs
        String email = loginEmail.getText().toString().toLowerCase().trim();
        String password = loginPassword.getText().toString().trim();

        //Check that Email was Provided
        if (email.isEmpty()){
            loginEmail.setError("Email is Required");
            loginEmail.requestFocus();
            return;
        }

        //Check that a Valid Email was Provided
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            loginEmail.setError("Valid Email is Required");
            loginEmail.requestFocus();
            return;
        }

        //Check that Password was Provided
        if (password.isEmpty()){
            loginPassword.setError("Password is Required");
            loginPassword.requestFocus();
            return;
        }

        //Once required checks are done - show progress bar
        loginProgress.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser loginUser = FirebaseAuth.getInstance().getCurrentUser();

                    //Once processing is complete hide progress bar
                    loginProgress.setVisibility(View.GONE);

                    //Check if the user's email has been verified
                    if (loginUser.isEmailVerified()){
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                    } else{
                        loginUser.sendEmailVerification();
                        Toast.makeText(Login.this, "Please Verify Email", Toast.LENGTH_LONG).show();
                    }
                } else{
                    //Once processing is complete hide progress bar
                    loginProgress.setVisibility(View.GONE);

                    //Display error message
                    Toast.makeText(Login.this, "Login Failed!!! Try Again!!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //Direct User to Forgot Password Page
    private void resetPassword(){
        Intent forgotPassword = new Intent(Login.this, ResetPassword.class);
        startActivity(forgotPassword);
    }

    /*
    //Direct User Back to Welcome Page
    private void backToMain(){
        Intent toWelcome = new Intent(Login.this, Welcome.class);
        startActivity(toWelcome);
    }
    */

    //Direct User to Sign Up Page
    private void register(){
        Intent newUser = new Intent(Login.this, SignUp.class);
        startActivity(newUser);
    }

}