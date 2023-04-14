package com.kodilla;

import com.kodilla.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrelloDelete {

    public static void main(String[] args) throws InterruptedException{

        String taskName = "Task number 72176";
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://staszewskip.github.io/");
        Thread.sleep(2000);
        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]"))
                .stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")).getText().equals(taskName))
                .forEach(theResult -> theResult.findElement(By.xpath(".//fieldset[@class=\"datatable__row-section datatable__row-section--button-section\"]/button[4]")).click());
    }
}