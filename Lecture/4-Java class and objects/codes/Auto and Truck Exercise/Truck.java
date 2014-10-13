public class Truck extends Auto{
	private double load;
	
	public Truck(){
		super();
		load=0;
	}
	public Truck(int doors, String transmission, double load){
		super(doors, transmission);
		this.load=load;
	}
	
	public double getLoad(){
		return load;
	}
	public void setLoad(double load){
		this.load=load;
	}
	public String toString(){
		String temp=super.toString();
		temp=temp+" "+Double.toString(load);
		return temp;
	}
	public boolean equals(Truck t){
		if(super.equals(t) && load==t.getLoad()){
			return true;
		}
		return false;
	}
}
