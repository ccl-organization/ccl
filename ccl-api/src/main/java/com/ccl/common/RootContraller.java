package com.ccl.common;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2018/6/24
 * To change this template use File | Settings | File Templates.
 **/
public class RootContraller {
    private static Object respond(ErrorCCL error, Object data, String message){
        Map<String, Object> result = prepare(error, data, message);
        return new ResponseEntity<Object>(result, new HttpHeaders(), HttpStatus.OK);
    }

    private static Map<String, Object> prepare(ErrorCCL error, Object data, String message){

        Map<String, Object> result = new HashMap<String, Object>();

        result.put("state", error.getValue());

        if(data != null){
            result.put("data", data);
        }

        result.put("message", message == null ? error.getMessage() : message);
        return result;
    }

    public Object respondDone(Object data){
        return respond(ErrorCCL.ERROR_STATE_OK, data, null);
    }

    public Object respondFailed(ErrorCCL error, String reason){
        return respond(error, null, reason);
    }




}
