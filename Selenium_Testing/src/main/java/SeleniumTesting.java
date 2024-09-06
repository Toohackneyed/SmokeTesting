import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTesting {

    public static void main(String[] args) {

        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org");

            WebElement titleWebPage = driver.findElement(By.cssSelector("#www-wikipedia-org > main > div.central-textlogo > h1 > span"));
            String titleText = titleWebPage.getText();
            String expectedText = "Wikipedia";

            if (titleText.equals(expectedText)) {
                System.out.println("1st Click Passed!");
            } else {
                System.out.println("1st Click Failed!");
                return; // Gracefully exit if the title does not match
            }

            WebElement firstClick = driver.findElement(By.id("js-link-box-en"));
            firstClick.click();

            String expectedPageTitle = "Welcome to Wikipedia";
            WebElement englishPage = driver.findElement(By.id("Welcome_to_Wikipedia"));
            if (englishPage.getText().contains(expectedPageTitle)) {
                System.out.println("Expected Page Passed!");
            } else {
                System.out.println("Expected Page Failed!");
            }

            WebElement webSearch = driver.findElement(By.cssSelector("input[placeholder='Search Wikipedia']"));
            String strSearch = "Embedded System";
            webSearch.sendKeys(strSearch);

            WebElement clickSearch = driver.findElement(By.xpath("//button[contains(@class, 'cdx-button') and contains(@class, 'cdx-search-input__end-button')]"));
            clickSearch.click();

            WebElement webSearchResult = driver.findElement(By.cssSelector("#firstHeading > span"));
            String expectedSearchResult = "Embedded system";
            if (webSearchResult.getText().equals(expectedSearchResult)) {
                System.out.println("Searching Passed!");
            } else {
                System.out.println("Searching Failed!");
            }

            driver.close();
        }
    }
