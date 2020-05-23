package br.com.confile.to;

public class PropertyTO {

    public static int INITIAL_STATE = 0;
    public static int COMMENTED_STATE = 1;

    private String key;
    private String value;

    private int state = INITIAL_STATE;

    public PropertyTO(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
