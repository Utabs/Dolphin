package ir.dolphin.base;

public enum Layer
{

    DAO(new Short("1")),
    COMPONENT(new Short("2")),
    BUSINESS(new Short("3")),
    FACADE(new Short("4")),
    WEB_SERVICE(new Short("5"));


    private Short layerCode;

    private Layer(Short layerCode) {
        this.layerCode = layerCode;
    }

    public Short getName() {
        return layerCode;
    }


}