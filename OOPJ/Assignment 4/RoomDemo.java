
class Room{
	double height;
	double width;
	double breath;
	public Room(double height, double width, double breath) {
		super();
		this.height = height;
		this.width = width;
		this.breath = breath;
	}
	
	public double volume() {
		return height * width * breath;
		
	}
}

public class RoomDemo {
	public static void main(String[] args) {
		
		Room room1 = new Room (10, 12, 14);
		Room room2 = new Room(1,3,5);
		
		System.out.println("Volume of Room 1" + room1.volume() + " cubic units");
		System.out.println("Volume of Room 2" + room2.volume() + " cubic units");
	}
}
