package com.github.curriculeon.arcade.games.cards.utils;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private final Stack<Card> cardStack;

    public Deck() {
        this(new Stack<>());
        for(Suit suit : Suit.values()) {
            for(Rank rank : Rank.values()) {
                cardStack.push(new Card(suit, rank));
            }
        }
    }

    public Deck(Stack<Card> cardStack) {
        this.cardStack = cardStack;
    }

    public void push(Card card) {
        this.cardStack.push(card);
    }

    public Card peek() {
        return cardStack.peek();
    }

    public Card pop() {
        return cardStack.pop();
    }


    public void shuffle() {
        Collections.shuffle(cardStack);
    }
}
