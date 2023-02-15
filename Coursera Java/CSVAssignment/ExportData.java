
import edu.duke.*;
import org.apache.commons.csv.*;

public class ExportData {
    public static void main(String args[]){
        ExportData ob=new ExportData();
        System.out.println("---------------START----------------");
        ob.tester();
    }
    public void tester(){
        FileResource fr=new FileResource("exportdata.csv");
        CSVParser parser0= fr.getCSVParser();
        //countryInfo(parser0,"Nauru");
        CSVParser parser1= fr.getCSVParser();
        //listExpoterstwoProducts(parser1,"flowers","cotton");
        CSVParser parser2= fr.getCSVParser();
        int n=numberOfExporters(parser2,"cocoa");
        CSVParser parser3= fr.getCSVParser();
        //bigExports(parser3,"$999,999,999,999");
        
    }
    public void countryInfo(CSVParser parser, String country){
        for(CSVRecord record: parser){
            String infoCountry=record.get("Country");
            if(infoCountry.contains(country)){
                String infoExport=record.get("Exports");
                String infoValue=record.get("Value (dollars)");
            System.out.println(infoCountry+": "+infoExport+": "+infoValue);
        }
    }
    }
    public void listExpoterstwoProducts(CSVParser parser, String exportItem1,String exportItem2){        
        for(CSVRecord record: parser){
            String infoItem=record.get("Exports");
            if(infoItem.contains(exportItem1)&&infoItem.contains(exportItem2)){
                String infoCountry=record.get("Country");
                System.out.println(infoCountry);
            }
        }
    }
    public int numberOfExporters(CSVParser parser, String exportItem){
        int c=0;
        for(CSVRecord record: parser){
            String infoE=record.get("Exports");
            if(infoE.contains(exportItem)){
                c++;
    }
}
    System.out.println("Item "+exportItem+" occurs: "+c);
    return c;
}
    public void bigExports(CSVParser parser,String amount){
        for(CSVRecord record: parser){
            String infoA=record.get("Value (dollars)");
            if(infoA.length()>amount.length())
            System.out.println(record.get("Country")+" "+infoA);
    }
}
}
        


