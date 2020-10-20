package com.smk.jdbcassignment;

public class lenovo {
	int modelno;
	String name;
	
	public lenovo()
	{
		
	}
	
	public lenovo(int modelno, String name) {
		super();
		this.modelno = modelno;
		this.name = name;
	}

	public int getModelno() {
		return modelno;
	}

	public void setModelno(int modelno) {
		this.modelno = modelno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "lenovo [modelno=" + modelno + ", name=" + name + "]";
	}
	
	
	

}
