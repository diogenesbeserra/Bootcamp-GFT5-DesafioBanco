package Dio.GFT5;

import Dio.GFT5.Banco.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        RepositorioContas contasRepositorio = new RepositorioContas();


        Cliente c1 = new Cliente("Diógenes", "11122233345");
        Cliente c2 = new Cliente("Pietra", "22233344456");
        Cliente c3 = new Cliente("Verônica", "33344455567");

        ContaCorrente cc1 = new ContaCorrente(c1);
        ContaPoupanca cp1 = new ContaPoupanca(c1);
        ContaPoupanca cp2 = new ContaPoupanca(c2);
        ContaPoupanca cc2 = new ContaPoupanca(c3);
        ContaPoupanca cp3 = new ContaPoupanca(c3);

        contasRepositorio.Inserir(cc1);
        contasRepositorio.Inserir(cp1);
        contasRepositorio.Inserir(cp2);
        contasRepositorio.Inserir(cc2);
        contasRepositorio.Inserir(cp3);

        //Listar contas de clientes buscando pelo nome
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o nome do cliente");
        String buscaCliente = in.next();

        try {
            Iterator<Conta> iterator = contasRepositorio.BuscarPorNome(buscaCliente).iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (Exception e) {
            System.out.println( e.getMessage() + " " + buscaCliente);
        }

        //Conta corrente permite saldo negativo
        cc1.creditar( 100d, "Depósito");
        cc1.transferir(50d, cp1);
        cc1.debitar(60d, "Saque");

        cc1.imprimirSaldo();
        cc1.imprimirExtrato();

        cc1.creditar(2500.00,"Salário");
        cc1.debitar(652.68, "Cartão");
        cc1.debitar(42.5, "Almoço");
        cc1.transferir(500, cp1);

        cc1.imprimirExtrato();

        cp1.debitar(40, "Almoço");

        cp1.imprimirSaldo();
        cp1.imprimirExtrato();

    }
}
