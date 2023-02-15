 
/**
 * Write a description of Part6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part6 {
int howMany(String stringa,String stringb){
    int c=0;
    int n=0;
    while(n<stringb.length()){
        if(stringb.indexOf(stringa,n)>-1){
            c++;
            n=n+stringa.length();
        }
        else{
            n++;
        }
    }
  
    return c;
}
void testHowMany(){
    FileResource fr=new FileResource("Dnatest.rtf");
    for(String line: fr.lines())
            System.out.println(howMany("CTG",line));
    
    System.out.println("No of occurence:"+howMany("AA","ATAAAAT"));
}
}
