package com.example.infs3605;

import android.app.Application;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Viewholder_Question extends RecyclerView.ViewHolder {
    TextView artName,artType;
    ImageButton fvrt_btn;
    DatabaseReference favouriteref;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    public Viewholder_Question(@NonNull View itemView) {
        super(itemView);
    }

    public void setitem(FragmentActivity activity,String name,String type){

        artName = itemView.findViewById(R.id.tvArtTitle);
        artType = itemView.findViewById(R.id.tvArtType);

        artName.setText(name);
        artType.setText(type);

    }
    public void favouriteChecker(final String postkey) {
        fvrt_btn = itemView.findViewById(R.id.fvrt_f2_item);


        favouriteref = database.getReference("favourites");
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String uid = user.getUid();

        favouriteref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.child(postkey).hasChild(uid)) {
                    fvrt_btn.setImageResource(R.drawable.ic_baseline_star_24);
                } else {
                    fvrt_btn.setImageResource(R.drawable.ic_baseline_star_border_24);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void setitemRelated(Application activity,String name,String type){

        TextView nametv = itemView.findViewById(R.id.rel_art_name);
        TextView typetv = itemView.findViewById(R.id.rel_art_type);

        nametv.setText(name);
        typetv.setText(type);

    }
}
