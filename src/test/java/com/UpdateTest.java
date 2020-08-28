package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.sys.entity.Lunbotu;
import com.sys.entity.Userinfo;
import com.sys.mapper.LunbotuMapper;
import com.sys.mapper.UserinfoMapper;

@SpringBootTest
class UpdateTest {
	
	@Autowired
	UserinfoMapper UserinfoMapper;
	
	@Autowired
	LunbotuMapper LunbotuMapper;
	
	@Test
	void insert(){
		Lunbotu l = new Lunbotu();
		l.setChangedby("sa'dlkas;odkopasld");
		l.setState(2);
		int insert = LunbotuMapper.insert(l);
		int a = 10/0;
		System.out.println(insert);
	}
	
	@Test
	void updateById(){
		
		Userinfo user = new Userinfo();
			user.setId(10474);
			user.setDiqu("火车站");
		int update = UserinfoMapper.updateById(user);
		System.out.println(update);
	}
	
	@Test
	void updateByWrapper(){
		UpdateWrapper<Userinfo> wrapper = new UpdateWrapper<Userinfo>();

		/***
		 *方法一
		 */
		wrapper.eq("name", "王君钰");//条件
		Userinfo user = new Userinfo();
			user.setDiqu("电影院");
		int update = UserinfoMapper.update(user, wrapper);
		/***
		 * 方法二 适用修改少数字段时
		 */
//		wrapper.eq("name", "王君钰").set("diqu", "电影院2");
//		int update = UserinfoMapper.update(null, wrapper);
//		
//		System.out.println(update);
	}
	
	@Test
	void lambdaUpdate(){
		LambdaUpdateWrapper<Userinfo> lambdaUpdate = Wrappers.lambdaUpdate();
		lambdaUpdate.eq(Userinfo::getName,"王君钰").set(Userinfo::getDiqu,"电影院3");
		int update = UserinfoMapper.update(null, lambdaUpdate);
		System.out.println(update);
	}
	
	@Test
	void lambdaUpdateByChain(){
		boolean update = new LambdaUpdateChainWrapper<Userinfo>(UserinfoMapper).
				eq(Userinfo::getName,"王君钰").set(Userinfo::getDiqu,"电影院3").update();
		System.out.println(update);
	}
}
