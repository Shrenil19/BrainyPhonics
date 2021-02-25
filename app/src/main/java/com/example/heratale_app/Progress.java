package com.example.heratale_app;

public class Progress {
    String user;
    int contractions_score = 0;

    public Progress(String user) {
        this.user = user;
    }

    public void setContractions_score(int score) {
        this.contractions_score = score;
    }
}
