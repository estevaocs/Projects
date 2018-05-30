import Logic.Calendario;
import Logic.Config;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import java.util.Calendar;

public class testaCalendario {

//    @Test
//    public void  teste(){
//        Calendar calendar = Calendar.getInstance();
//
//    }

    @Test
    public void testaGetMinutos1() {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.add(Calendar.MINUTE, 1);
        int minute = Calendario.getMinutes(cal);
        assertEquals(1, minute);
    }

    @Test
    public void testaGetMiinutos2() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.add(Calendar.HOUR, 1);
        int minute = Calendario.getMinutes(cal);
        assertEquals(60, minute);
    }

    @Test
    public void testaGetMiinutos3() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.add(Calendar.DATE, 1);
        int minute = Calendario.getMinutes(cal);
        assertEquals(1440, minute);
    }

    @Test
    public void testaGetMinutos4() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.add(Calendar.HOUR, 8);
        String str1 = Config.getParametros().getDateTime().format(cal.getTime());
        String str2 = Config.getParametros().getDateTime().format(Config.getParametros().getHorasUteis());
        assertEquals(str2, str1);

    }

    @Test
    public void testaDiffMinutos() {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.HOUR,1);
        int min = Calendario.diffMinutos(cal1,cal2);
        assertEquals(60, min);
    }

    @Test
    public void testaDiffMinutos2() {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.HOUR_OF_DAY, 8);
        cal1.set(Calendar.MINUTE,0);
        int min = Calendario.diffMinutos(Calendario.getHora(cal1), Config.getParametros().getHoraDeEntrada());
        assertEquals(30, min);
    }
}
