package com.ederfmatos.mockbean.bean;

public enum ProductDiscount {

    D_0(0),
    D_10(10),
    D_20(20),
    D_25(25),
    D_30(30);

    private final int discount;

    ProductDiscount(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

}
