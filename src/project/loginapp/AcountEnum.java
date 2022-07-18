package project.loginapp;

public enum AcountEnum {
    Admin, User;

    AcountEnum(){}

    public String value(){
        return name();
    }
    public static AcountEnum fromvalues(String v){
        return valueOf(v);
    }


}
