package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.By;
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

public class steps_parte2_cenario01 {

    public String diretorioEvidencia = UtilDiretorio.retornaDiretorioProjeto() + "/resources/Evidencias/";
    public WebDriver driver;
    public Login login;
    public String nome;
    public String email;
    public MenuAmericanas americanas;

    @Given("^que estou na tela principal do americanas4")
    public void que_estou_na_tela_principal_do_americanas() throws Throwable {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1600,900));

        Response response = ExtractJsonMockaroo.jsonMockaroo();

        JsonPath pathjson = response.getBody().jsonPath();

        String primeiro_nome = pathjson.get("first_name ");
        String segundo_nome = pathjson.get("last_name");

        nome = primeiro_nome + " " + segundo_nome;
        email = pathjson.get("email");

        americanas = new MenuAmericanas(driver);
        americanas.acessaAmericanas();
    }

    @When("^clico no link Cliente novo\\? Cadastrar antes de clicar faca login ou cadastre-se4")
    public void clico_no_link_Cliente_novo_Cadastrar_antes_de_clicar_faca_login_ou_cadastre_se() throws Throwable {
        login = new Login(driver);
        login.facaLogin();
    }

    @When("^informo todos os campos corretamente salvando novo usuario")
    public void cadastro_novo_login_valido() throws Throwable {
        login.cadastrarLogin(email,
                "Teste123@@##",
                GeraCPF.geraCPF(),
                nome,
                "06/04/1994",
                "masculino",
                "19998803131");

        Print.efetuaPrint(diretorioEvidencia + "steps_parte2_cenario01", driver);
    }

    @When("^logado na aplicacao fazer busca pelo texto Moto G6")
    public void efetua_pesquisa() {
        americanas.efetuaPesquisa("Moto G6");
    }

    @When("^adiciono dois produtos a sua cesta")
    public void adicionando_dois_produtos()  {
        americanas.efetuaPesquisa("Moto G6");

        driver.findElement(By.xpath("//*[@id=\"content-middle\"]/div[5]/div/div/div/div[1]/div[1]/a/section/div[1]/div/div/picture/img")).click();
        driver.findElement(By.xpath("//*[@id=\"btn-buy\"]/div")).click();
    }

    @When("^valido que o total da compra é inferior a 5 mil reais")
    public void compra_menor_que_cinco_mil()  {
        String preco = driver.findElement(By.xpath("//*[@id=\"offer-5b5a13a4172743a0f544dec4\"]/div/div[1]/div/div[2]/p[2]")).getAttribute("value");
    }

    @When("^valido que a compra pode ser dividida em até 10x sem juros")
    public void dividir_10x_sem_juros() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/main/div[2]/div/div/div[1]/section/div/div[2]/div/div[2]/div/div[1]/div/header/label")).click();
    }

    @Then("^deve fechar o navegador apos essa acao")
    public void a_mensagem_deve_aparecer() throws Throwable {
        driver.quit();
    }

}

