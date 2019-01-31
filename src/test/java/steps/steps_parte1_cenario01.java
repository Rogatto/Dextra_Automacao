package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Login;
import pages.MenuAmericanas;
import utilities.ExtractJsonMockaroo;
import utilities.GeraCPF;
import utilities.Print;
import utilities.UtilDiretorio;

import java.util.concurrent.TimeUnit;

public class steps_parte1_cenario01 {

    public String diretorioEvidencia = UtilDiretorio.retornaDiretorioProjeto() + "/resources/Evidencias/";
    public WebDriver driver;
    public Login login;
    public String nome;

    @Given("^que estou na tela principal do americanas1")
    public void que_estou_na_tela_principal_do_americanas() throws Throwable {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1600,900));

        Response response = ExtractJsonMockaroo.jsonMockaroo();

        JsonPath pathjson = response.getBody().jsonPath();

        String primeiro_nome = pathjson.get("first_name ");
        String segundo_nome = pathjson.get("last_name");

        nome = primeiro_nome + " " + segundo_nome;

        MenuAmericanas americanas = new MenuAmericanas(driver);
        americanas.acessaAmericanas();
    }


    @When("^clico no link Cliente novo\\? Cadastrar antes de clicar faca login ou cadastre-se1")
    public void clico_no_link_Cliente_novo_Cadastrar_antes_de_clicar_faca_login_ou_cadastre_se() throws Throwable {
        login = new Login(driver);
        login.facaLogin();
    }


    @When("^informo o campo email com o valor de teste@hotmail.com os demais campos devem estar corretos")
    public void informo_campo_email_com_email_ja_cadastrado() throws Throwable {

        login.cadastrarLogin("teste@hotmail.com",
                "password123",
                GeraCPF.geraCPF(),
                nome,
                "06/04/1994",
                "masculino",
                "19993703939");

        Print.efetuaPrint(diretorioEvidencia + "steps_parte1_cenario01", driver);
    }

    @Then("^a mensagem de e-mail já cadastrado deve aparecer")
    public void mensagem_de_email_ja_cadasreado_deve_aparecer() throws Throwable {
        if(driver.getPageSource().contains("E-mail já cadastrado")){
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
        driver.quit();
    }
}

