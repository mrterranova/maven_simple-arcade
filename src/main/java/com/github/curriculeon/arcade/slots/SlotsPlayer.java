package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.ArcadeAccountManager;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.arcade.numberguess.NumberGuessGame;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer implements PlayerInterface {
    ArcadeAccount arcadeAccount;
    private String player;
    private String password;


    @Override
    public ArcadeAccount getArcadeAccount() {

        return null;
    }

    @Override
    public void play(NumberGuessGame numberGuessGame) {

    }

    @Override
    public Object play() {
        return null;
    }
}