package Week1;

//Demo for Object State Chage

public class TrafficLight {	
	private String lightColor;
	
	public TrafficLight()
	{
		lightColor = "RED";
	}
	
	public TrafficLight(String color){
		lightColor = color.toUpperCase();}	
	
	public String lightColor()
	{
		return lightColor;
	}
	// next state of a TrafficLight object depends on its
	// current state and the message received

	public TrafficLight change(){	
		switch (lightColor)	{
		case "RED":
			lightColor = "GREEN";
			break;
		case "GREEN":
			lightColor = "YELLOW";
			break;
		case "YELLOW":
			lightColor = "RED";
			break;
		}
		return this;// returning an object
	}

	public static void main(String[] args) {
		TrafficLight lightAtX = new TrafficLight(); //creating obj on default constructor
		lightAtX.change();
		System.out.println(lightAtX.lightColor());
		
		// Chaining messages--to faciliate chaining we use 'this' keyword
		System.out.println(lightAtX.change().change().lightColor());

	}

}
