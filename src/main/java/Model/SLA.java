package Model;

import Model.Enums.Prioridade;

import java.util.Calendar;

public class SLA {
    private String empresa = null;
    private Prioridade prioridade;
    private Calendar tempoMaxInicoAtendimento = Calendar.getInstance();
    private Calendar tempoMaxResolucao = Calendar.getInstance();

    public SLA(String empresa, Prioridade prioridade, Calendar tempoMaxInicoAtendimento, Calendar tempoMaxResolucao) {
        this.empresa = empresa;
        this.prioridade = prioridade;
        this.tempoMaxInicoAtendimento = tempoMaxInicoAtendimento;
        this.tempoMaxResolucao = tempoMaxResolucao;
    }

    public SLA(Prioridade prioridade) {
        switch (prioridade.getValor()) {
            case "Urgente":
                this.tempoMaxInicoAtendimento.set(0,0,0,0,30);
                this.tempoMaxResolucao.set(0,0,0,4,0);
            case "Alta":
                this.tempoMaxInicoAtendimento.set(0,0,0,2,0);
                this.tempoMaxResolucao.set(0,0,0,8,0);
            case "Média":
                this.tempoMaxInicoAtendimento.set(0,0,0,4,0);
                this.tempoMaxResolucao.set(0,0,1,0,0);
            case "Baixa":
            case "NC-":
                this.tempoMaxInicoAtendimento.set(0,0,0,8,0);
                this.tempoMaxResolucao.set(0,0,1,16,0);
        }
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Calendar getTempoMaxInicoAtendimento() {
        return tempoMaxInicoAtendimento;
    }

    public void setTempoMaxInicoAtendimento(Calendar tempoMaxInicoAtendimento) {
        this.tempoMaxInicoAtendimento = tempoMaxInicoAtendimento;
    }

    public Calendar getTempoMaxResolucao() {
        return tempoMaxResolucao;
    }

    public void setTempoMaxResolucao(Calendar tempoMaxResolucao) {
        this.tempoMaxResolucao = tempoMaxResolucao;
    }
}
