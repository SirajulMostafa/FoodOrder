package com.mostafa.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mostafa.foodorder.Db.DbHelper;
import com.mostafa.foodorder.databinding.ActivityDetailsBinding;
import com.mostafa.foodorder.databinding.ActivityMainBinding;

public class DetailActivity extends AppCompatActivity {
 ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        //     setContentView(R.layout.activity_details);
        setContentView(binding.getRoot());
       final DbHelper dbHelper = new DbHelper(this);
//        int type = getIntent().getIntExtra("type", 0);
        if (getIntent().getIntExtra("type", 0)==1) {
            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("desc");
            binding.detailsImage.setImageResource(image);
            binding.totalPrice.setText(String.format("%d", price));
            binding.detailsFoodName.setText(name);
            binding.details.setText(description);


            binding.OrderNow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //insert order return true or false in dbhelper class
                    // so here we can check is insert or not

                    boolean isInserted = dbHelper.insertOrder(
                            binding.orderPersonName.getText().toString(),
                            binding.txtPhoneNumber.getText().toString(),
                            price,
                            name,
                            description,
                            image,
                            Integer.parseInt(binding.quantity.getText().toString())

                    );
                    if (isInserted)
                        Toast.makeText(DetailActivity.this, "Order success", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this, "Order failed ", Toast.LENGTH_SHORT).show();
                }
            });

        }else{
            int id = getIntent().getIntExtra("id",0);
            Cursor cursor = dbHelper.getOrderById(id);
            //foodname =0,id=1,price=2,description=3,image=4,name=5,phone=6,quantity=7
            binding.detailsImage.setImageResource(cursor.getInt(4));
            binding.totalPrice.setText(String.format("%d", cursor.getInt(2)));
            binding.detailsFoodName.setText(cursor.getString(0));
            binding.orderPersonName.setText(cursor.getString(5));
            binding.details.setText(cursor.getString(3));
            binding.txtPhoneNumber.setText(cursor.getString(6));
            binding.quantity.setText(cursor.getString(7));
            binding.OrderNow.setText("Update Now");
            final int image=cursor.getInt(4);
            binding.OrderNow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
// public boolean  orderUpdate(String name, String phone, int price,String foodName, String description,int image,int quantity,int id) {

                        boolean isUpdated = dbHelper.orderUpdate(
                                binding.orderPersonName.getText().toString(),
                                binding.txtPhoneNumber.getText().toString(),
                                Integer.parseInt(binding.totalPrice.getText().toString()),
                                binding.detailsFoodName.getText().toString(),
                                binding.details.getText().toString(),
                                image,
                                Integer.parseInt(binding.quantity.getText().toString()),
                                id

                    );
                    if (isUpdated)
                        Toast.makeText(DetailActivity.this, "Updated ", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this, " failed ", Toast.LENGTH_SHORT).show();

                    Toast.makeText(DetailActivity.this, "Order update", Toast.LENGTH_SHORT).show();
                }
            });



        }

    }
}