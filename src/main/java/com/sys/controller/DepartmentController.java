package com.sys.controller;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sys.entity.Userinfo;
import com.sys.service.IDepartmentService;
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
@RequestMapping("/sys/department")
public class DepartmentController {
	
	@Resource
	IDepartmentService IDepartmentService;
	
	@Resource
	IUserinfoService IUserinfoService;
		
	@RequestMapping(value="select")
	public Object select(String department) {
//		return IDepartmentService.selectbySp1(department);
		
		Map<String, Object> Map = new HashMap<String,Object>();
			Map.put("sp1", department);
		return IDepartmentService.listByMap(Map);
		
		
			
	}	
	
	@RequestMapping(value="haha")
	public Object haha(String emplyee) {
		
//		return IUserinfoService.selectbyEmplyee(emplyee);
		
		QueryWrapper<Userinfo> queryWrapper = new QueryWrapper<Userinfo>();
//		
//			queryWrapper.ne("sp3", "2020-03-17").likeRight("name","王");
//		return IUserinfoService.list(queryWrapper);
		queryWrapper.nested(wq->wq.eq("department_id", "od-0e51577660d3c249ee2ca7eee10d49d1").or().eq("labelid", "8"))
								.eq("zhiji", "G3");
		return IUserinfoService.listMaps(queryWrapper);
	}	
}
