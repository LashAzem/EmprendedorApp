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

//    private ShareActionProvider mShareActionProvider;
//    private int urlshare;
//    public static int[] imageUrls;
//    Product product;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.content_detail_grid_image_full);
//        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        Intent i = getIntent();
//        int position = i.getIntExtra("position", -1);
//        this.urlshare = position;
//
//        ImageView iv = (ImageView) findViewById(R.id.image);
//        Picasso.with(ImageViewFull.this)
//                .load(DetailActivity.imageUrls[position])
//                .placeholder(R.drawable.placeholder)
//                .noFade()
//                .into(iv);
//        Toast.makeText(ImageViewFull.this, imageUrls[position], Toast.LENGTH_SHORT).show();
//
//    }
    ImageView img;
    Bitmap bitmap;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_detail_grid_image_full);

        Intent i = getIntent();
        int position = i.getExtras().getInt("id");
        //ImageListAdapter imageListAdapter = new ImageListAdapter(this);

        img = (ImageView) findViewById(R.id.image);
        //String url = imageListAdapter.getItem(position);
        //String url = String.valueOf(imageUrls[position]);
        Picasso.with(ImageViewFull.this)
                .load(DetailActivity.imageUrls[position])
                .placeholder(R.drawable.placeholder)
                .noFade()
                .into(img);

        //new DownloadImage().execute(url);
    }
    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... URL) {
            String imageURL = URL[0];
            Bitmap bitmap = null;
            try {
                InputStream input = new java.net.URL(imageURL).openStream();
                bitmap = BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            img.setImageBitmap(result);
        }
    }
}
