import br.com.dio.dominio.Curso;
import br.com.dio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso("Java Basics", "Curso Java Básico", 16);
        Curso curso2 = new Curso("Java Collections", "Curso Collections introdução", 10);
        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Conhecendo o JAVA.");
        mentoria1.setDescricao("Introdução sobre o Java.");
        mentoria1.setCargaHoraria(2);
        mentoria1.setData(LocalDate.now());
        System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria1);
    }
}
