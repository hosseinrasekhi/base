package base.core.dto;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DtoUtils {
	
	@SuppressWarnings("unchecked")
	public static <E,D extends DTO<E>> List<D> entitysToDtoList(Collection<E> entityList,Class<D> dto){
		if(entityList == null || entityList.isEmpty())
			return null;
		List<D> dtos = new ArrayList<>();
		for (E e : entityList) {
			D d = null;
			try {
				d = (D) Class.forName(dto.getName()).getConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e1) {
				e1.printStackTrace();
				continue;
			}
			d.loadFrom(e);
			dtos.add(d);
		}
		return dtos;
	}
	
	@SuppressWarnings("unchecked")
	public static <E,D extends DTO<E>> Set<E> dtoListToEntitySet(List<D> dtoList,Class<E> entity){
		if(dtoList == null || dtoList.isEmpty())
			return null;
		Set<E> entitys = new HashSet<>();
		for (D d : dtoList) {
			E e = null;
			try {
				e = (E) Class.forName(entity.getName()).getConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e1) {
				e1.printStackTrace();
				continue;
			}
			d.saveTo(e);
			entitys.add(e);
		}
		return entitys;
	}
	
	@SuppressWarnings("unchecked")
	public static <E,D extends DTO<E>> E dtoToEntity(D dto,Class<E> entity){
		if(dto == null)
			return null;
		E e = null;
		try {
			e = (E) Class.forName(entity.getName()).getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException
				| ClassNotFoundException e1) {
			e1.printStackTrace();
			return null;
		}
		dto.saveTo(e);
		return e;
	}
	
	@SuppressWarnings("unchecked")
	public static <E,D extends DTO<E>> D entityToDto(E entity,Class<D> dto){
		if(entity == null)
			return null;
		D d = null;
		try {
			d = (D) Class.forName(dto.getName()).getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException
				| ClassNotFoundException e1) {
			e1.printStackTrace();
			return null;
		}
		d.loadFrom(entity);
		return d;
	}

}
