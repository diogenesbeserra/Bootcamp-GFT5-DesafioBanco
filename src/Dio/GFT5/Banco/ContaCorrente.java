package Dio.GFT5.Banco;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente, "Corrente");
    }

    @Override
    public void imprimirSaldo() {
        System.out.println("=== Saldo conta corrente ===" );
        super.imprimirInfoConta();
        System.out.println("");
        super.imprimirSaldo();
    }

    public void imprimirExtrato() {
        System.out.println("=== Extrato conta corrente ===" );
        super.imprimirInfoConta();
        super.imprimirExtrato();
        System.out.println("\n");
        super.imprimirSaldo();
    }


}
