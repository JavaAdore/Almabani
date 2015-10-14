package com.almabani.common.dto.menu;

import java.io.Serializable;

public class KeyValueHolder<K, V> implements Serializable,
		Comparable<KeyValueHolder> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private K key;
	private V value;

	public KeyValueHolder() {
	}

	public KeyValueHolder(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public int compareTo(KeyValueHolder o) {
		if (key instanceof String && o.getKey() instanceof String) {

			return ((String) key).compareTo((String) o.getKey());
		}

		return 0;
	}

}
