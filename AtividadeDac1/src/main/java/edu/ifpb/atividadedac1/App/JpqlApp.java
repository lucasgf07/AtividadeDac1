package edu.ifpb.atividadedac1.App;

import edu.ifpb.atividadedac1.domain.AlunoVO;
import edu.ifpb.atividadedac1.domain.Livro;
import edu.ifpb.atividadedac1.domain.Professor;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Lucas
 */
public class JpqlApp {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        InitDB.Init();
        
//        livrosAutoresNaoNascidoEm_21_11_1982(em);
//        professoresRua_QueAtividadeFacil(em);
//        AlunosTurma_2019_1(em);
//        professoresTelefoneFinal_8(em);
//        livrosAutoresCajazeirasData_01_01_2019__12_12_2019(em);
        livrosAutoresInicia_J(em);
    }

    private static void livrosAutoresNaoNascidoEm_21_11_1982(EntityManager em) {
        String jpql = "SELECT DISTINCT  livro FROM Livro livro, "
                + "IN (livro.autores) autores WHERE autores.dataNascimento != "
                + "'1982-11-21'";
        TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
        query.getResultList().forEach(l -> System.out.println(l.getTitulo()));
    }

    private static void professoresRua_QueAtividadeFacil(EntityManager em){
        String jpql = "SELECT DISTINCT professor FROM Professor professor "
                + "LEFT JOIN professor.telefones telefone "
                + "WHERE telefone.numero IS NOT NULL "
                + "AND (professor.endereco.rua) LIKE 'Que atividade fácil'";
        TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
        query.getResultList().forEach(p -> System.out.println(p.getNome()));
    }

    private static void AlunosTurma_2019_1(EntityManager em){
       String jpql = "SELECT NEW edu.ifpb.atividadedac1.domain.AlunoVO"
               + "(aluno.nome, aluno.cpf, aluno.idade) "
               + "FROM Aluno aluno WHERE aluno.turma = '2019.1'";
        TypedQuery<AlunoVO> query = em.createQuery(jpql, AlunoVO.class);
        query.getResultList().forEach(aVO->System.out.println(aVO.toString()));
    }
    
       private static void professoresTelefoneFinal_8(EntityManager em){
        String jpql = "SELECT professor FROM Professor professor "
                + "LEFT JOIN professor.telefones telefone "
                + "WHERE telefone.numero LIKE '%8'";
        TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
        query.getResultList().forEach(p->System.out.println(p.getNome()));
    }
    
    //Uma consulta que seleciona todos os livros dos Autores da cidade de Cajazeiras e tiveram seu lançamento entre os dias 01/01/2019 e 12/12/2019.
    private static void livrosAutoresCajazeirasData_01_01_2019__12_12_2019(EntityManager em){
        String jpql = "SELECT DISTINCT livro FROM Livro livro, "
                + "IN (livro.autores) autores "
                + "WHERE (autores.endereco.cidade) LIKE 'Cajazeiras' "
                + "AND livro.lancamento BETWEEN '2019-01-01' AND '2019-12-12'";
        TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
        query.getResultList().forEach(l -> System.out.println(
                "Livro: "+l.getTitulo())
        );
    }
    
    // Uma consulta que selecione os Livros dos Autores que começam com a letra “J”.
    private static void livrosAutoresInicia_J(EntityManager em){
        String jpql = "SELECT DISTINCT livro FROM Livro livro, "
                + "IN (livro.autores) autor WHERE (autor.nome) LIKE 'J%'";
        TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
        query.getResultList().forEach(l->System.out.println(
                "Livro: "+l.getTitulo())
        );
    }
}
