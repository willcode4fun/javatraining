package com.valtech.talent.program.web.model;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;

import java.io.Serializable;
import java.math.BigDecimal;

@ManagedBean(name="order")
@SessionScoped
public class OrderBean implements Serializable {

    private static final long serialVersionUID = 1L;



    public Order[] getOrderList() {

        // load orders here
        return new Order[]{};

    }

    public static class Order{

        String orderNo;
        String productName;
        BigDecimal price;
        int qty;

    }
}