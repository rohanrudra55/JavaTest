
/**
 * Write a description of Part1 here.
 * 
 * @author (Rohan Rudra) 
 * @version (25/1/2021)
 */
public class Part1 {
    public String findSimpleGene(String dna){
    int startIndex= dna.indexOf("ATG");
    int endIndex= dna.indexOf("TAA",startIndex);
    int diff=endIndex-startIndex;
    if(diff%3!=0||startIndex==-1||endIndex==-1){
        return "";
    }
    return dna.substring(startIndex,endIndex+3);
    }
    public void testSimpleGene(){
        System.out.println("DNA:"+"ATTGTGATTAA");
        System.out.println("Gene:"+findSimpleGene("ATTGTGATTAA"));
        System.out.println("DNA:"+"ATGTGTGATTAGTT");
        System.out.println("Gene:"+findSimpleGene("ATGTGTGATTAGTT"));
        System.out.println("DNA:"+"ATTGTGATTAGT");
        System.out.println("Gene:"+findSimpleGene("ATTGTGATTAGT"));
        System.out.println("DNA:"+"ATGGTGATTTAA");
        System.out.println("Gene:"+findSimpleGene("ATGGTGATTTAA"));
        System.out.println("DNA:"+"ATGGTGATTAA");
        System.out.println("Gene:"+findSimpleGene("ATGGTGATTAA"));
    }

}
