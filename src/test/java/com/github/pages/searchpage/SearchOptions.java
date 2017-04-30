package com.github.pages.searchpage;

public enum SearchOptions {
    MOST_STARS("Most stars"),
    FEWEST_STARS("Fewest stars"),
    MOST_FORKS("Most forks");
    // etc...


    private String value;

    SearchOptions(final String value) {
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
