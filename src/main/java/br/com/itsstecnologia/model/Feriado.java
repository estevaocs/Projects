package br.com.itsstecnologia.model;

import br.com.itsstecnologia.util.BaseEntities;

import javax.persistence.*;
import java.util.Calendar;


@Entity
@Table(name = "feriado")
@AttributeOverride(name = "id", column = @Column(name = "Id"))
public class Feriado extends BaseEntities<Integer> {

    private  static final long serialVersionUID = 201805300223L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Data", nullable = false, unique = false)
    @Temporal(TemporalType.DATE)
    private Calendar data;

    @Column(name = "Descricao", nullable = false, unique = false)
    private String nome;

    public Feriado() {
    }

    public Feriado(int id, Calendar data, String nome) {
        this.id = id;
        this.data = data;
        this.nome = nome;
    }

    public Integer getId() {
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
