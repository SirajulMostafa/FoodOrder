package com.mostafa.foodorder.Models;

public class OrdersModel {
    String OrderItemFoodName;
    String OrderItemPrice;

    String orderItemDescription;

    int orderItemImage;
    String OrderItemNumber;
    String OrderItemName;
    public OrdersModel(String orderItemFoodName, String orderItemNumber, String orderItemPrice, String orderItemDescription, int orderItemImage) {
        this.OrderItemNumber = orderItemNumber;
        this.OrderItemFoodName = orderItemFoodName;
        this.OrderItemPrice = orderItemPrice;
        this.orderItemDescription = orderItemDescription;
        this.orderItemImage = orderItemImage;
    }


    public OrdersModel(int orderItemImage, String orderItemName, String orderItemFoodName, String orderItemPrice, String orderItemDescription, String orderItemNumber) {
        this.orderItemImage = orderItemImage;
        OrderItemName = orderItemName;
        OrderItemFoodName = orderItemFoodName;
        OrderItemPrice = orderItemPrice;
        this.orderItemDescription = orderItemDescription;
        OrderItemNumber = orderItemNumber;
    }

    public String getOrderItemFoodName() {
        return OrderItemFoodName;
    }

    public void setOrderItemFoodName(String orderItemFoodName) {
        OrderItemFoodName = orderItemFoodName;
    }
//    public OrdersModel(int orderItemImage, String orderItemName, String orderItemPrice, String orderItemDescription, String orderItemNumber) {
//        this.orderItemImage = orderItemImage;
//        OrderItemName = orderItemName;
//        OrderItemPrice = orderItemPrice;
//        this.orderItemDescription = orderItemDescription;
//        OrderItemNumber = orderItemNumber;
//    }

    public OrdersModel() {
    }

    public int getOrderItemImage() {
        return orderItemImage;
    }

    public void setOrderItemImage(int orderItemImage) {
        this.orderItemImage = orderItemImage;
    }

    public String getOrderItemName() {
        return OrderItemName;
    }

    public void setOrderItemName(String orderItemName) {
        OrderItemName = orderItemName;
    }

    public String getOrderItemPrice() {
        return OrderItemPrice;
    }

    public void setOrderItemPrice(String orderItemPrice) {
        OrderItemPrice = orderItemPrice;
    }

    public String getOrderItemDescription() {
        return orderItemDescription;
    }

    public void setOrderItemDescription(String orderItemDescription) {
        this.orderItemDescription = orderItemDescription;
    }

    public String getOrderItemNumber() {
        return OrderItemNumber;
    }

    public void setOrderItemNumber(String orderItemNumber) {
        OrderItemNumber = orderItemNumber;
    }
}
