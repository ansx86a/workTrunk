package dao;

import java.util.List;
import model.Territory;
import model.TerritoryExample;
import org.apache.ibatis.annotations.Param;

public interface TerritoryMapper {
    int countByExample(TerritoryExample example);

    int deleteByExample(TerritoryExample example);

    int deleteByPrimaryKey(String territoryid);

    int insert(Territory record);

    int insertSelective(Territory record);

    List<Territory> selectByExample(TerritoryExample example);

    Territory selectByPrimaryKey(String territoryid);

    int updateByExampleSelective(@Param("record") Territory record, @Param("example") TerritoryExample example);

    int updateByExample(@Param("record") Territory record, @Param("example") TerritoryExample example);

    int updateByPrimaryKeySelective(Territory record);

    int updateByPrimaryKey(Territory record);
}