import edu.duke.*;
import java.io.File;
import java.util.*;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int c=0;
        for(Point x: s.getPoints()){
        c++;
        }
        return c;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double avg=(getPerimeter(s))/(getNumPoints(s));
        return avg;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double maxside=0.0;
        Point prvPoints = s.getLastPoint();
        for(Point currPoints : s.getPoints()){
        double dist=prvPoints.distance(currPoints);
        prvPoints=currPoints;
        maxside=Math.max(maxside,dist);
        }
        
        return maxside;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double maxX=0;
        for(Point currPoints : s.getPoints()){
            maxX=Math.max(maxX, currPoints.getX());
        
        }
        return maxX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double large=0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr= new FileResource(f);
            Shape s = new Shape(fr);
            large=Math.max(large,getPerimeter(s));
            
        
    }
    return large;
}

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("Total num of points:"+ getNumPoints(s));
        System.out.println("Average Length:"+ getAverageLength(s));
        System.out.println("Largest side:"+ getLargestSide(s));
        System.out.println("Largest X value:"+ getLargestX(s));
        System.out.println("perimeter = " + length);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        System.out.println("Largest Perimeter:"+getLargestPerimeterMultipleFiles());
        System.out.println("File with largest Perimeter:"+testFileWithLargestPerimeter());
    }

    public String testFileWithLargestPerimeter() {
        // Put code here
        double lrg=0.0,curr;
   
        String largeFile="",currFile="";
        int c=0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            currFile=f.toString();
            FileResource fr= new FileResource(f);
            Shape s = new Shape(fr);
            curr=getPerimeter(s);
            if(lrg<curr){
                lrg=curr;
                largeFile=currFile;
            }
    }
    return largeFile;
    
}

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
