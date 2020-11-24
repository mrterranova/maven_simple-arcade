package com.github.curriculeon.arcade.games.cards.redorblack;

import com.github.curriculeon.arcade.games.AbstractGame;
import com.github.curriculeon.arcade.games.cards.utils.Card;
import com.github.curriculeon.arcade.games.cards.utils.Deck;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

public class RedOrBlackGame extends AbstractGame<RedOrBlackPlayer> {
    private Deck deck;
    private Card card;

    public RedOrBlackGame() {
        this(new Deck());
    }

    public RedOrBlackGame(Deck deck) {
        this.deck = deck;
    }

    @Override
    public void setup() {
        deck.shuffle();
        this.card = deck.pop();
    }

    @Override
    public void run() {
        String userInput;
        IOConsole console = getIOConsole(AnsiColor.PURPLE);
        for (RedOrBlackPlayer player : getPlayerList()) {
            userInput = player.play();
            boolean userInputIsRed = "red".equalsIgnoreCase(userInput);
            boolean userInputIsBlack = "black".equalsIgnoreCase(userInput);
            boolean userInputIsValid = userInputIsRed || userInputIsBlack;
            boolean cardIsRed = getCard().getSuit().isRed();
            boolean userIsCorrectAboutRed = cardIsRed && userInputIsRed;
            boolean userIsCorrectAboutBlack = (!cardIsRed) && userInputIsBlack;
            boolean userIsCorrect = userIsCorrectAboutBlack || userIsCorrectAboutRed;

            if (userInputIsValid) {
                if (userIsCorrect) {
                    getWinnerList().add(player);
                }
            }
        }
        console.println("The value of the card was [ %s ]", getCard().toString());
        console.println("The following is a list of winners:");
        console.println(getWinnerList().toString());
    }

    public Card getCard() {
        return card;
    }
}