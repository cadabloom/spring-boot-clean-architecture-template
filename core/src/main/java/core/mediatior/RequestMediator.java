package core.mediatior;

import java.util.List;
import java.util.Optional;

public class RequestMediator implements Mediator {

	@SuppressWarnings("rawtypes")
	public final List<RequestHandler> handlers;
	
	@SuppressWarnings("rawtypes")
	public RequestMediator(List<RequestHandler> handlers) {
		this.handlers = handlers;
	}
	
	
	@SuppressWarnings("unchecked")
	public <TOutput, T extends Request<TOutput>> TOutput send(T request) {
		TOutput output = null;
		
		Optional<RequestHandler> handler = handlers.stream()
			.filter(h -> h.canHandle(request))
			.findFirst();
		
		if(handler.isPresent()) {
			output = (TOutput) handler.get().handle(request);
		}
		
		return output;
	}


}
