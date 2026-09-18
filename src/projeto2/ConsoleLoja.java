package projeto2;

import java.util.Scanner;

public class ConsoleLoja {

    private Scanner scanner;
    private ControladorLoja controlador;

    public ConsoleLoja() {
        scanner = new Scanner(System.in);
        controlador = new ControladorLoja();
    }

    private int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }

    private double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Double.parseDouble(scanner.nextLine().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor válido.");
            }
        }
    }

    private String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private Categoria lerCategoria() {
        while (true) {
            System.out.println("Categorias disponíveis:");

            for (Categoria categoria : Categoria.values()) {
                System.out.println("- " + categoria);
            }

            System.out.print("Digite a categoria: ");

            try {
                return Categoria.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Categoria inválida.");
            }
        }
    }

    private void exibirMenu() {
        System.out.println("==================================");
        System.out.println("      SISTEMA LOJA DE GAMES");
        System.out.println("==================================");
        System.out.println("1 - Cadastrar jogo físico");
        System.out.println("2 - Cadastrar jogo digital");
        System.out.println("3 - Cadastrar jogador");
        System.out.println("4 - Listar jogos");
        System.out.println("5 - Listar jogadores");
        System.out.println("6 - Buscar jogo");
        System.out.println("7 - Buscar jogador");
        System.out.println("8 - Comprar jogo");
        System.out.println("9 - Listar jogos por categoria");
        System.out.println("10 - Valor total do catálogo");
        System.out.println("11 - Jogo mais caro");
        System.out.println("12 - Jogo mais barato");
        System.out.println("13 - Alterar preço do jogo");
        System.out.println("0 - Sair");
        System.out.println();
    }

    public void iniciar() {
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Digite a opção: ");
            executarOpcao(opcao);

            if (opcao != 0) {
                System.out.println();
            }

        } while (opcao != 0);

        scanner.close();
    }

    private void executarOpcao(int opcao) {
        switch (opcao) {
        case 1:
            cadastrarJogoFisico();
            break;
        case 2:
            cadastrarJogoDigital();
            break;
        case 3:
            cadastrarJogador();
            break;
        case 4:
            listarJogos();
            break;
        case 5:
            listarJogadores();
            break;
        case 6:
            buscarJogo();
            break;
        case 7:
            buscarJogador();
            break;
        case 8:
            comprarJogo();
            break;
        case 9:
            listarJogoPorCategoria();
            break;
        case 10:
            valorCatalogo();
            break;
        case 11:
            jogoMaisCaro();
            break;
        case 12:
            jogoMaisBarato();
            break;
        case 13:
            alterarPreco();
            break;
        case 0:
            System.out.println("Programa encerrado.");
            break;
        default:
            System.out.println("Digite uma opção válida.");
        }
    }

    private void cadastrarJogoFisico() {
        String titulo = lerTexto("Digite o título: ");
        String desenvolvedora = lerTexto("Digite a desenvolvedora: ");
        double precoBase = lerDouble("Digite o preço base: ");
        int ano = lerInteiro("Digite o ano de lançamento: ");
        Categoria categoria = lerCategoria();
        int estoque = lerInteiro("Digite a quantidade em estoque: ");
        int codigo = lerInteiro("Digite o código: ");

        if (controlador.cadastrarJogoFisico(codigo, titulo, desenvolvedora,
                precoBase, ano, categoria, estoque)) {
            System.out.println("Jogo cadastrado com sucesso.");
        } else {
            System.out.println("Erro ao cadastrar jogo.");
        }
    }

    private void cadastrarJogoDigital() {
        String titulo = lerTexto("Digite o título: ");
        String desenvolvedora = lerTexto("Digite a desenvolvedora: ");
        double precoBase = lerDouble("Digite o preço base: ");
        int ano = lerInteiro("Digite o ano de lançamento: ");
        Categoria categoria = lerCategoria();
        double tamanho = lerDouble("Digite o tamanho (GB): ");
        int codigo = lerInteiro("Digite o código: ");

        if (controlador.cadastrarJogoDigital(codigo, titulo, desenvolvedora,
                precoBase, ano, categoria, tamanho)) {
            System.out.println("Jogo cadastrado com sucesso.");
        } else {
            System.out.println("Erro ao cadastrar jogo.");
        }
    }

    private void cadastrarJogador() {
        int codigo = lerInteiro("Digite o código: ");
        String nome = lerTexto("Digite o nome: ");
        String email = lerTexto("Digite o email: ");

        if (controlador.cadastrarJogador(codigo, nome, email)) {
            System.out.println("Jogador cadastrado com sucesso.");
        } else {
            System.out.println("Erro ao cadastrar jogador.");
        }
    }

    private void listarJogos() {
        System.out.println(controlador.listarJogos());
    }

    private void listarJogadores() {
        System.out.println(controlador.listarJogadores());
    }

    private void buscarJogo() {
    	int qtd = controlador.contarJogos();
    	if(qtd == 0) {
    		System.out.println("Não há jogos cadastrados.");
    		return;
    	}
        int codigo = lerInteiro("Digite o código do jogo: ");

        Jogo jogo = controlador.buscarJogo(codigo);

        if (jogo == null) {
            System.out.println("Jogo não encontrado.");
        } else {
            System.out.println(jogo);
        }
    }

    private void buscarJogador() {
    	int qtd = controlador.contarJogadores();
    	if(qtd == 0) {
    		System.out.println("Não há jogadores cadastrados.");
    		return;
    	}
        int codigo = lerInteiro("Digite o código do jogador: ");

        Jogador jogador = controlador.buscarJogador(codigo);

        if (jogador == null) {
            System.out.println("Jogador não encontrado.");
        } else {
            System.out.println(jogador);
        }
    }

    private void comprarJogo() {
    	int qtd = controlador.contarJogos();
    	if(qtd == 0) {
    		System.out.println("Não há jogos cadastrados.");
    		return;
    	}
        int codigoJogador = lerInteiro("Digite o código do jogador: ");
        int codigoJogo = lerInteiro("Digite o código do jogo: ");
        Jogo jogo = controlador.buscarJogo(codigoJogo);
        if (controlador.comprarJogo(codigoJogador, codigoJogo)) {
            System.out.println("Compra realizada com sucesso.");
            System.out.println("Jogo vendido: " + jogo.getTitulo());
        } else {
            System.out.println("Erro ao realizar a compra.");
        }
    }

    private void listarJogoPorCategoria() {
    	int qtd = controlador.contarJogos();
    	if(qtd == 0) {
    		System.out.println("Não há jogos cadastrados.");
    		return;
    	}
        Categoria categoria = lerCategoria();
        System.out.println(controlador.listarJogosCategoria(categoria));
    }

    private void valorCatalogo() {
    	int qtd = controlador.contarJogos();
    	if(qtd == 0) {
    		System.out.println("Não há jogos cadastrados.");
    		return;
    	}
        System.out.println("Valor total do catálogo: R$ " + controlador.calcularValorTotal());
    }

    private void jogoMaisCaro() {
    
        Jogo jogo = controlador.localizarMaisCaro();

        if (jogo == null) {
            System.out.println("Nenhum jogo cadastrado.");
        } else {
            System.out.println("Jogo mais caro:");
            System.out.println(jogo);
        }
    }

    private void jogoMaisBarato() {
    	
        Jogo jogo = controlador.localizarMaisBarato();

        if (jogo == null) {
            System.out.println("Nenhum jogo cadastrado.");
        } else {
            System.out.println("Jogo mais barato:");
            System.out.println(jogo);
        }
    }

    private void alterarPreco() {
    	int qtd = controlador.contarJogos();
    	if(qtd == 0) {
    		System.out.println("Não há jogos cadastrados.");
    		return;
    	}
        int codigo = lerInteiro("Digite o código do jogo: ");
        double novoPreco = lerDouble("Digite o novo preço: ");

        if (controlador.alterarPrecoJogo(codigo, novoPreco)) {
            System.out.println("Preço alterado com sucesso.");
        } else {
            System.out.println("Erro ao alterar o preço.");
        }
    }
}