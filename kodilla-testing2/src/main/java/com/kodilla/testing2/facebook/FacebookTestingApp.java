package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookTestingApp {
    public static final String XPATH_ACCEPT_ALL = "//div[contains(@class, \"_9fiw\")]/button[2]";
    public static final String XPATH_CREATE_NEW_ACCOUNT = "//div[contains(@class, \"6ltg\")]/a";
    public static final String XPATH_DAY = "//div[contains(@class, \"_5k_5\")]/span/span/select[1]";
    public static final String XPATH_MONTH = "//div[contains(@class, \"_5k_5\")]/span/span/select[2]";
    public static final String XPATH_YEAR = "//div[contains(@class, \"_5k_5\")]/span/span/select[3]";


    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://facebook.com/");

        while (!driver.findElement(By.xpath(XPATH_ACCEPT_ALL)).isDisplayed());

        WebElement acceptButton = driver.findElement(By.xpath(XPATH_ACCEPT_ALL));
        acceptButton.click();

        WebElement newAccountButton = driver.findElement(By.xpath(XPATH_CREATE_NEW_ACCOUNT));
        newAccountButton.click();

        //Below 'while' throws 'org.openqa.selenium.NoSuchElementException'!?
        //while (!driver.findElement(By.xpath(XPATH_DAY)).isDisplayed());

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_DAY)));

        WebElement selectComboDay = driver.findElement(By.xpath(XPATH_DAY));
        Select selectDay = new Select(selectComboDay);
        selectDay.selectByValue("28");

        WebElement selectComboMonth = driver.findElement(By.xpath(XPATH_MONTH));
        Select selectMonth = new Select(selectComboMonth);
        selectMonth.selectByValue("12");

        WebElement selectComboYear = driver.findElement(By.xpath(XPATH_YEAR));
        Select selectYear = new Select(selectComboYear);
        selectYear.selectByValue("1991");
    }
}
