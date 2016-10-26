package com.lashazem.emprendedor;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import com.lashazem.emprendedor.Data.ImageListAdapter;
import com.lashazem.emprendedor.Data.Product;
import com.squareup.picasso.Picasso;

import java.io.InputStream;

import static android.R.attr.bitmap;
import static com.lashazem.emprendedor.DetailActivity.imageUrls;

/**
 * Created by Lash_Azem on 10/25/16.
 */

public class ImageViewFull extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_detail_grid_image_full);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        int position = i.getIntExtra("position", -1);
        //this.urlshare = position;
        String url = getIntent().getStringExtra("Url");

        ImageView iv = (ImageView) findViewById(R.id.image);
        Picasso.with(ImageViewFull.this)
                .load(url)
                .placeholder(R.drawable.placeholder)
                .noFade()
                .into(iv);
        //Toast.makeText(ImageViewFull.this, url, Toast.LENGTH_SHORT).show();

    }
}
