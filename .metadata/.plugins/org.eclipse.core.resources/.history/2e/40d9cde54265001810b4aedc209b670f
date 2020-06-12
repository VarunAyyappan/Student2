package jrJava.mouseAndMaze_network;

public class Utility {

	public static void shift(Point[] points, double xShift, double yShift){
		for(int i=0; i<points.length; i++){
			points[i].x = points[i].x + xShift;
			points[i].y = points[i].y + yShift;
		}
	}
	
	public static void copy(Point[] src, Point[] dest){
		for(int i=0; i<src.length; i++){
			if(dest[i]==null) dest[i] = new Point(0, 0);
			dest[i].x = src[i].x;
			dest[i].y = src[i].y;
		}
	}
	
	
	public static void scale(Point[] points, Point ref, double scaleFactor){
		for(int i=0; i<points.length; i++){
			points[i].x = ref.x + (points[i].x - ref.x)*scaleFactor;
			points[i].y = ref.y + (points[i].y - ref.y)*scaleFactor;
		}
	}
	
	
	public static void scale(Point point, Point ref, double scaleFactor){
		point.x = ref.x + (point.x - ref.x)*scaleFactor;
		point.y = ref.y + (point.y - ref.y)*scaleFactor;
	}
	
	
	public static void rotateClockwise(Point[] points){
		double temp;
		for(int i=0; i<points.length; i++){
			temp = points[i].x;
			points[i].x = -points[i].y;
			points[i].y = temp;
		}
		
	}
	
}











