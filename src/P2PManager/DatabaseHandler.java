package P2PManager;

import java.sql.*;

public class DatabaseHandler {
    private static DatabaseHandler handler = null;

    private static Connection myConn = null;
    private static Statement myStmt = null;

    private static final String dbUrl = "jdbc:mysql://localhost:3306/StarkHub";
    private static final String user = "Bhanu";
    private static final String pass = "BhallalDev22";

    private DatabaseHandler(){
        createConnection();
    }

    public static DatabaseHandler getInstance() {
        if (handler == null) {
            handler = new DatabaseHandler();
        }
        return handler;
    }

    void createConnection() {
        try {
            myConn = DriverManager.getConnection(dbUrl, user, pass);
            System.out.println("Database connection successful!\n");
        } catch (Exception e) {
            System.out.println("Database connection unsuccessful!\n");
            e.printStackTrace();
        }
    }

    public boolean execAction(String qu) {
        try {
            myStmt = myConn.createStatement();
            int rowsAffected = myStmt.executeUpdate(qu);
            System.out.println("execAction query execution successful!\n");
            return true;
        } catch (SQLException ex) {
            System.out.println("execAction query execution unsuccessful!\n");
            ex.printStackTrace();
            return false;
        }
    }

    public ResultSet execQuery(String qu) {
        ResultSet myRs = null;
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(qu);
            System.out.println("execQuery query execution successful!\n");
        } catch (SQLException ex) {
            System.out.println("execQuery query execution unsuccessful!\n");
            ex.printStackTrace();
        }finally {
            return myRs;
        }
    }
}
