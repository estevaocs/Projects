package Logic;

import Model.Feriado;
import Params.Parametros;

import java.util.Calendar;

public class Calendario {

    public static Calendar getHora(Calendar cal) {
        Calendar calen = Calendar.getInstance();
        calen.set(0,0,0,cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
        return calen;
    }

    public static Calendar getData(Calendar cal) {
        Calendar calen = Calendar.getInstance();
        calen.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DATE));
        return calen;
    }

    public static boolean diaUtil(Calendar cal) {
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
                || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) return false;
        else {
            for (Feriado feriado:Parametros.getFeriados()) {
                if(getData(cal).compareTo(getData(feriado.getData())) == 0) return false;
            }
            return true;
        }
    }
}
