import java.util.ArrayList;

public class Point {

	public ArrayList<Point> neighbors;
	public static Integer []types ={0,1,2,3};
	public int type;
	public int staticField;
	public boolean isPedestrian;

	public Point() {
		type=0;
		staticField = 100000;
		neighbors= new ArrayList<Point>();
	}
	
	public void clear() {
		staticField = 100000;
		
	}

	public boolean calcStaticField() {
        int smallestStatic = 100000;
        for (Point point : neighbors)
            smallestStatic = point.staticField < smallestStatic ? point.staticField : smallestStatic;

        if (staticField > smallestStatic + 1) {
            staticField = smallestStatic + 1;
            return true;
        }
		return false;
	}
	
	public void move(){
	}

	public void addNeighbor(Point nei) {
		neighbors.add(nei);
	}
}