package com.triard.asus.openproject2019.activities;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

//import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.triard.asus.openproject2019.R;

import static com.triard.asus.openproject2019.activities.MainActivity.EXTRA_URL;

public class activityDetail extends AppCompatActivity {

    ImageView imageView;
    TextView tvNama, tvAsal,tvCoach,tvStadion, tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_detail);


        String image_detail = getIntent ().getStringExtra (EXTRA_URL);

        imageView  = findViewById(R.id.iv_img);
        tvNama= findViewById(R.id.tv_nama);
        tvAsal= findViewById(R.id.tv_asal);
        tvCoach = findViewById(R.id.a);
        tvDesc = findViewById(R.id.text_desc);
        tvStadion = findViewById(R.id.tv_stadion);

        tvNama.setText(getIntent().getStringExtra("nama"));
        tvAsal.setText(getIntent().getStringExtra("asal"));
        tvCoach.setText(getIntent().getStringExtra("coach"));
        tvDesc.setText(getIntent().getStringExtra("desc"));
        tvStadion.setText(getIntent().getStringExtra("stadion"));
        String image = getIntent().getStringExtra(EXTRA_URL);

        Picasso.get().load(image).into(imageView);
    }
}
