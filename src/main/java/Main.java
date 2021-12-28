import br.com.dio.dominio.*;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*Criando cursos para inserir no Bootcamp*/
        Curso curso1 = new Curso("Java Basics", "Curso Java Básico", 16);
        Curso curso2 = new Curso("Collections", "Curso Collections introdução", 10);
        Curso curso3 = new Curso("Estrutura de dados", "Curso Estrutura de dados", 15);
        Curso curso4 = new Curso("Desafios", "Desafio programação", 4);
        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Conhecendo a SPREAD.");
        mentoria1.setDescricao("Conhecendo algumas dicas sobre a SPREAD.");
        mentoria1.setCargaHoraria(2);
        mentoria1.setData(LocalDate.now());

        /* Devido à classe Conteudo ser MÃE das classes Curso e Mentoria, a classe curso
         * pode ser instanciada a partir de suas filhas. Exemplos abaixo, apenas para visualizar.
         * Não fazem parte da lógica do programa.*/
        Conteudo c1 = new Curso();
        Conteudo c2 = new Mentoria();
        /**********************************************/
        /*Criando um conjunto de conteúdos (cursos e mentorias)*/
        Set<Conteudo> conteudos = new LinkedHashSet<Conteudo>() {{
            add(curso1);
            add(curso2);
            add(curso3);
            add(curso4);
            add(mentoria1);
        }};
        /*Criando um bootcamp : adicionando nome, conteúdos e data*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp 1");
        bootcamp.setConteudos(conteudos);
        bootcamp.setDataInicial(LocalDate.now());

        /*Criando dois devs e increvendo-os no bootcamp criado*/
        Dev dev1 = new Dev();
        Dev dev2 = new Dev();
        dev1.setNome("John");
        dev1.inscreverBootcamp(bootcamp);
        dev2.setNome("Péricles Chamusca");
        dev2.inscreverBootcamp(bootcamp);

        /*Criando um terceiro dev sem fazer sua inscrição no bootcamp*/
        Dev dev3 = new Dev();
        dev3.setNome("Fuhler");


        System.out.println("Analisando se os desenvolvedores estão inscritos no bootcamp: ");
        /** Primeira maneira de analisar se o desenvolvedor está inscrito no bootcamp.*/
        Set<Dev> devs = new LinkedHashSet<Dev>() {{
            add(dev1);
            add(dev2);
            add(dev3);
        }};
        for (Dev dev : devs){
            System.out.println("Dev.id = "+dev.getId());
//            System.out.println("Analisando Dev: "+dev);
//            System.out.println("Devs no bootcamp: "+bootcamp.getDevsInscritos());
            if(bootcamp.getDevsInscritos().contains(dev.getId()))
                System.out.println("O desenvolvedor " + dev.getNome() +
                        " está inscrito no bootcamp " + bootcamp.getNome());
            else
                System.out.println("O desenvolvedor "+dev.getNome()+ " não está inscrito no bootcamp "+bootcamp.getNome());
        }

        /*Conferindo se os conteudos dos devs inscritos contêm os conteúdos do bootcamp */

        System.out.println("\n Avaliando o alinhamento entre os conteúdos de cada dev e o bootcamp:");
        for(Dev dev: devs){
            if(dev.getConteudosInscritos().containsAll(bootcamp.getConteudos())){
                System.out.println("Os conteudos do dev "+ dev.getNome() + " estão ok com o bootcamp.");
            }
            else
                System.out.println("Os conteudos do dev "+ dev.getNome() + " NÃO estão ok com o bootcamp.");
        }
        /* Progredindo com o treinamento dos devs */
        System.out.println("\nProgredindo com os treinamentos dos devs: ");
        System.out.println("Cursos dos devs, antes da progressão:");
        for(Dev dev: devs){
            System.out.println("Dev "+ dev.getId()+" inscritos = "+ dev.getConteudosInscritos());
            System.out.println("Dev "+ dev.getId()+" concluídos= "+ dev.getConteudosConcluídos());
        }
        dev1.progredirBootcamp();
        dev2.progredirBootcamp();
        dev3.progredirBootcamp();
        System.out.println("\n Após a progressão dos devs no bootcamp: ");

        for(Dev dev: devs){
            System.out.println("Dev "+ dev.getId()+" inscritos = "+ dev.getConteudosInscritos());
            System.out.println("Dev "+ dev.getId()+" concluídos= "+ dev.getConteudosConcluídos());
        }

        /*Exibindo o XP de cada dev*/
        System.out.println("\n Exibindo o XP de cada dev: ");
        devs.forEach((dev ->
                System.out.println("Dev "+ dev.getId()+ " XP = "+ dev.calcularTotalXP())));
        System.out.println("\nApós algumas progressões, o XP ficou assim: ");
        devs.forEach(dev -> {
            if(dev.getId()==1)
                dev.progredirBootcamp();
            else{

                dev.progredirBootcamp();
                dev.progredirBootcamp();
            }
        });
        devs.forEach(( dev ->
                System.out.println("Dev "+ dev.getId()+ " XP = "+ dev.calcularTotalXP())));
    }
}

