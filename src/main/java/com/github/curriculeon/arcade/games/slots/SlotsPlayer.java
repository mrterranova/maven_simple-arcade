package com.github.curriculeon.arcade.games.slots;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.games.AbstractPlayer;
import com.github.curriculeon.utils.IOConsole;

import java.util.StringJoiner;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer extends AbstractPlayer {
    public SlotsPlayer(ArcadeAccount arcadeAccount) {
        super(arcadeAccount);
    }

    @Override
    public String play() {
        return getIOConsole().getStringInput(String.format(new StringJoiner("\n")
                .add("[ %s ] it's your turn!")
                .add("From here you can select any of the following options:")
                .add("[ pull-lever ], [ view-slots ], [ exit ]")
                .toString(), getArcadeAccount().getName()));
    }
}