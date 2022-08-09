package com.epam.training.Matthew_Zhigalo.WebDriver.bring_it_on.model;

import java.util.Objects;

public class PasteBinModel {

    private final String pasteText;
    private final String expirationTime;
    private final String textHighlighting;
    private final String pasteTitle;

    public PasteBinModel(String pasteText, String expirationTime, String textHighlighting, String pasteTitle) {
        this.pasteText = pasteText;
        this.expirationTime = expirationTime;
        this.textHighlighting = textHighlighting;
        this.pasteTitle = pasteTitle;
    }

    public String getPasteText() {
        return pasteText;
    }

    public String getExpirationTime() {
        return expirationTime;
    }

    public String getTextHighlighting() {
        return textHighlighting;
    }

    public String getPasteTitle() {
        return pasteTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasteBinModel that = (PasteBinModel) o;
        return Objects.equals(pasteText, that.pasteText)
                && Objects.equals(expirationTime, that.expirationTime)
                && Objects.equals(textHighlighting, that.textHighlighting)
                && Objects.equals(pasteTitle, that.pasteTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pasteText, expirationTime, textHighlighting, pasteTitle);
    }

    @Override
    public String toString() {
        return "PasteBinModel{" +
                "pasteText='" + pasteText + '\'' +
                ", expirationTime='" + expirationTime + '\'' +
                ", textHighlighting='" + textHighlighting + '\'' +
                ", pasteTitle='" + pasteTitle + '\'' +
                '}';
    }
}
