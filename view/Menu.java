package view;

import controller.EventoController;
import controller.UsuarioController;
import model.Evento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private EventoController eventoController = new EventoController();
    private UsuarioController usuarioController = new UsuarioController();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        System.out.println("=== Cadastro de Usuário ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        usuarioController.criarUsuario(nome, email, cidade);

        int opcao;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Cadastrar evento");
            System.out.println("2. Listar eventos");
            System.out.println("3. Participar de evento");
            System.out.println("4. Cancelar participação");
            System.out.println("5. Ver eventos confirmados");
            System.out.println("6. Ver eventos ocorrendo agora");
            System.out.println("7. Ver eventos já ocorridos");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> cadastrarEvento();
                case 2 -> listarEventos();
                case 3 -> participarEvento();
                case 4 -> cancelarParticipacao();
                case 5 -> verEventosConfirmados();
                case 6 -> listarEventosOcorrendoAgora();
                case 7 -> listarEventosJaOcorridos();
            }
        } while (opcao != 0);
    }

    private void cadastrarEvento() {
        System.out.print("Nome do evento: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Categoria (Festa, Show, Esporte): ");
        String categoria = scanner.nextLine();
        System.out.print("Horário (yyyy-MM-dd HH:mm): ");
        String dataHora = scanner.nextLine();
        LocalDateTime horario = LocalDateTime.parse(dataHora, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        eventoController.adicionarEvento(new Evento(nome, endereco, categoria, horario, descricao));
        System.out.println("Evento cadastrado com sucesso!");
    }

    private void listarEventos() {
        List<Evento> eventos = eventoController.listarTodos();
        int i = 0;
        for (Evento e : eventos) {
            System.out.printf("[%d] %s\n", i++, e);
        }
    }

    private void participarEvento() {
        listarEventos();
        System.out.print("Digite o número do evento para participar: ");
        int index = Integer.parseInt(scanner.nextLine());
        Evento evento = eventoController.buscarEventoPorIndice(index);
        usuarioController.participarEvento(evento);
        System.out.println("Participação confirmada.");
    }

    private void cancelarParticipacao() {
        List<Evento> eventos = usuarioController.getUsuario().getEventosParticipando();
        int i = 0;
        for (Evento e : eventos) {
            System.out.printf("[%d] %s\n", i++, e);
        }
        System.out.print("Digite o número do evento para cancelar: ");
        int index = Integer.parseInt(scanner.nextLine());
        usuarioController.cancelarEvento(eventos.get(index));
        System.out.println("Participação cancelada.");
    }

    private void verEventosConfirmados() {
        List<Evento> eventos = usuarioController.getUsuario().getEventosParticipando();
        for (Evento e : eventos) {
            System.out.println(e);
        }
    }

    private void listarEventosOcorrendoAgora() {
        for (Evento e : eventoController.listarOcorrendoAgora()) {
            System.out.println(e);
        }
    }

    private void listarEventosJaOcorridos() {
        for (Evento e : eventoController.listarJaOcorridos()) {
            System.out.println(e);
        }
    }
}
