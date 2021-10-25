package core.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
	public Product() {
		
	}
	
	public Product(String name) {
		this.name = name;
	}
	public static String HOY = "HOY";
	
	private String id;
	private String name;
}
