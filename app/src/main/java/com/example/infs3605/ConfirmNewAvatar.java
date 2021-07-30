package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

public class ConfirmNewAvatar extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private String userUID;

    private int newAvatar;
    private ImageView selectedAvatar;
    private Button confirmChange;
    private Button cancelChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_new_avatar);

        selectedAvatar = findViewById(R.id.selectedAvatar);
        confirmChange = findViewById(R.id.confirmAvatarChange);
        cancelChange = findViewById(R.id.cancelAvatarChange);


        Bundle extras = getIntent().getExtras();
        if (extras != null){
            newAvatar = extras.getInt("Image ID");
        }

        selectedAvatar.setImageResource(newAvatar);

        confirmChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmSelection();
            }
        });

        cancelChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmNewAvatar.this, Profile.class);
                startActivity(intent);
            }
        });
    }

    private void confirmSelection(){
        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        userUID = user.getUid();

        databaseReference.child(userUID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User profile = snapshot.getValue(User.class);
                if (profile != null){
                    String fName = profile.firstName;
                    String lName = profile.lastName;
                    String email = profile.email;

                    User changeUser = new User(fName, lName, email, newAvatar);

                    FirebaseUser userRegistration = FirebaseAuth.getInstance().getCurrentUser();
                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(changeUser)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(ConfirmNewAvatar.this, "Avatar Changed", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(ConfirmNewAvatar.this, Profile.class);
                                    startActivity(intent);
                                }
                            });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}