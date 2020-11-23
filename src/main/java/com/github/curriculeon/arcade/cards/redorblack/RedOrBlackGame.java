package com.github.curriculeon.arcade.cards.redorblack;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.arcade.cards.utils.Card;
import com.github.curriculeon.arcade.cards.utils.Deck;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;

public class RedOrBlackGame implements GameInterface<RedOrBlackPlayer> {
    private final List<RedOrBlackPlayer> playerList;

    public RedOrBlackGame() {
        this(new ArrayList<>());
    }

    public RedOrBlackGame(List<RedOrBlackPlayer> playerList) {
        this.playerList = playerList;
    }

    @Override
    public List<RedOrBlackPlayer> getPlayerList() {
        return playerList;
    }

    @Override
    public void run() {
        String userInput = null;
        Deck deck = new Deck();
        IOConsole console = new IOConsole(AnsiColor.CYAN);
        do {
            deck.shuffle();
            Card card = deck.pop();
            for (PlayerInterface player : playerList) {
                userInput = player.play();
                boolean userInputIsRed = "red".equalsIgnoreCase(userInput);
                boolean userInputIsBlack = "black".equalsIgnoreCase(userInput);
                boolean userInputIsValid = userInputIsRed || userInputIsBlack;
                boolean cardIsRed = ((Card) card).isRed();
                boolean userIsCorrectAboutRed = cardIsRed && userInputIsRed;
                boolean userIsCorrectAboutBlack = (!cardIsRed) && userInputIsBlack;
                boolean userIsCorrect = userIsCorrectAboutBlack || userIsCorrectAboutRed;

                if (userInputIsValid) {
                    if (userIsCorrect) {
                        console.println("You were correct!");
                    } else {
                        console.println("You were incorrect!");
                    }
                    console.println("The value of the card was [ %s ]", card.toString());
                }
            }
            deck.push(card);
        } while (!"quit".equalsIgnoreCase(userInput));
    }
}