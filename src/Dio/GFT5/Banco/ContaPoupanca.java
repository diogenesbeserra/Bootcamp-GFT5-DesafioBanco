package Dio.GFT5.Banco;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente) {
        super(cliente, "Poupança");
    }

    @Override
    public void debitar(double valor, String descricao) {
        if(super.getSaldo() < valor) {
            System.out.println("Saldo insuficiente! Operação não realizada.");
        }else{ super.debitar(valor, descricao); }
    }

    @Override
    public void imprimirSaldo() {
        System.out.println("=== Saldo poupança ===" );
        super.imprimirInfoConta();
        System.out.println("");
        super.imprimirSaldo();
    }

    public void imprimirExtrato() {
        System.out.println("=== Extrato poupança ===" );
        super.imprimirInfoConta();
        super.imprimirExtrato();
        System.out.println("\n");
        super.imprimirSaldo();
    }
}
