package sms.module;

public abstract class Entity {
    private String id;

    public Entity() {
    }

    public Entity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id='" + id + '\'' +
                '}';
    }
}
