package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    public WebDriver driver;
    public String baseUrl = "https://www.americanas.com.br/";

    public Login(WebDriver driver){
        this.driver = driver;
    }

    public void facaLogin(){
        driver.findElement(By.xpath("//*[@id=\"h_user\"]")).click();

    }

    public void cadastrarLogin(String email, String senha, String cpf, String nome, String datanascimento, String sexo, String telefone)  {
        driver.findElement(By.linkText("Cliente novo? Cadastrar")).click();

        driver.findElement(By.id("email-input")).sendKeys(email);
        driver.findElement(By.id("password-input")).sendKeys(senha);
        driver.findElement(By.id("cpf-input")).sendKeys(cpf);
        driver.findElement(By.id("name-input")).sendKeys(nome);
        driver.findElement(By.id("birthday-input")).sendKeys(datanascimento);

        if(sexo == "masculino"){
            driver.findElement(By.xpath("//*[@id=\"gender\"]/div[1]/label")).click();
        } else {
            driver.findElement(By.xpath("//*[@id=\"gender\"]/div[2]/label")).click();
        }

        driver.findElement(By.id("phone-input")).sendKeys(telefone);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/button")).click();
    }
}
