package br.com.itsstecnologia.model;

import br.com.itsstecnologia.logic.CalculaSLA;
import br.com.itsstecnologia.logic.Config;
import br.com.itsstecnologia.model.enums.Estado;
import br.com.itsstecnologia.model.enums.Prioridade;
import br.com.itsstecnologia.util.BaseEntities;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "demandas")
@AttributeOverride(name = "id", column = @Column(name = "Id"))
public class Demanda extends BaseEntities<Integer> {

    @Id
    private int id;

    @Column(name = "Titulo", nullable = false, unique = false)
    private String titulo;

    @Column(name = "Empresa", nullable = false, unique = false)
    private String empresa;

    @Column(name = "Estado", nullable = false, unique = false)
    private Estado estado;

    @Column(name = "Status", nullable = false, unique = false)
    private String status;

    @Column(name = "Destino", nullable = false, unique = false)
    private String destino;

    @Column(name = "Prioridade", nullable = false, unique = false)
    private Prioridade prioridade;

    @Column(name = "DataAlteracao", nullable = false, unique = false)
    @Temporal(TemporalType.DATE)
    private Calendar dataAlteracao;

    @Column(name = "DataFinal", nullable = false, unique = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataFinal;

    @Column(name = "DataCriacao", nullable = false, unique = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataCriacao;

    @Column(name = "DataEntradaNoEstado", nullable = false, unique = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataEntradaNoEstado;

    @Column(name = "Responsavel", nullable = false, unique = false)
    private String responsavel;

    public Demanda() {
    }

    public Demanda(int id, String titulo, String empresa, Estado estado, String status, String destino, Prioridade prioridade,
                   Calendar dataAlteracao, Calendar dataCriacao, Calendar dataEntradaNoEstado, String responsavel) {
        super();
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
        atualiza();
    }

    private void atualiza() {
        this.dataFinal = CalculaSLA.calcular(this);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
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
        this.dataFinal = CalculaSLA.calcular(this);
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
        atualiza();
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
                ", Status: " + status +
//                ", Destino: " + destino +
                ", Prioridade: " + prioridade +
//                ", Data Alteração: " + dateFomr.getDate().format(dataAlteracao.getTime()) +
                ", Data de Entrada no Estado: " + Config.getParametros().getDateTime().format(dataEntradaNoEstado.getTime()) +
                ", Data Final: " + Config.getParametros().getDateTime().format(dataFinal.getTime()) +
//                ", Data de Criacao :" + dateFomr.getDateTime().format(dataCriacao.getTime()) +
//                ", Eesponsavel: " + responsavel +
                '}';
    }
}
