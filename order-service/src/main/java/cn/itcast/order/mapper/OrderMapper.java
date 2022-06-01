package cn.itcast.order.mapper;

import cn.itcast.order.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderMapper {
    /*
     *根据用户id查询用户
     * @author RenBoQing
     * @date 2022/6/1 0001
     * @param id
     * @return cn.itcast.order.pojo.Order
     */
    @Select("select * from tb_order where id = #{id}")
    Order findById(Long id);
}
