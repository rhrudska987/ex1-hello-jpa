package jpabasic.ex1hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);



            tx.commit();

            /*Address address = new Address("city", "street", "zipcode");
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setHomeAddress(address);
//            em.persist(member);
//
            Address address1 = new Address("newCity", address.getStreet(), address.getZipcode());
            Address address2 = new Address("newCity2", address.getStreet(), address.getZipcode());
//            member.setHomeAddress(address1);

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(address);

            member.getFavoriteFoods().add("chicken");
            member.getFavoriteFoods().add("pizza");
            member.getFavoriteFoods().add("meat");

            member.getAddressHistory().add(new AddressEntity(address1));
            member.getAddressHistory().add(new AddressEntity(address2));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("====================================");
            Member findMember = em.find(Member.class, member.getId());

            //city->oldcity setHomeAddress().setCity("newCity")이런식으로 하면 안됨. 다 갈아엎어야함
            findMember.setHomeAddress(new Address("oldCity", address.getStreet(), address.getZipcode()));
            findMember.getFavoriteFoods().remove("chicken");
            findMember.getFavoriteFoods().add("rice");

            //equals를 override해야함
            findMember.getAddressHistory().remove(new AddressEntity("newCity", address.getStreet(), address.getZipcode()));
            findMember.getAddressHistory().add(new AddressEntity("jeju", "wallstreet", "22222"));

            tx.commit();*/
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally{
            em.close();
            emf.close();
        }
    }
}
