package com.assesment.employee_management_system.dto;

import java.util.Date;

public class DepartmentDTO {
	
	private String name;
	
	private Date creationDate;
	
	private Long departmentHeadId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getDepartmentHeadId() {
		return departmentHeadId;
	}

	public void setDepartmentHeadId(Long departmentHeadId) {
		this.departmentHeadId = departmentHeadId;
	}

	public DepartmentDTO() {
		super();
	}

}
