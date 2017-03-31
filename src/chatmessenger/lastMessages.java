package chatmessenger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fOrHaD_
 */
public class lastMessages {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/authentication";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    String message = "";
    String user_name;
    static ResultSet rs;
    int max = 0;

    //String password;
    public lastMessages(String name) {
        try {
            String user_name = new String();
            user_name = name;
            Connection conn = null;
            Statement stmt = null;
            try {
                //STEP 2: Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                //STEP 3: Open a connection
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);

                //STEP 4: Execute a query
                System.out.println("Creating statement...");
                stmt = conn.createStatement();
                String sql;

                sql = "SELECT id,message FROM " + name
                        + " ORDER BY id DESC";

                rs = stmt.executeQuery(sql);
                int i = 0;

                while (rs.next()) {

                    if (i < 5) {
                        message += "\n" + name + ": ";
                        message += rs.getString("message");

                    }
                    i++;

                }
                System.out.println("testing...........");
               
        //STEP 5: Extract data from result set

                //STEP 6: Clean-up environment
            } catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
            } catch (Exception e) {
                //Handle errors for Class.forName
                e.printStackTrace();
            } finally {
                //finally block used to close resources
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                } catch (SQLException se2) {
                }// nothing we can do
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException se) {
                    se.printStackTrace();
                }//end finally try
            }//end try
            //rs.close();
            // stmt.close();
            //conn.close();

        } catch (Exception ex) {
        }

    }

    String get_m() {
        return message;
    }

    int get_i() {
        return max;
    }

    public static void main(String args[]) {
        lastMessages l = new lastMessages("c");
        System.out.print(l.get_m());
        System.out.println(l.get_i());
    }

}
