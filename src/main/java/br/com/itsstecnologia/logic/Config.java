package br.com.itsstecnologia.logic;

import br.com.itsstecnologia.params.Parametros;

public class Config {

    private static Parametros parametros = new Parametros();

    public static Parametros getParametros(){
        return parametros;
    }
}
