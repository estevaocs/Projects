package Model;

import java.util.Date;

public class Feriado {

    private int id;
    private Date data;
    private String nome;

    public Feriado(int id, Date data, String nome) {
        this.id = id;
        this.data = data;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
