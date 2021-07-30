package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
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

public class PersonalDetails extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private String userUID;

    private TextView currentDetails;
    private EditText newFName;
    private EditText newLName;
    private Button submitNames;
    private Button cancelNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        //Set Page Title
        setTitle("");

        currentDetails = findViewById(R.id.currentDetails);
        newFName = findViewById(R.id.newFName);
        newLName = findViewById(R.id.newLName);
        submitNames = findViewById(R.id.submitNewName);
        cancelNames = findViewById(R.id.cancelNewName);

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        userUID = user.getUid();

        databaseReference.child(userUID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //Get User Details
                User profile = snapshot.getValue(User.class);
                String fName = profile.firstName;
                String lName = profile.lastName;

                //Show user's name and email
                String userDetails = "Current Name: " + fName.substring(0, 1).toUpperCase() + fName.substring(1)
                        + " " + lName.substring(0, 1).toUpperCase() + lName.substring(1);
                currentDetails.setText(userDetails);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //Set Button OnClickListeners
        submitNames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUserDetails();
            }
        });

        cancelNames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnToProfile = new Intent(PersonalDetails.this, Profile.class);
                startActivity(returnToProfile);
            }
        });
    }

    private void updateUserDetails(){
        //Get Inputs
        String firstName = newFName.getText().toString().trim().toLowerCase();
        String lastName = newLName.getText().toString().trim().toLowerCase();

        //Check that First Name was Provided
        if (firstName.isEmpty()){
            newFName.setError("First Name is Required");
            newFName.requestFocus();
            return;
        }

        //Check that Last Name was Provided
        if (lastName.isEmpty()){
            newLName.setError("Last Name is Required");
            newLName.requestFocus();
            return;
        }

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        userUID = user.getUid();

        databaseReference.child(userUID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //Get User Details
                User profile = snapshot.getValue(User.class);
                String fName = profile.firstName;
                String lName = profile.lastName;
                String email = profile.email;
                int avatar_code = profile.avatar;

                //Show user's name and email
                String userDetails = "Current Name: " + fName.substring(0, 1).toUpperCase() + fName.substring(1)
                        + " " + lName.substring(0, 1).toUpperCase() + lName.substring(1);
                currentDetails.setText(userDetails);

                User changeUser = new User(firstName, lastName, email, avatar_code);

                FirebaseUser userRegistration = FirebaseAuth.getInstance().getCurrentUser();
                FirebaseDatabase.getInstance().getReference("Users")
                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .setValue(changeUser)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(PersonalDetails.this, "Name Changed", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(PersonalDetails.this, Profile.class);
                                startActivity(intent);
                            }
                        });


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}