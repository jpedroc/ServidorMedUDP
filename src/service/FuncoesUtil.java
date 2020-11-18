package service;

import java.util.ArrayList;
import java.util.List;

public class FuncoesUtil {

    public static List<List<String>> getTodasSublistasPossiveis(List<String> lista) {
        List<List<String>> listaFinal = new ArrayList<>();

        for (int i = 0; i < (1 << lista.size()); ++i) {
            List<String> novaLista = new ArrayList<>();

            for (int j = 0; j < lista.size(); ++j) {
                if ((i & (1 << j)) > 0) {
                    novaLista.add(lista.get(j));
                }
            }
            listaFinal.add(novaLista);
        }
        return listaFinal;
    }

    private FuncoesUtil() {
    }

}

