package core.mediatior;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class MediatorUtil {
	static boolean isRequestClassAssignableToHandlerClass(Class<?> handlerClass, Class<?> requestClass) {
	    Type[] interfaces = handlerClass.getGenericInterfaces();
	    Type genericSuperclass = handlerClass.getGenericSuperclass();

	    ParameterizedType parameterType;
	    if (interfaces.length > 0) {
	    	parameterType = (ParameterizedType) interfaces[0];
	    } else {
	    	parameterType = (ParameterizedType) genericSuperclass;
	    }

	    Type handlerRequestType = parameterType.getActualTypeArguments()[0];
	    Class<?> handlerRequestClass;

	    if (handlerRequestType instanceof ParameterizedType) {
	      ParameterizedType parameterized = (ParameterizedType) handlerRequestType;
	      handlerRequestClass = (Class<?>) parameterized.getRawType();
	    } else {
	    	handlerRequestClass = (Class<?>) handlerRequestType;
	    }

	    return handlerRequestClass.isAssignableFrom(requestClass);
	  }
}
