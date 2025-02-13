package com.example.form.bll.jdbc;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.form.bll.FormtestService;
import com.example.form.bo.Formtest;
import com.example.form.dao.FormtestDao;
import com.example.form.dao.jdbc.FormtestDaoJDBC;

@Service
public class FormtestServiceJDBC implements FormtestService {

	FormtestDao formtestDao = new FormtestDaoJDBC();

	@Override
	public void createFormtest(Formtest formtest) {
		formtestDao.save(formtest);
	}

	@Override
	public void updateFormtest(Formtest formtest) {
		formtestDao.update(formtest);
	}

	@Override
	public void deleteFormtest(int id) {
		formtestDao.delete(id);
	}

	@Override
	public List<Formtest> showFormtests() {
		return formtestDao.findAll();
	}

	@Override
	public Formtest showFormtestById(int id) {
		return formtestDao.findById(id);
	}

}
