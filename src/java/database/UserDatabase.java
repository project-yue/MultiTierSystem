/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Database features
 *
 * @author Yue Li
 */
public class UserDatabase {

    private final String URL = "jdbc:derby://localhost:1527/demo1;create=true";
    private final String USR_TBL_NAME = "DB_User";
    private final String[] USR_TBL_ATTRIBUTES = {"ID", "NAME", "PWD"};
    private final String ITEM_TBL = "DB_Item";
    private final String[] ITEM_TBL_ATTRIBUTES = {"ID", "NAME", "PRICE", "ACTIVE"};
    private Connection conn;

    public static void main(String[] args) {
        UserDatabase db = new UserDatabase();
        db.establishConnection();
        if (!db.doesUserTableExist()) {
            db.createUserTable();
        }
        if (!db.doesItemTableExist()) {
            db.createItemTable();
        }
        if (db.doesAccountExist("hello")) {
            System.out.println("user exists");
        } else {
            db.addNewUser("hello", "hello", "hello");
        }
    }

    /**
     * start connection with an existing database
     */
    public void establishConnection() {
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println(URL + "   connected....");
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * create user account table
     */
    public void createUserTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlCreate = "CREATE TABLE " + this.USR_TBL_NAME + "(" + this.USR_TBL_ATTRIBUTES[0]
                    + " VARCHAR(25) NOT NULL, " + this.USR_TBL_ATTRIBUTES[1] + " VARCHAR(30),"
                    + " " + this.USR_TBL_ATTRIBUTES[2] + " VARCHAR(10) NOT NULL, PRIMARY KEY (ID))";
            statement.executeUpdate(sqlCreate);
            System.out.println("User Table created");
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createItemTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlCreate = "CREATE TABLE " + this.ITEM_TBL + "(" + this.ITEM_TBL_ATTRIBUTES[0]
                    + " INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + " " + this.ITEM_TBL_ATTRIBUTES[1] + " VARCHAR(30), " + this.ITEM_TBL_ATTRIBUTES[2]
                    + " DECIMAL(16, 2), " + this.ITEM_TBL_ATTRIBUTES[3] + " BOOLEAN)";
            statement.executeUpdate(sqlCreate);
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean doesItemTableExist() {
        boolean result = false;
        try {
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, this.ITEM_TBL.toUpperCase(), null);
            if (tables.next()) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    /**
     * identify whether the user exists in the database
     *
     * @return true the user is a returning player, false otherwise
     */
    public boolean doesUserTableExist() {
        boolean result = false;
        try {
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, this.USR_TBL_NAME.toUpperCase(), null);
            if (tables.next()) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    /**
     * match password with user input
     *
     * @param password the password that user typed in
     * @param account the account in the table
     * @return true if passwords match, false otherwise
     */
    public boolean matchPasswords(String password, String account) {
        boolean isPasswordValid = false;
        try {
            Statement statement = this.conn.createStatement();
            String selectAccountPwd = "SELECT " + this.USR_TBL_ATTRIBUTES[2]
                    + " from " + this.USR_TBL_NAME + " where ID = '" + account + "'";
            ResultSet rs = statement.executeQuery(selectAccountPwd);
            while (rs.next()) {
                if (rs.getString(1).equals(password)) {
                    isPasswordValid = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isPasswordValid;
    }

    /**
     * does the account exist in the user table
     *
     * @param accountName the account to be searched in database
     * @return true if the account is found, false otherwise
     */
    public boolean doesAccountExist(String accountName) {
        boolean isFound = false;
        try {
            Statement statement = conn.createStatement();
            String selectComm = "SELECT ID from " + this.USR_TBL_NAME + " where ID = '" + accountName + "'";
            ResultSet rs = statement.executeQuery(selectComm);
            while (rs.next()) {
                if (rs.getString(1).equals(accountName)) {
                    isFound = true;
                }
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isFound;
    }

    /**
     * insert new user information to user table
     *
     * @param userId the accountName to be inserted
     * @param pwd the password of the account to be inserted
     */
    public void addNewUser(String userId, String userName, String pwd) {
        try {
            Statement statement = conn.createStatement();
            String sqlUpdate = "INSERT INTO " + this.USR_TBL_NAME + " values("
                    + " '" + userId + "' , '" + userName + "' , '" + pwd + "')";
            statement.executeUpdate(sqlUpdate);
            statement.close();
            System.out.println("new user added");
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * retrieve how many wins of a player
     *
     * @param userName the user account to be searched in the table
     * @return true if the account is found, false otherwise
     */
    public int getWins(String userName) {
        int wins = -1;
        try {
            Statement st = conn.createStatement();
            String sqlUpdate = "select WINS from " + this.USR_TBL_NAME + " where ID = '" + userName + "'";
            ResultSet rs = st.executeQuery(sqlUpdate);
            while (rs.next()) {
                wins = rs.getInt("WINS");
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

        return wins;
    }

    /**
     * increase a user's winning times by 1
     *
     * @param userName the winner
     */
    public void increaseWins(String userName) {
        int currentWins = getWins(userName);
        currentWins++;
        try {
            Statement st = conn.createStatement();
            String sqlUpdate = "update " + this.USR_TBL_NAME + " set WINS = " + currentWins + " where ID = '" + userName + "'";
            st.executeUpdate(sqlUpdate);
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * close connection
     */
    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
