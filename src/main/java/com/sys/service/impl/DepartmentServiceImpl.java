package com.sys.service.impl;

import com.sys.entity.Department;
import com.sys.mapper.DepartmentMapper;
import com.sys.service.IDepartmentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangjunyu.5508
 * @since 2020-04-14
 */
@Service
public  class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {
	
	
	@Autowired
	DepartmentMapper DepartmentMapper;
	
	@Override
	public List<Department> selectbySp1(String department) {
		
		//insert() 可以直接加
//		DepartmentMapper.selectById(id);  //主键查询+
//		DepartmentMapper.selectBatchIds(idList);//主键批量查询 
		
//		Map<String,Object> map = new HashMap();
//			map.put("leaderemployeeid", "17d1c4e5");//李让
//			map.put("sp1", "od-fc4d1c13f957e32424794fb2d94880a5");//数据服务
//			DepartmentMapper.selectByMap(map);
		
		//模糊查询
	    QueryWrapper<Department> queryWrapper = new QueryWrapper<Department>();
	    	queryWrapper.like("framework", "数据服务").orderByAsc("id");//排序
		return DepartmentMapper.selectList(queryWrapper);
		
//		return DepartmentMapper.selectbySp1(department);
	}

}
