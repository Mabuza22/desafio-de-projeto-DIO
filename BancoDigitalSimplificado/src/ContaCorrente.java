//Criado pelo Matheus Buratti Zagonel

public class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente) { //CONSTRUCTOR DE CONTA CORRENTE
        super(cliente);
        this.setTipo("corrente");
    }
}
