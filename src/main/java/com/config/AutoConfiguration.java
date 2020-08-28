package com.config;

import java.time.LocalDateTime;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.java.Log;

@Component
@Log
public class AutoConfiguration implements MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		 log.info("creatime执行");
		 boolean hasSetter = metaObject.hasSetter("creatime");
		 if(hasSetter) {
			 fillStrategy(metaObject, "creatime", LocalDateTime.now());
		 }
	}
	/***
	 * 逻辑删除updatetime不自动填充
	 */
	@Override
	public void updateFill(MetaObject metaObject) {
		log.info("updatetime执行");
		boolean hasSetter = metaObject.hasSetter("updatetime");
		if(hasSetter) {
			fillStrategy(metaObject, "updatetime", LocalDateTime.now());
		}
	}

}
