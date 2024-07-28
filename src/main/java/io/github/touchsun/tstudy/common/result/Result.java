package io.github.touchsun.tstudy.common.result;

/**
 * common result class
 * 
 * @param <T>
 */
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    // 构造器
    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // 静态方法快速创建实例
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "Success", data);
    }

    public static <T> Result<T> error(int code, String msg) {
        return new Result<>(code, msg, null);
    }

    // Getter 和 Setter
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // toString 方法用于调试
    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
