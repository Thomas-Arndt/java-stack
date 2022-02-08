package com.arndtt.abstractart;

public class Sculpture extends Art {
	protected String material;
	
	public Sculpture(String title, String author, String description, String material) {
		super(title, author, description);
		this.material = material;
	}

	@Override
	public void viewArt() {
		System.out.printf("\n----- %s -----\n", this.title);
		System.out.printf("Sculpted by: %s\n", this.author);
		System.out.printf("Description: %s\n", this.description);
		System.out.printf("Sculpted from %s", this.material);

	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}
