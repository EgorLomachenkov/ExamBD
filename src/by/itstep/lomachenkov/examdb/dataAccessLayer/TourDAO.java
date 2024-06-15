package by.itstep.lomachenkov.examdb.dataAccessLayer;

import by.itstep.lomachenkov.examdb.model.entity.Tour;

import java.sql.SQLException;
import java.util.List;

public interface TourDAO extends AbstractDAO<Tour> {
    @Override
    void insert(Tour tour) throws SQLException;

    @Override
    void update(Tour tour) throws SQLException;

    @Override
    List<Tour> getAll() throws SQLException;

    @Override
    Tour getById(int id) throws SQLException;

    @Override
    void delete(int id) throws SQLException;
}
