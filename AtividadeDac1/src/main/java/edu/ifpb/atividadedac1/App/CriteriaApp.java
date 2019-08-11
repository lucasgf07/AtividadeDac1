package edu.ifpb.atividadedac1.App;


import edu.ifpb.atividadedac1.domain.Aluno;
import edu.ifpb.atividadedac1.domain.AlunoVO;
import edu.ifpb.atividadedac1.domain.Autor;
import edu.ifpb.atividadedac1.domain.Livro;
import edu.ifpb.atividadedac1.domain.Professor;
import edu.ifpb.atividadedac1.domain.Telefone;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Lucas
 */
public class CriteriaApp {
     public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        InitDB.Init();
        
//        livrosAutoresNaoNascidoEm_21_11_1982(em);;;
//        professoresRua_QueAtividadeFacil(em);
//        AlunosTurma_2019_1(em);
//        professoresTelefoneFinal_8(em);
//        livrosAutoresCajazeirasData_01_01_2019__12_12_2019(em);
        livrosAutoresInicia_J(em);
        
    }

    private static void livrosAutoresNaoNascidoEm_21_11_1982(EntityManager entityManager) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Livro> criteriaQuery = criteriaBuilder.
                createQuery(Livro.class);
        
        Root<Livro> root = criteriaQuery.from(Livro.class);
        Join<Livro, Autor> join = root.join("autores", JoinType.LEFT);
        criteriaQuery.select(root).distinct(true).where(
                criteriaBuilder.notEqual(join.get(
                        "dataNascimento"),
                        "1982-11-21"
                )
        );
        TypedQuery<Livro> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.getResultList().forEach(l -> System.out.println(l.getTitulo()));
    }

    private static void professoresRua_QueAtividadeFacil(EntityManager entityManager){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        
        CriteriaQuery<Professor> criteriaQuery = criteriaBuilder.
                createQuery(Professor.class);
        
        Root<Professor> root = criteriaQuery.from(Professor.class);
        Join<Professor, Telefone> join = root.join("telefones", JoinType.LEFT);
        Predicate telefone = criteriaBuilder.isNotNull(join.get("numero"));
        Predicate rua = criteriaBuilder.like(
                root.get("endereco").get("rua"), 
                "Que atividade fácil"
        );     
        
        criteriaQuery.select(root).distinct(true).where(telefone,rua);   
        
        TypedQuery<Professor> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.getResultList().forEach(p -> System.out.println(p.getNome()));
    }
    
    private static void AlunosTurma_2019_1(EntityManager entityManager){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AlunoVO> criteriaQuery = criteriaBuilder.
                createQuery(AlunoVO.class);
        
        Root<Aluno> root = criteriaQuery.from(Aluno.class);
        Predicate turma = criteriaBuilder.like(root.get("turma"),"2019.1");
        criteriaQuery.where(turma).select(criteriaBuilder.construct(
                AlunoVO.class, 
                root.get("nome"), 
                root.get("cpf"),
                root.get("idade"))
        );
        
        TypedQuery<AlunoVO> typedQuery =  entityManager.createQuery(criteriaQuery);
        typedQuery.getResultList().forEach(aVO->System.out.println(aVO.toString()));
    }
    
    private static void professoresTelefoneFinal_8(EntityManager entityManager){
       CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
       CriteriaQuery<Professor> criteriaQuery = criteriaBuilder.
               createQuery(Professor.class);
       
       Root<Professor> root = criteriaQuery.from(Professor.class);
       Join<Professor, Telefone> join = root.join("telefones", JoinType.LEFT);
       
       Predicate numeroFinal = criteriaBuilder.like(join.get("numero"), "%8");
       criteriaQuery.select(root).where(numeroFinal);
       TypedQuery<Professor> typedQuery = entityManager.createQuery(criteriaQuery);
       typedQuery.getResultList().forEach(p->System.out.println(p.getNome()));
    }
    
    private static void livrosAutoresCajazeirasData_01_01_2019__12_12_2019(EntityManager entityManager){
       CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
       CriteriaQuery<Livro> criteriaQuery = criteriaBuilder.
               createQuery(Livro.class);
       
       Root<Livro> root = criteriaQuery.from(Livro.class);
       Join<Livro, Autor> join = root.join("autores",JoinType.LEFT);
       Predicate cidade = criteriaBuilder.like(
               join.get("endereco").get("cidade"), "Cajazeiras"
       );
       Predicate lancamento = criteriaBuilder.between(
               root.get("lancamento"), 
               "2019-01-01", 
               "2019-12-12"
       );
       criteriaQuery.select(root).where(cidade, lancamento).distinct(true);
       TypedQuery<Livro> typedQuery = entityManager.createQuery(criteriaQuery);
       typedQuery.getResultList().forEach(l->System.out.println(l.getTitulo()));
       
    }
    
    private static void livrosAutoresInicia_J(EntityManager entityManager){
       CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
       CriteriaQuery<Livro> criteriaQuery = criteriaBuilder.
               createQuery(Livro.class);
       
       Root<Livro> root = criteriaQuery.from(Livro.class);
       Join<Livro, Autor> join = root.join("autores",JoinType.LEFT);
       Predicate letraInicialNome = criteriaBuilder.like(
               join.get("nome"),
               "J%"
       );
       
       criteriaQuery.select(root).where(letraInicialNome).distinct(true);
       TypedQuery<Livro> typedQuery = entityManager.createQuery(criteriaQuery);
       typedQuery.getResultList().forEach(l->System.out.println(
               "Livro: "+l.getTitulo())
       );
    }
}
