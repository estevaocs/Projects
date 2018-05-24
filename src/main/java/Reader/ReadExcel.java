package Reader;

import Model.Demanda;
import Model.Enums.Estado;
import Model.Enums.Prioridade;
import Params.Parametros;
import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.DateTime;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

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
            String destino = null;
            Prioridade prioridade = null;
            DateCell dateCell = null;
            Date dataAlteracao = null;
            String responsavel = null;
            DateTime dateTime = null;
            Date dataCriacao = null;
            DateTime dateTime1 = null;
            Date dataEntradaNoEstado = null;

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
                            break;
                        case 7:
                            destino = cell.getContents();
                            break;
                        case 8:
                            prioridade = classificaPrioridade(cell.getContents());
                            break;
                        case 10:
                            dataAlteracao = dateFormat.getDate().parse(cell.getContents());
                            break;
                        case 18:
                            responsavel = cell.getContents();
                            break;
                        case 20:
                            dataCriacao = dateFormat.getDateTime().parse(cell.getContents());
                            break;
                        case 21:
                            dataEntradaNoEstado = dateFormat.getDateTime().parse(cell.getContents());
                            break;
                    }
                }
                Demanda demanda = new Demanda(id,titulo,empresa,estado,destino,prioridade,dataAlteracao,dataCriacao,
                        dataEntradaNoEstado,responsavel);
                System.out.println(demanda.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {

            if (workbook != null) {
                workbook.close();
            }

        }

    }

    private static Estado classificaEstado(String valor) {
        switch (valor) {
            case "Concluido \n":
                return Estado.CONCLUIDO;
            case "Ag. Avaliação Cliente\n":
                return Estado.AG_AVALIACAO;
            case "Em Atendimento N1\n":
                return Estado.EM_ATENDIMENTO;
            case "Em atendimento N2\n":
                return Estado.EM_ATENDIMENTO;
            case "Ag. Atendimento\n":
                return Estado.EM_ATENDIMENTO;
            case "Ag. Informação Cliente\n":
                return Estado.AG_INFORMACAO;
            default:
                return Estado.OUTROS;
        }
    }

    private static Prioridade classificaPrioridade(String valor) {
        switch (valor) {
            case "1. URGENTE - Ambiente produtivo ou processo parado\n":
                return Prioridade.URGENTE;
            case "2. ALTA - Apresenta alto risco para a operação\n":
                return Prioridade.ALTA;
            case "3. MÉDIA - Existe alternativa de contorno\n":
                return Prioridade.MEDIA;
            case "4. BAIXA - Melhoria, interface ou relatório\n":
                return Prioridade.BAIXA;
            default:
                return Prioridade.NC;
        }
    }
}
