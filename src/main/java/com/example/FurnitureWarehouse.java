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
    private List<Furniture> inventory = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setInventory(List<Furniture> furns) {
        this.inventory.clear();
        if (furns != null && !furns.isEmpty()) {
            for (Furniture f : furns) {
                this.inventory.add(f.copy());
            }
        }
    }

    public int getInventorySize() {
        return this.inventory.size();
    }

    public void addToInventory(Furniture newThing) {
        if (newThing != null && newThing.getName() != null && !newThing.getName().isEmpty()) {
            this.inventory.add(newThing);
        }
    }

    public void addToInventory(int howMany, Furniture newThing) {
        if (howMany > 0) {
            for (int i = 0; i < howMany; ++i) {
                addToInventory(newThing);
            }
        }
    }

    public int removeFromInventory(String toRemove) {
        if (this.inventory.isEmpty()) {
            return 0;
        }
        int removed = 0;
        Iterator<Furniture> iter = this.inventory.iterator();
        while (iter.hasNext()) {
            Furniture currentFurn = iter.next();

            if (currentFurn != null && currentFurn.getName().equals(toRemove)) {
                iter.remove();
                ++removed;
            }
        }
        return removed;
    }

    public int totalInventoryValue() {
        int ret = 0;

        for (Furniture furn : inventory) {
            ret += furn.getPrice();
        }

        return ret;
    }

    public List<Furniture> getInventory() {
        List<Furniture> ret = new ArrayList<>(inventory.size());
        for (Furniture furn : inventory) {
            ret.add(furn.copy());
        }

        return ret;
    }

    public List<Furniture> findPiece(String search) {
        if (search == null) {
            return Collections.emptyList();

        } else if (search.isEmpty()) {
            return getInventory();

        } else {

            List<Furniture> founds = new ArrayList<>(this.inventory.size());

            for (Furniture furn : inventory) {
                if (furn.getName().contains(search))
                    founds.add(furn.copy());
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
