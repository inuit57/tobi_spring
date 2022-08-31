package springbook.tobi_study.user.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import springbook.tobi_study.user.domain.User;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserDaoTest {

    @Autowired
    UserDao userDao;


    @Test
    void userAddSearch(){

        User user = new User();
        user.setId("test01");
        user.setName("ttt");

        userDao.addUser(user);
        Long userId = user.getUserId();

        Assertions.assertThat(userDao.findById(userId)).isEqualTo(user);
    }

}