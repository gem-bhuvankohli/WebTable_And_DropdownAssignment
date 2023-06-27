package org.example;
//Package Imports

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Main Class
public class Assignment2 {
    public static void main(String[] args) {
        try {

//          Change web driver according to your browser. Here Chrome browser has been used.
            WebDriver driver = new ChromeDriver();
//          User directory path
            String userDirectoryPath = System.getProperty("user.dir");
//          Launching the Dropdown.html
            driver.get(userDirectoryPath + "/src/main/resources/Assignment.html");
//          Maximizing window size
            driver.manage().window().maximize();

//          List to store names in table
            List<WebElement> nameList = driver.findElements(By.xpath("//tr/td[1]"));
//          List to store age in table
            List<WebElement> ageList = driver.findElements(By.xpath("//tr/td[2]"));

//          Map to store the frequency of names in table
            Map<String, Integer> nameFreqMap = new HashMap<>();

//          Map to store the name, and it's corresponding age in table
            Map<String, Integer> nameAndAgeMap = new HashMap<>();

            for (int i = 0; i < nameList.size(); i++) {

//              Adding name and age to nameAndAgeMap
                nameAndAgeMap.put(nameList.get(i).getText(), Integer.parseInt(ageList.get(i).getText()));

//              Setting names frequency in nameFreqMap
                if (nameFreqMap.get(nameList.get(i).getText()) != null) {
                    int nameCount = nameFreqMap.get(nameList.get(i).getText()) + 1;
                    nameFreqMap.put(nameList.get(i).getText(), nameCount);
                } else {
                    nameFreqMap.put(nameList.get(i).getText(), 1);
                }
            }

            driver.close();

//          Printing unique rows from the table
            System.out.println("The unique rows from the table are:\n");
            for (Map.Entry<String, Integer> iterator : nameFreqMap.entrySet()) {
                if (iterator.getValue() == 1) {
                    System.out.println(iterator.getKey() + " " + nameAndAgeMap.get(iterator.getKey()));
                }
            }
            System.out.println("\nThank you!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

//        **********************THANK YOU**********************

/*CREDITS:
    Bhuvan Kohli
    bhuvan.kohli@geminisolutions.com
*/