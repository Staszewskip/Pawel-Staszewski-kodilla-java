package com.kodilla.facebook;

import com.kodilla.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    private static final String XPATH_COOKIES = "//div[@class=\"_4-i2 _pig _9o-c _9pll _50f4\"]/div[3]/button[1]";
    private static final String XPATH_CREATE_ACCOUNT = "//div[@class=\"_6ltg\"]/a";
    private static final String XPATH_DAY_OF_BIRTH = "//div[@class=\"_5k_5\"]/span/span/select[1]";
    private static final String XPATH_MONTH_OF_BIRTH = "//div[@class=\"_5k_5\"]/span/span/select[2]";
    private static final String XPATH_YEAR_OF_BIRTH = "//div[@class=\"_5k_5\"]/span/span/select[3]";
    private static final String XPATH_SEX_MAN = "//span[@class=\"_5k_3\"]/span[2]/input";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://facebook.com");

        driver.findElement(By.xpath(XPATH_COOKIES)).click();
        driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT)).click();

        Thread.sleep(1500);

        WebElement dayOfBirth = driver.findElement(By.xpath(XPATH_DAY_OF_BIRTH));
        Select daySelect = new Select(dayOfBirth);
        daySelect.selectByValue("1");

        WebElement monthOfBirth = driver.findElement(By.xpath(XPATH_MONTH_OF_BIRTH));
        Select monthSelect = new Select(monthOfBirth);
        monthSelect.selectByIndex(1);

        WebElement yearOfBirth = driver.findElement(By.xpath(XPATH_YEAR_OF_BIRTH));
        Select yearSelect = new Select(yearOfBirth);
        yearSelect.selectByVisibleText("2000");

        driver.findElement(By.xpath(XPATH_SEX_MAN)).click();
    }
}
