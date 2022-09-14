package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearch {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        new WebDriverWait(driver, 10)
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='q']")));
        WebElement searchInput = driver.findElement(By.xpath("//input[@name='q']"));
        searchInput.sendKeys("value");
        searchInput.submit();
        List<WebElement> listItems = driver.findElements(By.cssSelector("a > h3"));
        for (WebElement listItem : listItems) {
            String textLabel = listItem.getText();
            arrayList.add(textLabel);
        }
        System.out.println("Результат поиска:");
        int counter = 1;
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(counter++ + ". " + arrayList.get(i) );
        }
        driver.quit();
    }


}
