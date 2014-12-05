package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.FileImpl;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by adi on 12/5/14.
 */
public abstract class FileContractTests {
    protected abstract File getFile();

    @Test
    public void aValidTextShouldBeAppendedTeExistingText(){
        File file = getFile();
        file.write("mytext");
        file.write("concatenated");

        String actual = file.toString();

        assertEquals("mytextconcatenated", actual);
    }
}
