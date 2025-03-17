package mation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LoginTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {

            driver.get("https://www.flipkart.com/");
            driver.manage().window().maximize();


            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@title='Login'])[1]")));
            loginButton.click();


            WebElement mobileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[2]")));
            mobileInput.sendKeys("9940640216");


            WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[3]/button"));
            continueButton.click();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the OTP: ");
            String otp = scanner.nextLine();
            scanner.close();

            List<WebElement> otpInputs = driver.findElements(By.cssSelector("input.r4vIwl.IX3CMV"));
            for (int i = 0; i < otp.length(); i++) {
                otpInputs.get(i).sendKeys(String.valueOf(otp.charAt(i)));
            }


            WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
            searchBar.sendKeys("iPhone 13");

            WebElement searchButton = driver.findElement(By.xpath("//button[@aria-label='Search for Products, Brands and More']"));
            searchButton.click();


            String mainWindow = driver.getWindowHandle();
            WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href, '/p/')])[2]")));
            productLink.click();

            Set<String> allWindows = driver.getWindowHandles();
            for (String window : allWindows) {
                if (!window.equals(mainWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }


            WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Add to cart')]")));
            addToCart.click();


            WebElement deliverHere = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Deliver Here']")));
            deliverHere.click();

            WebElement continueButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='CONTINUE']")));
            continueButton2.click();


            WebElement cardNumber = wait.until(ExpectedConditions.elementToBeClickable(By.name("cardNumber")));
            cardNumber.sendKeys("1234 5678 9012 3456");

            WebElement expiryDate = driver.findElement(By.name("expiry"));
            expiryDate.sendKeys("12/26");

            WebElement cvv = driver.findElement(By.name("cvv"));
            cvv.sendKeys("123");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
