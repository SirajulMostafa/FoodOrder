package com.mostafa.foodorder.Db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.mostafa.foodorder.Models.OrdersModel;

import java.util.ArrayList;
import java.util.HashMap;

public class DbHelper  extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "foodorderdb.db";
    public static final String ORDER_TABLE_NAME = "orders";
    public static final String ORDER_COLUMN_ID = "id";
    public static final String ORDER_COLUMN_NAME = "name";
    public static final String ORDER_COLUMN_PHONE = "phone";
    public static final String ORDER_COLUMN_PRICE = "price";
    public static final String ORDER_COLUMN_QUANTITY = "quantity";
    public static final String ORDER_COLUMN_DESCRIPTION = "description";
    public static final String ORDER_COLUMN_IMAGE = "image";
    public static final String ORDER_COLUMN_FOOD_NAME = "foodname";
    public static final int DB_VERSION = 1;
    private HashMap hp;


    public DbHelper( @Nullable Context context) {
        super(context, DATABASE_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       sqLiteDatabase.execSQL(
               new StringBuilder().append(" CREATE TABLE ").append(ORDER_TABLE_NAME).append("(").append(ORDER_COLUMN_ID).append(" INTEGER PRIMARY KEY AUTOINCREMENT,").append(ORDER_COLUMN_NAME).append(" text,").append(ORDER_COLUMN_PHONE).append(" int,").append(ORDER_COLUMN_PRICE).append(" int,").append(ORDER_COLUMN_DESCRIPTION).append(" text,").append(ORDER_COLUMN_FOOD_NAME).append(" text,").append(ORDER_COLUMN_IMAGE).append(" int, ").append(ORDER_COLUMN_QUANTITY).append(" int").append(")").toString()
       );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(
                new StringBuilder().append("DROP TABLE if EXIST ").append(ORDER_TABLE_NAME).toString());

        onCreate(sqLiteDatabase);
    }

    public boolean insertOrder (String name, String phone, int price,String foodName, String description,int image,int quantity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ORDER_COLUMN_NAME, name);
        contentValues.put(ORDER_COLUMN_PHONE, phone);
        contentValues.put(ORDER_COLUMN_PRICE, price);
        contentValues.put(ORDER_COLUMN_DESCRIPTION, description);
        contentValues.put(ORDER_COLUMN_FOOD_NAME,foodName );
        contentValues.put(ORDER_COLUMN_IMAGE, image);
        contentValues.put(ORDER_COLUMN_QUANTITY,quantity);
       long id =  db.insert(ORDER_TABLE_NAME, null, contentValues);
       if (id<=0) return false;
        return true;
    }

    public boolean  orderUpdate(String name, String phone, int price,String foodName, String description,int image,int quantity,int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ORDER_COLUMN_NAME, name);
        contentValues.put(ORDER_COLUMN_PHONE, phone);
        contentValues.put(ORDER_COLUMN_PRICE, price);
        contentValues.put(ORDER_COLUMN_DESCRIPTION, description);
        contentValues.put(ORDER_COLUMN_FOOD_NAME,foodName );
        contentValues.put(ORDER_COLUMN_IMAGE, image);
        contentValues.put(ORDER_COLUMN_QUANTITY,quantity);
//        long id =  db.insert(ORDER_TABLE_NAME, null, contentValues);
        long row = db.update(ORDER_TABLE_NAME,contentValues,"id="+id,null);
        if (row<=0) return false;
        return true;
    }

    public ArrayList<OrdersModel> getAllOrders() {
        ArrayList<OrdersModel> order_list = new ArrayList<>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select foodname,id,price,description,image from orders", null );
        res.moveToFirst();
       while(res.isAfterLast()==false){
          //  while (res.moveToNext()){
//                OrdersModel model = new OrdersModel();
//                model.setOrderItemFoodName(res.getString(0));
//                model.setOrderItemNumber(res.getInt(1)+"");
//                model.setOrderItemPrice(res.getInt(2)+"");
//                model.setOrderItemDescription(res.getString(3));
//                model.setOrderItemImage(res.getInt(4));
                OrdersModel model = new OrdersModel(res.getString(0),res.getInt(1)+"",res.getInt(2)+"",res.getString(3),res.getInt(4));
                order_list.add(model);
                res.moveToNext();
            // }

           // res.close();
            //db.close();
          //  return order_list;

        }

        return order_list;
    }
    public Cursor getOrderById(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select foodname,id,price,description,image,name,phone,quantity from orders WHERE id ="+id ,null);
        if(cursor != null) cursor.moveToFirst();

        //cursor.close();
        //db.close();
        return cursor;
    }
public int deletedOrder(int id){
    SQLiteDatabase db = this.getWritableDatabase();
    return db.delete(ORDER_TABLE_NAME,"id="+id,null);
}

}
