package br.com.dio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
    public final int PERIODO_PADRAO = 45;
    private String nome;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
//    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Integer> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
         this.dataFinal = dataInicial.plusDays(PERIODO_PADRAO);

    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }


    public Set<Integer> getDevsInscritos() {
        return devsInscritos;
    }

    public void setDevsInscritos(Set<Integer> devsInscritos) {
        this.devsInscritos = devsInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

    @Override
    public String toString() {
        return "Bootcamp{" +
                "nome='" + nome + '\n' +
                ", dataInicial=" + dataInicial +'\n'+
                ", dataFinal=" + dataFinal +'\n'+
                ", conteudos=" + conteudos + '\n' +
                ", devsInscritos=" + devsInscritos +'\n'+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bootcamp)) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(getNome(), bootcamp.getNome()) &&
                Objects.equals(getDataInicial(), bootcamp.getDataInicial()) &&
                Objects.equals(getDataFinal(), bootcamp.getDataFinal()) &&
                Objects.equals(getDevsInscritos(), bootcamp.getDevsInscritos()) &&
                Objects.equals(getConteudos(), bootcamp.getConteudos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getDataInicial(), getDataFinal(), getDevsInscritos(), getConteudos());
    }
}
