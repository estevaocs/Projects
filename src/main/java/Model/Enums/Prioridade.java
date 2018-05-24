package Model.Enums;

public enum Prioridade {

    URGENTE("Urgente"), ALTA("Alta"), MEDIA("Média"), BAIXA("Baixa"), NC("NC-");

    public String valor;

    Prioridade(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
