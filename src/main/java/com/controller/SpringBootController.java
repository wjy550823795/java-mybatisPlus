package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sys.entity.Department;
import com.sys.entity.Smwy;
import com.sys.service.IDepartmentService;
import com.utils.RedisUtils;

@RestController
//@Log4j2
public class SpringBootController {
    
    
    @Autowired
    IDepartmentService idepartmentservice;
    
    @Autowired
    private RedisUtils redisUtils;
    
    @Autowired
    private RedisTemplate redisTemplate;
    
    @RequestMapping(value = "/caonima")
    public Object caonima(String department){
        //查询缓存中是否存在
        boolean hasKey = redisUtils.exists(department);
        List<Department> list = new ArrayList<Department>();
        if(hasKey){
            //获取缓存
            Object object =  redisUtils.get(department);
            System.out.println("从缓存获取的数据"+ object);
//            return object;
        }else{
            //从数据库中获取信息
        	System.out.println("从数据库中获取数据");
            list = idepartmentservice.selectbySp1(department);
            
            //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
            redisUtils.set(department, list,10L,TimeUnit.SECONDS);
            System.out.println("数据插入缓存" + list);
        }
        return list;
    }
   
}

