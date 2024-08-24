package com.flipkart.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
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

        }

        driver.quit();
    }
}