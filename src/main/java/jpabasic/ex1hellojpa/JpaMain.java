package jpabasic.ex1hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            /*Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");*/
            /*List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();
            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }*/

            Member member = new Member();
            //member.setId("ID_A");
            member.setUsername("C");

            System.out.println("==================");
            em.persist(member); //Identity전략에서는 em.persist한 순간에 commit이 됨
            System.out.println("member.id = " + member.getId());
            System.out.println("==================");

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally{
            em.close();
            emf.close();
        }

    }
}
