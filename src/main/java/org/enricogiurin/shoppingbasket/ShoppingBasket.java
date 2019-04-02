package org.enricogiurin.shoppingbasket;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple Stateful shopping basket container.
 */
public class ShoppingBasket {
    private static final String LINE_SEPARATOR = "***************************";

    Map<Fruit, Integer> items = new TreeMap<>(Comparator.comparingInt(Fruit::ordinal));

    /**
     * Add the quantity of the specific fruit to the basket.
     *
     * @param fruit
     * @param quantity
     */
    public void addFruit(Fruit fruit, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Invalid quantity of " + fruit.getDescription() + ": " + quantity);
        }
        this.items.merge(fruit, quantity, Integer::sum);
    }

    /**
     * Calculates (in cents) the amount corresponding to the specific fruit presents in the basket.
     *
     * @param fruit
     * @return
     */
    public long totalByFruit(Fruit fruit) {
        Integer quantity = items.getOrDefault(fruit, 0);
        return fruit.price().applyAsLong(quantity);
    }

    /**
     * Calculates (in cents) the total amount to pay.
     *
     * @return
     */
    public long total() {
        return this.items.entrySet().stream()
                .map(entry -> entry.getKey().price().applyAsLong(entry.getValue()))
                .mapToLong(Long::longValue)
                .sum();
    }

    /**
     * Convenient representation of the status of the shopping basket.
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        long total = total();
        sb.append("\n").append(LINE_SEPARATOR);
        items.entrySet().stream()
                .filter(entry -> entry.getValue() >= 1)
                .forEach(entry -> sb.append("\n" + entry.getValue())
                        .append("\t").append(entry.getKey().getDescription())
                        .append("\t").append(convertCurrency(totalByFruit(entry.getKey()))));
        if (total > 0) {
            sb.append("\n").append(LINE_SEPARATOR);
        }
        sb.append("\nTotal: ").append(convertCurrency(total));
        return sb.toString();
    }

    /**
     * Returns the amount in the current currency.     *
     *
     * @param amount
     * @return
     */
    static String convertCurrency(long amount) {
        NumberFormat n = NumberFormat.getInstance();
        return n.format((double) amount / 100);
    }
}
