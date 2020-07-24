package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class Bigmac {
    private final Bun bun;
    private final int burgers;
    private final Sauce sauce;
    private final List<Ingredient> ingredients;
    private static final int BURGERS_MIN = 1;
    private static final int BURGERS_MAX = 3;

    public static class BigmacBuilder {
        private Bun bun;
        private int burgers;
        private Sauce sauce;
        private List<Ingredient> ingredients = new ArrayList<>();

        public BigmacBuilder bun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            if (burgers >= BURGERS_MIN && burgers <= BURGERS_MAX) {
                this.burgers = burgers;
                return this;
            } else {
                throw new IllegalStateException("You can choose burgers quantity only between " +
                        BURGERS_MIN + " and " + BURGERS_MAX + "!");
            }
        }

        public BigmacBuilder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(Ingredient ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, ingredients);
        }

    }

    private Bigmac(final Bun bun, final int burgers, final Sauce sauce, final List<Ingredient> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public Bun getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String toString() {
        return "Bigmac{" +
                "bun type='" + bun + '\'' +
                ", burgers quantity='" + burgers + '\'' +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
