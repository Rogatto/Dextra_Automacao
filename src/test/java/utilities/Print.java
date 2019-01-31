package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Print {

    public static void efetuaPrint(String diretorio_nome_arq, WebDriver driver) throws IOException {


            String diretorio = diretorio_nome_arq + "_" + DataAtual.retornadataAtual() + ".png";

            //Retira Evidência
            File scrnsht1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrnsht1, new File(diretorio));

        }
    }

