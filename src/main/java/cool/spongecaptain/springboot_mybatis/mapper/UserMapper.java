package cool.spongecaptain.springboot_mybatis.mapper;

import cool.spongecaptain.springboot_mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;

//@Mapper 这个注解必须加，否则会抛出  UserMapper' that could not be found. 的异常
@Mapper
public interface UserMapper {
    User getOne(int id);
}
