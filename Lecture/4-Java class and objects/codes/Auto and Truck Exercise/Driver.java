public class Driver{
	public static void main(String[] args){
		Auto accord=new Auto(4, "automatic");
		Auto porche=new Auto(2,"manual");
		Truck ford=new Truck(2, "manual", 2.4);
		
		System.out.println(accord);
		System.out.println(porche);
		System.out.println(ford);
		if(accord.equals(porche)){
			System.out.println("accord is the same as porche. yeah!");
		}
	}
}
