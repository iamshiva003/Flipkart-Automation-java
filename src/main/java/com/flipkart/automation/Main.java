package com.flipkart.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;

public class Main {

    public static void waitABit(WebDriver driver, WebElement nextPage) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> nextPage.isDisplayed());
    }

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.flipkart.com/");

        WebElement searchBar = driver.findElement(By.name("q"));

        searchBar.sendKeys("iphones");
        searchBar.sendKeys(Keys.ENTER);

        String totalPagesStr = driver.findElement(By.xpath("//span[contains(text(), 'Page 1 of ')]")).getText();
        int totalPages = Integer.parseInt(totalPagesStr.substring(totalPagesStr.length() - 2));

        WebElement nextPage = driver.findElement(By.xpath("//a[@class='_9QVEpD']/span"));

        for (int i = 0; i < totalPages; i++) {
            List<WebElement> productNames = driver.findElements(By.xpath("//div[@class=\"KzDlHZ\"]"));
            List<WebElement> productPrices = driver.findElements(By.xpath("//div[@class=\"Nx9bqj _4b5DiR\"]"));
            List<WebElement> productOverallRatings = driver.findElements(By.xpath("//div[@class=\"XQDdHH\"]"));
            List<WebElement> productRatings = driver.findElements(By.xpath("//span[contains(text(),\"Ratings\")]"));
            List<WebElement> productReviews = driver.findElements(By.xpath("//span[contains(text(),\"Reviews\")]"));
            System.out.println(productNames.size());
            for (int j = 0; j < productNames.size(); j++) {
                System.out.println(productNames.get(j).getText());
            }
            waitABit(driver, nextPage);
            nextPage.click();
        }

        driver.quit();
    }
}