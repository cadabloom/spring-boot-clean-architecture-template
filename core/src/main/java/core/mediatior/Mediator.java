package core.mediatior;

public interface Mediator {
	<TOutput, T extends Request<TOutput>> TOutput send(T request);
}
