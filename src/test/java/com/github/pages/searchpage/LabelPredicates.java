package com.github.pages.searchpage;

import java.util.function.Predicate;

public class LabelPredicates {


    public static Predicate<String> is(LanguagePanel lang) {
        return (String s) -> s.equalsIgnoreCase(lang.toString());
    }

    public static Predicate<String> isNot(LanguagePanel lang) {
        return (String s) -> !s.equalsIgnoreCase(lang.toString());
    }
}
