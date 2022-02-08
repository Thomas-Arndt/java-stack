package com.arndtt.abstractart;

public class Painting extends Art {
	protected String paintType;
	
	public Painting(String title, String author, String description, String paintType) {
		super(title, author, description);
		this.paintType = paintType;
	}

	@Override
	public void viewArt() {
		System.out.printf("\n----- %s -----\n", this.title);
		System.out.printf("Painted by: %s\n", this.author);
		System.out.printf("Description: %s\n", this.description);
		System.out.printf("Painted using %s", this.paintType);

	}

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

}
