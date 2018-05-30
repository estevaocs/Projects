import Logic.Config;
import Params.Parametros;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Calendar;

public class testaParametros {

    @Test
    public void testaValores(){
        Calendar cal =  Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.set(Calendar.HOUR_OF_DAY, 8);
        cal.set(Calendar.MINUTE, 30);
        String str1 = Config.getParametros().getHorario().format(cal.getTime());
        String str2 = Config.getParametros().getHorario().format(Config.getParametros().getHoraDeEntrada().getTime());
        assertEquals(str1,str2);
    }

    @Test
    public void testaValores2(){
        Calendar cal =  Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.set(Calendar.HOUR_OF_DAY, 8);
        cal.set(Calendar.MINUTE, 30);
        String str1 = Config.getParametros().getDate().format(cal.getTime());
        String str2 = Config.getParametros().getDate().format(Config.getParametros().getHoraDeEntrada().getTime());
        assertEquals(str1,str2);
    }

    @Test
    public void testaValores3(){
        Calendar cal =  Calendar.getInstance();
        String str1 = Config.getParametros().getDate().format(cal.getTime());
        String str2 = "28/05/2018";
        assertEquals(str1,str2);
    }
}
