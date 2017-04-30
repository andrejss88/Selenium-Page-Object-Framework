package com.github.pages.searchpage;

public enum LanguagePanel {
    JAVA("Java"),
    HTML("HTML"),
    PYTHON("Python");


    private String value;

    LanguagePanel(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
