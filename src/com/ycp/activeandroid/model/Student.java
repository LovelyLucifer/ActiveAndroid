package com.ycp.activeandroid.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name="Students")
public class Student extends Model{

	@Column(name="name")
	public String name;
	@Column(name="age")
	public Integer age;
}
