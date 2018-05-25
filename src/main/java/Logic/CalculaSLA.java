package Logic;

import Model.Demanda;

import java.util.Calendar;

public class CalculaSLA {

    public  static Calendar calcular(Demanda demanda) {
        return demanda.getDataCriacao();
    }
}
