package com.mycompany;

import com.mycompany.user.User;
import com.mycompany.user.UserRespository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(value = false)
public class UserRespositoryTests {
  @Autowired
  private UserRespository respository;

  @Test
  public void testAddNew () {
    User user = new User();
    user.setEmail("nhinguyenyen23022002@gmail.com");
    user.setPassword("123456");
    user.setFirstName("Yen Nhi");
    user.setLastName("Nguyen");

    User saveUser = respository.save(user);

    Assertions.assertThat(saveUser).isNotNull();
    Assertions.assertThat(saveUser.getId()).isGreaterThan(0);
  }

  @Test
  public void testListAll() {
    Iterable<User> users = respository.findAll();
    Assertions.assertThat(users).hasSizeGreaterThan(0);

    for (User user : users) {
      System.out.println(user);
    }
  }
}
