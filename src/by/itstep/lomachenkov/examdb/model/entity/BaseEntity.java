package by.itstep.lomachenkov.examdb.model.entity;

public class BaseEntity implements Entity {
    private int id;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
