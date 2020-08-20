package beans;

public class Country {
    private int pk;
    private int code;
    private String alpha2;
    private String name;

    public Country(int pk, int code, String alpha2, String name) {
        this.pk = pk;
        this.code = code;
        this.alpha2 = alpha2;
        this.name = name;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getAlpha2() {
        return alpha2;
    }

    public void setAlpha2(String alpha2) {
        this.alpha2 = alpha2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
