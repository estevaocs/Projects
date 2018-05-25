package Model;

import Logic.CalculaSLA;
import Model.Enums.Estado;
import Model.Enums.Prioridade;
import Params.Parametros;

import java.util.Calendar;

public class Demanda {

    private int id;
    private String titulo;
    private String empresa;
    private Estado estado;
    private String status;
    private String destino;
    private Prioridade prioridade;
    private Calendar dataAlteracao;
    private Calendar dataFinal;
    private Calendar dataCriacao;
    private Calendar dataEntradaNoEstado;
    private String responsavel;
    private Parametros dateFomr = new Parametros();

    public Demanda(int id, String titulo, String empresa, Estado estado, String status, String destino, Prioridade prioridade,
                   Calendar dataAlteracao, Calendar dataCriacao, Calendar dataEntradaNoEstado, String responsavel) {
        this.id = id;
        this.titulo = titulo;
        this.empresa = empresa;
        this.estado = estado;
        this.status = status;
        this.destino = destino;
        this.prioridade = prioridade;
        this.dataAlteracao = dataAlteracao;
        this.dataCriacao = dataCriacao;
        this.dataEntradaNoEstado = dataEntradaNoEstado;
        this.responsavel = responsavel;
        this.dataFinal = CalculaSLA.calcular(this);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Calendar getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteração(Calendar dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Calendar getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Calendar dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Calendar getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Calendar dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Calendar getDataEntradaNoEstado() {
        return dataEntradaNoEstado;
    }

    public void setDataEntradaNoEstado(Calendar dataEntradaNoEstado) {
        this.dataEntradaNoEstado = dataEntradaNoEstado;
        this.dataFinal = CalculaSLA.calcular(this);
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Demanda{" +
//                "ID: " + id +
//                ", Titulo: " + titulo +
//                ", Empresa: " + empresa +
//                ", Estado: " + estado +
//                ", Status: " + status +
//                ", Destino: " + destino +
//                ", Prioridade: " + prioridade +
//                ", Data Alteração: " + dateFomr.getDate().format(dataAlteracao.getTime()) +
                ", Data de Entrada no Estado: " + dateFomr.getDateTime().format(dataEntradaNoEstado.getTime()) +
                ", Data Final: " + dateFomr.getDateTime().format(dataFinal.getTime()) +
//                ", Data de Criacao :" + dateFomr.getDateTime().format(dataCriacao.getTime()) +
//                ", Eesponsavel: " + responsavel +
                '}';
    }
}
