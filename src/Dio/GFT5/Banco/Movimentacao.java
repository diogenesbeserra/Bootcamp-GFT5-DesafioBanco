package Dio.GFT5.Banco;

import java.time.LocalDateTime;
import java.util.List;

public class Movimentacao {

    private static int SEQUENCIAL = 1;
    private TipoMovimentacao tipo;
    private int id;
    private double valor;
    private LocalDateTime dateTime;
    private String descricao;

    public Movimentacao(double valor) {
        this.id = SEQUENCIAL++;
        this.valor = valor;
        this.dateTime = LocalDateTime.now();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoMovimentacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimentacao tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "{" +
                "tipo=" + tipo +
                ", id=" + id +
                ", valor=" + valor +
                ", dateTime=" + dateTime +
                '}';
    }
}
