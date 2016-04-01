package dao;

import java.util.List;
import model.CustomerCustomerDemoExample;
import model.CustomerCustomerDemoKey;
import org.apache.ibatis.annotations.Param;

public interface CustomerCustomerDemoMapper {
    int countByExample(CustomerCustomerDemoExample example);

    int deleteByExample(CustomerCustomerDemoExample example);

    int deleteByPrimaryKey(CustomerCustomerDemoKey key);

    int insert(CustomerCustomerDemoKey record);

    int insertSelective(CustomerCustomerDemoKey record);

    List<CustomerCustomerDemoKey> selectByExample(CustomerCustomerDemoExample example);

    int updateByExampleSelective(@Param("record") CustomerCustomerDemoKey record, @Param("example") CustomerCustomerDemoExample example);

    int updateByExample(@Param("record") CustomerCustomerDemoKey record, @Param("example") CustomerCustomerDemoExample example);
}