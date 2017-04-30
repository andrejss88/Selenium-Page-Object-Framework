package com.fluentselenium.utils;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertUtil {

    public static List<String> convertToStrings(List<WebElement> list) {
        return list.stream()
                .map(elem -> elem.getText())
                .collect(Collectors.toList());
    }
}
