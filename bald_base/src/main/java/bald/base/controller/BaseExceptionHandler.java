package bald.base.controller;


import entities.Result;
import entities.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 13548943514.
 * @date 2019/11/11.
 * @time 19:29.
 */
@ControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exception(Exception e){
        e.printStackTrace();
        return new Result(false,StatusCode.ERROR,e.getMessage(),null);
    }
}
