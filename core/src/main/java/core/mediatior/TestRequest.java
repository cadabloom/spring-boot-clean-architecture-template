package core.mediatior;

import core.domain.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestRequest implements Request<Product> {
	
	private String input;

}
