package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Avatar extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private String userUID;

    private ImageView currentAvatar;
    private TextView currentAvatarMessage;

    private ImageView everywhenLogo;
    private ImageView aboriginalFlag;
    private ImageView torresStraitFlag;
    private ImageView quokka;
    private ImageView platypus;
    private ImageView emu;
    private ImageView kangaroo;
    private ImageView cockatoo;
    private ImageView echidna;
    private ImageView galah;
    private ImageView kookaburra;
    private ImageView koala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);

        setTitle("");

        currentAvatar = findViewById(R.id.currentAvatar);
        currentAvatarMessage = findViewById(R.id.currentAvatarMessage);
        everywhenLogo = findViewById(R.id.avatarAppLogo);
        aboriginalFlag = findViewById(R.id.avatarAboriginalFlag);
        torresStraitFlag = findViewById(R.id.avatarTorresStraitFlag);
        quokka = findViewById(R.id.avatarQuokka);
        platypus = findViewById(R.id.avatarPlatypus);
        emu = findViewById(R.id.avatarEmu);
        kangaroo = findViewById(R.id.avatarKangaroo);
        cockatoo = findViewById(R.id.avatarCockatoo);
        echidna = findViewById(R.id.avatarEchidna);
        galah = findViewById(R.id.avatarGalah);
        kookaburra = findViewById(R.id.avatarKookaburra);
        koala = findViewById(R.id.avatarKoala);

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        userUID = user.getUid();

        databaseReference.child(userUID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User profile = snapshot.getValue(User.class);
                String fName = profile.firstName;
                String lName = profile.lastName;
                String email = profile.email;
                int avatar = profile.avatar;

                if(profile != null){
                    currentAvatar.setImageResource(avatar);

                    String greeting =fName.substring(0, 1).toUpperCase() + fName.substring(1);

                    currentAvatarMessage.setText(greeting + "'s Current Avatar");

                    everywhenLogo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            newAvatarSelection(R.drawable.applogo);
                        }
                    });

                    aboriginalFlag.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            newAvatarSelection(R.drawable.aboriginal_flag);
                        }
                    });

                    torresStraitFlag.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            newAvatarSelection(R.drawable.torres_strait_flag);
                        }
                    });

                    quokka.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            newAvatarSelection(R.drawable.quokka);
                        }
                    });

                    platypus.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            newAvatarSelection(R.drawable.platypus);
                        }
                    });

                    emu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            newAvatarSelection(R.drawable.cartoon_emu);
                        }
                    });

                    kangaroo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            newAvatarSelection(R.drawable.cartoon_kangaroo);
                        }
                    });

                    cockatoo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            newAvatarSelection(R.drawable.cockatoo);
                        }
                    });

                    echidna.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            newAvatarSelection(R.drawable.echidna);
                        }
                    });

                    galah.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            newAvatarSelection(R.drawable.galah);
                        }
                    });

                    kookaburra.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            newAvatarSelection(R.drawable.kookaburra);
                        }
                    });

                    koala.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            newAvatarSelection(R.drawable.koala);
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void newAvatarSelection(int imageID){
        Intent intent = new Intent(Avatar.this, ConfirmNewAvatar.class);
        intent.putExtra("Image ID", imageID);
        startActivity(intent);
    }
}