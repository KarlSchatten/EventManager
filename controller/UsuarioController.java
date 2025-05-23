package controller;

import model.Evento;
import model.Usuario;

public class UsuarioController {
    private Usuario usuario;

    public void criarUsuario(String nome, String email, String cidade) {
        this.usuario = new Usuario(nome, email, cidade);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void participarEvento(Evento evento) {
        usuario.participarEvento(evento);
    }

    public void cancelarEvento(Evento evento) {
        usuario.cancelarParticipacao(evento);
    }
}
