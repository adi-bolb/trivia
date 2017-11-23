package com.adaptionsoft.games.uglytrivia;

public class Roll {
    public final int value;

    public Roll(int value) {
        this.value = value;
    }

    public static Roll fromInteger(int value){
        return new Roll(value);
    }

    public boolean isOdd() {
        return value % 2 != 0;
    }

    @Override
    public String toString() {
        return ""+ value;
    }
}
