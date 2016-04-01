package dao;

import java.util.List;
import model.CustomerDemographic;
import model.CustomerDemographicExample;
import org.apache.ibatis.annotations.Param;

public interface CustomerDemographicMapper {
    int countByExample(CustomerDemographicExample example);

    int deleteByExample(CustomerDemographicExample example);

    int deleteByPrimaryKey(String customertypeid);

    int insert(CustomerDemographic record);

    int insertSelective(CustomerDemographic record);

    List<CustomerDemographic> selectByExample(CustomerDemographicExample example);

    CustomerDemographic selectByPrimaryKey(String customertypeid);

    int updateByExampleSelective(@Param("record") CustomerDemographic record, @Param("example") CustomerDemographicExample example);

    int updateByExample(@Param("record") CustomerDemographic record, @Param("example") CustomerDemographicExample example);

    int updateByPrimaryKeySelective(CustomerDemographic record);

    int updateByPrimaryKey(CustomerDemographic record);
}