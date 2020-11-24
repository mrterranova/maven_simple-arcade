package com.github.curriculeon.utils;

import java.io.InputStream;
import java.io.PrintStream;

public interface IOSocketInterface {
    default IOConsole getIOConsole() {
        return getIOConsole(AnsiColor.AUTO);
    }

    default IOConsole getIOConsole(AnsiColor color) {
        return getIOConsole(color, System.in, System.out);
    }

    default IOConsole getIOConsole(AnsiColor color, InputStream inputStream, PrintStream outputStream) {
        return new IOConsole(color, inputStream, outputStream);
    }
}