package ramiz.backend.frontend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class yandexMesto {

    private WebDriver driver;

    @Test
    public void test() {
        // Создаём драйвер для браузера Chrome

        driver = new ChromeDriver();
        driver.get("https://qa-mesto.praktikum-services.ru/");
        driver.findElement(By.xpath(".//input[@class='auth-form__textfield' and @id='email']")).sendKeys("amelie1908@inbox.ru");
        driver.findElement(By.xpath(".//input[@class='auth-form__textfield' and @id='password']")).sendKeys("19082015");
        driver.findElement(By.xpath(".//button[@class='auth-form__button']")).click();
        new WebDriverWait(driver,  Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("profile__image")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Кликни по кнопке добавления нового контента
        driver.findElement(By.xpath(".//button[@class = 'profile__add-button']")).click();
        // В поле названия введи «Прага»
        driver.findElement(By.xpath(".//input[@class = 'popup__input popup__input_type_card-name']")).sendKeys("Прага");
        // В поле ссылки на изображение введи ссылку
        driver.findElement(By.xpath(".//input[@class = 'popup__input popup__input_type_url']")).sendKeys("https://code.s3.yandex.net/qa-automation-engineer/java/files/new_photo_selenium.jpg");
        // Сохрани контент
        driver.findElement(By.xpath(".//form[@name='new-card']/button[text()='Сохранить']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Дождись появления кнопки удаления карточки
        new WebDriverWait(driver,  Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='card__delete-button card__delete-button_visible']")));
        // Удали контент
        driver.findElement(By.xpath(".//button[@class='card__delete-button card__delete-button_visible']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

   @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
