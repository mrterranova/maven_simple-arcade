package com.github.curriculeon.utils;

/**
 * Created by leon on 7/21/2020.
 * used to create color for output of `IOConsole`
 */
public enum AnsiColor {
    AUTO(0),
    BLACK(3),
    RED(31),
    GREEN(32),
    YELLOW(33),
    BLUE(34),
    PURPLE(35),
    CYAN(36),
    WHITE(37);

    private final String color;

    AnsiColor(int ansiNumber) {
        this.color = "[\u001B[" + ansiNumber + "m";
    }

    public String getColor() {
        return color;
    }

}