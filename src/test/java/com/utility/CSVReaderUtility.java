package com.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtility {

    public static Iterator<User> readCSVFile(String fileName) {
        //write validation code to check if the file passed is a valid csv file
        File csvFile = new File(System.getProperty("user.dir") + "/src/test/resources/testdata/" + fileName);
        FileReader csvFileReader = null;
        CSVReader csvReader = null;
        String[] line = null;
        List<User> userList = null;
        User userData = null;
        try {
            csvFileReader = new FileReader(csvFile);
            csvReader = new CSVReader(csvFileReader);
            userList = new ArrayList<>();

            csvReader.readNext(); //--> Skip the column names
            while((line = csvReader.readNext()) != null){
                userData = new User(line[0], line[1]);
                userList.add(userData);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return userList.iterator();
    }
}
