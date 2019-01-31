package pages;

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

}
