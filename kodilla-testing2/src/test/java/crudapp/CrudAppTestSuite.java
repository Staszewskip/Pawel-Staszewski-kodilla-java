package crudapp;

import com.kodilla.config.WebDriverConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class CrudAppTestSuite {
    private static WebDriver driver;
    private static Random generator;
    private static final String BASE_URL = "https://staszewskip.github.io";

    @BeforeAll
    public static void initTest() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @AfterAll
    public static void cleanUpAfterTest() {
        driver.close();
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTaskTest();
        sendTestTaskToTrello(taskName);
        Assertions.assertTrue(checkTaskExistInTrello(taskName));
        deleteTaskFromCrudApp(taskName);
    }

    private String createCrudAppTaskTest() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"v1/task\")]/fieldset[1]/input";
        final String XPATH_TASK_DESC = "//form[contains(@action, \"v1/task\")]/fieldset[2]/textarea";
        final String XPATH_BUTTON_ADD = "//form[contains(@action, \"v1/task\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement taskField = driver.findElement(By.xpath(XPATH_TASK_NAME));
        taskField.sendKeys(taskName);

        WebElement descField = driver.findElement(By.xpath(XPATH_TASK_DESC));
        descField.sendKeys(taskContent);

        WebElement buttonAdd = driver.findElement(By.xpath(XPATH_BUTTON_ADD));
        buttonAdd.click();
        Thread.sleep(2000);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(
                        By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
    }

    private boolean checkTaskExistInTrello(String taskName) throws InterruptedException {
        WebDriver trelloDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        final String TRELLO_URL = "https://trello.com/login";
        final String LOGIN_MAIL = "p.staszewski1@gmail.com";
        final String PASSWORD = "kodilla_password";
        boolean result;

        trelloDriver.get(TRELLO_URL);
        trelloDriver.findElement(By.id("user")).sendKeys(LOGIN_MAIL);
        trelloDriver.findElement(By.id("login")).click();

        Thread.sleep(2000);
        trelloDriver.findElement(By.id("password")).sendKeys(PASSWORD);
        trelloDriver.findElement(By.id("login-submit")).click();

        Thread.sleep(7000);

        trelloDriver.findElements(By.xpath("//a[@class=\"board-tile\"]"))
                .stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//div[@title=\"Kodilla Application\"]")).size() > 0)
                .forEach(WebElement::click);

        Thread.sleep(5000);

        result = trelloDriver.findElements(By.xpath("//span"))
                .stream()
                .anyMatch(match -> match.getText().equals(taskName));

        trelloDriver.close();
        return result;
    }

    private void deleteTaskFromCrudApp(String taskName) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]"))
                .stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")).getText().equals(taskName))
                .forEach(theResult -> theResult.findElement(By.xpath(".//fieldset[@class=\"datatable__row-section datatable__row-section--button-section\"]/button[4]")).click());
    }
}