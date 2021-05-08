package com.zilleyy.wordcomp;

/**
 * Author: Zilleyy
 * <br>
 * Date: 8/05/2021 @ 2:29 pm AEST
 */
public class Word {

    private String spelling;
    private double weight;
    private int rank;

    public Word(String spelling, double weight, int rank) {
        this.spelling = spelling;
        this.weight = weight;
        this.rank = rank;
    }

    public String getSpelling() {
        return this.spelling;
    }

    public double getWeight() {
        return this.weight;
    }

    public int getRank() {
        return this.rank;
    }

}
