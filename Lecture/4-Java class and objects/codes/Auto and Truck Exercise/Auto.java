public class Auto{
	private int doors;
	private String transmission;
	
	//constructor
	public Auto(){
		doors=0;
		transmission="automatic";
	}
	public Auto(int doors, String transmission){
		this.doors=doors;
		this.transmission=transmission;
	}
	//access and mutate functions
	public int getDoors(){
		return doors;
	}
	public String getTransmission(){
		return transmission;
	}
	public void setDoors(int doors){
		this.doors=doors;
	}
	public void setTransmission(String transmission){
		this.transmission=transmission;
	}
	
	public String toString(){
		String temp=Integer.toString(doors)+" "+transmission;
		return temp;
	}
	public boolean equals(Auto a){
		if(doors==a.getDoors() && transmission.equals(a.getTransmission())){
			return true;
		}
		return false;
	}
}
		
	
