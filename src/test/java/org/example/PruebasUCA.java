package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PruebasUCA {
    public WebDriver driver;

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote.allow-origins=*"));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    public void writeInLogin(){
        WebElement box1 = driver.findElement(By.cssSelector("#user-name"));
        WebElement box2 = driver.findElement(By.cssSelector("#password"));
        box1.click();
        box1.sendKeys("standard_user");
        box2.click();
        box2.sendKeys("secret_sauce");

    }

    public void clickLogin(){
        WebElement login;
        login = driver.findElement(By.cssSelector("#login-button"));
        login.click();
    }

    public void addToCart(){
        WebElement Element1Add = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        WebElement Element2Add = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light"));

        Element1Add.click();
        Element2Add.click();

    }

    public void clickCart(){

        WebElement Cart = driver.findElement(By.cssSelector("#shopping_cart_container"));
        Cart.click();

    }

    public void removeToCart(){
        WebElement Element1Remove = driver.findElement(By.cssSelector("#remove-sauce-labs-backpack"));
        //WebElement Element2Remove = driver.findElement(By.cssSelector("#remove-sauce-labs-bike-light"));

        Element1Remove.click();
        //Element2Remove.click();
    }

    public void clickCheckout(){
        WebElement Checkout = driver.findElement(By.cssSelector("#checkout"));
        Checkout.click();
    }


    @Test (priority = 1)
    public void test(){
        setUp();
        writeInLogin();
        clickLogin();
        addToCart();
        clickCart();
        removeToCart();
        clickCheckout();

    }

}
