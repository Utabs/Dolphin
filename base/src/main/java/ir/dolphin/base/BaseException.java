package ir.dolphin.base;

import java.util.Arrays;

public class BaseException extends Exception
{
    Object[] param = null;
    String exceptionCode = null;
    String exceptionDescription = null;
    Layer layer = null;
    Module module = null;
    Throwable cause;

    public BaseException()
    {
        super();
    }

    public BaseException(String exceptionCode)
    {
        super(exceptionCode);
        this.exceptionCode = exceptionCode;
    }

    public BaseException(String exceptionCode, Throwable cause, String exceptionDescription, Layer layer, Module module, Object[] param) {
        super(exceptionCode, cause);
        this.exceptionCode = exceptionCode;
        this.cause = cause;
        this.exceptionDescription = exceptionDescription;
        this.layer = layer;
        this.module = module;
        this.param = param;
    }

    public BaseException(String exceptionCode, String exceptionDescription, Layer layer, Module module, Object[] param) {
        super(exceptionCode);
        this.exceptionCode = exceptionCode;
        this.exceptionDescription = exceptionDescription;
        this.layer = layer;
        this.module = module;
        this.param = param;
    }

    public BaseException(String exceptionCode, String exceptionDescription, Layer layer, Module module) {
        super(exceptionCode);
        this.exceptionCode = exceptionCode;
        this.exceptionDescription = exceptionDescription;
        this.layer = layer;
        this.module = module;
    }

    public BaseException(String exceptionCode, Throwable cause, String exceptionDescription, Layer layer, Module module) {
        super(exceptionCode, cause);
        this.exceptionCode = exceptionCode;
        this.cause = cause;
        this.exceptionDescription = exceptionDescription;
        this.layer = layer;
        this.module = module;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public Object[] getParam() {
        return param;
    }

    public void setParam(Object[] param) {
        this.param = param;
    }

    public String getExceptionDescription() {
        return exceptionDescription;
    }

    public void setExceptionDescription(String exceptionDescription) {
        this.exceptionDescription = exceptionDescription;
    }

    public Layer getLayer() {
        return layer;
    }

    public void setLayer(Layer layer) {
        this.layer = layer;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }



    public String toJson() {
        return "BaseException{" +
                "param=" + Arrays.toString(param) +
                ", exceptionCode='" + exceptionCode + '\'' +
                ", exceptionDescription='" + exceptionDescription + '\'' +
                ", layer=" + layer +
                ", module=" + module +
                ", cause=" + cause +
                '}';
    }

    @Override
    public String toString() {
        return "BaseException{" +
                "param=" + Arrays.toString(param) +
                ", exceptionCode='" + exceptionCode + '\'' +
                ", exceptionDescription='" + exceptionDescription + '\'' +
                ", layer=" + layer +
                ", module=" + module +
                ", cause=" + cause +
                '}';
    }
}
