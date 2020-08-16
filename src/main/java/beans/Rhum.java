package beans;

public class Rhum {
    private int pk;
    private String name;
    private String description;
    private String trademark;
    private int fk_trademark;

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
}
