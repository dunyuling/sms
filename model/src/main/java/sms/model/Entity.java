package sms.model;

import java.io.Serializable;

public abstract class Entity implements Serializable {

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
