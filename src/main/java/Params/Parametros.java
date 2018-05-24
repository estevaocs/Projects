package Params;

import java.text.AttributedCharacterIterator;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Parametros {

    private SimpleDateFormat date;
    private SimpleDateFormat dateTime;
    private SimpleDateFormat horario;
    private String dateFormat = "dd/MM/yyyy";
    private String dateTimeFormat = "dd/MM/yyyy HH:mm";
    private String horarioFormat = "HH:mm";
    private Date horaDeEntrada;
    private Date horaDeSaida;
    private Date horarioDeAlmoco;
    private Date horarioDeRetorno;
    private Date tempoDeAlmoco;
    private Date horasUteis;

    public Parametros() {
        this.date = new SimpleDateFormat(dateFormat);
        this.dateTime = new SimpleDateFormat(dateTimeFormat);
        this.horario = new SimpleDateFormat(horarioFormat);
        this.horaDeEntrada = new Date(0,0,0,8,30);
        this.horaDeSaida= new Date(0,0,0,18,0);
        this.horarioDeAlmoco= new Date(0,0,0,12,0);
        this.horarioDeRetorno = new Date(0,0,0,13,30);
        atualizar();
    }

    private Date calculaHorasUteis() {
        return new Date((horaDeSaida.getTime() - horaDeEntrada.getTime()) - tempoDeAlmoco.getTime());
    }

    private Date calculaTempoDeAlmoço() {
        return new Date(horarioDeRetorno.getTime() - horarioDeAlmoco.getTime());
    }

    private void atualizar(){
        this.tempoDeAlmoco = calculaTempoDeAlmoço();
        this.horasUteis = calculaHorasUteis();
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


    public void setHoraDeEntrada(Date horaDeEntrada) {
        this.horaDeEntrada = horaDeEntrada;
        atualizar();
    }

    public void setHoraDeSaida(Date horaDeSaida) {
        this.horaDeSaida = horaDeSaida;
        atualizar();
    }

    public void setHorarioDeAlmoco(Date horarioDeAlmoco) {
        this.horarioDeAlmoco = horarioDeAlmoco;
        atualizar();
    }

    public void setHorarioDeRetorno(Date horarioDeRetorno) {
        this.horarioDeRetorno = horarioDeRetorno;
        atualizar();
    }

    public SimpleDateFormat getHorario() {
        return horario;
    }

    public String getHorarioFormat() {
        return horarioFormat;
    }

    public Date getHoraDeEntrada() {
        return horaDeEntrada;
    }

    public Date getHoraDeSaida() {
        return horaDeSaida;
    }

    public Date getHorarioDeAlmoco() {
        return horarioDeAlmoco;
    }

    public Date getHorarioDeRetorno() {
        return horarioDeRetorno;
    }

    public Date getTempoDeAlmoco() {
        return tempoDeAlmoco;
    }

    public Date getHorasUteis() {
        return horasUteis;
    }
}
