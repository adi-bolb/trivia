package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.trivia.File;

/**
 * Created by adi on 12/5/14.
 */
public class FileImpl implements File {
    private String text = "";

    @Override
    public void write(String text) {
        this.text += text;
    }

    @Override
    public void createFile(String fileName) {

    }

    @Override
    public String toString() {
        return text;
    }
}
