package com.pdobrowolski.tests;

import org.testng.annotations.*;
import java.awt.*;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class BaseForWiola {

    @Test
    protected void tearDown() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        int count = 0;
        while (true){
            robot.mouseMove(0,0);
            Thread.sleep(60000);
            System.out.println(count++);
        }
    }

    @Test
    protected void tearDown2() {
        System.out.print("Wprowadź dane do zapisania: ");
        String dane = "Dane";

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:baza_danych.db");

            // Zapisywanie danych
            String insertQuery = "INSERT INTO dane (dane) VALUES (?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, dane);
            insertStatement.executeUpdate();
            insertStatement.close();

            // Odczytywanie danych
            String selectQuery = "SELECT * FROM dane";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String daneZBazy = resultSet.getString("dane");
                System.out.println("ID: " + id + ", Dane: " + daneZBazy);
            }

            resultSet.close();
            selectStatement.close();

            connection.close();
        } catch (SQLException e) {
            System.out.println("Wystąpił błąd podczas operacji na bazie danych.");
            e.printStackTrace();
        }
    }

    private void createDataBase(String path, String name) {
        String url = "jdbc:sqlite:/+"+path+"/"+name+".db";
        try {
            Connection connection = DriverManager.getConnection(url);
            System.out.println("Plik bazy danych został utworzony.");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Wystąpił błąd podczas tworzenia pliku bazy danych.");
            e.printStackTrace();
        }
    }

    public boolean checkSQLiteFile (String path, String name) {
        String sciezkaDoPliku = path+"/"+name+".db";
        boolean checkSQLiteFile = false;
        File plik = new File(sciezkaDoPliku);
        if (plik.exists()) {
            checkSQLiteFile = true;
            System.out.println("Plik bazy danych istnieje.");
        } else {
            System.out.println("Plik bazy danych nie istnieje.");
        }
        return checkSQLiteFile;
    }

    public static void saveDataToDatabase(String pathToDatabase, String data) {
        String url = "jdbc:sqlite:"+pathToDatabase;

        try {
            Connection connection = DriverManager.getConnection(url);

            String insertQuery = "INSERT INTO table_name (column_name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.setString(1, data);
            statement.executeUpdate();

            statement.close();
            connection.close();

            System.out.println("Data saved to the SQLite database.");
        } catch (SQLException e) {
            System.out.println("Error saving data to the SQLite database.");
            e.printStackTrace();
        }
    }

    public static void readDataFromDatabase (String pathToDatabase, String tableName, String columnName) {
        String url = "jdbc:sqlite:"+pathToDatabase;

        try {
            Connection connection = DriverManager.getConnection(url);

            String selectQuery = "SELECT * FROM "+ tableName;
            PreparedStatement statement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String data = resultSet.getString(columnName);
                System.out.println("Data: " + data);
            }

            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("Data read from the SQLite database.");
        } catch (SQLException e) {
            System.out.println("Error reading data from the SQLite database.");
            e.printStackTrace();
        }
    }

    public static void readDataByIdFromDatabase(String pathToDatabase, String tableName,int id, String columnName) {
        String url = "jdbc:sqlite:"+pathToDatabase;

        try {
            Connection connection = DriverManager.getConnection(url);

            String selectQuery = "SELECT * FROM "+tableName+" WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(selectQuery);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String data = resultSet.getString(columnName);
                System.out.println("Data for ID " + id + ": " + data);
            } else {
                System.out.println("No data found for ID " + id);
            }

            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("Data read from the SQLite database.");
        } catch (SQLException e) {
            System.out.println("Error reading data from the SQLite database.");
            e.printStackTrace();
        }
    }

    public ArrayList getColumnValuesFromDatabase() {
        ArrayList  columnValues = new ArrayList<>();
        String url = "jdbc:sqlite:path/to/database/file.db";

        try {
            Connection connection = DriverManager.getConnection(url);

            String selectQuery = "SELECT column_name FROM table_name";
            PreparedStatement statement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String value = resultSet.getString("column_name");
                columnValues.add(value);
            }

            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("Column values retrieved from the SQLite database.");
        } catch (SQLException e) {
            System.out.println("Error retrieving column values from the SQLite database.");
            e.printStackTrace();
        }
        return columnValues;
    }

    public static ArrayList<String> getRecordValuesFromDatabase() {
        ArrayList<String> recordValues = new ArrayList<>();
        String url = "jdbc:sqlite:path/to/database/file.db";

        try {
            Connection connection = DriverManager.getConnection(url);

            String selectQuery = "SELECT * FROM table_name";
            PreparedStatement statement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = statement.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String value = resultSet.getString(i);
                    recordValues.add(value);
                }
            }

            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("Record values retrieved from the SQLite database.");
        } catch (SQLException e) {
            System.out.println("Error retrieving record values from the SQLite database.");
            e.printStackTrace();
        }

        return recordValues;
    }
}
