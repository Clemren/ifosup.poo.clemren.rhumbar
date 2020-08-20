package filters;

public class RhumFilter {
    private String name;
    private String trademark;
    private String origin;
    private int countryId;

    public RhumFilter(String name, String trademark, String origin, int countryId) {
        this.name = name;
        this.trademark = trademark;
        this.origin = origin;
        this.countryId = countryId;
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

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
}
