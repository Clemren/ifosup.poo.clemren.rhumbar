package builders;

import beans.Rhum;

public class RhumBuilder {
    private int id;
    private String name;
    private String trademark;
    private String origin;
    private String countryName;
    private String countryAlpha2;
    private String filename;

    public RhumBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public RhumBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public RhumBuilder withOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    public RhumBuilder withFilename(String filename) {
        this.filename = filename;
        return this;
    }

    public RhumBuilder withCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }


    public RhumBuilder withCountryAlpha2(String countryAlpha2) {
        this.countryAlpha2 = countryAlpha2;
        return this;
    }


    public RhumBuilder withTrademark(String trademark) {
        this.trademark = trademark;
        return this;
    }

    public Rhum build(){
        var rhum = new Rhum();
        rhum.setPk(this.id);
        rhum.setName(this.name);
        rhum.setOrigin(this.origin);
        rhum.setTrademark(this.trademark);
        rhum.setFilename(this.filename);
        rhum.setCountryName(this.countryName);
        rhum.setCountryAlphaName(this.countryAlpha2);
        return rhum;
    }

}
