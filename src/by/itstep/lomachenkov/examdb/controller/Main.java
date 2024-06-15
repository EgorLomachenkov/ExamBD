package by.itstep.lomachenkov.examdb.controller;

import by.itstep.lomachenkov.examdb.dataAccessLayer.TourDAOImplementation;
import by.itstep.lomachenkov.examdb.model.entity.Tour;
import com.mysql.cj.protocol.a.OffsetDateTimeValueEncoder;


import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        TourDAOImplementation implementation = new TourDAOImplementation();

        List<Tour> list = implementation.getAllByTypes();
        for (Tour tour : list) {
            System.out.println(tour.getName() + ", Price - " + tour.getCost());
        }

        System.out.println("Amount of tours: " + implementation.getToursAmount());

        System.out.println("Cheapest tour: " + implementation.getCheapestTour().getName());

        System.out.println("Most expensive tour: "
                + implementation.getMostExpensiveTour().getName() + " Its cost - "
                + implementation.getMostExpensiveTour().getCost());

        System.out.println("Most expensive tour type: " + implementation.getMostExpensiveTourType());

        System.out.println("_____________________________________________________");

        Tour tour = new Tour();
        tour.setId(14);
        tour.setId_tour_type(2);
        tour.setName("bike tour");
        tour.setStartDate(Date.valueOf("2025-12-19"));
        tour.setEndDate(Date.valueOf("2025-12-21"));
        tour.setCost(4909);
//        implementation.insert(tour);

//        List<Tour> list1 = implementation.getAllByTypes();
//        for (Tour tour1 : list1) {
//            System.out.println(tour1.getName() + ", Price - " + tour1.getCost());
//        }


        //implementation.delete(14);

        tour.setCost(4950);
        implementation.update(tour);


    }
}
