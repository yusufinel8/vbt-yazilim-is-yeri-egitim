package com.springexercise.springexercise.dto;

import com.springexercise.springexercise.enumm.ResponseEnum;

public class AbstractResponsePayload {

    ResponsePayload responsePayload = new ResponsePayload();

    public AbstractResponsePayload() {
    }

    public ResponsePayload setResponse(ResponsePayload response) {
        return response;
    }

    public void setMessage(String message) {

        responsePayload.setMessage(message);
    }

    public void setSuccess(Boolean success) {
        responsePayload.setSuccess(success);
    }

    public void setResponseEnum(ResponseEnum responseEnum) {
        responsePayload.setResponseEnum(responseEnum);
    }

    public void setResponseEnum(ResponseEnum responseEnum, String message) {
        responsePayload.setResponseEnum(responseEnum, message);
    }

    public void setData(Object data) {
        responsePayload.setData(data);
    }

    public ResponsePayload getResponse() {
        setDefaultResponse();
        return responsePayload;
    }

    public ResponsePayload getResponse(ResponseEnum responseEnum, String errorMessage) {
        responsePayload.setResponseEnum(responseEnum, errorMessage);
        ResponsePayload res = responsePayload;
        responsePayload = new ResponsePayload();
        return res;
    }
    public ResponsePayload getResponseNullData(ResponseEnum responseEnum, String errorMessage) {
        responsePayload.setData(null);
        responsePayload.setResponseEnum(responseEnum, errorMessage);
        ResponsePayload res = responsePayload;
        responsePayload = new ResponsePayload();
        return res;
    }

    public ResponsePayload getResponse(Object data) {
        setData(data);
        setDefaultResponse();
        ResponsePayload res = responsePayload;
        responsePayload = new ResponsePayload();
        return res;
    }

    private void setDefaultResponse() {
        if (responsePayload.getMessage() == null) {
            setMessage("SUCCESS");
        }
        if (responsePayload.getSuccess() == null) {
            setSuccess(true);
        }
        if (responsePayload.getResponseEnum() == null) {
            setResponseEnum(ResponseEnum.OK);
        }
    }
}
