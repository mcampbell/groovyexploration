package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * A simple implementation of the delivery service; mainly used for testing.
 */
public class SimpleDeliveryServiceImpl implements DeliveryService {

    Map<String, DeliveryStatus> statuses = new HashMap<>();

    @Override public String deliver(Furniture piece, String address) {
        String order = UUID.randomUUID().toString();
        statuses.put(order, DeliveryStatus.REQUESTED);

        return order;
    }

    @Override public DeliveryStatus deliveryStatus(String deliveryOrder) {
        if (deliveryOrder != null && !deliveryOrder.isEmpty()) {
            return statuses.get(deliveryOrder);

        } else {
            return null;
        }
    }
}
