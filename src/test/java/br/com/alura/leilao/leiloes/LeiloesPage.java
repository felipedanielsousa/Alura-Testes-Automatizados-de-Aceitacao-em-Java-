package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeiloesPage extends PageObject {

    public static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
    public static final String URL_LEILOES = "http://localhost:8080/leiloes";


    public LeiloesPage(WebDriver driver) {
        super(driver);
    }

    public CadastroLeilaoPage carregarFormulario() {
        this.driver.navigate().to(URL_CADASTRO_LEILAO);
        return new CadastroLeilaoPage(driver);
    }

    public boolean isLeilaoCadastrado(String nome, String valor, String data) {
        WebElement ultimaLinhaTabela = this.driver.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
        WebElement colunaNome = ultimaLinhaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement colunaDataAbertura = ultimaLinhaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement colunaValorInicial = ultimaLinhaTabela.findElement(By.cssSelector("td:nth-child(3)"));


        return colunaNome.getText().equals(nome) && colunaDataAbertura.getText().equals(data)
                && colunaValorInicial.getText().equals(valor);
    }

    public boolean isPaginaAtual() {
        return driver.getCurrentUrl().equals(URL_LEILOES);
    }
}
