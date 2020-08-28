package com;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sys.entity.Department;
import com.sys.entity.Lunbotu;
import com.sys.entity.Userinfo;
import com.sys.mapper.DepartmentMapper;
import com.sys.mapper.LunbotuMapper;
import com.sys.mapper.UserinfoMapper;

@SpringBootTest
class MybatisPlusApplicationTests {

	
	@Autowired
	DepartmentMapper DepartmentMapper;
	
	@Autowired
	UserinfoMapper UserinfoMapper;
	
	@Autowired
	LunbotuMapper LunbotuMapper;
	
	//主键查询
	@Test
	public void selectId() {
//		int id = 98440;
//		 DepartmentMapper.selectById(id);
		Lunbotu id = LunbotuMapper.selectById(1);
		System.out.println(id);
		
	}
	//多条件查询
	@Test
	void selectMap() {
		Map<String,Object> map = new HashMap<String, Object>();
			map.put("leaderemployeeid", "17d1c4e5");//李让
			map.put("sp1", "od-fc4d1c13f957e32424794fb2d94880a5");//数据服务
		List<Department> list = DepartmentMapper.selectByMap(map);
		System.out.println(list.toString());
		
	}
	
	//模糊查询
	@Test
	void queryWrapper1() {
		
	    QueryWrapper<Department> queryWrapper = new QueryWrapper<Department>();
	    
//	    	queryWrapper.select("id,sp1,sp2").like("framework", "数据服务").orderByAsc("id");//排序
	    	
	    	queryWrapper.select(Department.class, df->!df.getColumn().equals("sp1")&&!df.getColumn().equals("sp2")).like("framework", "数据服务").orderByAsc("id");//排序
		List<Department> list = DepartmentMapper.selectList(queryWrapper);
		System.out.println(list.toString());
		
	}
	
	//时间段查询 null判断
	@Test
	void queryWrapper2() {
		QueryWrapper<Userinfo> queryWrapper = new QueryWrapper<Userinfo>();
			queryWrapper.between("updatetime", "2019-12-27", "2019-12-28").isNull("zhiji");
		UserinfoMapper.selectList(queryWrapper);
	}
	
	//实体构造方法
	@Test
	void queryWrapper3() {
		Userinfo user = new Userinfo();
			user.setLabelid(8);
			user.setZhiji("G4");
		QueryWrapper<Userinfo> queryWrapper = new QueryWrapper<Userinfo>(user);
		UserinfoMapper.selectList(queryWrapper);
	}
	
	//lambda表达式用法
	/**
	 * 好处在于列名不会写错 name-->mame
	 */
	@Test
	void lambda1() {
//		LambdaQueryWrapper<Userinfo> lambda1 = new QueryWrapper<Userinfo>().lambda();
//		LambdaQueryWrapper<Userinfo> lambda2 = new LambdaQueryWrapper<Userinfo>();
		LambdaQueryWrapper<Userinfo> queryWrapper = Wrappers.<Userinfo> lambdaQuery();
		queryWrapper.like(Userinfo::getZhiji, "G4").eq(Userinfo::getLabelid, 8);
		List<Userinfo> selectList = UserinfoMapper.selectList(queryWrapper);
		selectList.forEach(System.out::println);
	}
	
	@Test
	void lambda2() {
		List<Userinfo> selectList = new LambdaQueryChainWrapper<Userinfo>(UserinfoMapper).
				like(Userinfo::getName, "王").eq(Userinfo::getLabelid, 8).list();
		selectList.forEach(System.out::println);
	}
	
	//自定义sql
	@Test
	void customMy1() {
		LambdaQueryWrapper<Userinfo> queryWrapper = Wrappers.<Userinfo> lambdaQuery();
			queryWrapper.like(Userinfo::getName, "王").eq(Userinfo::getLabelid, 8);
		List<Userinfo> selectList = UserinfoMapper.selectbyExample(queryWrapper);
		selectList.forEach(System.out::println);
	}
	
	//物理分页 速度快
	@Test
	void pageHelper1() {
		LambdaQueryWrapper<Userinfo> queryWrapper = Wrappers.<Userinfo> lambdaQuery();
		queryWrapper.like(Userinfo::getName, "王");
		Page<Userinfo> page = new Page<Userinfo>(1, 15);
		
//		Page<Userinfo> page = new Page<Userinfo>(2, 15,false); //洞听实例
		
		IPage<Userinfo> page2 = UserinfoMapper.selectPage(page, queryWrapper);
		System.out.println("总页数:"+page2.getPages());
		System.out.println("总记录数:"+page2.getTotal());
		
		List<Userinfo> selectList = page2.getRecords();
		selectList.forEach(System.out::println);
		
	}
	
	//连表分页分页 速度快
	@Test
	void pageHelper2() {
		
		QueryWrapper<Userinfo> qw = Wrappers.<Userinfo>query();
		
			qw.like("a.name","王").eq("b.labelname", "业务骨干");
		
		Page<Map<String, Object>> page = new Page<Map<String, Object>>(2, 15);
		
//			Page<Userinfo> page = new Page<Userinfo>(2, 15,false); //洞听实例
		
		IPage<Map<String, Object>> iPage = UserinfoMapper.selectLeftjoin(page, qw);
		System.out.println("总页数:"+iPage.getPages());
		System.out.println("总记录数:"+iPage.getTotal());
		
		List<Map<String, Object>> selectList = iPage.getRecords();
		selectList.forEach(System.out::println);
			
		}
}
