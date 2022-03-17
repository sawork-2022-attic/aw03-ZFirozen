package com.example.webpos.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {

    private List<Item> items = new ArrayList<>();

    public boolean addItem(Item item) {
        return items.add(item);
    }

    public boolean addExistedItem(Item item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct() == item.getProduct()) {
                return items.get(i).editAmount(item.getAmount());
            }
        }
        return false;
    }

    public boolean subItem(Item item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct() == item.getProduct()) {
                if (!items.get(i).editAmount(item.getAmount())) {
                    items.remove(i);
                }
                return true;
            }
        }
        return false;
    }

    public boolean delItem(Product product) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct() == product) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (items.size() ==0){
            return "Empty Cart";
        }
        double total = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart -----------------\n"  );

        for (int i = 0; i < items.size(); i++) {
            stringBuilder.append(items.get(i).toString()).append("\n");
            total += items.get(i).getQuantity() * items.get(i).getProduct().getPrice();
        }
        stringBuilder.append("----------------------\n"  );

        stringBuilder.append("Total...\t\t\t" + total );

        return stringBuilder.toString();
    }

    public double total() {
        double sum = 0;
        for (int i = 0; i < items.size(); i++) {
            sum += items.get(i).getQuantity() * items.get(i).getProduct().getPrice();
        }
        return sum;
    }
}
