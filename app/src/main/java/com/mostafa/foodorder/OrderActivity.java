package com.mostafa.foodorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import com.mostafa.foodorder.Adapters.OrdersAdapter;
import com.mostafa.foodorder.Db.DbHelper;
import com.mostafa.foodorder.Models.OrdersModel;
import com.mostafa.foodorder.databinding.ActivityOrderBinding;
import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
  //  private RecyclerView recyclerView;
   // private  RecyclerView.Adapter adapter;
    ActivityOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DbHelper dbHelper =  new DbHelper(this);
        ArrayList<OrdersModel> orders = dbHelper.getAllOrders();
//        order.add(new OrdersModel(R.drawable.food1,"pizza","4789","this is nice pizza hot price product","4785479"));
//        order.add(new OrdersModel(R.drawable.food1,"pizza","4789","this is nice pizza hot price product","4785479"));
//        order.add(new OrdersModel(R.drawable.food1,"pizza","4789","this is nice pizza hot price product","4785479"));
//        order.add(new OrdersModel(R.drawable.food1,"pizza","4789","this is nice pizza hot price product","4785479"));
//        order.add(new OrdersModel(R.drawable.food1,"pizza","4789","this is nice pizza hot price product","4785479"));
//        order.add(new OrdersModel(R.drawable.food1,"pizza","4789","this is nice pizza hot price product","4785479"));

        OrdersAdapter adapter = new OrdersAdapter(this,orders);
        binding.orderRecyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);
    }
}