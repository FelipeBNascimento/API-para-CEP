package com.cepbazan.apicep.bussines.apiexterna;

public class Main {

    public static void main(String[] args) {

        ConsumirApi consumir = new ConsumirApi();
        DadosCep dadosCep = new DadosCep();

        String teste = "https://viacep.com.br/ws/09111490/json/";

        String json = consumir.obterDados(teste);

        ConverterDados coverter = new ConverterDados();

        DadosCep dados = coverter.ObterDados(json, DadosCep.class);

        System.out.println(dados);

    }
}
