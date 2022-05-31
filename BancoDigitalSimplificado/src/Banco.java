import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

//Criado pelo Matheus Buratti Zagonel

public class Banco {

    static Set<Conta> contas = new HashSet<>();
    static Set<Cliente> clientes = new HashSet<>();

    public static void main(String[] args){
        int escolha, entradaInt;
        double entradaDouble;
        String entradaNome;
        Conta conta1, conta2;
        Cliente client;
        Scanner scanString = new Scanner(System.in);
        do {
            System.out.println("     BANCO\n" +
                    "Opcoes:\n " +
                    "1 -  Novo cliente\n " +
                    "2 -  Nova conta corrente\n " +
                    "3 -  Nova conta poupanca\n " +
                    "4 -  Deposito\n " +
                    "5 -  Saque\n " +
                    "6 -  Transferencia\n " +
                    "7 -  Dados do cliente\n " +
                    "8 -  Dados da conta\n " +
                    "9 -  Lista de clientes\n " +
                    "10 - Lista de contas\n " +
                    "0  - Sair");
            System.out.print("Digite o numero de sua opcao: ");
            escolha = lerInt();

            switch (escolha){
                case 0: {
                    return;
                }
                case 1:{ //NOVO CLIENTE
                    System.out.print("Digite o nome do cliente: ");
                    entradaNome = scanString.nextLine();
                    client = cadastrarCliente(entradaNome);
                    System.out.println("Cliente " + client.getNome() + " cadastrado com sucesso!");
                }break;
                case 2:{ //NOVA CONTA CORRENTE
                    System.out.print("Digite o nome do cliente dono da conta corrente: ");
                    conta1 = criarContaCorrente(scanString.nextLine());
                    if (conta1 != null){
                        System.out.println("Conta corrente " + conta1.getNumero() + " cadastrada com sucesso!");
                    } else{
                        System.out.println("Erro ao criar a conta");
                    }
                }break;
                case 3:{ // NOVA CONTA POUPANCA
                    System.out.print("Digite o nome do cliente dono da conta poupanca: ");
                    conta1 = criarContaPoupanca(scanString.nextLine());
                    if (conta1 != null){
                        System.out.println("Conta poupanca " + conta1.getNumero() + " cadastrada com sucesso!");
                    } else {
                        System.out.println("Erro ao criar a conta");
                    }
                }break;
                case 4:{ // DEPOSITO
                    System.out.print("Digite o numero da conta: ");
                    entradaInt = lerInt();
                    if (entradaInt == -1){
                        System.out.println("Entrada inválida!");
                        break;
                    }

                    System.out.println("entrada: " + entradaInt);
                    conta1 = null;
                    if (contas.isEmpty()){
                        System.out.println("Nao existe nenhuma conta");
                        break;
                    }
                    for (Conta conta : contas) {
                        if (conta.getNumero() == entradaInt){
                            conta1 = conta;
                            break;
                        }
                    }
                    if (conta1 == null){
                        System.out.println("Conta não encontrada.");
                    }else {
                        System.out.print("Digite o valor a ser depositado: ");
                        entradaDouble = lerDouble();
                        if (entradaDouble == -1){
                            System.out.println("Entrada inválida!");
                            break;
                        }
                        conta1.depositar(entradaDouble);
                    }
                }break;
                case 5:{ //SAQUE
                    System.out.print("Digite o numero da conta: ");
                    entradaInt = lerInt();
                    if (entradaInt == -1){
                        System.out.println("Entrada inválida!");
                        break;
                    }
                    conta1 = null;
                    for (Conta conta : contas) {
                        if (conta.getNumero() == entradaInt){
                            conta1 = conta;
                            break;
                        }
                    }
                    if (conta1 == null){
                        System.out.println("Conta não encontrada.");
                    }else {
                        System.out.print("Digite o valor a ser sacado: ");
                        entradaDouble = lerDouble();
                        if (entradaDouble == -1){
                            System.out.println("Entrada inválida!");
                            break;
                        }
                        conta1.sacar(entradaDouble);
                    }
                }break;
                case 6: { //TRANSACAO
                    System.out.print("Digite o numero da conta de origem: ");
                    entradaInt = lerInt();
                    if (entradaInt == -1){
                        System.out.println("Entrada inválida!");
                        break;
                    }
                    conta1 = null;
                    conta2 = null;
                    for (Conta conta : contas) {
                        if (conta.getNumero() == entradaInt){
                            conta1 = conta;
                            break;
                        }
                    }
                    if (conta1 == null){
                        System.out.println("Conta não encontrada.");
                    }else{
                        System.out.print("Digite o numero da conta de destino: ");

                        entradaInt = lerInt();
                        if (entradaInt == -1){
                            System.out.println("Entrada inválida!");
                            break;
                        }

                        for (Conta conta : contas) {
                            if (conta.getNumero() == entradaInt){
                                conta2 = conta;
                                break;
                            }
                        }
                        if (conta2 == null) {
                            System.out.println("Conta não encontrada.");
                        }
                        else {
                            System.out.print("Digite o valora ser transferido: ");
                            entradaDouble = lerDouble();
                            if (entradaDouble == -1){
                                System.out.println("Entrada inválida!");
                                break;
                            }
                            conta1.transferir(entradaDouble, conta2);
                        }
                    }
                }break;
                case 7:{ //DADOS DO CLIENTE
                    System.out.print("Insira o nome do cliente: ");
                    entradaNome = scanString.nextLine();
                    for (Cliente cliente : clientes) {
                        if (cliente.getNome().equalsIgnoreCase(entradaNome)) {
                            cliente.informacoes();
                            break;
                        }
                    }
                }break;
                case 8:{ //DADOS DA CONTA
                    System.out.print("Insira o numero da conta: ");
                    entradaInt = lerInt();
                    if (entradaInt == -1){
                        System.out.println("Entrada inválida!");
                        break;
                    }
                    for (Conta conta : contas){
                        if (conta.getNumero() == entradaInt){
                            conta.informacoes();
                            break;
                        }
                    }
                }break;
                case 9: { //LISTA DE CLIENTES
                    System.out.println("Lista de Cliente :");
                    for (Cliente cliente : clientes){
                        cliente.informacoes();
                    }
                }break;
                case 10: { //LISTA DE CONTAS
                    System.out.println("Lista de Contas");
                    for (Conta conta : contas){
                        conta.informacoes();
                    }
                }break;
                default: {
                    System.out.println("Entrada inválida!");
                }
            }
            System.out.print("Aperte a tecla \"enter\" para seguir! ");
            scanString.nextLine();
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }while(true);
    }

