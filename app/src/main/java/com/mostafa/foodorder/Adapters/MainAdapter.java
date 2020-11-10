package com.mostafa.foodorder.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.mostafa.foodorder.DetailsActivity;
import com.mostafa.foodorder.DetailActivity;
import com.mostafa.foodorder.Models.ProductModel;
import com.mostafa.foodorder.R;

import java.util.ArrayList;

//ProductAdapter er modde viewHolder extend kora holo<RecyclerView.Adapter<ProductAdapter.viewHolder>
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {
//    private Context context;
     Context context;
     ArrayList<ProductModel> list;

    public MainAdapter( ArrayList<ProductModel> list,Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //parent,false use for recyclerview's unwanted gape
        View  view = LayoutInflater.from(context).inflate(R.layout.sample_mainfood ,parent ,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
    final ProductModel product = list.get(position);
    holder.image.setImageResource(product.getImage());
    holder.name.setText(product.getName());
    holder.price.setText(product.getPrice());
    holder.description.setText(product.getDescription());

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(context, DetailActivity.class);
            i.putExtra("image",product.getImage());
            i.putExtra("price",product.getPrice());
            i.putExtra("desc",product.getDescription());
            i.putExtra("name",product.getName());
            i.putExtra("type",1);// insert/add product into card
            context.startActivity(i);
        }

    });

    }

    @Override
    public int getItemCount() {
       return list.size();
       // return 0;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView  name,price,description;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.image);
            //name = (TextView)itemView.findViewById(R.id.name);
            name = itemView.findViewById(R.id.name);
            price = (TextView)itemView.findViewById(R.id.price);
            description = (TextView)itemView.findViewById(R.id.description);

        }
    }
}
