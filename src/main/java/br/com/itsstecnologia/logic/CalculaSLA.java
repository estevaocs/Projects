package br.com.itsstecnologia.logic;


import br.com.itsstecnologia.model.Demanda;
import br.com.itsstecnologia.model.SLA;

import java.util.Calendar;

public class CalculaSLA {

    private static Calendar dataFinal = Calendar.getInstance();
    private static long tempo;
    private static int qntTempoMin;
    private static int qntTempoHoras;

    public static Calendar calcular(Demanda demanda) {
        tempo = demanda.getDataEntradaNoEstado().getTimeInMillis();
        dataFinal.setTimeInMillis(tempo);
        getHoras(demanda);
        ajustaHorario(true);
        calcula();
        return dataFinal;
    }

    private static void getHoras(Demanda demanda) {
        SLA sla = getSLA(demanda);
        if (demanda.getStatus() == "Ag. Atendimento") {
            qntTempoHoras = sla.getTempoMaxInicoAtendimentoHoras();
            qntTempoMin = sla.getTempoMaxInicoAtendimentoMinutos();
        } else {
            qntTempoHoras = sla.getTempoMaxResolucaoHoras();
            qntTempoMin = sla.getTempoMaxResolucaoMinutos();
        }

    }

    private static void calcula() {
        int i;
        for (i = 0; i < qntTempoMin; i++) {
            dataFinal.add(Calendar.MINUTE, 1);
            ajustaHorario(false);
        }
        for (i = 0; i < qntTempoHoras; i++) {
            dataFinal.add(Calendar.HOUR, 1);
            ajustaHorario(false);
        }
        ajustaHorario(false);
    }


    private static void ajustaHorario(boolean bool) {
        if (bool) {
            if (!Calendario.ehDiaUtil(dataFinal)) {
                descontaNaoUtil();
                setHora(Config.getParametros().getHoraDeEntrada());
                ajustaHorario(bool);
            } else if (Calendario.getHora(dataFinal).compareTo(Calendario.getHora(Config.getParametros().getHoraDeEntrada())) < 0) {
                dataFinal.add(Calendar.MINUTE,
                        Calendario.diffMinutos(Calendario.getHora(dataFinal), Config.getParametros().getHoraDeEntrada()));
            } else if (Calendario.getHora(dataFinal).compareTo(Calendario.getHora(Config.getParametros().getHorarioDeAlmoco())) > 0
                    && Calendario.getHora(dataFinal).compareTo(Calendario.getHora(Config.getParametros().getHorarioDeRetorno())) < 0) {
                setHora(Config.getParametros().getHorarioDeRetorno());
            } else if (Calendario.getHora(dataFinal).compareTo(Calendario.getHora(Config.getParametros().getHoraDeSaida())) >= 0) {
                dataFinal.add(Calendar.DATE, 1);
                setHora(Config.getParametros().getHoraDeEntrada());
            }
        } else {
            if (!Calendario.ehDiaUtil(dataFinal)) {
                descontaNaoUtil();
                ajustaHorario(bool);
            } else if (Calendario.getHora(dataFinal).compareTo(Calendario.getHora(Config.getParametros().getHoraDeEntrada())) < 0) {
                dataFinal.add(Calendar.MINUTE,
                        Calendario.diffMinutos(Calendario.getHora(dataFinal), Config.getParametros().getHoraDeEntrada()));
            } else if (Calendario.getHora(dataFinal).compareTo(Calendario.getHora(Config.getParametros().getHorarioDeAlmoco())) > 0
                    && Calendario.getHora(dataFinal).compareTo(Calendario.getHora(Config.getParametros().getHorarioDeRetorno())) < 0) {
                dataFinal.add(Calendar.MILLISECOND, (int) Config.getParametros().getTempoDeAlmoco());
            } else if (Calendario.getHora(dataFinal).compareTo(Calendario.getHora(Config.getParametros().getHoraDeSaida())) > 0) {
                dataFinal.add(Calendar.MILLISECOND, (int) Config.getParametros().getHorasUteis());
            }
        }
    }

    private static void descontaNaoUtil() {
        while (!Calendario.ehDiaUtil(dataFinal)) {
            dataFinal.add(Calendar.DATE, 1);
        }
    }

    private static void setHora(Calendar horario) {
        dataFinal.set(Calendar.HOUR_OF_DAY, horario.get(Calendar.HOUR_OF_DAY));
        dataFinal.set(Calendar.MINUTE, horario.get(Calendar.MINUTE));
    }


    private static SLA getSLA(Demanda demanda) {
        for (SLA sla : Config.getParametros().getSLAs()) {
            if (sla.getEmpresa() == demanda.getEmpresa() && sla.getPrioridade() == demanda.getPrioridade()) return sla;
        }
        for (SLA sla : Config.getParametros().getSLAs()) {
            if (sla.getPrioridade() == demanda.getPrioridade()) return sla;
        }
        return null;
    }
}
