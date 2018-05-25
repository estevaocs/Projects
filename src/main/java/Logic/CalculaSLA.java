package Logic;

import Model.Demanda;
import Model.Enums.Estado;
import Model.SLA;
import Params.Parametros;

import java.util.Calendar;

public class CalculaSLA {

    private static int qntTempoHoras;
    private static int qntTempoMin;
    private static boolean iniciado = false;
    private static Calendar dataFinal = Calendar.getInstance();

    public static Calendar calcular(Demanda demanda) {
        dataFinal.setTime(demanda.getDataEntradaNoEstado().getTime());
        getHoras(demanda);
        ajustaHorario(demanda);
        return dataFinal;
    }

    private static void getHoras(Demanda demanda) {
        if (demanda.getEstado() == Estado.EM_ATENDIMENTO) {
            if (demanda.getStatus() == "Ag. Atendimento\n") {
                qntTempoHoras = getSLA(demanda).getTempoMaxInicoAtendimento().get(Calendar.HOUR_OF_DAY);
                qntTempoMin = getSLA(demanda).getTempoMaxInicoAtendimento().get(Calendar.MINUTE);
                iniciado = false;
            } else {
                qntTempoHoras = getSLA(demanda).getTempoMaxResolucao().get(Calendar.HOUR_OF_DAY);
                qntTempoMin = getSLA(demanda).getTempoMaxResolucao().get(Calendar.MINUTE);
                iniciado = true;
            }
        }
    }

    private static void ajustaHorario(Demanda demanda) {
        if(!Calendario.diaUtil(dataFinal)) {
            while (Calendario.diaUtil(dataFinal)){
                dataFinal.add(Calendar.DATE,1);
            }
            setHora(Parametros.getHoraDeEntrada());
        } else if (Calendario.getHora(dataFinal).compareTo(Calendario.getHora(Parametros.getHoraDeEntrada())) < 0) {
            setHora(Parametros.getHoraDeEntrada());
        } else if (Calendario.getHora(dataFinal).compareTo(Calendario.getHora(Parametros.getHorarioDeAlmoco())) > 0
                && Calendario.getHora(dataFinal).compareTo(Calendario.getHora(Parametros.getHorarioDeRetorno())) < 0) {
            setHora(Parametros.getHorarioDeRetorno());
        } else if (Calendario.getHora(dataFinal).compareTo(Calendario.getHora(Parametros.getHoraDeSaida())) > 0) {
            dataFinal.add(Calendar.DATE, 1);
            setHora(Parametros.getHoraDeEntrada());
        }
    }

    private static void setHora(Calendar horario) {
        dataFinal.set(Calendar.HOUR_OF_DAY, horario.get(Calendar.HOUR_OF_DAY));
        dataFinal.set(Calendar.MINUTE, horario.get(Calendar.MINUTE));
    }


    private static SLA getSLA(Demanda demanda) {
        for (SLA sla : Parametros.getSLAs()) {
            if (sla.getEmpresa() == demanda.getEmpresa() && sla.getPrioridade() == demanda.getPrioridade()) return sla;
        }
        for (SLA sla : Parametros.getSLAs()) {
            if (sla.getPrioridade() == demanda.getPrioridade()) return sla;
        }
        return null;
    }
}
