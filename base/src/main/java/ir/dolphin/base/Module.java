package ir.dolphin.base;

public enum Module
{

    ASSET(new Short("1")),
    CUSTOMER(new Short("2")),
    SALLER(new Short("3")),
    SHOP(new Short("4"));

    private Short moduleCode;

    private Module(Short moduleCode) {
        this.moduleCode = moduleCode;
    }

    public Short getName() {
        return moduleCode;
    }


}