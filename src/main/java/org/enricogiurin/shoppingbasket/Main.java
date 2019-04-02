package org.enricogiurin.shoppingbasket;

import java.util.Scanner;

/**
 * Main class of the project
 */
public class Main {
    public static void main(String[] args) {

        ShoppingBasket shoppingBasket = new ShoppingBasket();
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("\nQuantity of Apples: ");
            shoppingBasket.addFruit(Fruit.APPLE, scanner.nextInt());
            System.out.print("\nQuantity of Oranges: ");
            shoppingBasket.addFruit(Fruit.ORANGE, scanner.nextInt());
            System.out.print("\nQuantity of Bananas: ");
            shoppingBasket.addFruit(Fruit.BANANA, scanner.nextInt());
            System.out.print("\nQuantity of Papayas: ");
            shoppingBasket.addFruit(Fruit.PAPAYA, scanner.nextInt());

            System.out.println(shoppingBasket);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }


}
