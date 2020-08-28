package com.sys.service.impl;

import com.sys.entity.Userinfo;
import com.sys.mapper.UserinfoMapper;
import com.sys.service.IUserinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

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
@Service("woshinidie")
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements IUserinfoService {

	@Autowired
	UserinfoMapper UserinfoMapper;
	
	@Override
	public List<Userinfo> selectbyEmplyee(String emplyee) {
		return UserinfoMapper.selectbyEmplyee(emplyee);
	}

}
