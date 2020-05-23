package br.com.confile;

public enum ConFileErrorCode {
    PATH_ARG_NOT_FOUND(1, "Argument required PATH not found.");

    private int code;
    private String msg;

    ConFileErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return msg;
    }
}
