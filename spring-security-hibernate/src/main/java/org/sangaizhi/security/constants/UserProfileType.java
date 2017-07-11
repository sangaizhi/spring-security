package org.sangaizhi.security.constants;

/**
 * created by sangaizhi on 2017/7/10.
 */
public enum UserProfileType {
    USER("user","普通用户", 0),
    DBA("dba","DBA", 1),
    ADMIN("admin","管理员",2),
    ;
    private String label;
    private String name;
    private Integer value;

    UserProfileType(String label, String name, Integer value) {
        this.label = label;
        this.name = name;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
