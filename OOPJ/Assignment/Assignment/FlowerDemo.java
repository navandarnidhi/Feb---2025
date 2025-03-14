class Flower {
	protected String name;
	protected String color;
	protected Boolean hasFragrance;

	public Flower (String name, String color, Boolean hasFragrance){
		this.name = name;
		this.color = color;
		this.hasFragrance = hasFragrance;
	}

	public void displayDetails(){
		System.out.println("Flower Name: " + name);
		System.out.println("Color: " + color);
		System.out.println("Has Fragrance" + (hasFragrance ? "Yes" : "No"));
		
	}
}

class Rose extends Flower {
 	private boolean hasThrons;
	public Rose(String color, boolean hasFragrance, boolean hasThrons){
		super("Rose", color, hasFragrance);
 		this.hasThrons = hasThrons;
 	}
	
 	public void displayDetails(){
 		System.out.println("ROSE DEATILS");
 		super.displayDetails();
 		System.out.println("Has Throns: " + (hasThrons ? "Yes" : "No"));
		System.out.println();

 	}
}

class Lily extends Flower{
	private boolean isWaterPlant;
	
	public Lily(String color, boolean hasFragrance, boolean isWaterPlant){
		super ("Lily", color, hasFragrance);
		this.isWaterPlant = isWaterPlant;
	}
	public void displayDetails(){
		System.out.println("LILY DETAILS");
		super.displayDetails();
		System.out.println("Is a water Plant: " + (isWaterPlant ? "Yes" : "No"));
		System.out.println();

	}	
}

public class FlowerDemo{
	public static void main(String args[]){
		Rose rose = new Rose("Red", true, true);
		Lily lily = new Lily("White", true, true);
		
		rose.displayDetails();
		lily.displayDetails();
	}
}















