package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PasswordChange extends AppCompatActivity {

    private FirebaseUser user;
    private EditText newPassword;
    private EditText confirmNewPassword;
    private Button submit;
    private Button cancel;
    private ProgressBar changePasswordProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);

        //Set Page Title
        setTitle("");

        newPassword = findViewById(R.id.newPassword);
        confirmNewPassword = findViewById(R.id.newPasswordConfirm);
        submit = findViewById(R.id.submitNewPassword);
        cancel = findViewById(R.id.cancelNewPassword);
        changePasswordProgress = findViewById(R.id.changePasswordProgress);

        //Set Button OnClickListeners
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeUserPassword();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancelChange = new Intent(PasswordChange.this, Profile.class);
                startActivity(cancelChange);
            }
        });
    }

    private void changeUserPassword(){

        //Get User Inputs
        String password = newPassword.getText().toString().trim();
        String confirmPassword = confirmNewPassword.getText().toString().trim();

        //Check that Password was Provided
        if (password.isEmpty()){
            newPassword.setError("Password is Required");
            newPassword.requestFocus();
            return;
        }

        //Check Password Length
        if (password.length() < 8){
            newPassword.setError("Password Must be at Least 8 Characters");
            newPassword.requestFocus();
            return;
        }

        //Check that Confirmation Password was Provided
        if (confirmPassword.isEmpty()){
            confirmNewPassword.setError("Enter Password Again to Confirm");
            confirmNewPassword.requestFocus();
            return;
        }

        //Check that passwords match
        if (!password.equals(confirmPassword)){
            confirmNewPassword.setError("Passwords Do Not Match");
            confirmNewPassword.requestFocus();
            return;
        }

        //Show progress bar to demonstrate that the system is processing
        changePasswordProgress.setVisibility(View.VISIBLE);
        user = FirebaseAuth.getInstance().getCurrentUser();
        user.updatePassword(password).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    //Once Processing is Complete Hide Progress Bar
                    changePasswordProgress.setVisibility(View.GONE);

                    //Show Success Message
                    Toast.makeText(PasswordChange.this, "Password Changed!!!", Toast.LENGTH_LONG).show();

                    //Redirect User Back to Profile Page upon Completion
                    Intent returntoProfile = new Intent(PasswordChange.this, Profile.class);
                    startActivity(returntoProfile);
                } else{
                    //Once Processing is Complete Hide Progress Bar
                    changePasswordProgress.setVisibility(View.GONE);

                    //Show Error Message
                    Toast.makeText(PasswordChange.this, "Password Change Failed!!! Try Again!!!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}