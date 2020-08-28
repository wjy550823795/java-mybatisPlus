package com.sys.haha;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public String MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
//        // 从异常对象中拿到ObjectError对象
//        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
//        // 然后提取错误提示信息进行返回
//        return objectError.getDefaultMessage();
//    }
//    
//}

	@ExceptionHandler(APIException.class)
	public ResultVO<String> APIExceptionHandler(APIException e) {
	    // 注意哦，这里传递的响应码枚举
	    return new ResultVO<>(ResultCode.FAILED, e.getMsg());
	}


	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResultVO<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
	    ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
	    // 注意哦，这里传递的响应码枚举
	    return new ResultVO<>(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage());
	}

}

