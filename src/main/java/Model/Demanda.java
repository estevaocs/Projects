package Model;

import Model.Enums.Estado;
import Model.Enums.Prioridade;
import Params.Parametros;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Demanda {

    private int id;
    private String titulo;
    private String empresa;
    private Estado estado;
    private String destino;
    private Prioridade prioridade;
    private Date dataAlteracao;
    private Date dataFinal;
    private Date dataCriacao;
    private Date dataEntradaNoEstado;
    private String responsavel;
    private Parametros dateFomr = new Parametros();

    public Demanda(int id, String titulo, String empresa, Estado estado, String destino, Prioridade prioridade,
                   Date dataAlteracao, Date dataCriacao, Date dataEntradaNoEstado, String responsavel) {
        this.id = id;
        this.titulo = titulo;
        this.empresa = empresa;
        this.estado = estado;
        this.destino = destino;
        this.prioridade = prioridade;
        this.dataAlteracao = dataAlteracao;
        this.dataCriacao = dataCriacao;
        this.dataEntradaNoEstado = dataEntradaNoEstado;
        this.responsavel = responsavel;
        this.dataFinal = calculaDataFinal();
    }

    private Date calculaDataFinal() {
        return new Date(this.dataCriacao.getTime() + TimeUnit.DAYS.toMillis(1));
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

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteração(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataEntradaNoEstado() {
        return dataEntradaNoEstado;
    }

    public void setDataEntradaNoEstado(Date dataEntradaNoEstado) {
        this.dataEntradaNoEstado = dataEntradaNoEstado;
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
                "ID: " + id +
                ", Titulo: " + titulo +
                ", Empresa: " + empresa +
                ", Estado: " + estado +
                ", Destino: " + destino  +
                ", Prioridade: " + prioridade +
                ", Data Alteração: " + dateFomr.getDate().format(dataAlteracao) +
                ", Data Final: " + dateFomr.getDateTime().format(dataFinal) +
                ", Data de Criacao :" + dateFomr.getDateTime().format(dataCriacao) +
                ", Data de Entrada no Estado: " + dateFomr.getDateTime().format(dataEntradaNoEstado) +
                ", Eesponsavel: " + responsavel +
                '}';
    }
}
