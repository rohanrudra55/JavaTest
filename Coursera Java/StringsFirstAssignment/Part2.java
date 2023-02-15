
/**
 * Write a description of Part2 here.
 * 
 * @author (Rohan Rudra) 
 * @version (26/1/2021)
 */
public class Part2 {

    public String findSimpleGene(String dna,String startCodon,String stopCodon){
    String dnaU=dna.toUpperCase();
    int startIndex= dnaU.indexOf("ATG");
    int endIndex= dnaU.indexOf("TAA",startIndex);
    int diff=endIndex-startIndex;
    ;
    
    if(diff%3!=0||startIndex==-1||endIndex==-1){
        return "";
    }
    return dna.substring(startIndex,endIndex+3);
    }
    public void testSimpleGene(){
        System.out.println("DNA:"+"AAATGCCCTAACTAGATTAAGAAACC");
        System.out.println("Gene:"+findSimpleGene("AAATGCCCTAACTAGATTAAGAAACC","ATG","TAA"));
        
    }

}



