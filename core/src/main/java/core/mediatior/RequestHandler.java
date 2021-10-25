package core.mediatior;

public interface RequestHandler<T extends Request<TOutput>,TOutput> {	
	TOutput handle(T request);
	//TOutput handle(Request<TOutput> request);
	
	default boolean canHandle(T request) {
	      Class handlerType = getClass();
	      Class commandType = request.getClass();
	      return MediatorUtil.isRequestClassAssignableToHandlerClass(handlerType, commandType);
    }
}
