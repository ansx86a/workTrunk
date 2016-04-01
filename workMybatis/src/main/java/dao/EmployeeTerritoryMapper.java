package dao;

import java.util.List;
import model.EmployeeTerritoryExample;
import model.EmployeeTerritoryKey;
import org.apache.ibatis.annotations.Param;

public interface EmployeeTerritoryMapper {
    int countByExample(EmployeeTerritoryExample example);

    int deleteByExample(EmployeeTerritoryExample example);

    int deleteByPrimaryKey(EmployeeTerritoryKey key);

    int insert(EmployeeTerritoryKey record);

    int insertSelective(EmployeeTerritoryKey record);

    List<EmployeeTerritoryKey> selectByExample(EmployeeTerritoryExample example);

    int updateByExampleSelective(@Param("record") EmployeeTerritoryKey record, @Param("example") EmployeeTerritoryExample example);

    int updateByExample(@Param("record") EmployeeTerritoryKey record, @Param("example") EmployeeTerritoryExample example);
}