    static Cliente cadastrarCliente(String nome){
        Cliente cliente = new Cliente(nome);
        clientes.add(cliente);
        return cliente;
    }

    static Conta criarContaCorrente(String nome){

        for (Cliente cliente : clientes){
            if (cliente.getNome().equalsIgnoreCase(nome)){
                Conta conta = new ContaCorrente(cliente);
                contas.add(conta);
                return conta;
            }
        }
        System.out.println("Cliente " + nome + " não existe.") ;
        return null;
    }

    static Conta criarContaPoupanca(String nome){

        for (Cliente cliente : clientes){
            if (cliente.getNome().equalsIgnoreCase(nome)){
                Conta conta = new ContaPoupanca(cliente);
                contas.add(conta);
                return conta;
            }
        }
        System.out.println("Cliente " + nome + "não existe.") ;
        return null;
    }

    static int lerInt(){
        int entradaInt;
        Scanner scan = new Scanner(System.in);
        try{
            entradaInt = scan.nextInt();
        }
        catch(InputMismatchException erro){
            entradaInt = -1;
        }

        return entradaInt;
    }

    static double lerDouble(){
        double entradaDouble;
        Scanner scan = new Scanner(System.in);
        try {
            entradaDouble = scan.nextDouble();
        } catch (InputMismatchException erro){
            entradaDouble = -1;
        }
        return entradaDouble;
    }

}


