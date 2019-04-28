package ir.dolphin.model;

public enum QueryName implements BaseQueryName
{

    getByState("getByState");


    private String queryName;

    private QueryName(String qName) {
        queryName = qName;
    }

    public String getName() {
        return queryName;
    }


}