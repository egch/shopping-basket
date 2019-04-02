package org.enricogiurin.shoppingbasket;

import java.util.function.LongUnaryOperator;

/**
 * Defines the fruits along with their unit prices.
 */
public enum Fruit {
    APPLE("Apple", 25), ORANGE("Orange", 30), BANANA("Banana", 15), PAPAYA("Papaya", 50);

    public String getDescription() {
        return description;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    private final String description;
    private final int unitPrice;

    /**
     * Constructor of the enum
     *
     * @param description short description of the fruit.
     * @param unitPrice   unit price expressed in cents.
     */
    Fruit(String description, int unitPrice) {
        this.description = description;
        this.unitPrice = unitPrice;
    }

    /**
     * Binds a specific discount policy to each fruit.
     *
     * @return the convenient implementation.
     */
    public LongUnaryOperator price() {
        switch (this) {
            case PAPAYA:
                return quantity -> quantity / 3 * 2 * this.unitPrice + (quantity % 3) * this.unitPrice;
            default:
                return quantity -> quantity * this.unitPrice;
        }
    }
}
