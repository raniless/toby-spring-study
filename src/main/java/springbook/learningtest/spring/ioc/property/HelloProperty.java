package springbook.learningtest.spring.ioc.property;

import org.springframework.beans.factory.annotation.Value;

public class HelloProperty {
    private String param;

    public HelloProperty(@Value("paramValue") String param) {   //메소드 파라미터
        this.param = param;
    }

    public String getParam() {
        return param;
    }

    @Value("fieldValue")    // 필드
    private String fieldValue;
    public String getFieldValue() {
        return fieldValue;
    }

    @Value("true")
    private boolean flag;
    public boolean isFlag() {
        return flag;
    }

    @Value("1.2")
    private double rate;

    public double getRate() {
        return rate;
    }

    @Value("1,2,3,4")
    private int[] intArr;

    public int[] getIntArr() {
        return intArr;
    }

    private String name;
    @Value("EveryOne")   // 수정자, <property name="name" value="Everyone" /> 과 동일
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String osName;
    @Value("#{systemProperties['os.name']}")
    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsName() {
        return osName;
    }

    private String userName;
    @Value("${db.username}")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}