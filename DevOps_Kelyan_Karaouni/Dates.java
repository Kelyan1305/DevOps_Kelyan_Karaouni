package com.example.DevOps_Kelyan_Karaouni;

public class Dates {
    private String begin;
    private String end;

    // Constructeur par défaut nécessaire pour la désérialisation JSON
    public Dates() {}

    public Dates(String begin, String end) {
        this.begin = begin;
        this.end = end;
    }

    // Getters
    public String getBegin() { return begin; }
    public String getEnd() { return end; }

    // Setters
    public void setBegin(String begin) { this.begin = begin; }
    public void setEnd(String end) { this.end = end; }
}

