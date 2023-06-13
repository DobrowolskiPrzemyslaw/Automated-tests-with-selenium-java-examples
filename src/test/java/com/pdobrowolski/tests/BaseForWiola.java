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
    protected void createDataBase_test() {

        String pathToDataBase = "C:/Users/User/Documents/";
        String nameDataBase = "wiola";
        String data_zEkranuDanych_kolumna_1 = "Ekran danych";
        String data_zEkranuDanych_kolumna_2 = "Ekran danych";
        String data_zEkranuDanych_kolumna_3 = "Ekran danych";
        String data_zEkranuWynikow = "Ekran wynikow";
        String tabelaDany_zEkranuDanych = "TABELA_EKRAN_DANYCH";
        String tabelaDany_zEkranuWynikow = "TABELA_EKRAN_WYNIKOW";
        String kolumna_1 = "kolumna_1";
        String kolumna_2 = "kolumna_2";
        String kolumna_3 = "kolumna_3";

        if(!czyIstniejPlikBazyDanych(pathToDataBase, nameDataBase)){
            stworzPlikBazyDanych(pathToDataBase, nameDataBase);
        }

        stworzTableZKolumnami(pathToDataBase, nameDataBase, tabelaDany_zEkranuDanych, kolumna_1, kolumna_2, kolumna_3);
//        stworzTableZKolumnami(pathToDataBase, nameDataBase, tabelaDany_zEkranuWynikow, kolumna_1, kolumna_2, kolumna_3);

//        zapiszDaneDoBazyDanych(pathToDataBase, nameDataBase, tabelaDany_zEkranuDanych, kolumna_1, data_zEkranuDanych_kolumna_1);
//        zapiszDaneDoBazyDanych(pathToDataBase, nameDataBase, tabelaDany_zEkranuDanych, kolumna_2, data_zEkranuDanych_kolumna_2);
//        zapiszDaneDoBazyDanych(pathToDataBase, nameDataBase, tabelaDany_zEkranuDanych, kolumna_3, data_zEkranuDanych_kolumna_3);
        czytajDaneKolumnyzBazyDanych(pathToDataBase, nameDataBase, tabelaDany_zEkranuDanych, kolumna_1);
    }

    private void stworzPlikBazyDanych(String path, String name) {
        String url = "jdbc:sqlite:"+path+name+".db";
        try {
            Connection connection = DriverManager.getConnection(url);
            System.out.println("Plik bazy danych został utworzony.");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Wystąpił błąd podczas tworzenia pliku bazy danych.");
            e.printStackTrace();
        }
    }

    public boolean czyIstniejPlikBazyDanych (String path, String name) {
        String sciezkaDoPliku = path+name+".db";
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

    public static void stworzTableZKolumnami(String path, String name, String tableName,
                                             String kolumna_1, String kolumna_2, String kolumna_3) {
        String url = "jdbc:sqlite:"+path+name+".db";

        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();

            String createTableQuery = "CREATE TABLE IF NOT EXISTS "+tableName+" ("
                    + kolumna_1 +" TEXT,"
                    + kolumna_2 +" TEXT,"
                    + kolumna_3 +" TEXT"
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


    public static void czytajDaneKolumnyzBazyDanych (String path, String name, String tableName, String columnName) {
        String url = "jdbc:sqlite:"+path+name+".db";

        try {
            Connection connection = DriverManager.getConnection(url);

            String selectQuery = "SELECT "+columnName+" FROM "+ tableName;
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
