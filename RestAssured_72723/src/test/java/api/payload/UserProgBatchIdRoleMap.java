package api.payload;

import java.util.List;

public class UserProgBatchIdRoleMap {
	
	private Integer programId;
	private String roleId;
	private String userId;
	private List<userRoleProgramBatches> userRoleProgramBatches;
	
	
	public Integer getProgramId() {
		return programId;
	}
	public void setProgramId(Integer programId) {
		this.programId = programId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<userRoleProgramBatches> getUserRoleProgramBatches() {
		return userRoleProgramBatches;
	}
	public void setUserRoleProgramBatches(List<userRoleProgramBatches> userRoleProgramBatches) {
		this.userRoleProgramBatches = userRoleProgramBatches;
	}
	
	
	


}
