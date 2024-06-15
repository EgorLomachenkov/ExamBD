package by.itstep.lomachenkov.examdb.dataAccessLayer;

import by.itstep.lomachenkov.examdb.model.entity.BaseEntity;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDAO<T extends BaseEntity> {
    void insert(T t) throws SQLException;
    void update(T t) throws SQLException;
    List<T> getAll() throws SQLException;
    T getById(int id) throws SQLException;
    void delete(int id) throws SQLException;
}
