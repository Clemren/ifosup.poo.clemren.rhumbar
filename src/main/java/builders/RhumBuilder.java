package builders;

import beans.Rhum;

public class RhumBuilder {
    private int id;
    private String name;
    private String trademark;
    private String origin;

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
        return rhum;
    }

}
