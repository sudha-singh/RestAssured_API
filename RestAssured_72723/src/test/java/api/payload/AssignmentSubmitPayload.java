package api.payload;

public class AssignmentSubmitPayload {
	
	private String subDesc;
	private String subComments;
	private String subPathAttach1;
	private String subPathAttach2;
	private String subPathAttach3;
	private String subPathAttach4;
	private String subPathAttach5;
	private String subDateTime;
	private Integer submissionId;
	private String userId;
	private Integer assignmentId;
	private String gradedBy;
	private String grade;	
	
	
	public String getGradedBy() {
		return gradedBy;
	}
	public void setGradedBy(String gradedBy) {
		this.gradedBy = gradedBy;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(Integer assignmentId) {
		this.assignmentId = assignmentId;
	}
	public Integer getSubmissionId() {
		return submissionId;
	}
	public void setSubmissionId(Integer submissionId) {
		this.submissionId = submissionId;
	}
		
	public String getSubDesc() {
		return subDesc;
	}
	public void setSubDesc(String subDesc) {
		this.subDesc = subDesc;
	}
	public String getSubComments() {
		return subComments;
	}
	public void setSubComments(String subComments) {
		this.subComments = subComments;
	}
	public String getSubPathAttach1() {
		return subPathAttach1;
	}
	public void setSubPathAttach1(String subPathAttach1) {
		this.subPathAttach1 = subPathAttach1;
	}
	public String getSubPathAttach2() {
		return subPathAttach2;
	}
	public void setSubPathAttach2(String subPathAttach2) {
		this.subPathAttach2 = subPathAttach2;
	}
	public String getSubPathAttach3() {
		return subPathAttach3;
	}
	public void setSubPathAttach3(String subPathAttach3) {
		this.subPathAttach3 = subPathAttach3;
	}
	public String getSubPathAttach4() {
		return subPathAttach4;
	}
	public void setSubPathAttach4(String subPathAttach4) {
		this.subPathAttach4 = subPathAttach4;
	}
	public String getSubPathAttach5() {
		return subPathAttach5;
	}
	public void setSubPathAttach5(String subPathAttach5) {
		this.subPathAttach5 = subPathAttach5;
	}
	public String getSubDateTime() {
		return subDateTime;
	}
	public void setSubDateTime(String subDateTime) {
		this.subDateTime = subDateTime;
	}
	
}
