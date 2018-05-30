package br.com.itsstecnologia.reader;

import Model.Demanda;
import Model.Enums.Estado;
import Model.Enums.Prioridade;
import Params.Parametros;
import jxl.*;
import jxl.read.biff.BiffException;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;

public class ReadExcel {
    private static final String EXCEL_FILE_LOCATION = "C:\\Users\\ITSS\\Desktop\\Demandas.xls";
    private static int indices[] = {1,2,5,6,7,8,10,18,20,21};
    private static Parametros dateFormat = new Parametros();


    public static void main(String[] args) {



        Workbook workbook = null;
        try {
            int id = 0;
            String titulo = null;
            String empresa = null;
            Estado estado = null;
            String status = null;
            String destino = null;
            Prioridade prioridade = null;
            Calendar dataAlteracao = Calendar.getInstance();
            String responsavel = null;
            Calendar dataCriacao = Calendar.getInstance();
            Calendar dataEntradaNoEstado = Calendar.getInstance();

            workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));
            Sheet sheet = workbook.getSheet(0);

            for (int i = 2; i < sheet.getRows(); i++) {

                for (int indice : indices) {
                    Cell cell = sheet.getCell(indice, i);
                    switch (indice) {
                        case 1:
                                id = Integer.parseInt(cell.getContents());
                            break;
                        case 2:
                            titulo = cell.getContents();
                            break;
                        case 5:
                            empresa = cell.getContents();
                            break;
                        case 6:
                            estado = classificaEstado(cell.getContents());
                            status = cell.getContents();
                            break;
                        case 7:
                            destino = cell.getContents();
                            break;
                        case 8:
                            prioridade = classificaPrioridade(cell.getContents());
                            break;
                        case 10:
                            dataAlteracao.setTime(dateFormat.getDate().parse(cell.getContents()));
                            break;
                        case 18:
                            responsavel = cell.getContents();
                            break;
                        case 20:
                            dataCriacao.setTime(dateFormat.getDateTime().parse(cell.getContents())) ;
                            break;
                        case 21:
                            dataEntradaNoEstado.setTime(dateFormat.getDateTime().parse(cell.getContents()));
                            break;
                    }
                }
                Demanda demanda = new Demanda(id,titulo,empresa,estado,status,destino,prioridade,dataAlteracao,dataCriacao,
                        dataEntradaNoEstado,responsavel);
                System.out.println(demanda.toString());
            }

        } catch (IOException e ) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {

        } finally {

            if (workbook != null) {
                workbook.close();
            }

        }

    }

    private static Estado classificaEstado(String valor) {
        switch (valor) {
            case "Concluido ":
                return Estado.CONCLUIDO;
            case "Ag. Avaliação Cliente":
                return Estado.AG_AVALIACAO;
            case "Em Atendimento N1":
                return Estado.EM_ATENDIMENTO;
            case "Em atendimento N2":
                return Estado.EM_ATENDIMENTO;
            case "Ag. Atendimento":
                return Estado.EM_ATENDIMENTO;
            case "Ag. Informação Cliente":
                return Estado.AG_INFORMACAO;
            default:
                return Estado.OUTROS;
        }
    }

    private static Prioridade classificaPrioridade(String valor) {
        String array[] = valor.split("\\.");
        switch (Integer.parseInt(array[0])) {
            case 1:
                return Prioridade.URGENTE;
            case 2:
                return Prioridade.ALTA;
            case 3:
                return Prioridade.MEDIA;
            case 4:
                return Prioridade.BAIXA;
            default:
                return Prioridade.NC;
        }
    }
}
