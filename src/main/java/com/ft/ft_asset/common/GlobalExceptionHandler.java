package com.ft.ft_asset.common;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;


/**
 * @author shenjiawei
 * 统一异常处理类
 * @date 2018-11-23
 */
@Slf4j
@RestControllerAdvice
@SuppressWarnings("unchecked")
public class GlobalExceptionHandler {

        private Logger logger = LoggerFactory.getLogger(getClass());
//会一个异常一个异常匹配，直到报错
        /**
         * 处理自定义异常
         */

        @ExceptionHandler(MyException.class)
        public Response handleMyException(MyException e){
            return Response.buildResponse(e.getCode(),e.getMessage());
        }

        @ExceptionHandler(NoHandlerFoundException.class)
        public Response handlerNoFoundException(Exception e) {
            logger.error(e.getMessage(), e);
            return Response.buildResponse("404", "路径不存在，请检查路径是否正确");
        }

        @ExceptionHandler(DuplicateKeyException.class)
        public Response handleDuplicateKeyException(DuplicateKeyException e){
            logger.error(e.getMessage(), e);
            return Response.buildFailedResponse("数据库中已存在该记录");
        }


//        @ExceptionHandler(AuthorizationException.class)
//
//        public Response handleAuthorizationException(AuthorizationException e){
//
//            logger.error(e.getMessage(), e);
//
//            return Response.error("没有权限，请联系管理员授权");
//
//        }

        @ExceptionHandler(Exception.class)
        public Response handleException(Exception e){
            logger.error(e.getMessage(), e);
            return Response.buildFailedResponse();
        }
}
