package Dio.GFT5.Banco;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int numero;
    protected int agencia;
    protected double saldo;
    protected Cliente cliente;
    protected List<Movimentacao> movimentacoesList;
    protected String tipoConta;


    public Conta(Cliente cliente, String tipoConta) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = 0d;
        movimentacoesList = new ArrayList<>();
        this.tipoConta = tipoConta;
    }

    public int getNumero() {
        return numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipoConta() { return tipoConta; }

    @Override
    public void debitar(double valor, String descricao) {
        //TODO VALIDAR SALDO
        Movimentacao debito = new Movimentacao(valor);
        saldo -= valor;
        debito.setTipo(TipoMovimentacao.DESPESA);
        debito.setDescricao(descricao);
        movimentacoesList.add(debito);
        System.out.println("Débito realizado com Sucesso." );

    }

    @Override
    public void creditar(double valor, String descricao) {
        Movimentacao credito = new Movimentacao(valor);
        saldo += valor;
        credito.setTipo(TipoMovimentacao.RECEITA);
        credito.setDescricao(descricao);
        movimentacoesList.add(credito);
        System.out.println("Crédito realizado com Sucesso." );
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.debitar(valor, "Transferência para " + contaDestino.cliente.getNome());
        contaDestino.creditar(valor, "Transferência de " + this.cliente.getNome());
    }

    @Override
    public String toString() {
        return "{" +
                "numero=" + numero +
                ", agencia=" + agencia +
                ", tipo=" + tipoConta +
                ", saldo=" + saldo +
                ", cliente=" + cliente.getNome() +
                '}';
    }

    protected void imprimirInfoConta() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
    }

    @Override
    public void imprimirSaldo() {
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public void imprimirExtrato() {
        Iterator<Movimentacao> iterator = movimentacoesList.iterator();
        System.out.println(String.format("Data              Tipo                Valor              Descrição"));
        while (iterator.hasNext()){
            Movimentacao movimentacao = iterator.next();
            System.out.println(String.format("%s        %s             %.2f               %s",
                    movimentacao.getDateTime().toLocalDate(),
                    movimentacao.getTipo(),
                    movimentacao.getValor(),
                    movimentacao.getDescricao()
                    ));
        }
    }

    public List<Movimentacao> listarMovimentacoes() {
        return this.movimentacoesList;
    }
}
