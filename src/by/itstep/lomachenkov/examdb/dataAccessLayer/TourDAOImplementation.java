package by.itstep.lomachenkov.examdb.dataAccessLayer;

import by.itstep.lomachenkov.examdb.model.entity.Tour;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TourDAOImplementation implements TourDAO {
    public static final String INSERT_TOUR = "INSERT INTO tours " +
            "(id_tour_type, name, start_date, end_date, cost)" +
            "VALUES (?, ?, ?, ?, ?)";
    public static final String UPDATE_TOUR = "UPDATE tours SET" +
            " id_tour_type = ?, name = ?, start_date = ?, end_date = ?," +
            " cost = ? WHERE id_tour = ?";
    public static final String GET_ALL = "SELECT * FROM tours";
    public static final String GET_BY_ID = "SELECT * FROM tours WHERE id_tour = ?";
    public static final String DELETE_TOUR = "DELETE FROM tours WHERE id_tour = ?";
    public static final String GET_ALL_BY_TYPES_ASC = "SELECT * FROM tours t" +
            " INNER JOIN tour_type tt WHERE t.id_tour_type = tt.id_tour_type" +
            " ORDER BY tt.type";
    public static final String GET_TOURS_AMOUNT = "SELECT COUNT(*) FROM tours";
    public static final String GET_CHEAPEST_TOUR = "SELECT * FROM tours ORDER BY" +
            " cost LIMIT 1";
    public static final String GET_MOST_EXPENSIVE_TOUR = "SELECT * FROM tours ORDER BY" +
            " cost DESC LIMIT 1";
    public static final String GET_MOST_EXPENSIVE_TOUR_TYPE = "SELECT tt.type," +
            " AVG(cost) FROM tours t INNER JOIN tour_type tt ON" +
            " t.id_tour_type = tt.id_tour_type GROUP BY tt.type ORDER BY" +
            " AVG(cost) DESC LIMIT 1";


    public List<Tour> getAllByTypes() throws SQLException {
        List<Tour> tours = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet set = statement.executeQuery(GET_ALL_BY_TYPES_ASC)) {
            while (set.next()) {
                tours.add(resultSetTour(set));
            }
        }
        return tours;
    }

    public int getToursAmount() throws SQLException {
        try(Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_TOURS_AMOUNT);
            ResultSet set = statement.executeQuery()) {
            if (set.next()) {
                return set.getInt(1);
            }
        }
        return 0;
    }
    public Tour getCheapestTour() throws SQLException {
        try(Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_CHEAPEST_TOUR);
            ResultSet set = statement.executeQuery()) {
            if (set.next()) {
                return resultSetTour(set);
            }
        }
        return null;
    }

    public Tour getMostExpensiveTour() throws SQLException {
        try(Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_MOST_EXPENSIVE_TOUR);
            ResultSet set = statement.executeQuery()) {
            if (set.next()) {
                return resultSetTour(set);
            }
        }
        return null;
    }

    public String getMostExpensiveTourType() throws SQLException {
        try(Connection connection = Database.getConnection();
        PreparedStatement statement = connection.prepareStatement(GET_MOST_EXPENSIVE_TOUR_TYPE);
        ResultSet set = statement.executeQuery()) {
            if (set.next()) {
                return set.getString(1);
            }
        }
        return null;
    }
    @Override
    public void insert(Tour tour) throws SQLException {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_TOUR)) {
            setTourParameters(tour, statement);

            statement.executeUpdate();
        }
    }

    @Override
    public void update(Tour tour) throws SQLException {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_TOUR)) {
            setTourParameters(tour, statement);
            statement.setInt(/*8*/ 6, tour.getId());

            statement.executeUpdate();
        }
    }

    @Override
    public List<Tour> getAll() throws SQLException {
        List<Tour> tours = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet set = statement.executeQuery(GET_ALL)) {
            while (set.next()) {
                tours.add(resultSetTour(set));
            }
        }
        return tours;
    }

    @Override
    public Tour getById(int id) throws SQLException {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                return resultSetTour(set);
            }
            set.close();
        }

        return null;
    }

    @Override
    public void delete(int id) throws SQLException {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_TOUR)) {
            statement.setInt(1, id);

            statement.executeUpdate();
        }
    }

    private void setTourParameters(Tour tour, PreparedStatement statement)
            throws SQLException {
//        statement.setInt(1, tour.getId_season());
        statement.setInt(1, tour.getId_tour_type());
        statement.setString(2, tour.getName());
        statement.setDate(3, tour.getStartDate());
        statement.setDate(4, tour.getEndDate());
        statement.setInt(5, tour.getCost());
        //statement.setString(7, tour.getDescription());
    }

    private Tour resultSetTour(ResultSet set) throws SQLException {
        Tour tour = new Tour();
        tour.setId(set.getInt(1));
        tour.setId_season(set.getInt(2));
        tour.setId_tour_type(set.getInt(3));
        tour.setName(set.getString(4));
        tour.setStartDate(set.getDate(5));
        tour.setEndDate(set.getDate(6));
        tour.setCost(set.getInt(7));
        tour.setDescription(set.getString(8));
        return tour;
    }
}
