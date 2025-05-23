package utils;

import model.Evento;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class DataManager {
    private static final String ARQUIVO = "events.data";

    public static void salvarEventos(List<Evento> eventos) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(ARQUIVO))) {
            for (Evento e : eventos) {
                writer.write(e.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar eventos.");
        }
    }

    public static List<Evento> carregarEventos() {
        List<Evento> eventos = new ArrayList<>();
        try {
            List<String> linhas = Files.readAllLines(Paths.get(ARQUIVO));
            for (String linha : linhas) {
                eventos.add(Evento.fromFileString(linha));
            }
        } catch (IOException e) {
            System.out.println("Nenhum evento salvo previamente.");
        }
        return eventos;
    }
}
