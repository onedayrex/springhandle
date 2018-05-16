package com.onedayrex.git.springhandle.exception;

import com.onedayrex.git.springhandle.constant.ConstantCode;
import com.onedayrex.git.springhandle.dto.RespCode;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class ClobalExceptionHandle {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        StringBuilder stringBuilder = new StringBuilder();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            stringBuilder.append(fieldError.getDefaultMessage());
            stringBuilder.append("\n");
        }
        RespCode respCode = new RespCode();
        respCode.setRespCode(ConstantCode.ERROR_CODE);
        respCode.setErrorMsg(stringBuilder.toString());
        return respCode;
    }
}
