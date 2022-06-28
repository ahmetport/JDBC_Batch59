import java.sql.*;

public class Query02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC", "root", "123987");
        Statement st = con.createStatement();

        //soru ogrenciler tablosundaki erkek ögrencilerin bilgilerini getirin
        ResultSet veri = st.executeQuery("select * from ogrenciler where cinsiyet = 'E'");
        while (veri.next()) {
            System.out.println(veri.getInt(1) + veri.getString(2) + veri.getString(3)
                    + veri.getString(4));
        }
        // SORU02: ÖĞRENCİLER TABLOSUNDAKİ  9. SINIF KIZ ÖĞRENCİ BİLGİLERİ GETİRİN
        System.out.println("*********************************************************");
        ResultSet veri2 = st.executeQuery("select * from ogrenciler where sinif=9 and cinsiyet='K'");

        while (veri2.next()) {
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", veri2.getInt(1), veri2.getString(2),
                    veri2.getString(3), veri2.getString(4));

        }
        con.close();
        st.close();
        veri.close();
        veri2.close();
    }
}