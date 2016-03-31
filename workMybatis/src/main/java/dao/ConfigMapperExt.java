package dao;

import java.util.HashMap;

import model.Config;

import org.apache.ibatis.annotations.Select;

public interface ConfigMapperExt extends ConfigMapper {
	@Select("select * from config where config_id = #{configId}")
	Config selectByPrimaryKeyAnnotation(Integer configId);

	@Select("select * from config where config_id = #{configId}")
	HashMap<String,Object> selectByPrimaryKeyAnnotationMap(Integer configId);
	// 以上j2seTest第一個測試使用
	
	//新增一個可以取回insertKey的method
	int insertGetKey(Config config);
	
	
	
	

}