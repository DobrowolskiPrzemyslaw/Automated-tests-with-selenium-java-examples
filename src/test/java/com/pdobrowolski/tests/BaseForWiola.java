package com.pdobrowolski.tests;

import org.testng.annotations.*;
import java.awt.*;
import java.io.File;
import java.sql.*;

public class BaseForWiola {

    @Test
    protected void tearDown() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        int count = 0;
        while (true) {
            robot.mouseMove(0, 0);
            Thread.sleep(600000);
            System.out.println(count++);
        }
    }

    @Test
    protected void createDataBase_test() {
        String path = "C:/Users/User/Documents/WIOLA.db";
        String tableName = "TABELA_DATA_SCREEN";
        String columnName = "column_1";
        String value = "Data screen";
        if (!czyIstniejPlikBazyDanych(path)) {
            stworzPlikBazyDanych(path);
            createTableWithColumn(path, tableName, columnName);
        }
        clearTable(path, tableName);
        setValueToColumn(path, tableName, columnName, value);
        getValueFromColumn(path, tableName, columnName);
        deleteSQLiteDatabase(path);
    }

    @Test
    protected void createDataBase_test2() {
        String path = "C:/Users/User/Documents/WIOLA2.db";
        String tableName = "TABELA_DATA_SCREEN";
        String columnName1 = "NAZWA RECEPTURY";
        String columnName2 = "NAZWA SKLADNIKA";
        String value1 = "Receptura1";
        String value2 = "Skladni1";
        if (!czyIstniejPlikBazyDanych(path)) {
            stworzPlikBazyDanych(path);
            createTableWithColumns(path, tableName, columnName1, columnName2);
        }
        clearTable(path, tableName);
        setValueToColumns(path, tableName, columnName1, columnName2, value1, value2);
        getValueFromColumns(path, tableName, columnName1, columnName2);
        deleteSQLiteDatabase(path);
    }

    private void stworzPlikBazyDanych(String path) {
        String url = "jdbc:sqlite:" + path;
        try {
            Connection connection = DriverManager.getConnection(url);
            System.out.println("The database file has been created.");
            connection.close();
        } catch (SQLException e) {
            System.out.println("An error occurred while creating the database file.");
            e.printStackTrace();
        }
    }

    public boolean czyIstniejPlikBazyDanych(String path) {
        boolean checkSQLiteFile = false;
        File file = new File(path);
        if (file.exists()) {
            checkSQLiteFile = true;
            System.out.println("The database file exists.");
        } else {
            System.out.println("The database file doesn't exists.");
        }
        return checkSQLiteFile;
    }

    public static void createTableWithColumn(String path, String tableName, String columnName) {
        String url = "jdbc:sqlite:" + path;
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                    + columnName + " TEXT"
                    + ")";
            statement.executeUpdate(createTableQuery);
            statement.close();
            connection.close();
            System.out.println("Table created in the SQLite database.");
        } catch (SQLException e) {
            System.out.println("Error creating table in the SQLite database.");
            e.printStackTrace();
        }
    }

    public static void createTableWithColumns(String path, String tableName, String columnName1, String columnName2) {
        String url = "jdbc:sqlite:" + path;
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                    + columnName1 + " TEXT,"
                    + columnName2 + " TEXT"
                    + ")";
            statement.executeUpdate(createTableQuery);
            statement.close();
            connection.close();
            System.out.println("Table created in the SQLite database.");
        } catch (SQLException e) {
            System.out.println("Error creating table in the SQLite database.");
            e.printStackTrace();
        }
    }

    public void setValueToColumn(String path, String tableName, String columnName, String value1) {
        Connection conn = connectDatabase(path);
        String insertQuery = "INSERT INTO "+tableName+" ("+ columnName +") VALUES (?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, value1);
            pstmt.executeUpdate();
            System.out.println("The values have been added to the table.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }

    public void setValueToColumns(String path, String tableName, String columnName1, String columnName2, String value1, String value2) {
        Connection conn = connectDatabase(path);
        String insertQuery = "INSERT INTO "+tableName+" ("+ columnName1 +","+ columnName2+") VALUES (?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, value1);
            pstmt.setString(2, value2);
            pstmt.executeUpdate();
            System.out.println("The values have been added to the table.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }

    public void getValueFromColumn(String path, String tableName, String columnName) {
        Connection conn = connectDatabase(path);
        String selectQuery = "SELECT " + columnName + " FROM " + tableName;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);
            while (rs.next()) {
                String value1 = rs.getString(columnName);
                System.out.println("Displayed value 1 from database: " + value1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }

    public void getValueFromColumns(String path, String tableName, String columnName1, String columnName2) {
        Connection conn = connectDatabase(path);
        String selectQuery = "SELECT " + columnName1 +","+columnName2 + " FROM " + tableName;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);
            while (rs.next()) {
                String value1 = rs.getString(columnName1);
                String value2 = rs.getString(columnName2);
                System.out.println("Displayed value from "+columnName1+": " + value1);
                System.out.println("Displayed value from "+columnName2+": " + value2);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }

    public void clearTable(String path, String tableName) {
        Connection conn = connectDatabase(path);
        String deleteQuery = "DELETE FROM " + tableName;
        try {
            Statement stmt = conn.createStatement();
            int rowsAffected = stmt.executeUpdate(deleteQuery);
            System.out.println("Cleared " + rowsAffected + " rows from the table.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }

    public void deleteSQLiteDatabase(String path) {
        File databaseFile = new File(path);
        if (databaseFile.exists()) {
            boolean deleted = databaseFile.delete();
            if (deleted) {
                System.out.println("The database has been successfully deleted.");
            } else {
                System.out.println("Failed to delete the database.");
            }
        } else {
            System.out.println("The database file does not exist.");
        }
    }

    public Connection connectDatabase(String path){
        String url = "jdbc:sqlite:" + path;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void closeConnection(Connection conn){
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
