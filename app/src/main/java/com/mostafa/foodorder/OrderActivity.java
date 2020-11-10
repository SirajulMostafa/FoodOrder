package com.mostafa.foodorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mostafa.foodorder.Adapters.OrdersAdapter;
import com.mostafa.foodorder.Db.DbHelper;
import com.mostafa.foodorder.Models.OrdersModel;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private  RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        recyclerView = findViewById(R.id.orderRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        ArrayList<OrdersModel> order = new ArrayList<>();

        DbHelper dbHelper =  new DbHelper(this);
        ArrayList<OrdersModel> orders = dbHelper.getAllOrders();

//        order.add(new OrdersModel(R.drawable.food1,"pizza","4789","this is nice pizza hot price product","4785479"));
//        order.add(new OrdersModel(R.drawable.food1,"pizza","4789","this is nice pizza hot price product","4785479"));
//        order.add(new OrdersModel(R.drawable.food1,"pizza","4789","this is nice pizza hot price product","4785479"));
//        order.add(new OrdersModel(R.drawable.food1,"pizza","4789","this is nice pizza hot price product","4785479"));
//        order.add(new OrdersModel(R.drawable.food1,"pizza","4789","this is nice pizza hot price product","4785479"));
//        order.add(new OrdersModel(R.drawable.food1,"pizza","4789","this is nice pizza hot price product","4785479"));
//        adapter = new OrdersAdapter(this,order);
        adapter = new OrdersAdapter(this,orders);
        recyclerView.setAdapter(adapter);
    }
}