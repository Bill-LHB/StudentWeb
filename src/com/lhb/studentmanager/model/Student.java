package com.lhb.studentmanager.model;

/**
 * 学生bean类
 * 
 * @author Administrator
 *
 */
public class Student {
	private int id;// id
	private String name;// 姓名
	private int number;// 学号
	private int age;// 年龄
	private boolean sex;// 性别 true为男 false 为女
	private String headerImg;// 头像

	public Student(int id, String name, int number, int age, boolean sex, String headerImg) {

		this.id = id;
		this.name = name;
		this.number = number;
		this.age = age;
		this.sex = sex;
		this.headerImg = headerImg;
	}

	public Student(String name, int number, int age, boolean sex) {

		this.name = name;
		this.number = number;
		this.age = age;
		this.sex = sex;
	}

	public Student(String name, int number, int age, boolean sex, String headerImg) {

		this.name = name;
		this.number = number;
		this.age = age;
		this.sex = sex;
		this.headerImg = headerImg;
	}

	public Student() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getHeaderImg() {
		return headerImg;
	}

	public void setHeaderImg(String headerImg) {
		this.headerImg = headerImg;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", number=" + number + ", age=" + age + ", sex=" + sex + ", headerImg="
				+ headerImg + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
