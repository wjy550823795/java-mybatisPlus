package com.sys.mapper;

import com.sys.entity.Userinfo;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangjunyu.5508
 * @since 2020-04-14
 */
public interface UserinfoMapper extends BaseMapper<Userinfo> {
	
	List<Userinfo> selectbyEmplyee(String emplyee);
	
//	@Select("select * from userinfo ${ew.customSqlSegment}")
	List<Userinfo> selectbyExample(@Param(Constants.WRAPPER) Wrapper<Userinfo> wrapper);
	
	IPage<Map<String, Object>> selectLeftjoin(Page<Map<String, Object>> page, 
			@Param(Constants.WRAPPER) Wrapper<Userinfo> wrapper);
}
