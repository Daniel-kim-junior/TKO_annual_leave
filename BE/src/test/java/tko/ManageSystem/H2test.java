package tko.ManageSystem;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import tko.ManageSystem.dto.UserDTO;
import tko.ManageSystem.repository.UserMapper;



@MybatisTest
@Profile("test")
public class H2test {

    @Autowired
    private UserMapper userMapper;
    @Test
    @Sql({"classpath:/db/schema.sql"})
    @Sql({"classpath:/db/data.sql"})
    public void findAll() throws Exception {
        List<UserDTO> all = userMapper.findAll();

        Assertions.assertThat(all.size()).isEqualTo(1);
    }
}
