package com.sys.service;

import com.sys.entity.Department;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangjunyu.5508
 * @since 2020-04-14
 */
public interface IDepartmentService extends IService<Department> {
	
		List<Department> selectbySp1(String department);
}
