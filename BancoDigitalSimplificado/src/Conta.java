//Criado pelo Matheus Buratti Zagonel

public class Conta {
    private static int numeroContas = 0;

    private int numero;

    private double saldo;

    private Cliente cliente;

    private String tipo;

    public void informacoes(){ //IMPRIME AS INFORMACOES DA CONTA
        System.out.printf("Conta: %06d\n" +
                "Tipo: %s\n" +
                "Cliente: %s\n" +
                "Saldo: %.2f\n\n", numero, tipo, cliente.getNome(), saldo);
    }

    public Conta(Cliente cliente) { //CONSTRUCTOR DE CONTA
        this.numero = ++numeroContas;
        this.saldo = 0;
        this.cliente = cliente;
        cliente.adicionarConta(this);
    }

    void sacar(double valor){ //RETIRA O VALOR DA CONTA
        if(valor < 0){//VERIFICA SE O VALOR E POSITIVO
            System.out.println("Valor invalido.");
            return;
        }
        if (valor > this.saldo){ // VERIFICA SE TEM SALDO SUFICIENTE
            System.out.println("Saldo insuficiente.");
            return;
        }
        this.saldo -= valor;
        System.out.printf("Saque de %.2f na conta %06d efetuado com sucesso!\n", valor, this.numero);

    }

    void depositar(double valor){ //ADICIONA O VALOR NA CONTA
        if (valor < 0){ //VERIFICA SE O VALOR E VALIDO
            System.out.println("Valor invalido");
            return;
        }
        this.saldo += valor;
        System.out.printf("Deposito de %.2f na conta %06d efetuado com sucesso!\n", valor, this.numero);

    }

    void transferir(double valor, Conta destino){ //RETIRA O VALOR DE UMA CONTA E ADIONA NA OUTRA
        if (valor < 0){ //VERIFICA SE O VALOR E VALIDO
            System.out.println("Valor invalido.");
            return;
        }
        if (valor > this.saldo){ //VERIFICA SE TEM SALDO SUFICIENTE
            System.out.println("Saldo insuficiente.");
            return;
        }

        this.saldo -= valor;
        destino.saldo += valor;
        System.out.printf("Transferencia de " + valor + " da conta %06d para conta %06d efetuada com sucesso!\n", this.numero, destino.getNumero());

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


}
