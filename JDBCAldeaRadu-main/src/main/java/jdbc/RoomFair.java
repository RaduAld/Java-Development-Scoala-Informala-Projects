package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
    RoomFair class is the model for room_fair table:
        -- room_fair: cu urmatoarele coloane
        -- id: int (primary key)
        -- value: double
        -- season: varchar(32)
 */

public class RoomFair {

    private int id;
    private double value;
    private String season;

    public RoomFair(int id, double value, String season) {
        this.id = id;
        this.value = value;
        this.season = season;
    }

    @Override
    public String toString() {
        return "RoomFair{" +
                "id=" + id +
                ", value=" + value +
                ", season='" + season + '\'' +
                '}';
    }

    public static List<RoomFair> getAllRoomFairs() throws SQLException {
        List<RoomFair> roomFairList = new ArrayList<>();
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection("jdbc:postgresql://localhost:5432/jdbc",
                "postgres", "Password");
        Statement query = connection.createStatement();
        ResultSet response = query.executeQuery("select * FROM room_fair");
        while (response.next()) {
            RoomFair roomFairEntry = new RoomFair(
                    response.getInt("id"),
                    response.getDouble("value"),
                    response.getString("season"));
            roomFairList.add(roomFairEntry);
        }
        return roomFairList;
    }

    public static RoomFair insertRoomFair(RoomFair roomFair) throws SQLException {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection("jdbc:postgresql://localhost:5432/jdbc",
                "postgres", "Password");

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO room_fair VALUES (nextVal('room_fairs_id_seq'), ?, ?)");

        preparedStatement.setDouble(1, roomFair.value);
        preparedStatement.setString(2, roomFair.season);
        preparedStatement.executeUpdate();

        Statement query = connection.createStatement();
        ResultSet resultSet = query.executeQuery("SELECT * FROM room_fair ORDER BY ID DESC LIMIT 1");

        if (resultSet.next()) {
            int last_index = resultSet.getInt("id");
            roomFair.setId(last_index);
        }
        return roomFair;
    }

    public static int deleteRoomFair(int roomFairID) throws SQLException {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection("jdbc:postgresql://localhost:5432/jdbc",
                "postgres", "Password");

        RelationAccommodationRoomFair.deleteByRoomFairId(roomFairID);

        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM room_fair WHERE id = (?)");
        preparedStatement.setInt(1, roomFairID);
        preparedStatement.executeUpdate();

        return roomFairID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomFair roomFair = (RoomFair) o;
        return id == roomFair.id && Double.compare(roomFair.value, value) == 0 && season.equals(roomFair.season);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, season);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
