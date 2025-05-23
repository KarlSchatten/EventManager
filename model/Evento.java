package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento {
    private String nome;
    private String endereco;
    private String categoria;
    private LocalDateTime horario;
    private String descricao;

    public Evento(String nome, String endereco, String categoria, LocalDateTime horario, String descricao) {
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
        this.horario = horario;
        this.descricao = descricao;
    }

    public String getNome() { return nome; }
    public String getEndereco() { return endereco; }
    public String getCategoria() { return categoria; }
    public LocalDateTime getHorario() { return horario; }
    public String getDescricao() { return descricao; }

    public boolean isOcorrendoAgora() {
        LocalDateTime agora = LocalDateTime.now();
        return horario.isBefore(agora.plusMinutes(1)) && horario.isAfter(agora.minusHours(1));
    }

    public boolean jaOcorrido() {
        return horario.isBefore(LocalDateTime.now());
    }

    public String toFileString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return nome + ";" + endereco + ";" + categoria + ";" + horario.format(formatter) + ";" + descricao;
    }

    public static Evento fromFileString(String linha) {
        String[] partes = linha.split(";");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return new Evento(partes[0], partes[1], partes[2], LocalDateTime.parse(partes[3], formatter), partes[4]);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s às %s\nDescrição: %s",
                categoria, nome, endereco, horario, descricao);
    }
}
