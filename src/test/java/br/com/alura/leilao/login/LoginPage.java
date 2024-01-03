package br.com.alura.leilao.login;
import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends PageObject {
    public static final String URL_LOGIN = "http://localhost:8080/login";
    public LoginPage() {
        super(null);
        this.driver.navigate().to(URL_LOGIN);
    }

    public void preencheFormulario(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

    }
    public LeiloesPage efetuaLogin() {
        driver.findElement(By.id("login-form")).submit();
        return new LeiloesPage(driver);
    }

    public boolean isPaginaDeLogin() {
        return driver.getCurrentUrl().equals(URL_LOGIN);
    }
    public boolean isPaginaDeLoginError() {
        return driver.getCurrentUrl().equals(URL_LOGIN + "?error");
    }

    public String getNomeUsuarioLogado() {
        try {
            return driver.findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void navegaParaPaginaDeLances() {
        driver.navigate().to("http://localhost:8080/leiloes/2");
    }
    public boolean contemTextoLeilaoPage(String texto) {
        return driver.getPageSource().contains(texto);
    }


}

