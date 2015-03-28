/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import beans.ItemBean;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Database features
 *
 * @author Yue Li
 */
public class UserDatabase {

    private final String URL = "jdbc:derby://localhost:1527/ass1DB;create=true";
    private final String USR_TBL_NAME = "DB_User";
    private final String[] USR_TBL_ATTRIBUTES = {"USER_ID", "USER_NAME", "USER_PWD", "SHARED", "USED"};
    private final String ITEM_TBL = "DB_Item";
    private final String[] ITEM_TBL_ATTRIBUTES = {"ITEM_ID", "ITEM_NAME", "HEAT", "AVAILABLE"};
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
        if (db.doesAccountExist("1")) {
            System.out.println("user exists");
        } else {
            db.addNewUser("1", "1", "1");
        }

        String[] test = db.getUserTradeRecords("hello");
        System.out.println("Hello! " + test[1] + ", You have sold " + test[4]
                + " , and bought " + test[3] + "item(s)");
        db.addNewItem("re", true);
    }

    public static UserDatabase INIT_DB() {
        UserDatabase db = new UserDatabase();
        db.establishConnection();
        if (!db.doesUserTableExist()) {
            db.createUserTable();
        }
        if (!db.doesItemTableExist()) {
            db.createItemTable();
        }
        return db;
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
    private void createUserTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlCreate = "CREATE TABLE " + this.USR_TBL_NAME + "(" + this.USR_TBL_ATTRIBUTES[0]
                    + " VARCHAR(25) NOT NULL, " + this.USR_TBL_ATTRIBUTES[1] + " VARCHAR(30),"
                    + " " + this.USR_TBL_ATTRIBUTES[2] + " VARCHAR(16) NOT NULL,"
                    + " " + this.USR_TBL_ATTRIBUTES[3] + " INTEGER, " + this.USR_TBL_ATTRIBUTES[4]
                    + " INTEGER," + " PRIMARY KEY (" + this.USR_TBL_ATTRIBUTES[0] + "))";
            statement.executeUpdate(sqlCreate);
            System.out.println("User Table created");
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createItemTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlCreate = "CREATE TABLE " + this.ITEM_TBL + "(" + this.ITEM_TBL_ATTRIBUTES[0]
                    + " INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + " " + this.ITEM_TBL_ATTRIBUTES[1] + " VARCHAR(30) NOT NULL ," + this.ITEM_TBL_ATTRIBUTES[2]
                    + " INTEGER, " + this.ITEM_TBL_ATTRIBUTES[3] + " BOOLEAN, " + this.USR_TBL_ATTRIBUTES[0]
                    + " VARCHAR(25), " + " CONSTRAINT primary_key PRIMARY KEY (" + this.ITEM_TBL_ATTRIBUTES[0] + "))";
            statement.executeUpdate(sqlCreate);
            System.out.println("Item table created");
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean doesItemTableExist() {
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
    private boolean doesUserTableExist() {
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
                    + " from " + this.USR_TBL_NAME + " where "
                    + this.USR_TBL_ATTRIBUTES[0] + " = '" + account + "'";
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
     * @param usr_id the account to be searched in database
     * @return true if the account is found, false otherwise
     */
    public boolean doesAccountExist(String usr_id) {
        boolean isFound = false;
        try {
            Statement statement = conn.createStatement();
            String selectComm = "SELECT " + this.USR_TBL_ATTRIBUTES[0]
                    + " from " + this.USR_TBL_NAME + " where "
                    + this.USR_TBL_ATTRIBUTES[0] + " = '" + usr_id + "'";
            ResultSet rs = statement.executeQuery(selectComm);
            while (rs.next()) {
                if (rs.getString(1).equals(usr_id)) {
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
     * @param userName user's preferred name
     * @param pwd the password of the account to be inserted
     */
    public void addNewUser(String userId, String userName, String pwd) {
        try {
            Statement statement = conn.createStatement();
            String sqlUpdate = "INSERT INTO " + this.USR_TBL_NAME + " values("
                    + "'" + userId + "', '" + userName + "', '" + pwd
                    + "', " + "0, " + "0)";
            statement.executeUpdate(sqlUpdate);
            statement.close();
            System.out.println("new user: " + userId + " added");
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<ItemBean> getAvailableItemsList() throws Exception {
        List<ItemBean> result = new ArrayList<>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from " + this.ITEM_TBL
                + " where " + this.ITEM_TBL_ATTRIBUTES[3] + " = TRUE");
        while (rs.next()) {
            ItemBean ib = new ItemBean();
            ib.setId(rs.getString(this.ITEM_TBL_ATTRIBUTES[0]));
            ib.setName(rs.getString(this.ITEM_TBL_ATTRIBUTES[1]));
            ib.setHeat(rs.getInt(this.ITEM_TBL_ATTRIBUTES[2]));
            ib.setAvailable(rs.getBoolean(this.ITEM_TBL_ATTRIBUTES[3]));
            result.add(ib);
        }
        return result;
    }

    public List<ItemBean> getUserItemsList(String userId) throws Exception {
        List<ItemBean> result = new ArrayList<>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from " + this.ITEM_TBL
                + " where " + USR_TBL_ATTRIBUTES[0] + "=\'" + userId + "\'");
        while (rs.next()) {
            ItemBean ib = new ItemBean();
            ib.setId(rs.getString(this.ITEM_TBL_ATTRIBUTES[0]));
            ib.setName(rs.getString(this.ITEM_TBL_ATTRIBUTES[1]));
            ib.setHeat(rs.getInt(this.ITEM_TBL_ATTRIBUTES[2]));
            ib.setAvailable(rs.getBoolean(this.ITEM_TBL_ATTRIBUTES[3]));
            result.add(ib);
        }
        return result;
    }

    public String[] getUserTradeRecords(String id) {
        String[] record = new String[5];
        String query = "SELECT " + "*"
                + " from " + this.USR_TBL_NAME + " where "
                + this.USR_TBL_ATTRIBUTES[0] + " = '" + id + "'";
        try {
            Statement statement = this.conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                record[0] = rs.getString(this.USR_TBL_ATTRIBUTES[0]);
                record[1] = rs.getString(this.USR_TBL_ATTRIBUTES[1]);
                record[3] = Integer.toString(rs.getInt(this.USR_TBL_ATTRIBUTES[3]));
                record[4] = Integer.toString(rs.getInt(this.USR_TBL_ATTRIBUTES[4]));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

        return record;
    }

    /**
     * increase a user's either purchase or sales count by 1
     *
     * @param userId the winner
     * @param attribute the attribute to increment
     */
    public void incrementUserAttribute(String userId, String attribute) {
        String[] record = getUserTradeRecords(userId);
        int currentValue;
        boolean isShared = false;
        if (attribute.equalsIgnoreCase(this.USR_TBL_ATTRIBUTES[3])) {
            currentValue = Integer.parseInt(record[3]);
            isShared = true;
        } else {
            currentValue = Integer.parseInt(record[4]);
        }
        currentValue++;
        try {
            Statement st = conn.createStatement();
            String sqlUpdate = null;
            if (isShared) {
                sqlUpdate = "UPDATE " + this.USR_TBL_NAME + " SET " + this.USR_TBL_ATTRIBUTES[4];
            }
            st.executeUpdate(sqlUpdate);
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//----------------Item table updates----------------------------------------------------
    public void addNewItem(String name, boolean available) {
        try {
            try (Statement statement = conn.createStatement()) {
                String sqlUpdate = "INSERT INTO " + this.ITEM_TBL + " (" + this.ITEM_TBL_ATTRIBUTES[1] + ", "
                        + this.ITEM_TBL_ATTRIBUTES[3] + ")"
                        + " values('" + name + "'," + true + ")";
                statement.executeUpdate(sqlUpdate);
            }
            System.out.println("new item: " + name + " added");
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
