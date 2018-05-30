import Logic.Config;
import Model.Demanda;
import Model.Enums.Estado;
import Model.Enums.Prioridade;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class testaCalculaSLA {

    private Demanda demanda = new Demanda(1, "titulo", "empres", Estado.EM_ATENDIMENTO,
            "Em Atendimento", "destino", Prioridade.URGENTE, Calendar.getInstance(),
            Calendar.getInstance(), Calendar.getInstance(), "responsavel");
    private Calendar data = Calendar.getInstance();

    {
        data.setTimeInMillis(0);
    }

    @Test
    public void teste1() {
        Calendar cal = data;
        Calendar esperado = data;
        esperado.set(2018, 06, 4, 9, 0);
        cal.set(2018, 06, 1, 17, 30);
        demanda.setDataEntradaNoEstado(cal);
        String str1 = Config.getParametros().getDateTime().format(esperado.getTime());
        String str2 = Config.getParametros().getDateTime().format(cal.getTime());
        assertEquals(str1, str2);
        assertEquals(esperado,demanda.getDataFinal());
    }

}
