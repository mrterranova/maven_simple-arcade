package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame implements GameInterface {
    private final List<NumberGuessGame> players;

    public NumberGuessGame() {
        this(new ArrayList<>());
    }

    public NumberGuessGame(List<NumberGuessGame> players) {
        this.players = players;
    }

    @Override
    public void add(PlayerInterface player) {
        players.add((NumberGuessPlayer) player);
    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {

    }


//        for (PlayerInterface playerInterface : playerList) {
//            String userInput;
//
//                NumberGuessPlayer numberGuessPlayer = (NumberGuessPlayer) playerInterface;
//                System.out.print("Welcome to the number guess game");
//
//                numberGuessPlayer.play(new NumberGuessGame());

}