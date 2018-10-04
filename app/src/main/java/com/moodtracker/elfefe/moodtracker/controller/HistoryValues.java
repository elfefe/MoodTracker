package com.moodtracker.elfefe.moodtracker.controller;

public class HistoryValues {

    private String quote;
    private int quoteColor;

    public HistoryValues(String quote, int quoteWidth) {
        this.quote = quote;
        this.quoteColor = quoteWidth;
    }

    public String getQuote() { return quote; }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public int getQuoteColor() {
        return quoteColor;
    }

    public void setQuoteColor(int quoteColor) {
        this.quoteColor = quoteColor;
    }
}
