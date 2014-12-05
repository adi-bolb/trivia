package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.GameResultWriter;

/**
 * Created by adi on 12/4/14.
 */
public class GameResultTextWriterImpl implements GameResultWriter{
    private File file;
    boolean isCreated = false;

    public void writeLine(String text) {
        if(!isCreated){
            file.createFile("some file");
            isCreated = true;
        }

        file.write(text);
    }

    public void setFile(File file) {

        this.file = file;
    }
}
