//Criado pelo Matheus Buratti Zagonel

public class ContaPoupanca extends Conta{


    public ContaPoupanca(Cliente cliente) { //CONSTRUCTOR DE CONTA POUPANCA
        super(cliente);
        this.setTipo("poupanca");
    }
}