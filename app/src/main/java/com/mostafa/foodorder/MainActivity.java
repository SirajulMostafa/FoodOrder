package com.mostafa.foodorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.mostafa.foodorder.Adapters.MainAdapter;
import com.mostafa.foodorder.Models.ProductModel;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//ActivityMainBinding mainBinding;
 private RecyclerView recyclerView;
 private  RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mainBinding= ActivityMainBinding.inflate(getLayoutInflater());
       // setContentView(mainBinding.getRoot());//root here mainActivity.xml
        setContentView(R.layout.activity_main);
        //object create and demo data set
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<ProductModel> list = new ArrayList<>();
        list.add(new ProductModel(R.drawable.food1,"icream","500","this is sample product"));
        list.add(new ProductModel(R.drawable.food2,"book","505","this is sample product"));
        list.add(new ProductModel(R.drawable.food3,"pen","50","this is sample product"));
        list.add(new ProductModel(R.drawable.food1,"water","51","this is sample product"));
        list.add(new ProductModel(R.drawable.food2,"water","51","this is sample product"));
        list.add(new ProductModel(R.drawable.food3,"water","51","this is sample product"));
        list.add(new ProductModel(R.drawable.food2,"water","51","this is sample product"));
        //set this data throw  adapter into recyclerview
         adapter = new MainAdapter(list,this );

         recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Order:
                startActivity(new Intent(MainActivity.this,OrderActivity.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}