package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class App {

    public static void main(String[] args){
        /*MovieStore movieStore = new MovieStore();
        String result = movieStore.getMovies().entrySet().stream()
                    .flatMap(e -> e.getValue().stream())
                    .collect(Collectors.joining("; ","<<",">>"));
        System.out.println(result);*/
        OrderRequestRetriever orderRequestRetriever =new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(new MailService(), new ProductOrderServices(), new OrderDataBase());
        orderProcessor.process(orderRequest);
    }
}
