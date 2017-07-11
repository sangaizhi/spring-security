package org.sangaizhi.security.constants;

/**
 * created by sangaizhi on 2017/7/10.
 */
public enum State {
    ACTIVE("active","激活", 0),
    INACTIVE("INACTIVE","不活动的", 1),
    DELETED("DELETED","激活",2),
    LOCKED("LOCKED","激活", 3);
    ;
    private String label;
    private String name;
    private Integer value;

    State(String label, String name, Integer value) {
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
