package pers.hai.simple.jdk.utilapis;

public enum Season {

    Spring("春天"),
    Summer("夏天"),
    Autumn("秋天"),
    Winter("冬天");

    private String value;

    private Season(String value) {
        this.setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
