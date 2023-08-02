package api.requestbody;

import java.io.IOException;
import java.util.Random;

import api.payload.AssignmentPayload;
import api.utilities.RestUtils;

public class AssignmentBody extends RestUtils{

	//Post Body
	public static AssignmentPayload PostBody()  throws IOException{

		Random random = new Random();
		int AssSerialNum = random.nextInt(1000);

		AssignmentPayload.setAssignmentDescription(xlutils.getCellData("Assignmentpostdata", 1, 0));
		AssignmentPayload.setAssignmentName(ProgramPayload.getProgramName()+ xlutils.getCellData("Assignmentpostdata", 1, 1)+AssSerialNum);
		AssignmentPayload.setBatchId(BatchPayload.getBatchId());
		AssignmentPayload.setComments(xlutils.getCellData("Assignmentpostdata", 1 , 2));
		AssignmentPayload.setCreatedBy(AdminUser);
		AssignmentPayload.setDueDate(xlutils.getCellData("Assignmentpostdata", 1 , 3));
		AssignmentPayload.setGraderId(AdminUser);
		AssignmentPayload.setPathAttachment1(xlutils.getCellData("Assignmentpostdata", 1, 4));
		AssignmentPayload.setPathAttachment2(xlutils.getCellData("Assignmentpostdata", 1, 5));
		AssignmentPayload.setPathAttachment3(xlutils.getCellData("Assignmentpostdata", 1, 6));
		AssignmentPayload.setPathAttachment4(xlutils.getCellData("Assignmentpostdata", 1, 7));
		AssignmentPayload.setPathAttachment5(xlutils.getCellData("Assignmentpostdata", 1, 8));

		return AssignmentPayload;

	}

	//post body for assignment 2
	public static AssignmentPayload PostBodyAss2() throws IOException {

		Random random = new Random();
		int AssSerialNum = random.nextInt(1000);

		AssignmentPayload.setAssignmentDescription(xlutils.getCellData("Assignmentpostdata", 2, 0));
		//AssignmentPayload.setAssignmentId(0);
		AssignmentPayload.setAssignmentName(ProgramPayload.getProgramName()+ xlutils.getCellData("Assignmentpostdata", 2, 1)+AssSerialNum);
		AssignmentPayload.setBatchId(BatchPayload.getBatchId());
		AssignmentPayload.setComments(xlutils.getCellData("Assignmentpostdata", 2, 2));
		AssignmentPayload.setCreatedBy(AdminUser);
		AssignmentPayload.setDueDate(xlutils.getCellData("Assignmentpostdata", 2, 3));
		AssignmentPayload.setGraderId(AdminUser);
		AssignmentPayload.setPathAttachment1(xlutils.getCellData("Assignmentpostdata", 2, 4));
		AssignmentPayload.setPathAttachment2(xlutils.getCellData("Assignmentpostdata", 2, 5));
		AssignmentPayload.setPathAttachment3(xlutils.getCellData("Assignmentpostdata", 2, 6));
		AssignmentPayload.setPathAttachment4(xlutils.getCellData("Assignmentpostdata", 2, 7));
		AssignmentPayload.setPathAttachment5(xlutils.getCellData("Assignmentpostdata", 2, 8));

		return AssignmentPayload;

	}

	//post body for existing values
	public static AssignmentPayload PostBodyExistingValues()  throws IOException{

		AssignmentPayload.setAssignmentDescription(xlutils.getCellData("Assignmentpostdata", 1, 0));
		AssignmentPayload.setAssignmentName(AssignmentPayload.getAssignmentName());
		AssignmentPayload.setBatchId(BatchPayload.getBatchId());
		AssignmentPayload.setComments(xlutils.getCellData("Assignmentpostdata", 1 , 2));
		AssignmentPayload.setCreatedBy(AdminUser);
		AssignmentPayload.setDueDate(xlutils.getCellData("Assignmentpostdata", 1 , 3));
		AssignmentPayload.setGraderId(AdminUser);
		AssignmentPayload.setPathAttachment1(xlutils.getCellData("Assignmentpostdata", 1, 4));
		AssignmentPayload.setPathAttachment2(xlutils.getCellData("Assignmentpostdata", 1, 5));
		AssignmentPayload.setPathAttachment3(xlutils.getCellData("Assignmentpostdata", 1, 6));
		AssignmentPayload.setPathAttachment4(xlutils.getCellData("Assignmentpostdata", 1, 7));
		AssignmentPayload.setPathAttachment5(xlutils.getCellData("Assignmentpostdata", 1, 8));

		return AssignmentPayload;

	}

