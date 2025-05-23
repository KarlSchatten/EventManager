# 📌 EventManagerConsoleApp

**Sistema de Gerenciamento de Eventos Locais** desenvolvido em Java, utilizando o paradigma orientado a objetos e arquitetura MVC simples. A aplicação é executada via console (terminal) e permite cadastro de usuários, eventos, participação e notificações com base em data/hora.

---

## 📚 Funcionalidades

- Cadastro de usuários com nome, e-mail e cidade
- Criação de eventos com:
  - Nome
  - Endereço
  - Categoria (ex: Festa, Show, Esporte)
  - Data e Hora
  - Descrição
- Visualização de eventos ordenados por data
- Participação e cancelamento de participação em eventos
- Listagem de:
  - Todos os eventos
  - Eventos em andamento
  - Eventos passados
  - Eventos confirmados pelo usuário
- Salvamento automático dos eventos no arquivo `events.data`
- Leitura automática dos eventos salvos na inicialização

---

## 🗂 Estrutura de Pastas

```
EventManagerConsoleApp/
├── model/
│   ├── Usuario.java
│   └── Evento.java
├── controller/
│   ├── UsuarioController.java
│   └── EventoController.java
├── utils/
│   └── DataManager.java
├── view/
│   └── Menu.java
└── Main.java
```

---

## 🛠️ Como executar

### 1. Pré-requisitos

- JDK 11 ou superior
- IDE como IntelliJ, Eclipse, NetBeans, ou uso via terminal
- Git (opcional, se clonar o repositório)

### 2. Compilar e executar via terminal

```bash
javac Main.java
java Main
```

Ou utilize o botão de execução da sua IDE com `Main.java` como ponto de entrada.

---

## 🧪 Exemplo de uso

```
=== Cadastro de Usuário ===
Nome: Karl Marx Alves Pereira
Email: karlmarxshade@icloud.com
Cidade: Caldas Novas Goias

=== MENU ===
1. Cadastrar evento
2. Listar eventos
3. Participar de evento
4. Cancelar participação
...
```

---

## 🧱 Tecnologias usadas

- Java 11+
- Programação Orientada a Objetos
- Java Collections (List, Scanner, etc.)
- `java.time.LocalDateTime` para controle de horários
- Arquivos `.data` para persistência local

---

## 📈 Diagrama UML

![UML Class Diagram](./A_UML_(Unified_Modeling_Language)_class_diagram_in.png)

---

## 📁 Arquivo de dados

Todos os eventos são armazenados no arquivo `events.data` automaticamente. Caso o arquivo não exista, ele será criado.

---

## 📄 Licença

Este projeto é acadêmico e livre para fins de aprendizado.

---

## ✍️ Autor

**Karl Marx Alves Pereira**  
📧 karlmarxshade@icloud.com  
📍 Caldas Novas, Goiás – Brasil
