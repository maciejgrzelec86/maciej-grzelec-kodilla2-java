package com.kodilla.good.patterns.challenges;

public class OrderDataBase implements OrderRepository {
    @Override
    public boolean createOrder(User user, Product product, int quantity){
        return true;
    }
}
