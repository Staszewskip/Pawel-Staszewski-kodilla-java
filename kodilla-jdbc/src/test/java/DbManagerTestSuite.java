import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class DbManagerTestSuite {
    @Test
    void testConnect() throws SQLException {
//        given
//        when
        DbManager dbManager = DbManager.getInstance();
//        then
        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
//        given
        DbManager dbManager = DbManager.getInstance();

//        when
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

//        then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(5, counter);
    }

    @Test
    void testSelectUsersAndTasks() throws SQLException {
//        given
        DbManager dbManager = DbManager.getInstance();
//        when
        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, I.SUMMARY\n" +
                " FROM USERS U\n" +
                " JOIN ISSUES I ON U.ID = I.USER_ID_ASSIGNEDTO";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

//        then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME") + ", " +
                    rs.getString("SUMMARY"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(0, counter);
    }

    @Test
    void testSelectUsersAndPosts() throws SQLException {
//        given
        DbManager dbManager = DbManager.getInstance();
//        when
        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_NUMBER\n" +
                "FROM USERS U JOIN POSTS P ON U.ID = P.USER_ID\n" +
                " GROUP BY P.USER_ID\n" +
                "HAVING COUNT(*) >=2";

        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);
//        then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME") + ", " +
                    rs.getInt("POSTS_NUMBER"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(1, counter);
    }
}



