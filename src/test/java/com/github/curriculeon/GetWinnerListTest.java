package com.github.curriculeon;


import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.games.numberguess.NumberGuessGame;
import com.github.curriculeon.arcade.games.numberguess.NumberGuessPlayer;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;
import com.github.curriculeon.utils.RandomUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

public class GetWinnerListTest {
    @Test
    public void GoodWinnerListNumberGuessGame() {
        // given
        NumberGuessGame numberGuessGame = new NumberGuessGame();
        numberGuessGame.setup();
        Integer mysteryNumber = numberGuessGame.getMysteryNumber();
        ArcadeAccount arcadeAccount = new ArcadeAccount("M", "1");
        NumberGuessPlayer numberGuessPlayer = new NumberGuessPlayer(arcadeAccount) {
            @Override
            public IOConsole getIOConsole() {
                String userInput = mysteryNumber.toString();
                byte[] inputBytes = userInput.getBytes();
                ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
                IOConsole console = new IOConsole(AnsiColor.AUTO, inputByteArray, System.out) {
                    @Override
                    public String getStringInput(String prompt, Object... args) {
                        new IOConsole().println(userInput);
                        return super.getStringInput(prompt, args);
                    }
                };
                return console;
            }
        };
        numberGuessGame.add(numberGuessPlayer);
        numberGuessGame.run();

        // when
        List<NumberGuessPlayer> winnerList = numberGuessGame.getWinnerList();

        // then
        System.out.println("The mystery number was: " + mysteryNumber);
        Assert.assertTrue(winnerList.contains(numberGuessPlayer));

    }

    @Test
    public void MultipleWinnersTest() {
        // given
        NumberGuessGame numberGuessGame = new NumberGuessGame();
        numberGuessGame.setup();
        Integer mysteryNumber = numberGuessGame.getMysteryNumber();
        ArcadeAccount arcadeAccount = new ArcadeAccount("M", "1");
        NumberGuessPlayer numberGuessPlayer = new NumberGuessPlayer(arcadeAccount) {
            @Override
            public IOConsole getIOConsole() {
                String userInput = mysteryNumber.toString();
                byte[] inputBytes = userInput.getBytes();
                ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
                IOConsole console = new IOConsole(AnsiColor.AUTO, inputByteArray, System.out) {
                    @Override
                    public String getStringInput(String prompt, Object... args) {
                        new IOConsole().println(userInput);
                        return super.getStringInput(prompt, args);
                    }
                };
                return console;
            }
        };
        numberGuessGame.add(numberGuessPlayer);
        numberGuessGame.run();

        // when
        List<NumberGuessPlayer> winnerList = numberGuessGame.getWinnerList();

        // then
        System.out.println("The mystery number was: " + mysteryNumber);
        Assert.assertTrue(winnerList.contains(numberGuessPlayer));

    }

    @Test
    public void BadWinnerListNumberGuessGame() {
        // given
        NumberGuessGame numberGuessGame = new NumberGuessGame();
        numberGuessGame.setup();
        int mysteryNumber = numberGuessGame.getMysteryNumber();
        int incorrectNumber = RandomUtils.createInteger(0,9);
        while (incorrectNumber == mysteryNumber){
            incorrectNumber = RandomUtils.createInteger(0,9);
        }
        ArcadeAccount arcadeAccount = new ArcadeAccount("M", "1");
        int finalIncorrectNumber = incorrectNumber;
        NumberGuessPlayer numberGuessPlayer = new NumberGuessPlayer(arcadeAccount) {
            @Override
            public IOConsole getIOConsole() {
                String userInput = finalIncorrectNumber +"";
                byte[] inputBytes = userInput.getBytes();
                ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
                IOConsole console = new IOConsole(AnsiColor.AUTO, inputByteArray, System.out) {
                    @Override
                    public String getStringInput(String prompt, Object... args) {
                        new IOConsole().println(userInput);
                        return super.getStringInput(prompt, args);
                    }
                };
                return console;
            }
        };
        numberGuessGame.add(numberGuessPlayer);
        numberGuessGame.run();

        // when
        List<NumberGuessPlayer> winnerList = numberGuessGame.getWinnerList();

        // then
        System.out.println("Your guess was: " + finalIncorrectNumber);
        System.out.println("The mystery number was: " + mysteryNumber);
        Assert.assertFalse(winnerList.contains(numberGuessPlayer));

    }
}
