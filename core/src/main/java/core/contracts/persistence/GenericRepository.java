package core.contracts.persistence;

public interface GenericRepository<T> {
	T save(T entity);
	Boolean deleteAll();
	T findById(int id);
}
