public class Query10 extends DatabaseUtılıty{
    public static void main(String[] args) {

        createConnection();

        String query="select * from ogrenciler";

        System.out.println("sutun isimleri: "+getColumnNames(query));
        System.out.println("okul no: "+ getColumnData(query,"okul_no"));
        System.out.println("ogrencı ismi: "+ getColumnData(query,"ogrenci_ismi"));
        System.out.println("sinif: "+ getColumnData(query,"sinif"));
        System.out.println("cinsiyet: "+ getColumnData(query,"cinsiyet"));
        System.out.println("cinsiyet: "+ getColumnData(query,"ORANGE"));


    }
}
