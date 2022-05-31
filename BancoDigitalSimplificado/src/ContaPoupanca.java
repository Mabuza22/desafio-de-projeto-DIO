//Criado pelo Matheus Buratti Zagonel

public class ContaPoupanca extends Conta{


    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        this.setTipo("poupanca");
    }
}