package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DadosMockados {

    public static List<String> getSintomas() {
        return new ArrayList<>(Arrays.asList(
                "Sintoma 1", "Sintoma 2", "Sintoma 3", "Sintoma 4", "Sintoma 4",
                "Sintoma 6", "Sintoma 7", "Sintoma 8", "Sintoma 9", "Sintoma 10"
        ));
    }

    private DadosMockados() {
    }
}
