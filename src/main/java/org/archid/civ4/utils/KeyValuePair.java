package org.archid.civ4.utils;

/**
 * Implementation of the {@link IKeyValuePair} interface
 * 
 * @author jim
 *
 * @param <S> Object type of the key
 * @param <T> Object type of the value
 */
public class KeyValuePair<S, T> implements IKeyValuePair<S, T> {
	
	private S key;
	private T value;
	
	public KeyValuePair(S key, T value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public void setKey(S key) {
		this.key = key;
	}

	@Override
	public S getKey() {
		return key;
	}

	@Override
	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public T getValue() {
		return value;
	}

}
