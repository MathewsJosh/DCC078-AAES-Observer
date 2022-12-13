package padroescomportamentais.observer;

import java.util.Observable;

public class Almoxarifado extends Observable {

    private Integer lote;
    private Integer quantidade;
    private String nome_produto;
    private String modelo;

    public Almoxarifado(Integer lote, Integer quantidade, String nome_produto, String modelo) {
        this.lote = lote;
        this.quantidade = quantidade;
        this.nome_produto = nome_produto;
        this.modelo = modelo;
    }

    public void atualizarEstoque() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Almoxarifado{" +
                "lote=" + lote +
                ", quantidade=" + quantidade +
                ", nome_produto='" + nome_produto + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
