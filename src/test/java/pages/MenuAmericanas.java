package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuAmericanas {
    
    public WebDriver driver;
    public String baseUrl = "https://www.americanas.com.br/";
    
    public MenuAmericanas(WebDriver driver){
        this.driver = driver;
    }

    public void acessaAmericanas(){
        driver.get(baseUrl);
    }

    public void efetuaPesquisa(String itembusca){
        driver.findElement(By.id("h_search-input")).sendKeys(itembusca);
    }
}
