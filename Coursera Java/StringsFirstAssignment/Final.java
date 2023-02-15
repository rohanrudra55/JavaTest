import edu.duke.*;
import java.util.*;
public class Final{
    
    public void processGenes(StorageResource sr){
        int currIndex=0,a=0,b=0,c=0,g=0,l=0,n=0;
    for(String line:sr.data()){
        while(true){
            String currGene=findGene(line,currIndex);
            if(currGene==" ")
                break;
            
    currIndex=line.indexOf(currGene, currIndex)+currGene.length();
      //System.out.println(currGene);     
    b++;
            
    if(cgRatio(currGene)>0.35){
        //System.out.println(cgRatio(currGene)+"  "+a);
        a++;
    }
    

    if(currGene.length()>9)
        c++;
    
    if(currGene.length()>60)
        g++;
    
    l=Math.max(l,currGene.length());
    
    } 
    n=n+howMany("CTG",line);
}
    System.out.println("Number of genes more than length 60: "+g);
    //System.out.println("Number of genes: "+b);
    System.out.println("Strings larger than length 9: "+c);
    System.out.println("Number of cgRatio greater than 0.35: "+a+"ERROR");
    System.out.println("Longest gene length: "+l);
    System.out.println("CTG occures: "+n);
}int howMany(String stringa,String stringb){
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
public float cgRatio(String dna){
    int c=howMany("C",dna);
    int g=howMany("G",dna);
    float ratio=((float)(c+g))/(dna.length());
    //System.out.println(dna+"/n"+ratio);
    return ratio;
}
/*public int find(Char a,String mainDna){
    String dna=mainDna.toUpperCase();
    int c=0;
    for(int i=0;i<dna.length();i++){
        if(dna.charAt(i)==a)
        c++;
}
return c;
}*/

public String findGene(String mainDna,int where){
    String dna=mainDna.toUpperCase();
    int len=mainDna.length();
 int startIndex=dna.indexOf("ATG",where);
 int i=0;
 if(startIndex==-1){
     return (" ");
     }
     else{
         int pos1=findStopCodon(dna,startIndex,"TAA");
         int pos2=findStopCodon(dna,startIndex,"TAG");
         int pos3=findStopCodon(dna,startIndex,"TGA");
         if(pos1!=len||pos2!=len||pos3!=len){
         int near=Math.min(Math.min(pos1,pos2),pos3);
         //System.out.println(near);
         if(near==len-2)
         return (mainDna.substring(startIndex,near+1)+mainDna.charAt(len+1)+mainDna.charAt(len+2));
         return mainDna.substring(startIndex,near+3);
}
return " ";
}
}

public int findStopCodon(String dna, int startIndex,String stopCodon){
    int currIndex=startIndex+3,d=0;
    
    while(currIndex!=-1){
         currIndex=dna.indexOf(stopCodon,currIndex+1);
         d=currIndex-startIndex;
           if((d%3==0)&&(currIndex!=-1))
               return currIndex;

}
  return dna.length(); 
 }   

public void testProcessgenes(){
    FileResource fr = new FileResource("GRch38dnapart.fa");
    String dna = fr.asString();
    StorageResource sr=new StorageResource();
    sr.add(dna);
    sr.add(" ");
    processGenes(sr);
}
public static void main(String args[]){
    System.out.println("--------------Start--------------");
    Final ob=new Final();
    ob.testProcessgenes();
    System.out.println("---------------End--------------");
}
}