import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query06 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "123987");
        Statement st = con.createStatement();

        // SORU1: Bölümler tablosunda yeni bir kayıt (80, 'ARGE', 'ISTANBUL')
        //int s1= st.executeUpdate("insert into bolumler values (80, 'ARGE', 'İSTANBUL')");
        //System.out.println(s1+ "satır ekelendi");

//st.addBatch :verilerin hepsini bir araya toplar ikinci yolla böyle yapılıyor
//st.executeBatch: bir araya gelen verileri tek seferde döndürür
       // String[] veri1 = {"insert into bolumler values (95, 'YEMEKHANE', 'ISTANBUL')",
               // "insert into bolumler values (85, 'OFIS1', 'ANKARA')"};
       // int count = 0;
       // for (String each : veri1) {
           // count = count + st.executeUpdate(each);
       // }
       // System.out.println(count + "data eklendi");
        {
        }

        // SORU3; Bölümler tablosuna birden fazla kayıt ekleyelim.
        String[] veri3 = {"insert into bolumler values (100, 'YEMEKHANE', 'ISTANBUL')",
                "insert into bolumler values (101, 'OFIS1', 'ANKARA')",
                "insert into bolumler values (102, 'OFIS2', 'TRABZON')",
                "insert into bolumler values (103, 'OFIS2', 'TRABZON')",
                "insert into bolumler values (104, 'OFIS2', 'TRABZON')"};

        for (String each : veri3) {
            st.addBatch(each);
        }
        st.executeBatch();

        System.out.println("Veriler database eklendi");

    }

}



