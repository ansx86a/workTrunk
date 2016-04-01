package dao;

import java.util.List;
import model.Shipper;
import model.ShipperExample;
import org.apache.ibatis.annotations.Param;

public interface ShipperMapper {
    int countByExample(ShipperExample example);

    int deleteByExample(ShipperExample example);

    int deleteByPrimaryKey(Integer shipperid);

    int insert(Shipper record);

    int insertSelective(Shipper record);

    List<Shipper> selectByExample(ShipperExample example);

    Shipper selectByPrimaryKey(Integer shipperid);

    int updateByExampleSelective(@Param("record") Shipper record, @Param("example") ShipperExample example);

    int updateByExample(@Param("record") Shipper record, @Param("example") ShipperExample example);

    int updateByPrimaryKeySelective(Shipper record);

    int updateByPrimaryKey(Shipper record);
}