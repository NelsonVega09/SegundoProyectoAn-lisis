/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectarsql;

import java.lang.*;
import java.util.*;
import java.sql.*;

public class DBConect {

    public String url = null;
    protected String database = null;
    protected String userID = null;
    protected String password = null;
    protected String DBUrl;
    protected String theDriver = null;
    protected Connection theConnection;
    protected Statement theStatement;
    protected ResultSet theResultSet;
    public StringBuffer messages;
    protected int numMessages = 0;

    public DBConect() {
    }

    public DBConect(String db) {
        database = db;
    }

    public DBConect(String db, String uid) {
        database = db;
        userID = uid;
    }

    public DBConect(String db, String uid, String pw) {
        database = db;
        userID = uid;
        password = pw;
    }

    public Connection makeConnection() {
        messages = new StringBuffer("");
        // check for existing connection
        if (theConnection != null) {
            return theConnection;
        }

        DBUrl = url + database;
        try {
            Class.forName(theDriver);
        } catch (Exception e) {
            messages.append("Message[" + (numMessages++) + "]: (DBmanager) ");
            messages.append(e.getMessage() + "\n");
            //System.exit(-1);
            return null;
        }
        Properties connectInfo = null;

        if (userID != null) {
            connectInfo = new Properties();
            connectInfo.put("user", userID);
            if (password != null) {
                connectInfo.put("password", password);
            }
        }
        try {
            //System.out.println("url = " + DBUrl);
            if (connectInfo == null) {
                theConnection = DriverManager.getConnection(DBUrl);
            } else {
                theConnection = DriverManager.getConnection(DBUrl, connectInfo);
            }
            DatabaseMetaData meta = theConnection.getMetaData();
            System.out.println("Connected to database, with user: " + meta.getUserName());

        } catch (Exception e) {
            e.printStackTrace();
            //System.exit(-1);
            return null;
        }

        return theConnection;
    }

    public String showdatabase() {
        return database;
    }

    public void setUrl(String newUrl) {
        url = newUrl;
    }

    public void setDatabase(String newDatabase) {
        database = newDatabase;
    }

    public void setUserID(String newUserID) {
        userID = newUserID;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public void setDriver(String newDriver) {
        theDriver = newDriver;
    }

    public String getUrl() {
        return url;
    }

    public String getDatabase() {
        return database;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String getDriver() {
        return theDriver;
    }

    public Statement getStatement() {
        if (theConnection == null) {
            return null;
        }
        if (theStatement == null) {
            try {
                theStatement = theConnection.createStatement();
            } catch (SQLException sqle) {
                messages.append("Message[" + (numMessages++) + "]: (SQL error) ");
                messages.append(sqle.getMessage() + "\n");
            }
        }
        return theStatement;
    }

    public Connection getConnection() {
        if (theConnection == null) {
            theConnection = makeConnection();
        }
        return theConnection;
    }

    public void makeNewConnection() {
        makeConnection();
    }

    public void makeNewStatement() {
        if (theConnection == null) {
            makeConnection();
        }
        try {
            theStatement = theConnection.createStatement();
        } catch (SQLException sqle) {
            messages.append("Message[" + (numMessages++) + "]: (SQL error) ");
            messages.append(sqle.getMessage() + "\n");
        }
    }

    public String getField(String sqlStatement) {
        String theElement = "";
        try {
            theResultSet = theStatement.executeQuery(sqlStatement);
            if (!theResultSet.next()) {
                return null;
            }
            theElement = theResultSet.getObject(1).toString();
        } catch (SQLException sqle) {
            messages.append("Message[" + (numMessages++) + "]: (SQL error) ");
            messages.append(sqle.getMessage() + "\n");
            return null;
        }
        return theElement;
    }

    public ResultSet SelectQuery(final String queryString, final List<String> argument) {
        try {
            PreparedStatement preparedStatement = theConnection.prepareStatement(queryString);
            for (int i = 0; argument != null && i < argument.size(); i++) {
                preparedStatement.setString(i, argument.get(i));
            }
            ResultSet result = preparedStatement.executeQuery();
            /*while (result.next()) {
             StringBuilder row = new StringBuilder();
             row.append("[" + result.getString(1) + ", ");
             row.append(result.getString(2) + "]");
             System.out.println(row.toString());
             }*/
            return result;
        } catch (SQLException e) {
            messages.append("Message[" + (numMessages++) + "]: (SQL error) ");
            messages.append(e.getMessage() + "\n");
        }
        return null;
    }

    public void InsertQuery(final String queryString, final ArrayList<String> arguments) {
        try {
            PreparedStatement preparedStatement = theConnection.prepareStatement(queryString);
            int i = 0;
            while (arguments != null && arguments.size() > 0 && i < arguments.size()) {
                preparedStatement.setString(i+1, arguments.get(i));
                //preparedStatement.setString(2, arguments.get(1));
                i++;
            }
            System.out.println("executing: " + preparedStatement.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            messages.append("Message[" + (numMessages++) + "]: (SQL error) ");
            messages.append(e.getMessage() + "\n");
        }
    }

    public StringBuffer getMessages() {
        return messages;
    }

    public void printMessages() {
        System.out.println(messages.toString());
    }

    public void closeConnection() {
        try {
            if (theConnection != null) {
                theConnection.close();
            }
            theConnection = null;
        } catch (SQLException e) {
            messages.append("Message[" + (numMessages++) + "]: (SQL error) ");
            messages.append(e.getMessage() + "\n");
        }
    }
}
