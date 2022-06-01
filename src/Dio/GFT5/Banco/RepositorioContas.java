package Dio.GFT5.Banco;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class RepositorioContas {

    private List<Conta> contas =  new ArrayList<>();

    public void Inserir(Conta novaConta){
        this.contas.add(novaConta);
    }

    public void Excluir(Conta conta){
        this.contas.remove(conta);
    }

    public void Atualizar(int id, Conta conta){
        this.contas.set(id, conta);
    }

    public List<Conta> Listar(){
        return contas;
    }

    public List<Conta> BuscarPorNome(String nome) throws Exception {

        Iterator<Conta> iterator = contas.iterator();

        List<Conta> listaRetorno = new ArrayList<>();

        while (iterator.hasNext()){
            Conta conta = iterator.next();
            if (  conta.cliente.getNome().toLowerCase().equals(nome.toLowerCase()) ){
                listaRetorno.add(conta);
            }
        }
        if(listaRetorno.isEmpty()) throw new Exception("Cliente não localizado.");

        return listaRetorno;

    }

}
