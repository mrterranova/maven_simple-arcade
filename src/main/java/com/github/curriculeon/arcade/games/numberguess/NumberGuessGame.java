package com.github.curriculeon.arcade.games.numberguess;

import com.github.curriculeon.arcade.games.AbstractGame;
import com.github.curriculeon.arcade.games.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame extends AbstractGame<NumberGuessPlayer> {
    private int mysteryNumber;

    @Override
    public void setup() {
        this.mysteryNumber = ThreadLocalRandom.current().nextInt(0, 10);
    }

    @Override
    public void run() {
        IOConsole console = getIOConsole(AnsiColor.RED);
        for (NumberGuessPlayer player : getPlayerList()) {
            Integer numberGuessedByPlayer = player.play();
            if (numberGuessedByPlayer.equals(getMysteryNumber())) {
                getWinnerList().add(player);
            }
        }
        console.println("The following is a list of players who guessed the correct value:");
        console.println(getWinnerList().stream().map(player -> player.getName()).toString());
    }

    public int getMysteryNumber() {
        return mysteryNumber;
    }
}