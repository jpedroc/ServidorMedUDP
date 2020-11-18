package service;

import domain.Prontuario;
import domain.RegraForte;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Apriori {

    private static final Long FREQUENCIA_MINIMA = (long) 0.5;
    private static final Long CONFIABILIDADE_MINIMA = (long) 0.75;

    public static List<String> getItemsFrequentes(List<Prontuario> prontuarios) {
        return DadosMockados.getSintomas().stream()
                .filter(candidato -> prontuarios.stream().filter(prontuario -> prontuario.getSintomas().stream().anyMatch(candidato::equals))
                .count() > FREQUENCIA_MINIMA * prontuarios.size()).collect(Collectors.toList());
    }

    public static List<RegraForte> getCandidatos(List<Prontuario> prontuarios, List<String> itemsFrequentes) {
        List<List<String>> candidatos = FuncoesUtil.getTodasSublistasPossiveis(itemsFrequentes);

        return candidatos.stream()
                .map(candidato -> new RegraForte("", candidato))
                .peek(candidato -> candidato.setFrequencia( candidatos.stream().filter(cand -> !Collections.disjoint(candidatos, prontuarios)).count() / prontuarios.size() ))
                .filter(candidato -> candidato.getFrequencia() > FREQUENCIA_MINIMA)
                .collect(Collectors.toList());
    }

    public static List<RegraForte> getCandidatos(List<Prontuario> prontuarios) {
        return getCandidatos(prontuarios, getItemsFrequentes(prontuarios));
    }

    public static String getDoenca(List<Prontuario> prontuarios, List<RegraForte> regras, Prontuario exame) {
        List<Prontuario> prontuariosConsideraveis = prontuarios.stream()
                .filter(prontuario -> !Collections.disjoint(regras, prontuarios)).collect(Collectors.toList());

        Integer indice = prontuariosConsideraveis.indexOf(exame);
        return indice >= 0 ? prontuarios.get(indice).getDoenca() : "Doença desconhecida";
    }

    public static String getDoenca(List<Prontuario> prontuarios, Prontuario exame) {
        return getDoenca(prontuarios, getCandidatos(prontuarios), exame);
    }

}