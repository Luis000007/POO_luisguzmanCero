package edu.luisguzman.reto11.Process;

import edu.luisguzman.reto11.Idiomas.Idiomas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Clase que encuentra las palabras más utilizadas en un archivo de texto y realiza diversas operaciones con ellas.
 */
public class TopWordsFinder {
    private static Idiomas idiomas;

    public static void setLanguege(Idiomas idiomas){
        TopWordsFinder.idiomas = idiomas;
    }

    private static final String CARACTERES_NO_ALFABETICOS = "[^a-zA-ZáéíóúüñÁÉÍÓÚÜÑ]";

    /** Procesa el archivo de texto especificado y encuentra las 10 palabras más utilizadas. @param filePath La ruta del archivo de texto a procesar.
     */
    public void procesarLibro(String filePath) {
        // Mapa para almacenar las palabras y su frecuencia
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        // Lista para almacenar palabras que empiezan en vocal
        List<String> palabrasVocalInicial = new ArrayList<>();
        // Lista para almacenar palabras con número impar de letras
        List<String> palabrasImparLetras = new ArrayList<>();
        // Contadores de vocales
        Map<Character, Integer> contadorVocales = new HashMap<>();
        // Palabra más larga y más corta
        String palabraMasLarga = "";
        String palabraMasCorta = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Leer el libro línea por línea
            while ((line = br.readLine()) != null) {
                /** Dividir la línea en palabras usando espacio como separador*/
                String[] words = line.split("\\s+");
                // Actualizar el mapa de frecuencia de palabras y las listas según los criterios
                for (String word : words) {
                    // Limpiar la palabra de caracteres no alfabéticos y convertirla a minúsculas
                    word = limpiarPalabra(word);
                    if (!word.isEmpty()) {
                        // Conteo de vocales
                        contarVocales(word, contadorVocales);
                        // Palabras que empiezan en vocal
                        if (comienzaConVocal(word)) {
                            palabrasVocalInicial.add(word);
                        }
                        // Palabras con número impar de letras
                        if (word.length() % 2 != 0) {
                            palabrasImparLetras.add(word);
                        }
                        // Actualizar la palabra más larga y más corta
                        if (palabraMasLarga.isEmpty() || word.length() > palabraMasLarga.length()) {
                            palabraMasLarga = word;
                        }
                        if (palabraMasCorta == null || word.length() < palabraMasCorta.length()) {
                            palabraMasCorta = word;
                        }
                        // Actualizar el mapa de frecuencia de palabras
                        wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(idiomas.ERROR_AL_LEER + e.getMessage());
            return;
        }

        // Menú
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println(idiomas.MENU_TOP_WORDS_FINDER);

            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    // Imprimir las 10 palabras más utilizadas
                    System.out.println(idiomas.PALABRA_MAS_USADA);
                    wordFrequencyMap.entrySet().stream()
                            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                            .limit(10)
                            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
                    break;
                case 2:
                    // Imprimir conteo de vocales
                    System.out.println(idiomas.CONTEO_DE_VOCALES);
                    contadorVocales.forEach((vocal, count) -> System.out.println(vocal + ": " + count));
                    break;
                case 3:
                    // Imprimir palabras que empiezan en vocal ordenadas alfabéticamente
                    System.out.println(idiomas.PALABRAS_QUE_EMPIEZAN_EN_VOCAL);
                    Map<String, Integer> vocalInicialMap = new HashMap<>();
                    palabrasVocalInicial.forEach(word -> vocalInicialMap.put(word, vocalInicialMap.getOrDefault(word, 0) + 1));
                    vocalInicialMap.entrySet().stream()
                            .sorted(Comparator.comparing(Map.Entry::getKey))
                            .forEach(entry -> {
                                if (entry.getValue() > 1) {
                                    System.out.println(entry.getKey() + idiomas.SE_REPITE + entry.getValue() + idiomas.VECES);
                                } else {
                                    System.out.println(entry.getKey());
                                }
                            });
                    break;
                case 4:
                    // Imprimir palabras con número impar de letras
                    System.out.println(idiomas.PALABRS_CON_NUMERO_IMPAR);
                    Map<String, Integer> imparLetrasMap = new HashMap<>();
                    palabrasImparLetras.forEach(word -> imparLetrasMap.put(word, imparLetrasMap.getOrDefault(word, 0) + 1));
                    imparLetrasMap.entrySet().stream()
                            .sorted(Comparator.comparing(Map.Entry::getKey))
                            .forEach(entry -> {
                                if (entry.getValue() > 1) {
                                    System.out.println(entry.getKey() + idiomas.SE_REPITE + entry.getValue() + " veces");
                                } else {
                                    System.out.println(entry.getKey());
                                }
                            });
                    break;
                case 5:
                    // Imprimir palabra más larga
                    System.out.println(idiomas.PALABRA_MAS_LARGA + palabraMasLarga);
                    break;
                case 6:
                    // Imprimir palabra más corta
                    System.out.println(idiomas.PALABRA_MAS_CORTA + palabraMasCorta);
                    break;
                case 7:
                    // Identificar si hay al menos una palabra que cumple ciertos criterios
                    boolean palabraConCriterios = wordFrequencyMap.keySet().stream()
                            .anyMatch(word -> comienzaConVocal(word) && terminaConVocal(word) && word.length() >= 5);
                    System.out.println(idiomas.PALABRA_QUE_CUMPLE_LOS_CRITERIOS + (palabraConCriterios ? idiomas.SI : idiomas.NO));
                    break;
                case 8:
                    // Salir del programa
                    System.out.println(idiomas.SALIENDO_DEL_PROGRAMA);
                    break;
                default:
                    // Opción no válida
                    System.out.println(idiomas.OPCION_NO_VALIDA);
                    break;
            }
        } while (opcion != 8);
    }

    /**
     * Limpia la palabra de caracteres no alfabéticos y la convierte a minúsculas.
     *
     * @param word La palabra a limpiar.
     * @return La palabra limpiada.
     */
    private String limpiarPalabra(String word) {
        return word.replaceAll(CARACTERES_NO_ALFABETICOS, "").toLowerCase();
    }

    /**
     * Verifica si una palabra comienza con una vocal.
     *
     * @param word La palabra a verificar.
     * @return true si la palabra comienza con una vocal, de lo contrario false.
     */
    private boolean comienzaConVocal(String word) {
        char firstChar = Character.toLowerCase(word.charAt(0));
        return idiomas.aeiou.indexOf(firstChar) != -1;
    }

    /**
     * Verifica si una palabra termina con una vocal.
     *
     * @param word La palabra a verificar.
     * @return true si la palabra termina con una vocal, de lo contrario false.
     */
    private boolean terminaConVocal(String word) {
        char lastChar = Character.toLowerCase(word.charAt(word.length() - 1));
        return idiomas.aeiou.indexOf(lastChar) != -1;
    }

    /**
     * Cuenta el número de vocales en una palabra y las almacena en un mapa.
     *
     * @param word             La palabra en la que contar las vocales.
     * @param contadorVocales  El mapa para almacenar el conteo de vocales.
     */
    private void contarVocales(String word, Map<Character, Integer> contadorVocales) {
        for (char c : word.toLowerCase().toCharArray()) {
            if (idiomas.aeiou.indexOf(c) != -1) {
                contadorVocales.put(c, contadorVocales.getOrDefault(c, 0) + 1);
            }
        }
    }
}
