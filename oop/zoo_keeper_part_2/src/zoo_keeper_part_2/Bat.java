package zoo_keeper_part_2;

public class Bat extends Mammal{
	
	public Bat() {
		super();
		this.setEnergyLevel(300);
	}
	
	public void fly() {
		System.out.println("\nThe bat flies around (*fwip fwip fwip*)");
		this.setEnergyLevel(getEnergyLevel()-50);
	}
	
	public void eatHuman() {
		System.out.println("\nThe bat just...ate...a...human...!!!");
		this.setEnergyLevel(getEnergyLevel()+25);
	}
	
	public void attackTown() {
		System.out.println("\nThe bat set the town on fire!!!");
		this.setEnergyLevel(getEnergyLevel()-100);
	}
}
