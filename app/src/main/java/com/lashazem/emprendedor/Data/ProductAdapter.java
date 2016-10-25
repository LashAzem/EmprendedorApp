package com.lashazem.emprendedor.Data;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lashazem.emprendedor.DetailActivity;
import com.lashazem.emprendedor.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    public ArrayList<Product> products;

    public ProductAdapter(Context context, ArrayList<Product> products){
        this.context = context;
        this.products = products;
    }

    View view;

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.from(parent.getContext())
                .inflate(R.layout.product_cardview, parent, false);

        ProductViewHolder productViewHolder = new ProductViewHolder(view);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        final Product selectedProduct = products.get(position);
        holder.tvName.setText(selectedProduct.name);
        //holder.tvPrice.setText("" + selectedProduct.price);

        String fullUrl = "http://api.lashazem.com/customer/" + selectedProduct.image_url;
        final ImageView ivImage = (ImageView)view.findViewById(R.id.ivImageUrl);

        Picasso.with(context)
                .load(fullUrl)
                .placeholder(R.drawable.placeholder)
                .error(android.R.drawable.stat_notify_error)
                .into(holder.ivImage);

        holder.ivImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent in = new Intent(context, DetailActivity.class);
                in.putExtra("product", selectedProduct);
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(in);
                //Toast.makeText(context, selectedProduct.name, Toast.LENGTH_SHORT).show();
            }

        });

    }

    @Override
    public int getItemCount() {
        if(products != null){
            return products.size();
        }
        return 0;
    }

    //ViewHolder class
    public static class ProductViewHolder extends RecyclerView.ViewHolder{

        public CardView cvProduct;
        public ImageView ivImage, icWebsite, icFacebook, icInstagram;
        public TextView tvName, tvDescription;
        //public TextView tvDescription;
        //public TextView tvWebsite;

        public ProductViewHolder(View itemView) {
            super(itemView);
            cvProduct = (CardView)itemView.findViewById(R.id.cvProduct);
            ivImage = (ImageView)itemView.findViewById(R.id.ivImageUrl);
            tvName = (TextView)itemView.findViewById(R.id.tvName);
//            tvDescription = (TextView)itemView.findViewById(R.id.tvDescription);
//            //tvWebsite = (TextView)itemView.findViewById(R.id.tvWebsite);
//            icWebsite = (ImageView)itemView.findViewById(R.id.icwebsite);
//            icFacebook = (ImageView)itemView.findViewById(R.id.icfacebook);
//            icInstagram = (ImageView)itemView.findViewById(R.id.icinstagram);

        }

    }


}