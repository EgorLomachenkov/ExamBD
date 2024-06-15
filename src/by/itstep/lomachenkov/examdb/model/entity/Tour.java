package by.itstep.lomachenkov.examdb.model.entity;

import java.time.OffsetDateTime;
import java.sql.Date;

public class Tour extends BaseEntity {
    private int id_season;
    private int id_tour_type;
    private String name;
    private Date startDate;
    private Date endDate;
    private int cost;
    private String description;

    public Tour() {
    }

    public Tour(int id_season, int id_tour_type, String name, Date startDate, Date endDate, int cost, String description) {
        this.id_season = id_season;
        this.id_tour_type = id_tour_type;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
        this.description = description;
    }

    public int getId_season() {
        return id_season;
    }

    public void setId_season(int id_season) {
        this.id_season = id_season;
    }

    public int getId_tour_type() {
        return id_tour_type;
    }

    public void setId_tour_type(int id_tour_type) {
        this.id_tour_type = id_tour_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
