package br.ufsm.csi.trabpoow.models;

public class RelatorioJogosAvaliados {
    private String nomeJogo;
    private String nomeCategoria;
    private int avalicao;

    public RelatorioJogosAvaliados(String nomeJogo, String nomeCategoria, int avalicao) {
        this.nomeJogo = nomeJogo;
        this.nomeCategoria = nomeCategoria;
        this.avalicao = avalicao;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public int getAvalicao() {
        return avalicao;
    }

    public void setAvalicao(int avalicao) {
        this.avalicao = avalicao;
    }
}
