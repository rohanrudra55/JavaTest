
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class WeatherData {
    //PERSONAL METHOD:
     public static void main(String args[]){
        WeatherData ob=new WeatherData();
        System.out.println("---------------START----------------");
        ob.testFiles();
        System.out.println("---------------END----------------");
    }
    
public CSVRecord compare(CSVRecord currTemp,CSVRecord coldestTemp,String coloum){
    if(coldestTemp==null){
            coldestTemp=currTemp;
        }
            else{
                double coldestTempV=Double.parseDouble(coldestTemp.get(coloum));
                double currTempV=Double.parseDouble(currTemp.get(coloum));
                if(coldestTempV>currTempV){
                    coldestTemp=currTemp;
            }
}
return coldestTemp;
}
//EDND
    public void testFiles(){
        DirectoryResource dr=new DirectoryResource();
        for(File f: dr.selectedFiles()){
        //COLDEST TEMPERATURE   
     //String fileName= fileWithColdestTemperature();
     //System.out.println("The file with coldest temperature is"+fileName);
     FileResource fr=new FileResource(f);
        //COLDEST HOUR IN FILE
     //CSVParser colDparser= fr.getCSVParser();
     //CSVRecord temp=coldestHourInFile(colDparser);
     //System.out.println("Coldest temperature of the following day is "+temp.get("TemperatureF")+" at "+temp.get("DateUTC"));
        //LOW HUMIDITY 
     CSVParser loWparser= fr.getCSVParser();
     CSVRecord lowHumidity=lowestHumidityInFile(loWparser);
     System.out.println("Lowest Humidity was "+lowHumidity.get("Humidity")+" at "+lowHumidity.get("DateUTC"));
        //LOWEST HUMIDITY AMONG MULTIPLE FILES
     //lowestHumidityInMultipleFiles();
        //AVERAGE TEMPERATURE
     //CSVParser avGparser= fr.getCSVParser();
     //System.out.println("Average temperature is"+averageTemperatureInFile(avGparser));
        //AVERAGE TEMPERATURE OF HIGH HUMIDITY
     //CSVParser aVGparser= fr.getCSVParser();
     //System.out.println("Average temperature of high humidity "+ averageTemperatureWithHighHumidityInFile(aVGparser,80));

    }
}
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldestTemp=null;
        for(CSVRecord currTemp: parser){
            double currTempV=Double.parseDouble(currTemp.get("TemperatureF"));
            if(currTempV!=-9999){
          coldestTemp=compare(currTemp,coldestTemp,"TemperatureF");
    }
}
    return coldestTemp;

}
public String fileWithColdestTemperature(){
    String name=null;
    DirectoryResource dr=new DirectoryResource();
    CSVRecord coldestTemp=null,currTemp=null;
    File coldf=null;
    for(File currf: dr.selectedFiles()){
        FileResource fr=new FileResource(currf);
        currTemp=coldestHourInFile(fr.getCSVParser());
        coldestTemp=compare(currTemp,coldestTemp,"TemperatureF");
        if(coldf==null)
        coldf=currf;
        if(coldestTemp==currTemp)
            coldf=currf;
    
    }
    System.out.println("Coldest temperature is "+coldestTemp.get("TemperatureF"));
    return coldf.getName();

}

public CSVRecord lowestHumidityInFile(CSVParser parser){
    CSVRecord lowHum=null;
    String coloum="Humidity";
    for(CSVRecord currHum:parser){
        if(currHum.get(coloum).contains("N/A")){
        }
        
        else{ if(lowHum==null){lowHum=currHum;}
        else{
            lowHum=compare(currHum,lowHum,coloum);
        }
        }

    }
    return lowHum;
}
public void lowestHumidityInMultipleFiles(){
    CSVRecord lowHum=null;
    DirectoryResource dr=new DirectoryResource();
    for(File f: dr.selectedFiles()){
        FileResource fr=new FileResource(f);
        CSVRecord currHum=lowestHumidityInFile(fr.getCSVParser());
        if(lowHum==null){
        lowHum=currHum;
    }
        else {lowHum=compare(lowHum,currHum,"Humidity");}
    }
    System.out.println("Lowest Humidity is "+lowHum.get("Humidity")+" at "+lowHum.get("DateUTC"));
}
public double averageTemperatureInFile(CSVParser parser){
    double avgTemp=0.0;
    int c=0;
    for(CSVRecord temp:parser){
        avgTemp+=Double.parseDouble(temp.get("TemperatureF"));
        c++;
    }
    avgTemp=avgTemp/c;
    return avgTemp;
}
public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
    double avgTemp=0.0;int c=0;
    double hum=0.0;
    for(CSVRecord currHum: parser){
       if( currHum.get("Humidity")!="N/A"){
        hum=Double.parseDouble(currHum.get("Humidity"));
        if(hum>value){
            avgTemp+=Double.parseDouble(currHum.get("TemperatureF"));
            c++;
        }
        }
    }
        avgTemp=avgTemp/c;
    return avgTemp;
}
}
