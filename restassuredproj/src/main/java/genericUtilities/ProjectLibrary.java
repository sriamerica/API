package genericUtilities;

import net.bytebuddy.implementation.bind.annotation.Super;

public class ProjectLibrary 

{
	//Step 1. declare the variables globally
	String createdBy;
	  String projectName;
	  String status;
	  int teamSize;
	
	 // step2. create a constructor 
	  
	public ProjectLibrary() {
		super();
	}
	public ProjectLibrary(String createdBy, String projectName, String status, int teamSize) {
		super();
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
	}
	
	//step 3 provide getters and setters
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	  
	

}
