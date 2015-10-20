package com.example;

public interface DeliveryService {

    public enum DeliveryStatus {
        REQUESTED, OUT_FOR_DELIVERY, DELIVERED
    }

    /**
     * Deliver a piece of furniture to an address.
     * @param piece
     * @param address
     * @return the UUID of the delivery order
     */
    String deliver(Furniture piece, String address);


    DeliveryStatus deliveryStatus(String deliveryOrder);
}
