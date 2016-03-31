package controller;

import model.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ConfigMapperExt;

@Service
public class 第一個Service {
	@Autowired
	private ConfigMapperExt configMapperExt;

	public void 最簡單的select() {
		System.out.println(configMapperExt);
		System.out.println(configMapperExt.selectByPrimaryKey(1));
		//測一下insert有無回傳pk
		Config config = new Config();
		config.setName("keyName");
		config.setType("keyType");
		config.setValue("keyValue");
		config.setDescription("keyDesc");
		int pk = configMapperExt.insert(config);
		System.out.println(config.getConfigId());
	}
}
