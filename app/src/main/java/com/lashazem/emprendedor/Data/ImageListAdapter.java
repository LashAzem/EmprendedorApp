package com.lashazem.emprendedor.Data;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.lashazem.emprendedor.R;
import com.squareup.picasso.Picasso;

public class ImageListAdapter extends ArrayAdapter {

    private Context context;
    private LayoutInflater inflater;
    int imageTotal = 4;
    public static String[] imageUrls;


    public int getCount() {
        return imageTotal;
    }

    @Override
    public String getItem(int position) {
        return imageUrls[position];
    }

    public long getItemId(int position) {
        return 0;
    }

    public ImageListAdapter(Context context, String[] imageUrls) {
        super(context, R.layout.content_detail_grid_image, imageUrls);

        this.context = context;
        this.imageUrls = imageUrls;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.content_detail_grid_image, parent, false);
        }

        Picasso.with(context)
                .load(imageUrls[position])
                .placeholder(R.drawable.placeholder)
                .into((ImageView) convertView);


        return convertView;
    }
}

