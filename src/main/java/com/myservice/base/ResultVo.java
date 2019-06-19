package com.myservice.base;

import io.swagger.annotations.ApiModelProperty;

public class ResultVo<T> {

    private static final long serialVersionUID = 2907211119535752349L;

    @ApiModelProperty("是否成功")
    private boolean success;

    @ApiModelProperty("错误码,0、正确，非0、错误")
    private String code;

    @ApiModelProperty("错误信息")
    private String message;

    @ApiModelProperty("数据对象")
    private T data;

    @ApiModelProperty("数据数量，数据为List时为空")
    private Integer count;

    @ApiModelProperty("最大数量，分页时可用")
    private Integer totalCount;

    @ApiModelProperty("分页开始位置，可能为position，也可能我pageNo，根据接口定义，分页时可用")
    private Integer start;

    public ResultVo() {
    }

    private ResultVo(boolean success, String code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultVo(boolean success, String code, String message, T data, int count) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        this.count = count;
    }

    public ResultVo(boolean success, String code, String message, T data, int count, Integer totalCount, Integer start) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        this.count = count;
        this.totalCount = totalCount;
        this.start = start;
    }

    public ResultVo<T> ok(String code, String message, T data) {
        return new ResultVo(true, code, message, data);
    }

    public ResultVo<T> ok(T data, int count) {
        return new ResultVo(true, "0", "调用成功", data, count);
    }

    public ResultVo<T> ok(T data) {
        return new ResultVo(true, null, null, data);
    }

    public ResultVo<T> error(String code, String message, Object data) {
        return new ResultVo(false, code, message, data);
    }

    public ResultVo<T> error(String message) {
        return new ResultVo(false, null, message, null);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
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
