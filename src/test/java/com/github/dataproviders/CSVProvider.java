package com.github.dataproviders;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVProvider {

    public static String[][] getCSVData(String fileName){
        List<Object[]> rows = new ArrayList<>();
        String userDir = System.getProperty("user.dir");
        String pathToFile = userDir + "\\src\\test\\java\\com\\github\\testdata\\" + fileName;
        try {
            CSVReader reader = new CSVReader(new FileReader(pathToFile));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null){
                rows.add(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rows.toArray(new String[rows.size()][]);
    }
}