	//post body for missing values
	public static AssignmentPayload missingFieldPostBody() throws IOException {

		AssignmentPayload.setAssignmentDescription(xlutils.getCellData("Assignmentpostdata", 2, 0));
		AssignmentPayload.setAssignmentName("");
		AssignmentPayload.setBatchId(BatchPayload.getBatchId());
		AssignmentPayload.setComments(xlutils.getCellData("Assignmentpostdata", 2, 2));
		AssignmentPayload.setCreatedBy(AdminUser);
		AssignmentPayload.setDueDate(xlutils.getCellData("Assignmentpostdata", 2, 3));//2023-07-29T22:00:04.964+00:00
		AssignmentPayload.setGraderId(AdminUser);
		AssignmentPayload.setPathAttachment1(xlutils.getCellData("Assignmentpostdata", 2, 4));
		AssignmentPayload.setPathAttachment2(xlutils.getCellData("Assignmentpostdata", 2, 5));
		AssignmentPayload.setPathAttachment3(xlutils.getCellData("Assignmentpostdata", 2, 6));
		AssignmentPayload.setPathAttachment4(xlutils.getCellData("Assignmentpostdata", 2, 7));
		AssignmentPayload.setPathAttachment5(xlutils.getCellData("Assignmentpostdata", 2, 8));

		return AssignmentPayload;

	}

	//put body
	public static AssignmentPayload PutBody() throws IOException{

		Random random = new Random();
		int AssSerialNum = random.nextInt(1000);
		AssignmentPayload.setAssignmentDescription("JAVA Assignment");
		AssignmentPayload.setAssignmentName(ProgramPayload.getProgramName()+ xlutils.getCellData("Assignmentpostdata", 1, 1)+AssSerialNum);
		AssignmentPayload.setBatchId(BatchPayload.getBatchId());
		AssignmentPayload.setComments(xlutils.getCellData("Assignmentpostdata", 1 , 2));
		AssignmentPayload.setCreatedBy(AdminUser);
		AssignmentPayload.setDueDate("2023-07-29T22:00:04.964+00:00");
		AssignmentPayload.setGraderId(AdminUser);
		AssignmentPayload.setPathAttachment1(xlutils.getCellData("Assignmentpostdata", 1, 4));
		AssignmentPayload.setPathAttachment2(xlutils.getCellData("Assignmentpostdata", 1, 5));
		AssignmentPayload.setPathAttachment3(xlutils.getCellData("Assignmentpostdata", 1, 6));
		AssignmentPayload.setPathAttachment4(xlutils.getCellData("Assignmentpostdata", 1, 7));
		AssignmentPayload.setPathAttachment5(xlutils.getCellData("Assignmentpostdata", 1, 8));

		return AssignmentPayload;
	}

	//put missing field body
	public static AssignmentPayload PutBodyMissingField() throws IOException{

		AssignmentPayload.setAssignmentDescription(AssignmentPayload.getAssignmentDescription());
		AssignmentPayload.setAssignmentName(AssignmentPayload.getAssignmentName());
		AssignmentPayload.setBatchId(BatchPayload.getBatchId());
		AssignmentPayload.setComments(AssignmentPayload.getComments());
		AssignmentPayload.setCreatedBy("");

		AssignmentPayload.setGraderId(AdminUser);

		return AssignmentPayload;

	}

	//put body post due date
	public static AssignmentPayload PutBodyPostDueDate() throws IOException {

		AssignmentPayload.setAssignmentDescription(AssignmentPayload.getAssignmentDescription());
		AssignmentPayload.setAssignmentName(AssignmentPayload.getAssignmentName());
		AssignmentPayload.setBatchId(BatchPayload.getBatchId());
		AssignmentPayload.setComments(AssignmentPayload.getComments());
		AssignmentPayload.setCreatedBy(AdminUser);
		AssignmentPayload.setDueDate(xlutils.getCellData("Assignmentputdata", 1, 3));//2023-07-29T22:00:04.964+00:00
		AssignmentPayload.setGraderId(AdminUser);

		return AssignmentPayload;

	}

}
