package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.GameResultWriter;

public class GameResultTextWriterImpl implements GameResultWriter{
    private File file;
    boolean isCreated = false;

    public void writeLine(String text) {
        if(!isCreated){
            String fileName = "file name not used";
            file.createFile(fileName);
            isCreated = true;
        }

        file.write(text);
    }

    public void setFile(File file) {

        this.file = file;
    }
}