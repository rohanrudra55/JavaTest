
/**
 * Write a description of Part4 here.
 * 
 * @author (Rohan Rudra) 
 * @version (26/1/21)
 */
import edu.duke.*;
import java.io.File;
public class Url {
public static void main(String args[]){
    System.out.println("start");
    URLResource ur=new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
    for(String s:ur.words()){
       
    String a=s.toLowerCase();
    if(a.indexOf("youtube.com")>-1){
        
        char c=34;
        int n=a.indexOf(c);
        int m=a.indexOf(c,n+1);
        
        if(m==a.indexOf(c,a.indexOf("youtube.com"))){
            System.out.println("links are:"+s.substring(n,m+1));
        }
        
    }
    }
}
}
