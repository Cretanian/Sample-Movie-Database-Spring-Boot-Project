package com.gmdb.team5.pf7project.domain;

public enum Genre {
    Romance("Romance"), Horror("Horror"), Comedy("Comedy"), Adventure("Adventure"), Action("Action"), SciFi("SciFi"),
    Drama("Drama"), Documentary("Documentary"), Mystery("Mystery"), Supernatural("Supernatural"), Psychological("Psychological"),
    SliceOfLife("SliceOfLife"), Fantasy("Fantasy"), Crime("Crime"), Thriller("Thriller"), Animation("Animation");

    private final String genre;

    Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return this.genre;
    }
}
