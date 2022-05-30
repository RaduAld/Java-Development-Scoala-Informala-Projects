package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
    Accommodation class is the model for accommodation table:
        -- id: int (primary key)
        -- type: varchar (32)
        -- bed_type: varchar (32)
        -- max_guests: int
        -- description: varchar(512)
 */

public class Accommodation {

    private int id;
    private String type;
    private String bed_type;
    private int max_guests;
    private String description;

    public Accommodation(int id, String type, String bed_type, int max_guests, String description) {
        this.id = id;
        this.type = type;
        this.bed_type = bed_type;
        this.max_guests = max_guests;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", bed_type='" + bed_type + '\'' +
                ", max_guests=" + max_guests +
                ", description='" + description + '\'' +
                '}';
    }

    public static List<Accommodation> getAllAccommodations() throws SQLException {
        List<Accommodation> accommodationList = new ArrayList<>();
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection("jdbc:postgresql://localhost:5432/jdbc",
                "postgres", "Password");
        Statement query = connection.createStatement();
        ResultSet response = query.executeQuery("select * FROM accommodation");
        while (response.next()) {
            Accommodation accommodationEntry = new Accommodation(
                    response.getInt("id"),
                    response.getString("type"),
                    response.getString("bed_type"),
                    response.getInt("max_guests"),
                    response.getString("description"));
            accommodationList.add(accommodationEntry);
        }
        return accommodationList;
    }

    public static Accommodation insertAccommodation(Accommodation accommodation) throws SQLException {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection("jdbc:postgresql://localhost:5432/jdbc",
                "postgres", "Password");

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO accommodation VALUES (nextVal('accommodations_id_seq'), ?, ?, ?, ?)");

        preparedStatement.setString(1, accommodation.type);
        preparedStatement.setString(2, accommodation.bed_type);
        preparedStatement.setInt(3, accommodation.max_guests);
        preparedStatement.setString(4, accommodation.description);
        preparedStatement.executeUpdate();

        Statement query = connection.createStatement();
        ResultSet resultSet = query.executeQuery("SELECT * FROM accommodation ORDER BY ID DESC LIMIT 1");

        if (resultSet.next()){
            int index = resultSet.getInt("id");
            accommodation.setId(index);
        }
        return accommodation;
    }

    public static int deleteAccommodation(int accommodationID) throws SQLException {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection("jdbc:postgresql://localhost:5432/jdbc",
                "postgres", "Password");

        RelationAccommodationRoomFair.deleteByAccommodationId(accommodationID);

        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM accommodation WHERE id = (?)");
        preparedStatement.setInt(1, accommodationID);
        preparedStatement.executeUpdate();

        return accommodationID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accommodation that = (Accommodation) o;
        return id == that.id && max_guests == that.max_guests && type.equals(that.type) && bed_type.equals(that.bed_type) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, bed_type, max_guests, description);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
