package zoo_keeper_part_2;

public class Gorilla extends Mammal {
	
	public Gorilla() {
		super();
	}

	public void throwSomething() {
		System.out.println("The gorilla threw something...");
		this.energyLevel -= 5;
	}

	public void eatBananas() {
		System.out.println("The gorilla enjoyed eating the bananas you gave it.");
		this.setEnergyLevel(getEnergyLevel()+10);
	}
	
	public void climb() {
		System.out.println("The gorilla has climbed a tree.");
		this.setEnergyLevel(getEnergyLevel()-10);
	}
}
