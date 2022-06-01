package Dio.GFT5.Banco;

public interface IConta {
    void debitar(double valor, String descricao);
    void creditar(double valor, String descricao);
    void imprimirSaldo();
    void transferir(double valor, Conta contaDestino);
}
