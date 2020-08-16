package beans;

public class Trademark {
    private int pk;
    private String name;
    private String description;
    private String origin;
    private int fk_origin;
    private boolean canDelete;
     public Trademark(){

     }

    public Trademark(int pk, int fk_origin ,String name) {
        this.pk = pk;
        this.fk_origin = fk_origin;
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

    public int getFk_origin() {
        return fk_origin;
    }

    public void setFk_origin(int fk_origin) {
        this.fk_origin = fk_origin;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }
}
