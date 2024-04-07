package edu.luisguzman.reto9.Process;

import edu.luisguzman.reto9.Ui.Idiomas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TopWordsFinder {
    private static Idiomas idiomas;
    public static void setLanguage(Idiomas idiomas){
        TopWordsFinder.idiomas = idiomas;
    }
    private static final String CARACTERES_NO_ALFABETICOS = "[^a-zA-ZáéíóúüñÁÉÍÓÚÜÑ]";

    public void procesarLibro(String filePath) {
        // Mapa para almacenar las palabras y su frecuencia
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Leer el libro línea por línea
            while ((line = br.readLine()) != null) {
                // Dividir la línea en palabras usando espacio como separador
                String[] words = line.split("\\s+");
                // Actualizar el mapa de frecuencia de palabras
                for (String word : words) {
                    // Limpiar la palabra de caracteres no alfabéticos y convertirla a minúsculas
                    word = limpiarPalabra(word);
                    if (!word.isEmpty()) {
                        wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(idiomas.ERRORALLEERELARCHIVO + e.getMessage());
            return;
        }

        // Ordenar el mapa por valor (frecuencia) de manera descendente y limitar a las 10 palabras más utilizadas
        Map<String, Integer> topWords = wordFrequencyMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        // Imprimir las 10 palabras más utilizadas
        System.out.println(idiomas.PALABRASMASUTILIZADAS);
        topWords.forEach((word, frequency) -> System.out.println(word + ": " + frequency));
    }

    // Método para limpiar una palabra de caracteres no alfabéticos y convertirla a minúsculas
    private String limpiarPalabra(String word) {
        return word.replaceAll(CARACTERES_NO_ALFABETICOS, "").toLowerCase();
    }
}
