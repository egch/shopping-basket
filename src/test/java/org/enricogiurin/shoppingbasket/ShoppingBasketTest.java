package org.enricogiurin.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class ShoppingBasketTest {
    private ShoppingBasket shoppingBasket = null;

    @Before
    public void setUp() throws Exception {
        this.shoppingBasket = new ShoppingBasket();
    }

    @Test
    public void addFruit() {
        //given
        assertThat(shoppingBasket.items).isEmpty();

        //when
        shoppingBasket.addFruit(Fruit.APPLE, 1);
        shoppingBasket.addFruit(Fruit.APPLE, 2);
        shoppingBasket.addFruit(Fruit.APPLE, 4);
        shoppingBasket.addFruit(Fruit.BANANA, 5);
        shoppingBasket.addFruit(Fruit.BANANA, 1);

        //then
        assertThat(shoppingBasket.items.get(Fruit.APPLE)).isEqualTo(7);
        assertThat(shoppingBasket.items.get(Fruit.BANANA)).isEqualTo(6);
    }

    @Test
    public void addFruit_ThrowException() {
        //given
        assertThat(shoppingBasket.items).isEmpty();

        //when-then
        assertThatThrownBy(() -> {
            shoppingBasket.addFruit(Fruit.ORANGE, -2);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("-2")
                .hasMessageContaining(Fruit.ORANGE.getDescription());
    }

    @Test
    public void totalByFruit() {
        //given
        assertThat(shoppingBasket.items).isEmpty();

        //when
        shoppingBasket.addFruit(Fruit.PAPAYA, 4);
        shoppingBasket.addFruit(Fruit.ORANGE, 4);
        shoppingBasket.addFruit(Fruit.APPLE, 4);
        shoppingBasket.addFruit(Fruit.BANANA, 4);

        //then
        assertThat(shoppingBasket.totalByFruit(Fruit.PAPAYA)).isEqualTo(150L);
        assertThat(shoppingBasket.totalByFruit(Fruit.ORANGE)).isEqualTo(120L);
        assertThat(shoppingBasket.totalByFruit(Fruit.APPLE)).isEqualTo(100L);
        assertThat(shoppingBasket.totalByFruit(Fruit.BANANA)).isEqualTo(60L);
    }

    @Test
    public void totalByFruit_Empty() {
        //given
        assertThat(shoppingBasket.items).isEmpty();

        //then
        assertThat(shoppingBasket.totalByFruit(Fruit.PAPAYA)).isEqualTo(0L);
        assertThat(shoppingBasket.totalByFruit(Fruit.ORANGE)).isEqualTo(0L);
        assertThat(shoppingBasket.totalByFruit(Fruit.APPLE)).isEqualTo(0L);
        assertThat(shoppingBasket.totalByFruit(Fruit.BANANA)).isEqualTo(0L);
    }

    @Test
    public void total() {
        //given
        assertThat(shoppingBasket.items).isEmpty();

        //when
        shoppingBasket.addFruit(Fruit.PAPAYA, 4);
        shoppingBasket.addFruit(Fruit.ORANGE, 4);
        shoppingBasket.addFruit(Fruit.APPLE, 4);
        shoppingBasket.addFruit(Fruit.BANANA, 4);

        //then
        assertThat(shoppingBasket.total()).isEqualTo(430L);
    }

    @Test
    public void total_empty() {
        //given
        assertThat(shoppingBasket.items).isEmpty();

        //then
        assertThat(shoppingBasket.total()).isEqualTo(0L);
    }

    @Test
    public void convertCurrency() {
        assertThat(ShoppingBasket.convertCurrency(20_000L)).isEqualTo("200");
        assertThat(ShoppingBasket.convertCurrency(0L)).isEqualTo("0");
        assertThat(ShoppingBasket.convertCurrency(1934L)).isEqualTo("19.34");
        assertThat(ShoppingBasket.convertCurrency(100L)).isEqualTo("1");
    }
}