package com.example.form.dao;

import java.util.List;

/**
 * Generic interface for CRUD methods for all kind of data
 */
public interface Dao<T> {
	/**
	 * Insert the data into the datasource
	 * 
	 * @param element
	 */
	public default void save(T data) {
	}

	/**
	 * Update the data into the datasource
	 * 
	 * @param id
	 */
	public default void update(T data) {
	}

	/**
	 * Delete the data into the datasource with its id
	 * 
	 * @param id
	 */
	public default void delete(int id) {
	}

	/**
	 * Select all data from the datasource
	 * 
	 * @return
	 */
	public default List<T> findAll() {
		return null;
	}

	/**
	 * Select one data from the datasource
	 * 
	 * @return
	 */
	public default T findById(int id) {
		return null;
	}
}
