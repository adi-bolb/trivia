package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.FileImpl;
import com.adaptionsoft.games.uglytrivia.GameResultConsoleWriterImpl;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by adi on 12/4/14.
 */
public class FileImplTests extends FileContractTests {

    @Override
    protected File getFile() {
        return new FileImpl();
    }
}
