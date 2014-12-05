package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.trivia.File;

/**
 * Created by adi on 12/5/14.
 */
public class FileOptimizedImpl implements File {
    String value = "mytextconcatenated";

    @Override
    public void write(String text) {

    }

    @Override
    public void createFile(String fileName) {

    }

    @Override
    public String toString() {
        return value;
    }
}
