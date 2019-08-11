package edu.ifpb.atividadedac1.App;

import edu.ifpb.atividadedac1.domain.Aluno;
import edu.ifpb.atividadedac1.domain.Autor;
import edu.ifpb.atividadedac1.domain.Endereco;
import edu.ifpb.atividadedac1.domain.Livro;
import edu.ifpb.atividadedac1.domain.Professor;
import edu.ifpb.atividadedac1.domain.Telefone;
import edu.ifpb.atividadedac1.domain.TelefoneType;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import javax.persistence.EntityManager;

/**
 *
 * @author Lucas
 */
public class InitDB {
    public static void Init() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Aluno a1 = new Aluno(
                "010101-11",
                Date.valueOf(LocalDate.of(2018, Month.JANUARY, 20)),
                "2018.1",
                "José Joaquino da Silva",
                "111.111.111-11", 
                19,
                Date.valueOf(LocalDate.of(2000, Month.MAY, 26)),
                new Endereco(
                    "Rua Existente de Verdade",
                    "Bairro Aleatorio",
                    "Lastro",
                    "66602-555"
                )
        );
        Aluno a2 = new Aluno(
                "010101-22",
                Date.valueOf(LocalDate.of(2019, Month.JANUARY, 20)),
                "2019.1",
                "Maria Antonia Carlita", 
                "111.111.111-22", 
                20,
                Date.valueOf(LocalDate.of(1999, Month.FEBRUARY, 12)),
                new Endereco(
                    "Rua Estrada Sem Fim",
                    "Bairro Centro",
                    "Uberlandia",
                    "88024-485"
                )
        );
        Aluno a3 = new Aluno(
                "010101-33",
                Date.valueOf(LocalDate.of(2018, Month.AUGUST, 01)),
                "2018.2",
                "Josefa Betania da Costa",
                "111.111.111-33", 
                19,
                Date.valueOf(LocalDate.of(2000, Month.MAY, 26)),
                new Endereco(
                    "Rua Original",
                    "Bairro Guararibe",
                    "Recife",
                    "66792-555"
                )
        );
        
        Livro l1 = new Livro(
                "Aprendendo JPA",
                "97984532113",
                Date.valueOf(LocalDate.of(2002,Month.JANUARY,03)),
                new ArrayList<>()
        );
        Livro l2 = new Livro(
                "Historinhas da Disney",
                "9798453779",
                Date.valueOf(LocalDate.of(1990,Month.OCTOBER,01)),
                new ArrayList<>()
        );
        
        Livro l3 = new Livro(
                "Contos de Terro dos anos 80",
                "87481184113",
                Date.valueOf(LocalDate.of(1995,Month.APRIL,20)),
                new ArrayList<>()
        );
        
        Livro l4 = new Livro(
                "Historias da Guerra",
                "67443184213",
                Date.valueOf(LocalDate.of(2019,Month.JULY,23)),
                new ArrayList<>()
        );
        
        Autor at1 = new Autor(
                "Augusto dos Santos",
                "880.550.015-44",
                50,
                Date.valueOf(LocalDate.of(1969, Month.AUGUST, 30)),
                new Endereco(
                        "Av. dos Humanoides",
                        "Bairro Centro",
                        "Campinas",
                        "58112-551"
                ),
                "Instituto Federal City",
                Arrays.asList(l1,l2)
        );
        Autor at2 = new Autor(
                "João Roberto de Alcantara",
                "680.680.015-31",
                69,
                Date.valueOf(LocalDate.of(1950, Month.NOVEMBER, 10)),
                new Endereco(
                        "Av. Burguesia",
                        "Bairro Primavera",
                        "California",
                        "77842-978"
                ),
                "University Campus",
                Arrays.asList(l3)
        );
        Autor at3 = new Autor(
                "Regina Correia",
                "220.510.015-44",
                60,
                Date.valueOf(LocalDate.of(1979, Month.AUGUST, 27)),
                new Endereco(
                        "Rua Prefeito Joavantino",
                        "Bairro Estefasis",
                        "Cajazeiras",
                        "58811-520"
                ),
                "Instituto Federal PB",
                Arrays.asList(l4)
        );
        
        Telefone t1 = new Telefone(
                "(84)99721-4545",
                TelefoneType.RESIDENCIAL
        );
        Telefone t2 = new Telefone(
                "(84)99880-4545",
                TelefoneType.COMERCIAL
        );
        Telefone t3 = new Telefone(
                "(83)98201-9005",
                TelefoneType.RESIDENCIAL
        );
        Telefone t4 = new Telefone(
                "(83)99735-4580",
                TelefoneType.COMERCIAL
        );
        Telefone t5 = new Telefone(
                "(84)99850-9090",
                TelefoneType.RESIDENCIAL
        );
        Telefone t6 = new Telefone(
                "(83)99221-7028",
                TelefoneType.COMERCIAL
        );
        
        Professor p1 = new Professor(
                Arrays.asList(t1,t2),
                15000,
                "Ricardo Job",
                "513.550.104-66",
                28,
                Date.valueOf(LocalDate.of(1991, Month.MARCH, 15)),
                new Endereco(
                        "Rua Bezerra dos Santos",
                        "Bairro Bancarios",
                        "João Pessoa",
                        "55800-800"
                )
        );
        Professor p2 = new Professor(
                Arrays.asList(t3,t4),
                12000,
                "Fabio Abrantes",
                "513.505.880-66",
                39,
                Date.valueOf(LocalDate.of(1980, Month.OCTOBER, 25)),
                new Endereco(
                        "Rua Projetada",
                        "Bairro Centro",
                        "Marizópolis",
                        "56740-820"
                )
        );
        Professor p3 = new Professor(
                Arrays.asList(t5,t6),
                19000,
                "Alvaro Magnum",
                "714.741.104-67",
                28,
                Date.valueOf(LocalDate.of(1991, Month.MARCH, 15)),
                new Endereco(
                        "Que atividade fácil",
                        "Bairro Bancarios",
                        "João Pessoa",
                        "55800-950"
                )
        );
                    
         em.getTransaction().begin();
         em.persist(a1);
         em.persist(a2);
         em.persist(a3);
         em.persist(at1);
         em.persist(at2);
         em.persist(at3);
         em.persist(p1);
         em.persist(p2);
         em.persist(p3);
         em.persist(l1);
         em.persist(l2);
         em.persist(l3);
         em.persist(l4);
         em.getTransaction().commit();

    }
}
