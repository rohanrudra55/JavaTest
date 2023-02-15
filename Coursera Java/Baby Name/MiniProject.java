
import java.io.*;
import java.util.*;
import edu.duke.*;
import org.apache.commons.csv.*;

public class MiniProject {
    //PERSONAL METHOD:
     public static void main(String args[]){
        MiniProject ob=new MiniProject();
        System.out.println("---------------START----------------");
        ob.test();
        System.out.println("---------------END----------------");
    }
    public void test(){
        Scanner sc=new Scanner(System.in);
       /* {
        //TOTAL BIRTHS:
        DirectoryResource dr= new DirectoryResource();
        for(File f:dr.selectedFiles()){
           FileResource fr=new FileResource(f);
           totalBirths(fr);
    }
}
    {
            //GET RANK
        System.out.println("Enter the year, name and gender to find rank");
        String year=sc.nextLine();
        String name=sc.nextLine();
        String gender=sc.nextLine();
        System.out.println("The rank of the input is"+getRank(year, name, gender));
    }
    {

    //GET NMAE
        System.out.println("Enter the year, gender and rank to find name");
        String year=sc.nextLine();
        String gender=sc.nextLine();
        int rank=sc.nextInt();
        //String gender=sc.nextLine();
        //System.out.println(rank+"-"+gender+"-"+rank);
        System.out.println("The name of the input is"+getName(year, rank, gender));
    }
   /* {

    //WHAT IS NAME IN YEAR
        System.out.println("Enter the year, name and gender to find the name in another desire year:");
        String year=sc.nextLine();
        String name=sc.nextLine();
        String gender=sc.nextLine();
        String year2=sc.nextLine();
        whatIsNameInYear(name, year,year2,gender);
    }
    {
        
            //YEAR OF HIEGHEST RANK
        System.out.println("Enter the name and gender and select the files to find year of highest rank and average");
        String name=sc.nextLine();
        String gender=sc.nextLine();
        //System.out.println("The year of heighest rank of the input is"+
        yearOfHighestRankAndAvgRank(name, gender);
    }
    {
        
            //GET TOTAL BIRTHS RANKED HIGHER
        System.out.println("Enter the year, name and gender to find total births ranked higher");
        int year=sc.nextInt();
        String name=sc.nextLine();
        String gender=sc.nextLine();
       getTotalBirthsRankedHigher(year, name, gender);
    }*/
}
    
    //END
    public void totalBirths(FileResource fr){
        int totalBirths=0;
        int boys=0;
        int girls=0;
        for(CSVRecord currName:fr.getCSVParser(false)){
            int currBirths=Integer.parseInt(currName.get(2));
            totalBirths+=currBirths;
            String gender=currName.get(1);
            if(gender.equals("F")){
                girls++;
            }
            if(gender.equals("M")){
                boys++;
            }
        }
        System.out.println("Total number of boys "+boys+" and "+"girls "+girls);
        System.out.println("Total number of births in the selceted file is "+totalBirths);
}
public void testGetRank(String year, String name,String gender){
    System.out.println("The rank of the input is"+getRank(year, name, gender));
}
public int getRank(String year, String name,String gender){
    int rank=1,birth=0,lastBirth=0;
    FileResource fr=new FileResource("yob"+year+".csv");
    for(CSVRecord currInfo:fr.getCSVParser(false)){
        String currGender=currInfo.get(1);
        String currName=currInfo.get(0);
        if(currGender.contains(gender)&&currName.equals(name)){
            birth=Integer.parseInt(currInfo.get(2));
            break;
        }
    }
    System.out.println(birth);
    if(birth==0)
      return -1;
     for(CSVRecord currInfo:fr.getCSVParser(false)){
         String currGender=currInfo.get(1);
         int currBirth=Integer.parseInt(currInfo.get(2));
         String currName=currInfo.get(0);
         if(currGender.contains(gender)&&(currName.equals(name)==false)){
             if(currBirth>=birth){
                 rank++;
                 lastBirth=currBirth;
                }
            }
        }
        return rank;
    }
    
  
  public void testGetName(String year,int rank,String gender){
      System.out.println("The name of the input is"+getName(year, rank, gender));
    }
    public String getName(String year,int rank,String gender){  
      int currRank=0,c=0;
      FileResource fr=new FileResource("yob"+year+".csv");
        for(CSVRecord extractRank:fr.getCSVParser(false)){
            String currName=extractRank.get(0);
            String currGender=extractRank.get(1);
            if(currGender.equals(gender)){
                c++;
                if(c<rank)
                continue;
                currRank=getRank(year,currName,gender);
                if(currRank==rank){
                    return currName;
            }
        }
    }
  return "NO";
}
  public void whatIsNameInYear(String name,String year,String newYear,String gender){
      //System.out.println(year+ "" +newYear);
    int rank=getRank(year,name,gender);
          //System.out.println(rank);
    String newName=getName(newYear,rank,gender);
    System.out.println("In the year "+newYear+" the give name will be renamed to "+newName);
    
}
public void yearOfHighestRankAndAvgRank(String name,String gender){
    String finalYear =" "; int finalRank=0,allRank=0,c=0;
    DirectoryResource dr= new DirectoryResource();
        for(File f:dr.selectedFiles()){
            FileResource fr=new FileResource(f);
           for( CSVRecord currInfo: fr.getCSVParser(false)){
            String currYear=f.getName();
            currYear=currYear.substring(3,7);
            //System.out.println(currYear);
            if(currInfo.get(1).equals(gender)){
                if(currInfo.get(0).equals(name)){
                    c++;
                    int currRank=getRank(currYear,name,gender);
                    allRank+=currRank;
                    if(finalRank==0){
                    finalRank=currRank;
                    finalYear=currYear;
                }
                else{
                    if(finalRank>currRank){
                      finalRank=currRank;
                      finalYear=currYear;
                    }
                }
        }
    }
    }
}
    if(finalRank==0){
        finalRank=-1;
    
}
    System.out.println("The year of heighest rank is "+finalYear);
    System.out.println("The average rank is "+(((double)allRank)/c));
}


public void getTotalBirthsRankedHigher(int year, String name,String gender){
    int totalBirths=0;
    String yearS=Integer.toString(year);
    int rank=getRank(yearS,name,gender);
    //System.out.println(yearS+" "+rank);
   // DirectoryResource dr= new DirectoryResource();
        //for(File f:dr.selectedFiles()){
            FileResource fr=new FileResource("yob"+year+".csv");
           for( CSVRecord currInfo: fr.getCSVParser(false)){
               if((currInfo.get(1)).equals(gender)){
               int currRank=getRank(yearS,(currInfo.get(0)),gender);
              // System.out.println(currInfo.get(0));
               if((currRank<=rank)&&((currInfo.get(0).equals(name))==false)){
                   System.out.println(currInfo.get(0)+""+currRank);
               totalBirths+=Integer.parseInt(currInfo.get(2));
            }
            }
       // }
    }
    System.out.println("Total births of higher ranked:"+totalBirths);
}


}
