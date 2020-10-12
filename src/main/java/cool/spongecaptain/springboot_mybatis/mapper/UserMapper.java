package cool.spongecaptain.springboot_mybatis.mapper;

import cool.spongecaptain.springboot_mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 补充说明：
 * @Select 是查询类的注解，所有的查询均使用这个
 * @Result 修饰返回的结果集，关联实体类属性和数据库字段一一对应，如果实体类属性和数据库属性名保持一致，就不需要这个属性来修饰。
 * @Insert 插入数据库使用，直接传入实体类会自动解析属性到对应的值
 * @Update 负责修改，也可以直接传入对象
 * @delete 负责删除
 */
//@Mapper 这个注解必须加，否则会抛出  UserMapper' that could not be found. 的异常
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE id = #{id} LIMIT 1")
    //这里虽然类名刚好等于 Model 的字段名，但是为了完整性，还是使用此注解
    @Results({
            @Result(property = "id",column = "id",javaType = Integer.class),
            @Result(property = "name",column = "name",javaType = String.class),
            @Result(property = "age",column = "age",javaType = Integer.class)
    })
    User getOne(int id);

    //xml-temp
}
