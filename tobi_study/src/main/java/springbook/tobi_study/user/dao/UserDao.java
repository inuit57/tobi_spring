package springbook.tobi_study.user.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import springbook.tobi_study.user.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class UserDao {

    @PersistenceContext
    private final EntityManager em;

    public void addUser(User user){
        em.persist(user);
    }

    public User findById(Long userId){
        return em.find(User.class, userId);
    }
}
