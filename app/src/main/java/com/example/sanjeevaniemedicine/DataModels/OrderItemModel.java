package com.example.sanjeevaniemedicine.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class OrderItemModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int OrdItemID;

    @ColumnInfo(name = "ordItemName")
    private String OrdItemName;

    @ColumnInfo(name = "ordItemQty")
    private int OrdItemQty;

    @ColumnInfo(name = "ordItemPrice")
    private float OrdItemPrice;


    @ColumnInfo(name = "orderId")
    private long orderId;

    @ColumnInfo(name = "ordItemImg")
    private byte[] OrdItemImg;

    public OrderItemModel() {
    }

    public int getOrdItemID() {
        return OrdItemID;
    }

    public void setOrdItemID(int ordItemID) {
        OrdItemID = ordItemID;
    }

    public String getOrdItemName() {
        return OrdItemName;
    }

    public void setOrdItemName(String ordItemName) {
        OrdItemName = ordItemName;
    }

    public int getOrdItemQty() {
        return OrdItemQty;
    }

    public void setOrdItemQty(int ordItemQty) {
        OrdItemQty = ordItemQty;
    }

    public float getOrdItemPrice() {
        return OrdItemPrice;
    }

    public void setOrdItemPrice(float ordItemPrice) {
        OrdItemPrice = ordItemPrice;
    }

    public byte[] getOrdItemImg() {
        return OrdItemImg;
    }

    public void setOrdItemImg(byte[] ordItemImg) {
        OrdItemImg = ordItemImg;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
