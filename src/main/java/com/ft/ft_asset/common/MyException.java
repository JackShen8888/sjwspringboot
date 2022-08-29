package com.ft.ft_asset.common;

import lombok.Data;

//2.创建MyException类，并继承RuntimeException类，并编写一些构造方法
@Data
public class MyException extends RuntimeException {

    private static final long serialVersionUID =1L;

    private String msg;

    private String code ="500";

    public MyException(String msg) {

        super(msg);

        this.msg = msg;

    }

    public MyException(String msg, Throwable e) {

        super(msg, e);

        this.msg = msg;

    }

    public MyException(String msg, String code) {

        super(msg);

        this.msg = msg;

        this.code = code;

    }

    public MyException(String msg, String code, Throwable e) {

        super(msg, e);

        this.msg = msg;

        this.code = code;

    }

}
