package com.example;

import java.util.List;

public class GroovyIzeApplication {

    public static void main(String[] args) {
        FurnitureWarehouse warehouse = new FurnitureWarehouse();
        warehouse.setName("My Warehouse");

        warehouse.addToInventory("chair");
        warehouse.addToInventory("lamp");
        warehouse.addToInventory("chest");
        warehouse.addToInventory("mirror");

        List<String> inventory = warehouse.getInventory();

        System.out.println("Here's the inventory");
        for (int i = 0; i < inventory.size(); ++i) {
            System.out.println(String.format("%d: %s", i + 1, inventory.get(i)));
        }

        // I have a lot of beds to add.
        for (int i = 0; i < 8; ++i) {
            warehouse.addToInventory("bed");
        }

        inventory = warehouse.getInventory();
        System.out.println("Here's the inventory");
        for (int i = 0; i < inventory.size(); ++i) {
            System.out.println(String.format("%d: %s", i + 1, inventory.get(i)));
        }

        System.out.println("warehouse = " + warehouse);
    }

}
