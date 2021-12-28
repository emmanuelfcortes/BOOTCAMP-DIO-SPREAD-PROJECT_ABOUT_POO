package br.com.dio.dominio;


import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private static int acumuladorId;
    private Integer id;
    private String nome;
    private Set<Conteudo> conteudosConcluídos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();

    private int geradorId(){
        return ++this.acumuladorId;
    }
    public Dev(){
        id = geradorId();
    }

    public Integer getId() {
        return id;
    }


    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this.id);
    }

    public void progredirBootcamp() {

        Optional<Conteudo> conteudo = this.getConteudosInscritos().stream().findFirst();
        if (conteudo.isPresent()) {
            this.conteudosConcluídos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        }
        else
            System.err.println("Não há conteúdos cadastrados.");
    }

    public double calcularTotalXP() {
        return this.conteudosConcluídos.stream().mapToDouble(Conteudo::calcularXP).sum();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosConcluídos() {
        return conteudosConcluídos;
    }

    public void setConteudosConcluídos(Set<Conteudo> conteudosConcluídos) {
        this.conteudosConcluídos = conteudosConcluídos;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dev)) return false;
        Dev dev = (Dev) o;
        return Objects.equals(getNome(), dev.getNome()); /*&&
                Objects.equals(getConteudosConcluídos(), dev.getConteudosConcluídos()) &&
                Objects.equals(getConteudosInscritos(), dev.getConteudosInscritos()*///);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getConteudosConcluídos(), getConteudosInscritos());
    }

    @Override
    public String toString() {
        return "Dev{" +
                "nome='" + nome + '\'' + '}';
    }
}
