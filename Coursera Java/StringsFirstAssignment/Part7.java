
public class Part7 {

public int findStopCodon(String dna, int startIndex,String stopCodon){
    int a=-1,d=0;startIndex++;
    while(a<0){
     if(startIndex<dna.length()-1){
         a=dna.indexOf(stopCodon,startIndex++);
         d=a-startIndex;
           if((d%3==0)&&(a>-1)){
               return a;
    }
    else{
        a=-1;
    }
}
else{
    return dna.length();
}
}  
return dna.length(); 
 }   
public void testFindStopCodon(){
System.out.println("The index of stopCodon is:"+findStopCodon("AATGTRGTATATAGTAATG",3,"ATG"));
}
public String findGene(String dna){
 int a=dna.indexOf("ATG");
 if(a==-1){
     return " ";}
     else{
     int b=findStopCodon(dna,a,"TAA");
     int c=findStopCodon(dna,a,"TAG");
     if(b<c){
         return (b!=dna.length())?dna.substring(a,b+3):" ";
        }
        else
         return (c!=dna.length())?dna.substring(a,c+3):" ";   
        }
}
void testFindGene(){
    printAllGenes("ATGTAAGATGCCCTAGT");
    System.out.println();
}
void printAllGenes(String dna){
    int a=0;
    while(a<dna.length()){
        String ans=findGene(dna.substring(a,dna.length()));
       System.out.println(ans);
       a=a+ans.length();
}
}
int countGenes(String dna){
    int a=0,c=0;
    while(a<dna.length()){
   String ss= findGene(dna.substring(a++,dna.length()));
   if(ss.equals(" ")){
       a++;  
    }
    else{
        a=a+ss.length();
        c++;
    }
}
    return c;
}
void testcountGenes(){
    System.out.println(countGenes("ATGTAAGATGCCCTAGT"));
}
void coursera(){
    String dna = "CTGCCTGCATGATCGTA";
int pos = dna.indexOf("TG");
int count = 0;
while (pos >= 0) {
  count = count + 1;
  pos = dna.indexOf("TG",pos);
}
System.out.println(count);
}
}
