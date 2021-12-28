package br.com.dio.dominio;

public abstract class Conteudo {
    protected final double XP_PADRAO = 10d;
    private String titulo;
    private String descricao;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public abstract double calcularXP();

    @Override
    public String toString() {
        return "Conteudo{" +
                "XP_PADRAO=" + XP_PADRAO +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                '}'+'\n';
    }
}
