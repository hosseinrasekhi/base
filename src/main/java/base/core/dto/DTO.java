package base.core.dto;

public abstract class DTO<E> {
	public abstract void loadFrom(E obj);
	public abstract void saveTo(E obj);
}
