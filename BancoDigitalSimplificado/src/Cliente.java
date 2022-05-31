import java.util.HashSet;
import java.util.Set;

//Criado pelo Matheus Buratti Zagonel

public class Cliente {

    private String nome;
    private Set<Conta> contas;

    public void informacoes(){
        System.out.println("Nome: " + nome +"\nContas:");
        for (Conta conta : contas){
            System.out.printf("  - " + conta.getTipo() + ": %06d\n", conta.getNumero());
        }
        System.out.println();
    }

    public Cliente(String nome) {
        this.nome = nome;
        this.contas = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", contas=" + contas +
                '}';
    }

    public void adicionarConta (Conta conta){
        this.contas.add(conta);
    }

//        public void setNome(String nome) {
//        this.nome = nome;
//    }
}
