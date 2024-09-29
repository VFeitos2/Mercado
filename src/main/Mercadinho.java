package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import mode.Produt;
//1import utils.utili;

public class Mercadinho {
    private static Scanner input = new Scanner(System.in);

    private static ArrayList<Produt> produtos;

    private static Map<Produt, Integer> carrinho;

    public static void main (String[] args){
        produtos = new ArrayList<>();
        carrinho = new HashMap<>();
        menu();
    }
    
    private static void menu(){
        System.out.println("______________________________________");
        System.out.println("_____Bem vindo ao Mercadinho__________");
        System.out.println("______________________________________");
        System.out.println("Selecione uma operação:");
        System.out.println("    Opção 1 - Cadastrar");
        System.out.println("    Opção 2 - Listar");     
        System.out.println("    Opção 3 - Comprar");
        System.out.println("    Opção 4 - Carrinho");
        System.out.println("    Opção 5 - Sair");

        // Variável do switch
        int option = input.nextInt();

        switch(option){
            case 1:
                cadastrarProdutos();
                break;
            case 2:
                listarProdutos();
                break;
            case 3:
                comprarProdutos();
                break;
            case 4:
                verCarrinho();
                break;
            case 5:
                System.out.println("Volte sempre");
                System.exit(0);
            default:
                System.out.println("Opção invalida");
                menu();
                break;
        }

    }

    private static void cadastrarProdutos(){
        System.out.println("Nome do produto: ");
        String nome = input.next();

        System.out.println("Preço do produto: ");
        Double preco = input.nextDouble();

        Produt produto = new Produt(nome, preco);
        produtos.add(produto);

    System.out.println(produto.getNome() + "Cadastrado com sucesso!");
    menu();
    }

    private static void listarProdutos(){
        //  Verificação existência de produtos
        if(produtos.size() > 0){
            System.out.println("Lista de produtos \n");

            for(Produt p : produtos){
                System.out.println(p);
            }
        } else{
            System.out.println("Nenhum produto cadastrado!");
        }

        menu();
    }

    private static void comprarProdutos(){
        if(produtos.size() > 0){
            System.out.println("Código de produtos \n");
            
            System.out.println("Produtos disponíveis");
                for(Produt p : produtos){
                   System.out.println(p);
                }
            } 
            int id = Integer.parseInt(input.next());
            boolean isPresent = false;

            //  Verificar a ID do produto
            for(Produt p : produtos){
                if (p.getId() == id){
                    int qtd = 0;
                    // Verifica se o produto está no carrinho.
                    try {
                        qtd = carrinho.get(p);
                        // Checa se o produto já está no carrinho, incrementa quantidade
                        carrinho.put(p, qtd +1);
                    } catch (NullPointerException e) {
                        // Se o produto for o primeiro no carrinho
                        carrinho.put(p, 1);
                    }

                System.out.println(p.getNome() + "adicionado ao carrinho");
                isPresent = true;

                if(isPresent){
                    System.out.println("Deseja adicionar outro produto? ");
                    System.out.println("Digite 1 para sim, ou 0 para finalizar a compra \n"); 
                    int option = Integer.parseInt(input.next());

                    if (option == 1){
                        comprarProdutos();
                    } else{
                        finalizarCompra();
                    }
                }
                
            } else{
                System.out.println("Produto não encontrado");
                menu();
            }


        } 
    }

    private static void verCarrinho(){
        System.out.println("Produtos no seu carrinho");
        if (carrinho.size()>0){
            for (Produt p : carrinho.keySet()){
                System.out.println("Produto: " + p +"\n Quantidade: " + 
                carrinho.get(p));
            }
        } else {
            System.out.println("Carrinho vazio");
        }
        menu();
    }

    private static void finalizarCompra(){
        Double valorDaCompra = 0.0;
        System.err.println("Seus produtos");

        for (Produt p : carrinho.keySet()){
            int qtd = carrinho.get(p);
            valorDaCompra += p.getPreco() * qtd;
            System.out.println(p);
            System.out.println("Quantidade " + qtd);
            System.out.println("-----------------------");
        }
    System.out.println("O valor da sua compra é: " + valorDaCompra);
    // utili.doubleToString(valorDaCompra));
    carrinho.clear();
    System.out.println("Obrigado pela preferência");
    menu();
    }
}


