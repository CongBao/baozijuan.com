package com.baozijuan.timegallery.bean;

import java.io.Serializable;

public class Response implements Serializable {

    public static class Status implements Serializable {

        public static final Status OK = new Status(200, "OK");
        public static final Status BAD_REQUEST = new Status(400, "Bad Request");
        public static final Status UNAUTHORIZED = new Status(401, "Unauthorized");
        public static final Status FORBIDDEN = new Status(403, "Forbidden");
        public static final Status NOT_FOUND = new Status(404, "Not Found");
        public static final Status METHOD_NOT_ALLOWED = new Status(405, "Method Not Allowed");
        public static final Status INTERNAL_SERVER_ERROR = new Status(500, "Internal Server Error");
        public static final Status NOT_IMPLEMENTED = new Status(501, "Not Implemented");

        private int code;
        private String message;

        public Status() {
        }

        public Status(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }

    private Status status;
    private Object data;

    public Response() {
    }

    public Response(Status status) {
        this(status, null);
    }

    public Response(Status status, Object data) {
        this.status = status;
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
