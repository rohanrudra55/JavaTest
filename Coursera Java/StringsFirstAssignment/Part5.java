
/**
 * Write a description of Part5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part5 {
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
     int b=findStopCodon(dna,a,"TAA");
     int c=findStopCodon(dna,a,"TAG");
     if(b<c){
         return (b!=dna.length())?dna.substring(a,b):" ";
        }
        else
         return (c!=dna.length())?dna.substring(a,c):" ";   
}
void testFindGene(){
    System.out.println();
    System.out.println();
}
void printAllGenes(String dna){
    int a=0;
    while(a<dna.length()){
        findGene(dna.substring(a++,dna.length()));
}
}
}
