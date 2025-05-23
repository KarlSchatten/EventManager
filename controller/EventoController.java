package controller;

import model.Evento;
import utils.DataManager;

import java.util.*;
import java.util.stream.Collectors;

public class EventoController {
    private List<Evento> eventos;

    public EventoController() {
        this.eventos = DataManager.carregarEventos();
    }

    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
        DataManager.salvarEventos(eventos);
    }

    public List<Evento> listarTodos() {
        return eventos.stream()
                .sorted(Comparator.comparing(Evento::getHorario))
                .collect(Collectors.toList());
    }

    public List<Evento> listarOcorrendoAgora() {
        return eventos.stream().filter(Evento::isOcorrendoAgora).collect(Collectors.toList());
    }

    public List<Evento> listarJaOcorridos() {
        return eventos.stream().filter(Evento::jaOcorrido).collect(Collectors.toList());
    }

    public Evento buscarEventoPorIndice(int index) {
        if (index >= 0 && index < eventos.size()) {
            return eventos.get(index);
        }
        return null;
    }
}
