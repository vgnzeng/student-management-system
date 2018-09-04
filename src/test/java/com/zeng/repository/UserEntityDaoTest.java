package com.zeng.repository;

/**
 * Created by Guan on 9/2/2018.
 */

import com.zeng.entity.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEntityDaoTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() throws Exception {
        UserEntity user = new UserEntity();
        user.setId("1");
        user.setUserName("Guan");
        user.setPassword("hi5566");
        user.setEmail("vgnzeng@gmail.com");
        user.setUserType("manage");
        userRepository.save(user);
        //Assert.assertEquals("manage", userRepository.findByUserName("Guan").getUserType());
        //Assert.assertEquals(1, userRepository.count());

    }

}

