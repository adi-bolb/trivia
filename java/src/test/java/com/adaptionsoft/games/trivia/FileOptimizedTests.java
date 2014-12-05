package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.FileOptimizedImpl;

/**
 * Created by adi on 12/5/14.
 */
public class FileOptimizedTests extends FileContractTests {
    @Override
    protected File getFile() {
        return new FileOptimizedImpl();
    }

    // Can write tests for optimized file writing
}
