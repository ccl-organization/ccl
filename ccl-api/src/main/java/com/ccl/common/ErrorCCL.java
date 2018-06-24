package com.ccl.common;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2018/6/24
 * To change this template use File | Settings | File Templates.
 **/


    public enum ErrorCCL {
        ERROR_STATE_OK(0),
        ERROR_PARAMS_ERROR(100),
        ERROR_INNER_ERROR(101),
        ERROR_EXCEOTION_ERROR(102);


        private final int value;
        ErrorCCL(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }

        public String getMessage(){
            switch (this) {
                case ERROR_STATE_OK:
                    return "正常";
                case ERROR_PARAMS_ERROR:
                    return "参数错误";
                case ERROR_INNER_ERROR:
                    return "内部错误";
                case ERROR_EXCEOTION_ERROR:
                    return "处理异常";
            }
            return null;
        }


        }
