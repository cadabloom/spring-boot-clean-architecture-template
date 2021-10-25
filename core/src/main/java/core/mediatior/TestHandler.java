package core.mediatior;

import core.domain.Product;

public class TestHandler implements RequestHandler<TestRequest,core.domain.Product> {

	@Override
	public Product handle(TestRequest request) {
		// TODO Auto-generated method stub
		return new Product("HAHA");
	}


}
