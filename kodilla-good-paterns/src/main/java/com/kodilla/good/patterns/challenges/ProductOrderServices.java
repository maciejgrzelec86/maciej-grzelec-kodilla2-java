package com.kodilla.good.patterns.challenges;

public class ProductOrderServices implements OrderService {
    @Override
    public boolean createOrder(User user, Product product, int quantity){
        System.out.println("Ordered product: " + product.getProductName() + "for: "  + user.getName() +" " +
                user.getSurname() + ", quantity: " + quantity + " price" + product.getProductPrice()*quantity);
        return  true;
    }
}
