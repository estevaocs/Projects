package Model;

import java.util.Calendar;
import java.util.Date;

public class Feriado {

    private int id;
    private Calendar data;
    private String nome;

    public Feriado(int id, Calendar data, String nome) {
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

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
