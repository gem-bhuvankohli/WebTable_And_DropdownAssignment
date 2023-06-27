package org.example;
//Package Imports

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//Main Class
public class Assignment1 {
    public static void main(String[] args) {
        try {

//          Change web driver according to your browser. Here Chrome browser has been used.
            WebDriver driver = new ChromeDriver();

//          User directory path
            String userDirectoryPath = System.getProperty("user.dir");

//          Launching the Dropdown.html
            driver.get(userDirectoryPath + "/src/main/resources/Dropdown.html");

//          Maximizing window size
            driver.manage().window().maximize();

//          Select element of Day dropdown
            Select drpDay = new Select(driver.findElement(By.name("dob-day")));
            drpDay.selectByVisibleText("05");

//          Select element of Month dropdown
            Select drpMonth = new Select(driver.findElement(By.name("dob-month")));
            drpMonth.selectByVisibleText("May");

//          Select element of Year dropdown
            Select drpYear = new Select(driver.findElement(By.name("dob-year")));
            drpYear.selectByVisibleText("2005");

//          Selecting date 05-05-2005 from the dropdown and validating the same.
            if (drpDay.getFirstSelectedOption().getText().equals("05") && drpMonth.getFirstSelectedOption().getText().equals("May") && drpYear.getFirstSelectedOption().getText().equals("2005")) {
                System.out.println("""
                        Selected date 05-05-2005 from the dropdown
                        and it matches with the current visible date.
                        Hence this condition is successfully validated!
                        """);
            } else {
                System.out.println("Incorrect Date is Visible");
            }

//          Checking whether the year from the dropdown is in order(default=true).
            boolean check = true;
            for (int i = 2; i < drpYear.getOptions().size() - 1; i++) {
                int currYear = Integer.parseInt(drpYear.getOptions().get(i).getText());
                int nextYear = Integer.parseInt(drpYear.getOptions().get(i + 1).getText());
                if (currYear < nextYear) {
                    check = false;
                    break;
                }
            }

            driver.close();

            if (check) {
                System.out.println("""
                        The years are in Ascending order while we move
                        from last option to the first.
                        """);
                System.out.println("All conditions validated successfully!");

            } else {
                System.out.println("The years are not in order");
            }

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