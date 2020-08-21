package beans;

import java.text.DecimalFormat;
import java.util.Locale;

public class Rhum {
    private int pk;
    private String name;
    private String description;
    private String trademark;
    private String origin;
    private String filename;
    private String countryName;
    private String countryAlphaName;
    private int fk_trademark;
    private double unitPrice;
    private boolean canDelete;

     public Rhum(){

     }

    public Rhum(int pk, int fk_trademark , String name) {
        this.pk = pk;
        this.fk_trademark = fk_trademark;
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

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public int getFk_trademark() {
        return fk_trademark;
    }

    public void setFk_trademark(int fk_trademark) {
        this.fk_trademark = fk_trademark;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryAlphaName() {
        return countryAlphaName;
    }

    public void setCountryAlphaName(String countryAlphaName) {
        this.countryAlphaName = countryAlphaName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getVatIncludedUnitPrice() {
        return unitPrice * 1.21;
    }

    public String getFormattedCurrencyPrice(){
        return DecimalFormat.getCurrencyInstance(Locale.FRANCE).format(this.getVatIncludedUnitPrice());
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }
}
