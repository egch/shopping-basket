package org.enricogiurin.shoppingbasket;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.enricogiurin.shoppingbasket.Fruit.APPLE;
import static org.enricogiurin.shoppingbasket.Fruit.BANANA;
import static org.enricogiurin.shoppingbasket.Fruit.ORANGE;
import static org.enricogiurin.shoppingbasket.Fruit.PAPAYA;

/**
 * Check if the enums is complaint with the specifications.
 * Apples are 25 ct. each.
 * Oranges are 30 ct. each.
 * Bananas are 15 ct. each.
 * Papayas are 50 ct. each
 */

public class FruitTest {

    @Test
    public void getUnitPrice() {
        assertThat(APPLE.getUnitPrice()).isEqualTo(25);
        assertThat(ORANGE.getUnitPrice()).isEqualTo(30);
        assertThat(BANANA.getUnitPrice()).isEqualTo(15);
        assertThat(PAPAYA.getUnitPrice()).isEqualTo(50);
    }

    @Test
    public void price() {
        assertThat(APPLE.price().applyAsLong(3)).isEqualTo(APPLE.getUnitPrice() * 3);
        assertThat(ORANGE.price().applyAsLong(3)).isEqualTo(ORANGE.getUnitPrice() * 3);
        assertThat(BANANA.price().applyAsLong(3)).isEqualTo(BANANA.getUnitPrice() * 3);
        assertThat(PAPAYA.price().applyAsLong(3)).isEqualTo(PAPAYA.getUnitPrice() * 2);
    }
}