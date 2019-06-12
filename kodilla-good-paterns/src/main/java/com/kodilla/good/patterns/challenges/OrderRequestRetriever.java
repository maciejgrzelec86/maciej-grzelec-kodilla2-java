package com.kodilla.good.patterns.challenges;

public class OrderRequestRetriever {
    public OrderRequest retrieve(){
        User user = new User("XYZ", "ABC");
        Product product1 = new Product("product1", 10);
        int quantity = 10;

        return new OrderRequest(user, product1,quantity);
    }
}
