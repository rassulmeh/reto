package hackatonbeta.Models;

package PkXC.models;
import hackatonbeta.Controllers.studentClass;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassDB {

    studentClass std = new studentClass();
    private final String Connection = "jdbc:mysql://localhost:3306/";
    private final String db = "hackathonBeta";
    private final String user = "root";
    private final String password = "";
    private final String tableName = "student";
    private Connection con;
    private Statement stmt;
    String query = "";

    public ClassDB() throws SQLException {
        ConnectToDataBase();
        CreateDB();
        CreateTable();
        ReadTable();
        DeleteTable();
        UpdateTable();
    }

    public void ConnectToDataBase() {
        try {
            con = DriverManager.getConnection(Connection, user, password);
            System.out.println("Connect OK");
        } catch (SQLException ex) {
            System.out.println("Error Connection");
        }
    }

    public void CreateDB() {
        query = "CREATE DATABASE IF NOT EXISTS " + db;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("CREATE DB OK");
        } catch (SQLException ex) {
            System.out.println("CREATE DB NOT OK");
        }
    }

    private void CreateTable() {
        query = "CREATE TABLE IF NOT EXISTS " + db + "." + tableName + "( `id` INT(15) NOT NULL , `nombre` VARCHAR(50) NOT NULL , `apellido` VARCHAR(50) NOT NULL, `edad` INT(3) NOT NULL,`curso` VARCHAR(50) NOT NULL ) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_spanish_ci;";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("CREATE TABLE OK");

        } catch (SQLException ex) {
            System.out.println("CREATE TABLE NOT OK");
        }
    }

    private void ReadTable() {
        query = "SELECT * FROM " + db + "." + tableName;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            System.out.println();
            System.out.println("READ OK");
        } catch (SQLException ex) {
            System.out.println("READ NOT OK");
        }
    }

    private void UpdateTable() throws SQLException {
        query = "UPDATE " + tableName + " SET id=" + std.getId() + ",nombre='" + std.getName() + "', apellido='" + std.getSurname() + "', edad=" + std.getAge() + ", curso='" + std.getCourse() + "' WHERE id=" + std.getId() + ";";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            int n = stmt.executeUpdate(query);
            System.out.println("filas  Modificadas: " + n);
        } catch (SQLException e) {
            System.out.println("bd No Modificada");
        } finally {
            stmt.close();
        }
    }

    private void DeleteTable() throws SQLException {
        query = "DELETE FROM " + tableName + " WHERE id=" + std.getId() + ";";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            int n = stmt.executeUpdate(query);
            System.out.println("filas  Borradas:" + n);
        } catch (SQLException e) {
            System.out.println("fila No borrada");
        } finally {
            stmt.close();
        }
    }

    public void insertStd(studentClass std) throws SQLException {
        query = "INSERT INTO " + db + "." + tableName
                + " (id, name, surname, age, course) VALUES (" + std.getId()
                + ", '" + std.getName() + "', '"
                + std.getSurname() + "', '"
                + std.getAge() + "', "
                + std.getCourse() + ");";

        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Std inserted!");
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    }
}
