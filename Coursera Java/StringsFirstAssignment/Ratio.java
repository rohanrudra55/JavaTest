

import edu.duke.*;
public class Ratio {
public void cgRatio(String dna){
    int a=howMany("C",dna);
    System.out.println(a);
    int b=howMany("G",dna);
    float c=((float)a+b)/(dna.length());
    System.out.println("cgRatio:"+c); 
}
int howMany(String stringa,String stringb){
    int c=0;
    for(int n=0;n<stringb.length();){
        if(stringb.indexOf(stringa,n)>-1){
            c++;
            n=stringa.length()+stringb.indexOf(stringa,n);
        }
        else{
            
            n++;
        }
    }
    return c;
}
public int find(char a,String dna){
    int c=0;
    for(int i=0;i<dna.length();i++){
        if(dna.charAt(i)==a)
        c++;
}
return c;
}
void test(){
    FileResource fr=new FileResource("Dnatest.rtf");
   for(String line: fr.lines()){
       System.out.println(howMany("CTG",line));
           // cgRatio("ATGAAATTGACACAACAACAACAACAACAAAAATACAAAACATAAC");
        }
}
}
