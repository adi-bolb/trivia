package com.adaptionsoft.games.uglytrivia;

public class Roll {
    private final int number;

    public Roll(int number) {
        this.number = number;
    }

    public boolean isOdd() {
        return number % 2 != 0;
    }
}
