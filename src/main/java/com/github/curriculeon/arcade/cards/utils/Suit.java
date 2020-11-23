package com.github.curriculeon.arcade.cards.utils;

public enum Suit {
    HEARTS(true),
    DIAMONDS(true),
    SPADES,
    CLUBS;

    private final boolean isRed;

    Suit() {
        this(false);
    }

    Suit(boolean isRed) {
        this.isRed = isRed;
    }

    public boolean isRed() {
        return isRed;
    }
}