package com.onedayrex.git.springhandle.common.exception;

import com.onedayrex.git.springhandle.common.constant.ConstantCode;
import com.onedayrex.git.springhandle.common.dto.RespCode;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
