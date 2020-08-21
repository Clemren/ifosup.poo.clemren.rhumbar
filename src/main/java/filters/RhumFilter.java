package filters;

public class RhumFilter {
    private String name;
    private String trademark;
    private String origin;
    private String country;

    public RhumFilter(String name, String trademark, String origin, String country) {
        this.name = name;
        this.trademark = trademark;
        this.origin = origin;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
