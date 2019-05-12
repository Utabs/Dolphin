package ir.dolphin.base;



public class InvocationContext<T>  {
    private static final long serialVersionUID = 7349998902337183936L;

    int errorCode = 0;
    int errorStep = 0;
    T data;
    String[] errorParam = null;

    public InvocationContext(int errorCode, int errorStep) {
        this.errorCode = errorCode;
        this.errorStep = errorStep;
    }

    //new String[]{"start", "end", "count"}
    public InvocationContext(int errorCode, int errorStep, String[] errorParam) {
        this.errorCode = errorCode;
        this.errorStep = errorStep;
        this.errorParam = errorParam;
    }

    
    public InvocationContext() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode, int errorStep) {
        this.errorCode = errorCode;
        this.errorStep = errorStep;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorStep() {
        return errorStep;
    }

    @Override
    public String toString() {
        return "InvocationContext{" + "errorCode=" + errorCode + ", errorStep=" + errorStep + ", data=" + data + '}';
    }

    public boolean isSuccessful() {
        return this.errorCode == ErrorMessageConstant.APPROVED_CODE;
    }

    public String[] getErrorParam() {
        return errorParam;
    }

    public void setErrorParam(String[] errorParam) {
        this.errorParam = errorParam;
    }
}
