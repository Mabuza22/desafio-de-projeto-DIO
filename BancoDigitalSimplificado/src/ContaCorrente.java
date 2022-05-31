//Criado pelo Matheus Buratti Zagonel

public class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        this.setTipo("corrente");
    }
}
