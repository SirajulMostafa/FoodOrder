package com.mostafa.foodorder.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mostafa.foodorder.Db.DbHelper;
import com.mostafa.foodorder.DetailActivity;
import com.mostafa.foodorder.Models.OrdersModel;
import com.mostafa.foodorder.R;

import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.viewHolder> {
    Context context;
    ArrayList<OrdersModel> list;

    public OrdersAdapter(Context context, ArrayList<OrdersModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View  view = LayoutInflater.from(context).inflate(R.layout.sample_order ,parent ,false);
        return new OrdersAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder vh, int position) {
//   viewHolder e age set kora hoise field er resource
    final  OrdersModel model = list.get(position);
        vh.imageView.setImageResource(model.getOrderItemImage());
        vh.name.setText(model.getOrderItemName());
        vh.price.setText(model.getOrderItemPrice());
        vh.invoiceNumber.setText(model.getOrderItemNumber());
        vh.description.setText(model.getOrderItemDescription());
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("id",Integer.parseInt(model.getOrderItemNumber()));
                intent.putExtra("type",2);//2 for update
                context.startActivity(intent);
            }

        });
        vh.itemView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                new AlertDialog.Builder(context)
                        .setTitle("Delete Item box")
                        .setIcon(R.drawable.ic_baseline_remove_circle_24)
                        .setMessage("Are you want to deleted this item")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
//                               finish() ;
//                                Toast.makeText(context, "Deleted item successfully", Toast.LENGTH_SHORT).show();
                DbHelper dbHelper = new DbHelper(context);
                 final int invoiceNumber = Integer.parseInt(model.getOrderItemNumber());
                if (dbHelper.deletedOrder(invoiceNumber) > 0){
                    Toast.makeText(context, "deleted successfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "deleted failed", Toast.LENGTH_SHORT).show();
                }

                            }
                        }).setNeutralButton("Help", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(context, "Open Help Activity", Toast.LENGTH_SHORT).show();
                    }
                }).setNeutralButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       dialogInterface.cancel();
                    }
                }).show();
//                DbHelper dbHelper = new DbHelper(context);
//                 final int invoiceNumber = Integer.parseInt(model.getOrderItemNumber());
//                if (dbHelper.deletedOrder(invoiceNumber) > 0){
//                    Toast.makeText(context, "deleted successfully", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(context, "deleted failed", Toast.LENGTH_SHORT).show();
//                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
//        step1
        ImageView imageView;
        TextView name,price,description,invoiceNumber;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.orderName);
            price = itemView.findViewById(R.id.orderPrice);
            description =itemView.findViewById(R.id.orderDescription);
            invoiceNumber =itemView.findViewById(R.id.invoiceNumber);


        }
    }


}
