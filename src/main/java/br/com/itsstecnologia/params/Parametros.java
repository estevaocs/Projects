package br.com.itsstecnologia.params;

import Logic.Calendario;
import Logic.Config;
import Model.Enums.Prioridade;
import Model.Feriado;
import Model.SLA;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class Parametros {

    private  String dateFormat = "dd/MM/yyyy";
    private  String dateTimeFormat = "dd/MM/yyyy HH:mm";
    private  String horarioFormat = "HH:mm";
    private  SimpleDateFormat date = new SimpleDateFormat(dateFormat);
    private  SimpleDateFormat dateTime = new SimpleDateFormat(dateTimeFormat);
    private  SimpleDateFormat horario = new SimpleDateFormat(horarioFormat);
    private  Calendar horaDeEntrada = Calendar.getInstance();
    private  Calendar horaDeSaida = Calendar.getInstance();
    private  Calendar horarioDeAlmoco = Calendar.getInstance();
    private  Calendar horarioDeRetorno = Calendar.getInstance();
    private  long tempoDeAlmoco;
    private  long horasUteis;
    private  List<SLA> slas;
    private  List<Feriado> feriados;

    public Parametros() {
        feriados = new ArrayList<>();
        slas = new ArrayList<>();

        horaDeEntrada.set(1970,1,1,8,30);
        horaDeSaida.set(1970,1,1, 18,0);
        horarioDeAlmoco.set(1970,1,1,12,00);
        horarioDeRetorno.set(1970,1,1,13,30);

        atualizar();
        instaciaSLA();
    }

    private  void instaciaSLA() {
        for (Prioridade prioridade : Prioridade.values()) {
            SLA sla = new SLA(prioridade);
            slas.add(sla);
        }
    }

    private  void calculaHorasUteis() {
        horasUteis = (long) (horaDeSaida.getTimeInMillis() - horaDeEntrada.getTimeInMillis()) - tempoDeAlmoco;
    }

    private  void calculaTempoDeAlmoco() {
        tempoDeAlmoco = horarioDeRetorno.getTimeInMillis() - horarioDeAlmoco.getTimeInMillis();
    }

    private  void atualizar() {
        calculaTempoDeAlmoco();
        calculaHorasUteis();
    }

    public  SimpleDateFormat getDate() {
        return date;
    }

    public  SimpleDateFormat getDateTime() {
        return dateTime;
    }

    public  SimpleDateFormat getHorario() {
        return horario;
    }

    public  Calendar getHoraDeEntrada() {
        return horaDeEntrada;
    }

    public  Calendar getHoraDeSaida() {
        return horaDeSaida;
    }

    public  Calendar getHorarioDeAlmoco() {
        return horarioDeAlmoco;
    }

    public  Calendar getHorarioDeRetorno() {
        return horarioDeRetorno;
    }

    public  long getTempoDeAlmoco() {
        return tempoDeAlmoco;
    }

    public  long getHorasUteis() {
        return horasUteis;
    }

    public  List<SLA> getSLAs() {
        return slas;
    }

    public  List<Feriado> getFeriados() {
        return feriados;
    }
}
