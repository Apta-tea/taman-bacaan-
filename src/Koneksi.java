
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fa
 */
public class Koneksi {

    Connection c;
    Statement s;
    ResultSet rs;
    String sql;
    PreparedStatement ps;
    public static Connection koneksi; //Koneksi

   /* public static Connection buka_koneksi() {
        if (koneksi == null) {
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection conn = DriverManager.getConnection("jdbc:ucanaccess://perpustakaan.accdb");
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Error membuat koneksi");
            }
        }
        return koneksi;
    }*/
    void setKoneksi(){
        try {
            //buat driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Error" + ex);
        }
        
        String url = "jdbc:ucanaccess://perpustakaan.accdb";
        try {
            c = DriverManager.getConnection("jdbc:ucanaccess://perpustakaan.accdb");
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
    }

    void readData() {
        try {
            s = c.createStatement();
            rs = s.executeQuery(sql);
        } catch (SQLException ex) {
            System.err.println("Error di create" + ex);
        }

    }

    void crud() {
        try {
            ps = c.prepareStatement(sql);
        } catch (SQLException ex) {
            System.err.println("Error di crud" + ex);
        }
    }
}
