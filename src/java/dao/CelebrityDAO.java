package dao;

import domain.Celebrity;
import static domain.Celebrity_.id;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CelebrityDAO {

    @PersistenceContext
    private EntityManager em;

    public void addCeleb(Celebrity myCeleb) {
        em.persist(myCeleb);
    }

    public Celebrity findCelebrity(int id) {
        return em.find(Celebrity.class, id);
    }

    public List<Celebrity> findAllCelebrity() {
        return em.createQuery("SELECT c FROM Celebrity as c").getResultList();
    }

    public void removeCelebrity(Celebrity celeb) {
        em.remove(em.find(Celebrity.class, id));
    }

    public void removeCelebrityById(int id) {
        em.remove(em.merge(em.find(Celebrity.class, id)));
    }
    
    public void edit(Celebrity celeb) {
        em.merge(celeb);
    }
   
    
    
//    public void addVotes(int id){
//       int totalVotes = em.find(Celebrity.class, id).getVotes();
//       Query query =  em.createQuery("UPDATE Tag c set c.votes = c.votes + 1 WHERE c.id = :id");
//        query.setParameter("id", id);       
//    }
    
    
    
//    public Student findStudentByName(String firstName) {
//        Query query = em.createQuery("SELECT s FROM Student s WHERE s.firstName=:firstName");
//        query.setParameter("firstName", firstName);
//        return (Student) query.getSingleResult();
//    }
    
    

}
