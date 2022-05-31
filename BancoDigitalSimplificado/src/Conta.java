//Criado pelo Matheus Buratti Zagonel

public class Conta {
    private static int numeroContas = 0;

    private int numero;

    private double saldo;

    private Cliente cliente;

    private String tipo;

    public void informacoes(){
        System.out.printf("Conta: %06d\n" +
                "Tipo: %s\n" +
                "Cliente: %s\n" +
                "Saldo: %.2f\n\n", numero, tipo, cliente.getNome(), saldo);
    }

    public Conta(Cliente cliente) {
        this.numero = ++numeroContas;
        this.saldo = 0;
        this.cliente = cliente;
        cliente.adicionarConta(this);
    }

    void sacar(double valor){
        if(valor < 0){
            System.out.println("Valor invalido.");
            return;
        }
        if (valor > this.saldo){
            System.out.println("Saldo insuficiente.");
            return;
        }
        this.saldo -= valor;
        System.out.printf("Saque de %.2f na conta " + this.numero + " efetuado com sucesso!\n", valor);

    }

    void depositar(double valor){
        if (valor < 0){
            System.out.println("Valor invalido");
            return;
        }
        this.saldo += valor;
        System.out.printf("Deposito de %.2f na conta " + this.numero + " efetuado com sucesso!\n", valor);

    }

    void transferir(double valor, Conta destino){
        if (valor < 0){
            System.out.println("Valor invalido.");
            return;
        }
        if (valor > this.saldo){
            System.out.println("Saldo insuficiente.");
            return;
        }

        this.saldo -= valor;
        destino.saldo += valor;
        System.out.println("Transferencia de " + valor + " da conta " + this.numero + " para conta " + destino.getNumero() + " efetuada con sucesso!");

    }

    public int getNumero() {
        return this.numero;
    }

    public String getTipo () {
        return this.tipo;
    }

    public void setTipo (String tipo){
        this.tipo = tipo;
    }
//    public void setNumero(int numero) {
//        this.numero = numero;
//    }
//
//    public double getSaldo() {
//        return this.saldo;
//    }
//
//    public Cliente getCliente() {
//        return this.cliente;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }

}
