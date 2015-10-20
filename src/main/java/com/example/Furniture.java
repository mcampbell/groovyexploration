package com.example;

/**
 *
 */
public class Furniture {
    private String name;
    private int price;

    public Furniture(String name, int price) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name must not be filled out.");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Furniture copy() {
        return new Furniture(name, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Furniture furniture = (Furniture) o;

        if (price != furniture.price) return false;
        return !(name != null ? !name.equals(furniture.name) : furniture.name != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
