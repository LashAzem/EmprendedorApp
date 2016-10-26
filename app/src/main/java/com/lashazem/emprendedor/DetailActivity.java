package com.lashazem.emprendedor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lashazem.emprendedor.Data.ImageListAdapter;
import com.lashazem.emprendedor.Data.Product;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;


public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";
    public static int[] imageUrls;
    ImageView ivImage, ivImage1, ivImage2, ivImage3, ivImage4, icWebsite, icInstagram, icFacebook, gvImage;
    TextView tvTitle, tvDescription, tvWebsite;
    Product product;
    GridView gv;
    private Target target;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gv = (GridView) findViewById(R.id.gv);

        ivImage = (ImageView) findViewById(R.id.ivImageUrl);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        icWebsite = (ImageView) findViewById(R.id.icwebsite);
        icFacebook = (ImageView) findViewById(R.id.icfacebook);
        icInstagram = (ImageView) findViewById(R.id.icinstagram);

        if (getIntent().getSerializableExtra("product") != null) {
            product = (Product) getIntent().getSerializableExtra("product");
            final String fullUrl = "http://api.lashazem.com/customer/" + product.image_url;
            final String galleryUrl1 = "http://api.lashazem.com/customer/" + product.gallery_1;
            final String galleryUrl2 = "http://api.lashazem.com/customer/" + product.gallery_2;
            final String galleryUrl3 = "http://api.lashazem.com/customer/" + product.gallery_3;
            final String galleryUrl4 = "http://api.lashazem.com/customer/" + product.gallery_4;

            //Full Image

            Picasso.with(this)
                    .load(fullUrl)
                    .placeholder(R.drawable.placeholder)
                    .fit()
                    .into(ivImage);

            //Gallery

            final String[] imageUrls = {
                    galleryUrl1,
                    galleryUrl2,
                    galleryUrl3,
                    galleryUrl4
            };
//            gv.setVerticalScrollBarEnabled(false);
//            gv.setAdapter(new ImageListAdapter(DetailActivity.this, imageUrls));
//
//            gv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Intent i = new Intent(DetailActivity.this, ImageViewFull.class);
//                    i.putExtra("position", position);
//                    startActivity(i);
//                    Toast.makeText(DetailActivity.this, "position "+position, Toast.LENGTH_SHORT).show();
//                }
//            });
            final GridView gridview = (GridView) findViewById(R.id.gv);
            //gridview.setAdapter(new ImageListAdapter(this));
           gridview.setAdapter(new ImageListAdapter(DetailActivity.this, imageUrls));
            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    Intent i = new Intent(getApplicationContext(), ImageViewFull.class);
                    i.putExtra("id", position);
                    i.putExtra("Url",imageUrls[position]);
                    startActivity(i);
                    //Toast.makeText(DetailActivity.this, imageUrls[position], Toast.LENGTH_SHORT).show();
                }
            });

            tvTitle.setText(product.name);
            tvDescription.setText(product.description);

            //Website link
            icWebsite.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Intent Getintent = new Intent(Intent.ACTION_VIEW, Uri.parse(product.website));
                    startActivity(Getintent);

                }
            });

            //Instagram link
            icInstagram.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Intent Getintent = new Intent(Intent.ACTION_VIEW, Uri.parse(product.instagram));
                    startActivity(Getintent);

                }
            });

            //Facebook link
            icFacebook.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Intent Getintent = new Intent(Intent.ACTION_VIEW, Uri.parse(product.facebook));
                    startActivity(Getintent);

                }
            });

        }

        // Show the Title in the action bar.
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbar.setTitle(product.name);

    }
}
