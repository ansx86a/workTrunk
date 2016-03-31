package controller;

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
	}

}
