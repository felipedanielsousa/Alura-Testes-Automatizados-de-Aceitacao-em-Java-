package br.com.alura.leilao.lance;

import br.com.alura.leilao.PageObject;

public class LancesPage extends PageObject {
    private static final String URL_LANCES = "http://localhost:8080/leiloes";

    public  LancesPage(){
        super(null);
        driver.navigate().to(URL_LANCES);
    }
    public boolean isPaginaAtual() {
        return driver.getCurrentUrl().contains(URL_LANCES);
    }

    public boolean isTituloLeilaoVisivel() {
        return driver.getPageSource().contains("Dados do Leilão");
    }
}
