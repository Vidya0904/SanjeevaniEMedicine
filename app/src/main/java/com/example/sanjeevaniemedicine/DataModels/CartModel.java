package com.example.sanjeevaniemedicine.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import javax.crypto.SecretKey;

@Entity
public class CartModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int cartID;

    @ColumnInfo(name = "cartMedName")
    private String CartMedName;

    @ColumnInfo(name = "cartMedQty")
    private int CartMedQty;

    @ColumnInfo(name = "cartMedPrice")
    private float CartMedPrice;

    @ColumnInfo(name = "cartMedStripSize")
    private int CartMedStripSize;

    @ColumnInfo(name = "cartMedImg")
    private byte[] CartMedImg;

    public CartModel() {
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public String getCartMedName() {
        return CartMedName;
    }

    public void setCartMedName(String cartMedName) {
        CartMedName = cartMedName;
    }

    public int getCartMedQty() {
        return CartMedQty;
    }

    public void setCartMedQty(int cartMedQty) {
        CartMedQty = cartMedQty;
    }

    public float getCartMedPrice() {
        return CartMedPrice;
    }

    public void setCartMedPrice(float cartMedPrice) {
        CartMedPrice = cartMedPrice;
    }

    public int getCartMedStripSize() {
        return CartMedStripSize;
    }

    public void setCartMedStripSize(int cartMedStripSize) {
        CartMedStripSize = cartMedStripSize;
    }

    public byte[] getCartMedImg() {
        return CartMedImg;
    }

    public void setCartMedImg(byte[] cartMedImg) {
        CartMedImg = cartMedImg;
    }
}
