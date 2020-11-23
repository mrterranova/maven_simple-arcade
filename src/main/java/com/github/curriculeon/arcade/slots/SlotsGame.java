package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.IOConsole;
import com.github.curriculeon.arcade.games.slots.SlotsPlayer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface<SlotsPlayer> {
    private List<SlotsPlayer> playerList;

    public SlotsGame() {
        this(new ArrayList<>());
    }

    public SlotsGame(List<SlotsPlayer> playerList) {
        this.playerList = playerList;
    }

    @Override
    public List<SlotsPlayer> getPlayerList() {
        return playerList;
    }

    @Override
    public void run() {
        IOConsole console = new IOConsole();
        for (PlayerInterface player : playerList) {
            SlotsReelImage image1 = null;
            SlotsReelImage image2 = null;
            SlotsReelImage image3 = null;
            String userInput;
            do {
                userInput = player.play();
                if ("pull-lever".equalsIgnoreCase(userInput)) {
                    image1 = SlotsReelImage.getRandom();
                    image2 = SlotsReelImage.getRandom();
                    image3 = SlotsReelImage.getRandom();
                } else if ("view-slots".equalsIgnoreCase(userInput)) {
                    console.println("|| %s || %s || %s ||", image1, image2, image3);
                } else if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }
            } while (!"exit".equalsIgnoreCase(userInput));
        }
    }
}