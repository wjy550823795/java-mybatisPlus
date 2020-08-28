package com.sys.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sys.entity.Userinfo;
import com.sys.service.IUserinfoService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangjunyu.5508
 * @since 2020-04-14
 */
@RestController
@RequestMapping("/sys/userinfo")
public class UserinfoController {
	
	@Resource
	IUserinfoService iuserinfoservice;
	
	@RequestMapping("/wuwu")
	public List<Userinfo> wuwu() {
		return	iuserinfoservice.selectbyEmplyee("893c52d7");
	}
	
}
