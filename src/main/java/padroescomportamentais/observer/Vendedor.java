package padroescomportamentais.observer;

import java.util.Observable;
import java.util.Observer;

public class Vendedor implements Observer {

    private String nome;
    private int telefone;
    private String nome_supervisor;

    private String ultimaNotificacao;

    public Vendedor(String nome, int telefone, String nome_supervisor) {
        this.nome = nome;
        this.telefone = telefone;
        this.nome_supervisor = nome_supervisor;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void vender(Almoxarifado almoxarifado) {
        almoxarifado.addObserver(this);
    }

    public void update(Observable almoxarifado, Object arg1) {
        this.ultimaNotificacao = this.nome + ", vendeu o produto " + almoxarifado.toString();
        // System.out.println(this.ultimaNotificacao);
    }
}
