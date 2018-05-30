package br.com.itsstecnologia.model.enums;

import java.util.Calendar;

public enum PrioridadeEnum {



    URGENTE{

        private String valor = "Urgente";
        private Calendar horaMaxAtendimento;
        private Calendar horaMaxResolucao;



        @Override
        public void setHoraMaxAtendimento(Calendar horaMaxAtendimento) {
            this.horaMaxAtendimento = horaMaxAtendimento;
        }

        @Override
        public void setHoraMaxResolucao(Calendar horaMaxResolucao) {
            this.horaMaxResolucao = horaMaxResolucao;
        }

        @Override
        public String getValor() {
            return this.valor;
        }

        @Override
        public Calendar getHoraMaxAtendiemento() {
            this.horaMaxAtendimento.set(0,0,0,0,30);
            return this.horaMaxAtendimento;
        }

        @Override
        public Calendar getHoraMaxResolucao() {
            this.horaMaxResolucao.set(0,0,0,4,0);
            return this.horaMaxResolucao;
        }
    },
    ALTA {

        private String valor = "Alta";
        private Calendar horaMaxAtendimento = Calendar.getInstance();
        private Calendar horaMaxResolucao = Calendar.getInstance();

        @Override
        public void setHoraMaxAtendimento(Calendar horaMaxAtendimento) {
            this.horaMaxAtendimento = horaMaxAtendimento;
        }

        @Override
        public void setHoraMaxResolucao(Calendar horaMaxResolucao) {
            this.horaMaxResolucao = horaMaxResolucao;
        }


        @Override
        public String getValor() {
            return this.valor;
        }

        @Override
        public Calendar getHoraMaxAtendiemento() {
            this.horaMaxAtendimento.set(0,0,0,2,0);
            return this.horaMaxAtendimento;
        }

        @Override
        public Calendar getHoraMaxResolucao() {
            this.horaMaxResolucao.set(0,0,0,8,0);
            return this.horaMaxResolucao;
        }
    },
    MEDIA {

        private String valor = "Média";
        private Calendar horaMaxAtendimento = Calendar.getInstance();
        private Calendar horaMaxResolucao = Calendar.getInstance();

        @Override
        public void setHoraMaxAtendimento(Calendar horaMaxAtendimento) {
            this.horaMaxAtendimento = horaMaxAtendimento;
        }

        @Override
        public void setHoraMaxResolucao(Calendar horaMaxResolucao) {
            this.horaMaxResolucao = horaMaxResolucao;
        }

        @Override
        public String getValor() {
            return this.valor;
        }

        @Override
        public Calendar getHoraMaxAtendiemento() {
            this.horaMaxAtendimento.set(0,0,0,4,0);
            return this.horaMaxAtendimento;
        }

        @Override
        public Calendar getHoraMaxResolucao() {
            this.horaMaxResolucao.set(0,0,1,0,0);
            return this.horaMaxResolucao;
        }
    },
    BAIXA {

        private String valor = "Baixa";
        private Calendar horaMaxAtendimento = Calendar.getInstance();
        private Calendar horaMaxResolucao = Calendar.getInstance();

        @Override
        public void setHoraMaxAtendimento(Calendar horaMaxAtendimento) {
            this.horaMaxAtendimento = horaMaxAtendimento;
        }

        @Override
        public void setHoraMaxResolucao(Calendar horaMaxResolucao) {
            this.horaMaxResolucao = horaMaxResolucao;
        }

        @Override
        public String getValor() {
            return this.valor;
        }

        @Override
        public Calendar getHoraMaxAtendiemento() {
            this.horaMaxAtendimento.set(0,0,0,8,0);
            return this.horaMaxAtendimento;
        }

        @Override
        public Calendar getHoraMaxResolucao() {
            this.horaMaxResolucao.set(0,0,1,16,0);
            return this.horaMaxResolucao;
        }
    }, NC{

        private String valor = "NC-";
        private Calendar horaMaxAtendimento = Calendar.getInstance();
        private Calendar horaMaxResolucao = Calendar.getInstance();

        @Override
        public void setHoraMaxAtendimento(Calendar horaMaxAtendimento) {
            this.horaMaxAtendimento = horaMaxAtendimento;
        }

        @Override
        public void setHoraMaxResolucao(Calendar horaMaxResolucao) {
            this.horaMaxResolucao = horaMaxResolucao;
        }

        @Override
        public String getValor() {
            return this.valor;
        }

        @Override
        public Calendar getHoraMaxAtendiemento() {
            this.horaMaxAtendimento.set(0,0,0,8,0);
            return this.horaMaxAtendimento;
        }

        @Override
        public Calendar getHoraMaxResolucao() {
            this.horaMaxResolucao.set(0,0,1,16,0);
            return this.horaMaxResolucao;
        }
    };

    private static String valor;
    private static Calendar horaMaxAtendimento = Calendar.getInstance();
    private static Calendar horaMaxResolucao = Calendar.getInstance();

    public abstract String getValor();

    public abstract Calendar getHoraMaxAtendiemento();

    public abstract Calendar getHoraMaxResolucao();

    public abstract void setHoraMaxAtendimento(Calendar horaMaxAtendimento);

    public abstract void setHoraMaxResolucao(Calendar horaMaxResolucao);

}