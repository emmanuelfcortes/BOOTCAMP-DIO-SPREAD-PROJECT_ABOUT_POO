package br.com.dio.dominio;
import java.time.LocalDate;


public class Mentoria extends Conteudo {
    private int cargaHoraria;
    private LocalDate data;

    public Mentoria() {
    }

    public Mentoria(String titulo, String descricao, int cargaHoraria, LocalDate data) {
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        this.cargaHoraria = cargaHoraria;
        this.data = data;
    }


    @Override
    public double calcularXP() {
        return this.XP_PADRAO * this.cargaHoraria;
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
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", data=" + data +
                '}';
    }
}
