
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String stringa,String stringb){
    if(stringb.indexOf(stringa)>-1){
        return ((stringb.indexOf(stringa,stringb.indexOf(stringa)))!=(-1));
    }
    else{
        return false;
    }
}
public void testing(){
    System.out.println("The part of the string after an in banana:");
    System.out.println(twoOccurrences("an", "banana"));
    System.out.println("The part of the string after zoo in forest:");
    System.out.println(twoOccurrences("zoo", "forest"));
}
public String lastPart(String stringa,String stringb){
if(twoOccurrences(stringa,stringb)==true){
    String a=stringb.substring((stringb.indexOf(stringa)),(stringb.indexOf(stringa,(stringb.indexOf(stringa)))));
    return a;
    
}
else return stringb;
}
}
