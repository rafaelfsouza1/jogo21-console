package entities;

public class Dado {
	
	public static Integer resultDado() {
		return (int)Math.round(Math.random() * (10 - 1) + 1);
	}

}
