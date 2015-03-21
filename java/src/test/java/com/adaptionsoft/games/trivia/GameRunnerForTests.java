package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;

import java.util.Random;

/**
 * Created by adi on 3/21/15.
 */
public class GameRunnerForTests extends GameRunner {
    @Override
    protected Random getRandom(){
        return new Random(4);
    }
}
