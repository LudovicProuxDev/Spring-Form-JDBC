package com.example.form.bll;

import java.util.List;

import com.example.form.bo.Formtest;

public interface FormtestService {

	void createFormtest(Formtest formtest);

	void updateFormtest(Formtest formtest);

	void deleteFormtest(int id);

	List<Formtest> showFormtests();

	Formtest showFormtestById(int id);
}
