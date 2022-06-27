package jpabasic.ex1hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);

            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
            findParent.getChildList().remove(0);

            tx.commit();
/*
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member1 = new Member();
            member1.setUsername("hello1");
            member1.setTeam(team);
//            Member member2 = new Member();
//            member2.setUsername("hello12");
            em.persist(member1);
            //em.persist(member2);

            em.flush();
            em.clear();

            Member m = em.find(Member.class, member1.getId());
            System.out.println("m = " + m.getTeam().getClass());

            //refMember.getUsername(); //강제 초기화
//            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember)); //프록시 초기화 여부
//            Hibernate.initialize(refMember); //강제 초기화

//            Member m1 = em.find(Member.class, member1.getId());
//            System.out.println("m1 = " + m1.getClass());
//            Member reference = em.getReference(Member.class, member1.getId());
//            System.out.println("reference = " + reference.getClass());
//            Member m2 = em.getReference(Member.class, member2.getId());
//
//            //영속성 컨텍스트에 찾는 엔티티가 이미 있으면 em.getReference()를 호출해도 실제 엔티티 반환
//            System.out.println("m1 == reference : " + (m1 == reference));
//
//            System.out.println("m1==m2 = " + (m1.getClass() == m2.getClass())); //m2는 프록시이기때문에 다름
//            System.out.println("m1==m2 = " + (m1 instanceof Member)); //instanceof를 사용해야함
//            System.out.println("m1==m2 = " + (m2 instanceof Member));

            //Member findMember = em.find(Member.class, member.getId());
//            Member findMember = em.getReference(Member.class, member.getId());
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.username = " + findMember.getUsername());
//            System.out.println("findMember.username = " + findMember.getUsername());

            tx.commit();
*/
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally{
            em.close();
            emf.close();
        }
    }
}
