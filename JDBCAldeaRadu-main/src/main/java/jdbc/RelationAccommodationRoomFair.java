package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
    RelationAccommodationRoomFair class is the model for accommodation_fair_relation table:
        -- accomodation_fair_relation: cu urmatoarele coloane:
        -- id: int (primary key)
        -- id_accomodation: int (foreign key of accomodation)
        -- id_room_fair: int (foreign key of room fair)
 */

public class RelationAccommodationRoomFair {

    private int id;
    private int id_accommodation;
    private int id_room_fair;

    @Override
    public String toString() {
        return "RelationAccommodationRoomFait{" +
                "id=" + id +
                ", id_accommodation=" + id_accommodation +
                ", id_room_fair=" + id_room_fair +
                '}';
    }

    public static ResultSet getFormattedAccommodationPrices() throws SQLException {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection("jdbc:postgresql://localhost:5432/jdbc",
                "postgres", "Password");
        Statement query = connection.createStatement();
        return query.executeQuery("SELECT accommodation_fair_relation.id, " +
                "accommodation.id, accommodation.type, accommodation.bed_type, accommodation.description," +
                "room_fair.id, room_fair.value, room_fair.season" +
                "     FROM accommodation_fair_relation" +
                "     JOIN accommodation ON accommodation_fair_relation.id_accommodation=accommodation.id" +
                "     JOIN room_fair ON accommodation_fair_relation.id_room_fair=room_fair.id");
    }

    public RelationAccommodationRoomFair(int id, int id_accommodation, int id_room_fair) {
        this.id = id;
        this.id_accommodation = id_accommodation;
        this.id_room_fair = id_room_fair;
    }

    public static List<RelationAccommodationRoomFair> getAllAccommodationFair() throws SQLException {
        List<RelationAccommodationRoomFair> roomFairList = new ArrayList<>();
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection("jdbc:postgresql://localhost:5432/jdbc",
                "postgres", "Password");
        Statement query = connection.createStatement();
        ResultSet response = query.executeQuery("select * FROM accommodation_fair_relation");
        while (response.next()) {
            RelationAccommodationRoomFair relationAccommodationRoomFairEntry = new RelationAccommodationRoomFair(
                    response.getInt("id"),
                    response.getInt("id_accommodation"),
                    response.getInt("id_room_fair"));
            roomFairList.add(relationAccommodationRoomFairEntry);
        }
        return roomFairList;
    }

    public static RelationAccommodationRoomFair insertRelation(RelationAccommodationRoomFair relationAccommodationRoomFair) throws SQLException {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection("jdbc:postgresql://localhost:5432/jdbc",
                "postgres", "Password");

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO accommodation_fair_relation VALUES (nextVal('accommodation_fair_relations_id_seq'), ?, ?)");
        preparedStatement.setInt(1, relationAccommodationRoomFair.id_accommodation);
        preparedStatement.setInt(2, relationAccommodationRoomFair.id_room_fair);
        preparedStatement.executeUpdate();

        Statement query = connection.createStatement();
        ResultSet resultSet = query.executeQuery("SELECT * FROM accommodation_fair_relation ORDER BY ID DESC LIMIT 1");
        if (resultSet.next()) {
            int index = resultSet.getInt("id");
            relationAccommodationRoomFair.setId(index);
        }
        return relationAccommodationRoomFair;
    }

    public static int deleteRelation(int relation_id) throws SQLException {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection("jdbc:postgresql://localhost:5432/jdbc",
                "postgres", "Password");

        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM accommodation_fair_relation WHERE id = (?)");
        preparedStatement.setInt(1, relation_id);
        preparedStatement.executeUpdate();
        return relation_id;
    }

    public static void deleteByRoomFairId(int id_room_fair) throws SQLException {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection("jdbc:postgresql://localhost:5432/jdbc",
                "postgres", "Password");

        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM accommodation_fair_relation WHERE id_room_fair = (?)");
        preparedStatement.setInt(1, id_room_fair);
        preparedStatement.executeUpdate();
    }

    public static void deleteByAccommodationId(int id_accommodation) throws SQLException {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection("jdbc:postgresql://localhost:5432/jdbc",
                "postgres", "Password");

        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM accommodation_fair_relation WHERE id_accommodation = (?)");
        preparedStatement.setInt(1, id_accommodation);
        preparedStatement.executeUpdate();
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelationAccommodationRoomFair that = (RelationAccommodationRoomFair) o;
        return id == that.id && id_accommodation == that.id_accommodation && id_room_fair == that.id_room_fair;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_accommodation, id_room_fair);
    }

    public void setId(int id) {
        this.id = id;
    }
}
