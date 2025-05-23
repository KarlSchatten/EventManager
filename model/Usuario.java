package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private String cidade;
    private List<Evento> eventosParticipando;

    public Usuario(String nome, String email, String cidade) {
        this.nome = nome;
        this.email = email;
        this.cidade = cidade;
        this.eventosParticipando = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getCidade() { return cidade; }
    public List<Evento> getEventosParticipando() { return eventosParticipando; }

    public void participarEvento(Evento evento) {
        if (!eventosParticipando.contains(evento)) {
            eventosParticipando.add(evento);
        }
    }

    public void cancelarParticipacao(Evento evento) {
        eventosParticipando.remove(evento);
    }
}
