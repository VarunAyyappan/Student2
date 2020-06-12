package jrJava.mouseAndMaze;

public class Utility {

	public static void copy(Point[] a, Point[] b){
		if(b==null || a.length!=b.length) b = new Point[a.length];

		for(int i=0; i<a.length; i++){
			if(b[i]==null) b[i] = new Point(0, 0);
			b[i].x = a[i].x;
			b[i].y = a[i].y;
		}
	}


	public static void shift(Point[] points, double xShift, double yShift){
		for(int i=0; i<points.length; i++){
			points[i].x += xShift;
			points[i].y += yShift;
		}
	}


	public static void scale(Point[] points, Point ref, double scaleFactor){
		for(int i=0; i<points.length; i++){
			points[i].x = ref.x + scaleFactor*(points[i].x - ref.x);
			points[i].y = ref.y + scaleFactor*(points[i].y - ref.y);
		}
	}


	public static void scale(Point points, Point ref, double scaleFactor){
		points.x = ref.x + scaleFactor*(points.x - ref.x);
		points.y = ref.y + scaleFactor*(points.y - ref.y);
	}

	
	public static void rotateClockwise(Point[] points){
		double temp;
		for(int i=0; i<points.length; i++){
			temp = points[i].y;
			points[i].y = points[i].x;
			points[i].x = -temp;
		}
	}
	
}















