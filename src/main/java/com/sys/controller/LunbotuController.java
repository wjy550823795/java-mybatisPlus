package com.sys.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sys.entity.Lunbotu;
import com.sys.service.ILunbotuService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangjunyu.5508
 * @since 2020-04-30
 */
@RestController
@RequestMapping("/sys/lunbotu")
public class LunbotuController {

	@Autowired
	ILunbotuService ilunbotuservice;
	
	@RequestMapping("/add")
    public String add(@RequestBody @Valid Lunbotu lunbotu/*,BindingResult bindingResult*/) {
        // 如果有参数校验失败，会将错误信息封装成对象组装在BindingResult里
//        for (ObjectError error : bindingResult.getAllErrors()) {
//            return error.getDefaultMessage();
//        }
		System.out.println(lunbotu.toString());
        return "succuss";
    }
}
