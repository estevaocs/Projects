package Params;

import Model.Enums.Prioridade;
import Model.SLA;

import javax.swing.plaf.SliderUI;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

public class Parametros {

    private static String dateFormat = "dd/MM/yyyy";
    private static String dateTimeFormat = "dd/MM/yyyy HH:mm";
    private static String horarioFormat = "HH:mm";
    private static SimpleDateFormat date = new SimpleDateFormat(dateFormat);
    private static SimpleDateFormat dateTime = new SimpleDateFormat(dateTimeFormat);
    private static SimpleDateFormat horario = new SimpleDateFormat(horarioFormat);
    private static Calendar horaDeEntrada = Calendar.getInstance();
    private static Calendar horaDeSaida = Calendar.getInstance();
    private static Calendar horarioDeAlmoco = Calendar.getInstance();
    private static Calendar horarioDeRetorno = Calendar.getInstance();
    private static Calendar tempoDeAlmoco = Calendar.getInstance();
    private static Calendar horasUteis = Calendar.getInstance();
    private static List<SLA> SLAs = new ArrayList<>();
    static {
        try {
            horaDeEntrada.setTime(horario.parse("8:30"));
            horaDeSaida.setTime(horario.parse("18:00"));
            horarioDeAlmoco.setTime(horario.parse("12:00"));
            horarioDeRetorno.setTime(horario.parse("13:30"));
            atualizar();
            instaciaSLA();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void instaciaSLA(){
        for (Prioridade prioridade:Prioridade.values()) {
            SLAs.add(new SLA(prioridade));
        }
    }

    private static void calculaHorasUteis() {
        long valor = (horaDeSaida.getTimeInMillis() - horaDeEntrada.getTimeInMillis()) - tempoDeAlmoco.getTimeInMillis();
        Date data;
        Calendar tempoUtil = Calendar.getInstance();
        data =  new Date();
        data.setTime(valor);
        tempoUtil.setTime(data);
    }

    private static void calculaTempoDeAlmoco() {
        long valor = horarioDeRetorno.getTimeInMillis() - horarioDeAlmoco.getTimeInMillis();
        Date data;
        Calendar tempoAlmoco = Calendar.getInstance();
        data =  new Date();
        data.setTime(valor);
        tempoAlmoco.setTime(data);
    }

    private static void atualizar(){
        calculaTempoDeAlmoco();
        calculaHorasUteis();
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public SimpleDateFormat getDateTime() {
        return dateTime;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public String getDateTimeFormat() {
        return dateTimeFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        this.date = new SimpleDateFormat(dateFormat);
    }

    public void setDateTimeFormat(String dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
        this.dateTime = new SimpleDateFormat(dateTimeFormat);
    }

    public void setHorarioFormat(String horarioFormat) {
        this.horarioFormat = horarioFormat;
        this.horario = new SimpleDateFormat(horarioFormat);
    }

    public static void setHoraDeEntrada(Calendar horaDeEntrada) {
        Parametros.horaDeEntrada = horaDeEntrada;
        atualizar();
    }

    public static void setHoraDeSaida(Calendar horaDeSaida) {
        Parametros.horaDeSaida = horaDeSaida;
        atualizar();
    }

    public static void setHorarioDeAlmoco(Calendar horarioDeAlmoco) {
        Parametros.horarioDeAlmoco = horarioDeAlmoco;
        atualizar();
    }

    public static void setHorarioDeRetorno(Calendar horarioDeRetorno) {
        Parametros.horarioDeRetorno = horarioDeRetorno;
        atualizar();
    }

    public static String getHorarioFormat() {
        return horarioFormat;
    }

    public static SimpleDateFormat getHorario() {
        return horario;
    }

    public static Calendar getHoraDeEntrada() {
        return horaDeEntrada;
    }

    public static Calendar getHoraDeSaida() {
        return horaDeSaida;
    }

    public static Calendar getHorarioDeAlmoco() {
        return horarioDeAlmoco;
    }

    public static Calendar getHorarioDeRetorno() {
        return horarioDeRetorno;
    }

    public static Calendar getTempoDeAlmoco() {
        return tempoDeAlmoco;
    }

    public static Calendar getHorasUteis() {
        return horasUteis;
    }
}
