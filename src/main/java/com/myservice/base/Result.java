package com.myservice.base;

import java.io.Serializable;

public class Result implements Serializable {

    private static final long serialVersionUID = 2907211119535752349L;

//    @ApiModelProperty("是否成功")
    private boolean success;

//    @ApiModelProperty("错误码,0、正确，非0、错误")
    private String code;

//    @ApiModelProperty("错误信息")
    private String message;

//    @ApiModelProperty("数据对象")
    private Object data;

//    @ApiModelProperty("数据数量，数据为List时为空")
    private Integer count;

//    @ApiModelProperty("最大数量，分页时可用")
    private Integer totalCount;

//    @ApiModelProperty("分页开始位置，可能为position，也可能我pageNo，根据接口定义，分页时可用")
    private Integer start;

    public Result() {
    }

    private Result(boolean success, String code, String message, Object data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(boolean success, String code, String message, Object data, int count) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        this.count = count;
    }

    public Result(boolean success, String code, String message, Object data, int count, Integer totalCount, Integer start) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        this.count = count;
        this.totalCount = totalCount;
        this.start = start;
    }

    public static Result ok(String code, String message, Object data) {
        return new Result(true, code, message, data);
    }

    public static Result ok(Object data, int count) {
        return new Result(true, "1", "成功", data, count);
    }

    public static Result ok(Object data) {
        return new Result(true, null, null, data);
    }

    public static Result error(String code, String message, Object data) {
        return new Result(false, code, message, data);
    }

    public static Result error(String message) {
        return new Result(false, null, message, null);
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }
}
