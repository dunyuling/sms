package sms.model;

public class Course extends NamedEntity {

    public Course() {
    }

    public Course(String id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Course{} " + super.toString();
    }
}
