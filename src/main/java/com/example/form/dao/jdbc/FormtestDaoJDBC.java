package com.example.form.dao.jdbc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.form.bo.Formtest;
import com.example.form.config.jdbc.SpringJdbcConfig;
import com.example.form.dao.FormtestDao;

@Repository
public class FormtestDaoJDBC implements FormtestDao {

	/**
	 * Insert the Formtest data
	 */
	@Override
	public void save(Formtest form) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(SpringJdbcConfig.mysqlDataSource());
		try {
			jdbcTemplate.update(
					"INSERT INTO formtest (name,kilometers,price,creation,email,phonenumber,good,season,color,image,pdf) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					form.getName(),
					form.getKilometers(),
					form.getPrice(),
					form.getCreation(),
					form.getEmail(),
					form.getPhonenumber(),
					form.getGood(),
					form.getSeason(),
					form.getColor(),
					form.getImage(),
					form.getPdf());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Update the Formtest data
	 */
	@Override
	public void update(Formtest form) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(SpringJdbcConfig.mysqlDataSource());
		try {
			jdbcTemplate.update(
					"UPDATE formtest SET name = ?, kilometers = ?, price = ?, creation = ?, email = ?, phonenumber = ?, good = ?, season = ?, color = ?, image = ?, pdf = ? WHERE id = ?",
					form.getName(),
					form.getKilometers(),
					form.getPrice(),
					form.getCreation(),
					form.getEmail(),
					form.getPhonenumber(),
					form.getGood(),
					form.getSeason(),
					form.getColor(),
					form.getImage(),
					form.getPdf(),
					form.getId());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Delete the Formtest from its id
	 */
	@Override
	public void delete(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(SpringJdbcConfig.mysqlDataSource());
		try {
			jdbcTemplate.update("DELETE FROM formtest WHERE ID = ?", id);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get all Formtest data
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List<Formtest> findAll() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(SpringJdbcConfig.mysqlDataSource());
		List<Formtest> forms = new ArrayList<>();
		List<Map<String, Object>> rows = new ArrayList<>();
		try {
			rows = jdbcTemplate.queryForList("SELECT * FROM formtest");

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		for (Map row : rows) {
			Formtest obj = new Formtest();
			obj.setId((Integer) row.get("id"));
			obj.setName((String) row.get("name"));
			obj.setKilometers((Integer) row.get("kilometers"));
			obj.setPrice((Double) row.get("price"));
			obj.setCreation((LocalDateTime) row.get("creation"));
			obj.setEmail((String) row.get("email"));
			obj.setPhonenumber((String) row.get("phonenumber"));
			obj.setGood((Boolean) row.get("good"));
			obj.setSeason((String) row.get("season"));
			obj.setColor((String) row.get("color"));
			obj.setImage((String) row.get("image"));
			obj.setPdf((String) row.get("pdf"));

			forms.add(obj);
		}

		return forms;
	}

	/**
	 * Get the Formtest from its id
	 */
	@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	@Override
	public Formtest findById(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(SpringJdbcConfig.mysqlDataSource());
		Formtest form = null;
		try {
			String sql = "SELECT * FROM formtest WHERE ID = ?";

			return (Formtest) jdbcTemplate.queryForObject(sql, new Object[] { id },
					new BeanPropertyRowMapper(Formtest.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return form;
	}
}