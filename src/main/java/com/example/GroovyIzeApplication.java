package com.example;

import java.util.List;

public class GroovyIzeApplication {

    public static void main(String[] args) {
        FurnitureWarehouse warehouse = new FurnitureWarehouse();
        warehouse.setName("My Warehouse");

        warehouse.addToInventory(new Furniture("chair", 10));
        warehouse.addToInventory(new Furniture("lamp", 20));
        warehouse.addToInventory(new Furniture("chest", 30));
        warehouse.addToInventory(new Furniture("mirror", 40));

        List<Furniture> inventory = warehouse.getInventory();

        System.out.println("Here's the inventory");
        for (int i = 0; i < inventory.size(); ++i) {
            System.out.println(String.format("%d: %s", i + 1, inventory.get(i)));
        }

        // I have a lot of beds to add.
        warehouse.addToInventory(8, new Furniture("bed", 15));


        inventory = warehouse.getInventory();
        System.out.println("Here's the inventory");
        for (int i = 0; i < inventory.size(); ++i) {
            System.out.println(String.format("%d: %s", i + 1, inventory.get(i)));
        }

        System.out.println("warehouse = " + warehouse);
        System.out.println("value = " + warehouse.totalInventoryValue());
    }

}
