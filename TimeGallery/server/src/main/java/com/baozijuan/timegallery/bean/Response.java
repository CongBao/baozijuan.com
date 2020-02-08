package com.baozijuan.timegallery.bean;

import java.io.Serializable;

public class Response<T> implements Serializable {

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
    private T data;

    public Response() {
    }

    public Response(Status status, T data) {
        this.status = status;
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Response<T> ok() {
        return Response.ok(null);
    }

    public static <T> Response<T> ok(T object) {
        return new Response<>(Status.OK, object);
    }

    public static <T> Response<T> badRequest() {
        return Response.badRequest(null);
    }

    public static <T> Response<T> badRequest(T data) {
        return new Response<>(Status.BAD_REQUEST, data);
    }

    public static <T> Response<T> unauthorized() {
        return Response.unauthorized(null);
    }

    public static <T> Response<T> unauthorized(T data) {
        return new Response<>(Status.UNAUTHORIZED, data);
    }

    public static <T> Response<T> forbidden() {
        return Response.forbidden(null);
    }

    public static <T> Response<T> forbidden(T data) {
        return new Response<>(Status.FORBIDDEN, data);
    }

    public static <T> Response<T> notFound() {
        return Response.notFound(null);
    }

    public static <T> Response<T> notFound(T data) {
        return new Response<>(Status.NOT_FOUND, data);
    }

    public static <T> Response<T> methodNotAllowed() {
        return Response.methodNotAllowed(null);
    }

    public static <T> Response<T> methodNotAllowed(T data) {
        return new Response<>(Status.METHOD_NOT_ALLOWED, data);
    }

    public static <T> Response<T> internalServerError() {
        return Response.internalServerError(null);
    }

    public static <T> Response<T> internalServerError(T data) {
        return new Response<>(Status.INTERNAL_SERVER_ERROR, data);
    }

    public static <T> Response<T> notImplemented() {
        return Response.notImplemented(null);
    }

    public static <T> Response<T> notImplemented(T data) {
        return new Response<>(Status.NOT_IMPLEMENTED, data);
    }

}
