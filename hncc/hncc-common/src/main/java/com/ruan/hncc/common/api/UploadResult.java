package com.ruan.hncc.common.api;

/**
 * @创建人：ruanteng
 * @创建时间：2020/11/14 12:06
 */
public class UploadResult implements  java.io.Serializable{
    private boolean success;
    private String message;

    public UploadResult(){

    }

    public UploadResult(boolean success,String message){
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
