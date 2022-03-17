package com.example.webpos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private Product product;
    private int quantity;

    @Override
    public String toString(){
        return product.toString() +"\t" + quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return quantity;
    }

    public boolean editAmount(int quantityModified) {
        if (quantity + quantityModified <= 0) {
            // the boolean return doesn't mean the edit success or not
            // it only represents whether the original amount is enough to be decreased or not
            // thus the Cart could identify should it delete the whole item
            return false;
        }
        else {
            quantity += quantityModified;
            return true;
        }
    }
}
