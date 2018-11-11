package sms.module;

public class NamedEntity extends Entity {

    private String name;

    public NamedEntity() {
    }

    public NamedEntity(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NamedEntity{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
