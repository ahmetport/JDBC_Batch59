import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //ilk işlem driver yükle
        Class.forName("com.mysql.jdbc.Driver");

        //baglantı oluştur
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC","root","123987");
       // statement oluşturacagız : sql kodlarımızı ysazmak için nesne oluşturuyoruz
        Statement st=con.createStatement();

        //resultSet: sql sorguları oluşturacagız
       ResultSet veri= st.executeQuery("select * from ogrenciler");//select * from ogrenciler

        //sonuçları al
        while (veri.next()) {
            //index kullanarak aldık
            System.out.println(veri.getInt(1) + veri.getString(2)
                    + veri.getString(3) + veri.getString(4));
            //sutun ismi kullanarak yaptık
            System.out.println(veri.getInt("okul_no") + veri.getString("ogrenci_ismi")
                    + veri.getString("sinif") + veri.getString("cinsiyet"));
        }
            //kapatma
            con.close();
            st.close();
            veri.close();
    }
}
