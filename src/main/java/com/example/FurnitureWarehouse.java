package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *

 */
public class FurnitureWarehouse {
    private String name;
    private List<String> inventory = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setIventory(List<String> inventory) {
        this.inventory.clear();
        if (inventory != null && !inventory.isEmpty()) {
            this.inventory.addAll(inventory);
        }
    }

    public int getInventorySize() {
        return this.inventory.size();
    }

    public void addToInventory(String newThing) {
        if (newThing != null && !newThing.isEmpty()) {
            this.inventory.add(newThing);
        }
    }

    public int removeFromInventory(String toRemove) {
        if (this.inventory.isEmpty()) {
            return 0;
        }
        int removed = 0;
        Iterator<String> iter = this.inventory.iterator();
        while (iter.hasNext()) {
            String currentThing = iter.next();
            if (currentThing != null && !currentThing.isEmpty() &&
                    currentThing.equalsIgnoreCase(toRemove)) {
                iter.remove();
                ++removed;
            }
        }
        return removed;
    }

    public List<String> getInventory() {
        return new ArrayList(this.inventory);
    }

    public List<String> findPiece(String search) {
        if (search == null) {
            return Collections.emptyList();

        } else if (search.isEmpty()) {
            return getInventory();

        } else {

            List<String> founds = new ArrayList<>(this.inventory.size());

            for (String i : inventory) {
                if (i.toLowerCase().startsWith(search.toLowerCase())) {
                    founds.add(i);
                }
            }

            return founds;
        }
    }

    @Override
    public String toString() {
        return "FurnitureWarehouse{" +
                "name='" + name + '\'' +
                ", inventory=" + inventory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FurnitureWarehouse warehouse = (FurnitureWarehouse) o;

        if (name != null ? !name.equals(warehouse.name) : warehouse.name != null) return false;
        return !(inventory != null ? !inventory.equals(warehouse.inventory) : warehouse.inventory != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (inventory != null ? inventory.hashCode() : 0);
        return result;
    }
}
