package beans;

public class Origin {
    private int pk;
    private String name;
    private String countryAlpha2;
    private String description;
    private String countryName;
    private boolean canDelete;

    public Origin() {

    }

    public Origin(int pk, String name) {
        this.pk = pk;
        this.name = name;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }


    public String getCountryAlpha2() {
        return countryAlpha2;
    }

    public void setCountryAlpha2(String countryAlpha2) {
        this.countryAlpha2 = countryAlpha2;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
