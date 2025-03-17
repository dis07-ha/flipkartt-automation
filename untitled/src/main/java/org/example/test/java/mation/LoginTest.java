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
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
        driver.findElement(By.xpath("(//a[@title='Login'])[1]")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("9080319780");
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[3]/button")).click();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the OTP: ");
        String otp = scanner.nextLine();
        scanner.close();

        List<WebElement> otpInputs = driver.findElements(By.cssSelector("input.r4vIwl.IX3CMV"));

        for (int i = 0; i < otp.length(); i++) {
            otpInputs.get(i).sendKeys(String.valueOf(otp.charAt(i)));
        }

        Thread.sleep(10000);




        WebElement searchBar = driver.findElement(By.xpath("//input[@name='q']"));
        searchBar.sendKeys("iPhone 13");

        driver.findElement(By.xpath("//button[contains(@class, 'MJG8Up')]")).click();


            String mainPage = driver.getWindowHandle();
            System.out.println("Main page" + mainPage);
        driver.findElement(By.xpath("//a[contains(text(),'Apple iPhone 13')]")).click();

            Set<String> allPages = driver.getWindowHandles();
            for (String page : allPages) {
                if (!page.equals(mainPage)) {
                    driver.switchTo().window(page);
                    break;
                }
            }
            // Shorter XPath (using class or text)
            driver.findElement(By.cssSelector("button[type='submit']")).click();


            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2));
            driver.findElement(By.xpath("//button[text()='Deliver Here']")).click();
        driver.findElement(By.xpath("//button[text()='CONTINUE']")).click();
            WebElement cardNumber = wait.until(ExpectedConditions.elementToBeClickable(By.name("cardNumber")));
            cardNumber.sendKeys("1234 5678 9012 3456");

            WebElement expiryDate = driver.findElement(By.name("expiry"));
            expiryDate.sendKeys("12/26");

            WebElement cvv = driver.findElement(By.name("cvv"));
            cvv.sendKeys("123");

        }
    }

