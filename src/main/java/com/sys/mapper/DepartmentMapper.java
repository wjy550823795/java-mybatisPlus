package com.sys.mapper;

import com.sys.entity.Department;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangjunyu.5508
 * @since 2020-04-14
 */
public interface DepartmentMapper extends BaseMapper<Department> {

	List<Department> selectbySp1(String department);

}
