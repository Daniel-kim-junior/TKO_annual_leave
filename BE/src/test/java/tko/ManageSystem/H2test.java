package tko.ManageSystem;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import tko.ManageSystem.dto.UserDTO;
import tko.ManageSystem.repository.UserMapper;


/**
 * Daniel kim
 * H2test : test 예제 구현
 * 2023-04-13
 * @Sql 어노테이션을 이용해 in-memory db에 sql 실행 후 테스트 가능
 */

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
        assertThat(all.size()).isEqualTo(1);
    }
}
