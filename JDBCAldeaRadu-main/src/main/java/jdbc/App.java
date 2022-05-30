package jdbc;

import java.sql.*;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {

        System.out.println("----------------------");

        for (Accommodation acc : Accommodation.getAllAccommodations()){
            System.out.println(acc);
        }

        System.out.println("----------------------");

        for (RoomFair roomF : RoomFair.getAllRoomFairs()){
            System.out.println(roomF);
        }

        System.out.println("----------------------");

        for (RelationAccommodationRoomFair relation : RelationAccommodationRoomFair.getAllAccommodationFair()){
            System.out.println(relation);
        }

        System.out.println("----------------------");



    }
}
