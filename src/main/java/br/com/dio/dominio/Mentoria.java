package br.com.dio.dominio;
import java.time.LocalDate;


public class Mentoria {
    private String titulo;
    private String descricao;
    private int cargaHoraria;
    private LocalDate data;

    public Mentoria() {
    }

    public Mentoria(String titulo, String descricao, int cargaHoraria, LocalDate data) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.data = data;
    }

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

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate date) {
        this.data = date;
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", data=" + data +
                '}';
    }
}
