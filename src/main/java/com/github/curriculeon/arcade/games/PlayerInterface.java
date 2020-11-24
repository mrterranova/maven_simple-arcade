package com.github.curriculeon.arcade.games;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.utils.IOSocketInterface;

/**
 * Created by leon on 7/21/2020.
 * All players of a game should abide by `PlayerInterface`.
 * All players must have reference to the `ArcadeAccount` used to log into the `Arcade` system.
 * All players are capable of `play`ing a game.
 */
public interface PlayerInterface extends IOSocketInterface {
    /**
     * @return the `ArcadeAccount` used to log into the `Arcade` system to play this game
     */
    ArcadeAccount getArcadeAccount();

    /**
     * Defines how a specific implementation of `PlayerInterface` plays their respective game.
     * @param <SomeReturnType> specify any return type you would like here
     * @return whatever return value you would like
     */
    <SomeReturnType> SomeReturnType play();

}