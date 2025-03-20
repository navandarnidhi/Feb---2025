
class Box{
	double height;
	double width;
	double breadth;
	public Box(double height, double width, double breath) {
		super();
		this.height = height;
		this.width = width;
		this.breadth = breath;
	}
	
	public double getVolume() {
		return height * width * breadth;
	}
	
	public double getArea() {
		return 2 * (height * width + width * breadth + height * breadth);
	}
}
public class BoxDemo {
	public static void main(String[] args) {
		
		Box b1 = new Box(10, 12, 14);
		Box b2 = new Box(1, 3, 5);
		

		System.out.println("Box 1 volume " + b1.getVolume());
		System.out.println("Box 1 Area " + b1.getArea());
		
		System.out.println("Box 2 volume " + b2.getVolume());
		System.out.println("Box 2 Area " + b2.getArea());
	}

}
