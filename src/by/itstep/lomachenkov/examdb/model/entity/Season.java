package by.itstep.lomachenkov.examdb.model.entity;

public class Season extends BaseEntity {
    private String seasonType;

    public Season(String seasonType) {
        this.seasonType = seasonType;
    }

    public String getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(String seasonType) {
        this.seasonType = seasonType;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }
}
