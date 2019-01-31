package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DataAtual {


    public static String retornadataAtual () {

        Locale locale = new Locale("pt","BR");
        Calendar calendar = Calendar.getInstance(locale);

        SimpleDateFormat formatador = new SimpleDateFormat("dd'_'MM'_'yyyy",locale);
        String data = formatador.format(calendar.getTime());

        //Data atual + 30 dias
        calendar.add(Calendar.DAY_OF_MONTH, 30);

        return data;

    }


    public  String dataSomada (int dias) {

        Locale locale = new Locale("pt","BR");
        Calendar calendar = Calendar.getInstance(locale);

        SimpleDateFormat formatador = new SimpleDateFormat("dd'/'MM'/'yyyy",locale);

        //Data atual + 30 dias
        calendar.add(Calendar.DAY_OF_MONTH, dias);

        String data = formatador.format(calendar.getTime());

        return data;

    }

}