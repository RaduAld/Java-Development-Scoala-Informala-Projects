package jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AppTests {

    /*
        This test is used to check the insert into the db methods and also for their deletion from the db methods
     */
    @Test
    public void InsertTest() throws SQLException, InterruptedException {

        List<Accommodation> initialAccommodationList = Accommodation.getAllAccommodations();
        List<RoomFair> initialRoomFairList = RoomFair.getAllRoomFairs();
        List<RelationAccommodationRoomFair> initialRelationAccommodationRoomFairList =
                RelationAccommodationRoomFair.getAllAccommodationFair();

        //Accommodation
        Accommodation acc1 = new Accommodation(0, "motel", "twin", 1, "small room for 1 person.");
        Accommodation acc2 = new Accommodation(0, "cottage", "king", 2, "spacious room perfect for couples.");

        acc1 = Accommodation.insertAccommodation(acc1);
        acc2 = Accommodation.insertAccommodation(acc2);
        initialAccommodationList.add(acc1); initialAccommodationList.add(acc2);

        List<Accommodation> finalAccommodationList = Accommodation.getAllAccommodations();
        assertTrue(initialAccommodationList.size() == finalAccommodationList.size() &&
                finalAccommodationList.containsAll(initialAccommodationList) &&
                initialAccommodationList.containsAll(finalAccommodationList));

        //RoomFair
        RoomFair rf1 = new RoomFair(0, 500, "summer");
        RoomFair rf2 = new RoomFair(0, 700, "spring");

        rf1 = RoomFair.insertRoomFair(rf1);
        rf2 = RoomFair.insertRoomFair(rf2);
        initialRoomFairList.add(rf1); initialRoomFairList.add(rf2);

        List<RoomFair> finalRoomFairList = RoomFair.getAllRoomFairs();
        assertTrue(initialRoomFairList.size() == finalRoomFairList.size() &&
                finalRoomFairList.containsAll(initialRoomFairList) &&
                initialRoomFairList.containsAll(finalRoomFairList));

        //RelationAccommodationRoomFair
        RelationAccommodationRoomFair rel1 = new RelationAccommodationRoomFair(0, acc1.getId(), 2);
        RelationAccommodationRoomFair rel2 = new RelationAccommodationRoomFair(0, acc1.getId(), rf1.getId());
        RelationAccommodationRoomFair rel3 = new RelationAccommodationRoomFair(0, acc2.getId(), rf2.getId());

        rel1 = RelationAccommodationRoomFair.insertRelation(rel1);
        rel2 = RelationAccommodationRoomFair.insertRelation(rel2);
        rel3 = RelationAccommodationRoomFair.insertRelation(rel3);
        initialRelationAccommodationRoomFairList.add(rel1);
        initialRelationAccommodationRoomFairList.add(rel2);
        initialRelationAccommodationRoomFairList.add(rel3);

        List<RelationAccommodationRoomFair> finalRelationAccommodationRoomFairList =
                RelationAccommodationRoomFair.getAllAccommodationFair();
        assertTrue(initialRelationAccommodationRoomFairList.size() == finalRelationAccommodationRoomFairList.size() &&
                finalRelationAccommodationRoomFairList.containsAll(initialRelationAccommodationRoomFairList) &&
                initialRelationAccommodationRoomFairList.containsAll(finalRelationAccommodationRoomFairList));

        //DELETE DATA
        assertEquals(rel1.getId(), RelationAccommodationRoomFair.deleteRelation(rel1.getId()));

        assertEquals(acc1.getId(), Accommodation.deleteAccommodation(acc1.getId()));
        assertEquals(acc2.getId(), Accommodation.deleteAccommodation(acc2.getId()));

        assertEquals(rf1.getId(), RoomFair.deleteRoomFair(rf1.getId()));
        assertEquals(rf2.getId(), RoomFair.deleteRoomFair(rf2.getId()));


    }

    /*
        This test is used to check the RelationAccommodationRoomFair method that uses JOIN to get the accommodation prices
     */
    @Test
    public void PrintTest() throws SQLException {
        ResultSet resultSet = RelationAccommodationRoomFair.getFormattedAccommodationPrices();
        while (resultSet.next()){
            System.out.println(resultSet.getString("type") + ' ' +
                    resultSet.getString("bed_type") + " : " +
                    resultSet.getString("description") + "\n\t" +
                    resultSet.getString("value") + " (" +
                    resultSet.getString("season") + ')');
        }
    }

}
