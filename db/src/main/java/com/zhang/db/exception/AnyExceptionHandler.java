package com.zhang.db.exception;


import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.zhang.db.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.time.format.DateTimeParseException;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class AnyExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseResult handlerGlobalException(Exception exception) {
        exception.printStackTrace();
        return ResponseResult.fail(-1, "未知异常");
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseResult handlerMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception) {


        return ResponseResult.fail(-6, "参数" + exception.getName() + "格式错误");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        return ResponseResult.fail(-6, "参数" + exception.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }


    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseResult handlerMaxUploadSizeExceededException(MaxUploadSizeExceededException exception) {

        return ResponseResult.fail(-6, "图片最大不能超过" + 50);
    }


    @ExceptionHandler(DateTimeParseException.class)
    public ResponseResult handlerDateTimeParseException(DateTimeParseException exception) {
        return ResponseResult.fail(-6, "日期格式错误");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseResult handlerIllegalArgumentException(IllegalArgumentException exception) {
        exception.printStackTrace();
        return ResponseResult.fail(-6, "日期格式错误");
    }

    @ExceptionHandler(BindException.class)
    public ResponseResult handlerBindException(BindException exception) {
        String msg = exception.getMessage();
        System.out.println("msg:" + msg);
        List<ObjectError> allErrors = exception.getAllErrors();
        BindingResult bindingResult = exception.getBindingResult();


        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String field = fieldError.getField();
            return ResponseResult.fail(-1, field + "参数异常");
        }
        return ResponseResult.fail(-1, "未知异常");
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseResult handlerInvalidFormatException(InvalidFormatException exception) {
        exception.printStackTrace();
        return ResponseResult.fail(-6, "日期格式错误");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseResult handlerHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        exception.printStackTrace();

        HttpInputMessage httpInputMessage = exception.getHttpInputMessage();
        String message = exception.getMessage();
        Throwable cause = exception.getCause();
        if (cause instanceof InvalidFormatException) {
            InvalidFormatException formatException = (InvalidFormatException) cause;
            System.out.println(formatException.getValue());
            System.out.println(formatException.getMessage());
            System.out.println(formatException.getOriginalMessage());
            List<JsonMappingException.Reference> path = formatException.getPath();
            for (JsonMappingException.Reference reference : path) {
                String fieldName = reference.getFieldName();
                System.out.println(reference.getDescription());
                System.out.println(reference.getFrom());
                System.out.println(reference.getIndex());
                return ResponseResult.fail(-6, fieldName + "参数格式错误");
            }

        }
        String localizedMessage = exception.getLocalizedMessage();
        Throwable rootCause = exception.getRootCause();

        return ResponseResult.fail(-6, "日期格式错误");
    }
}
