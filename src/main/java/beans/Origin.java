package beans;

public class Origin {
    private int pk;
    private String name;


     public Origin(){

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
}
