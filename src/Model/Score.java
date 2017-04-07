/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author arthur
 */
public class Score implements Serializable {

    private static final String filename = "assets/scores/scores.ser";
    public static final int LENGTH = 5;

    private int[] scores;

    public Score() {
        scores = new int[5];
    }

    public int getScores(int i) {
        return scores[i];
    }

    public void updateScores(int newScore) {

    }
}
