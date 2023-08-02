package api.requestbody;

import java.io.IOException;

import api.payload.AssignmentSubmitPayload;
import api.utilities.RestUtils;

public class AssignmentSubmitBody extends RestUtils{


	//Assignment Submit Post Body
	public static AssignmentSubmitPayload PostBody() throws IOException {			

		AssignmentSubmitPayload.setAssignmentId(AssignmentPayload.getAssignmentId());
		AssignmentSubmitPayload.setUserId(StudentUser);
		AssignmentSubmitPayload.setSubDesc(xlutils.getCellData("AssignSubmitpostdata",1,0));
		AssignmentSubmitPayload.setSubComments(xlutils.getCellData("AssignSubmitpostdata",1,1));
		AssignmentSubmitPayload.setSubPathAttach1(xlutils.getCellData("AssignSubmitpostdata",1,2));
		AssignmentSubmitPayload.setSubPathAttach2(xlutils.getCellData("AssignSubmitpostdata",1,3));
		AssignmentSubmitPayload.setSubPathAttach3(xlutils.getCellData("AssignSubmitpostdata",1,4));
		AssignmentSubmitPayload.setSubPathAttach4(xlutils.getCellData("AssignSubmitpostdata",1,5));
		AssignmentSubmitPayload.setSubPathAttach5(xlutils.getCellData("AssignSubmitpostdata",1,6));
		AssignmentSubmitPayload.setSubDateTime(xlutils.getCellData("AssignSubmitpostdata",1,7));//07-20-2023 18:07:30

		return AssignmentSubmitPayload;
	}

	//Assignment Submit Missing Body
	public static AssignmentSubmitPayload PostBodyForMissingAssignmentID() throws IOException {			


		AssignmentSubmitPayload.setAssignmentId(0);
		AssignmentSubmitPayload.setUserId(StudentUser);
		AssignmentSubmitPayload.setSubDesc(xlutils.getCellData("AssignSubmitpostdata", 2, 0));
		AssignmentSubmitPayload.setSubComments(xlutils.getCellData("AssignSubmitpostdata", 2, 1));
		AssignmentSubmitPayload.setSubPathAttach1(xlutils.getCellData("AssignSubmitpostdata", 2, 2));
		AssignmentSubmitPayload.setSubPathAttach2(xlutils.getCellData("AssignSubmitpostdata", 2, 3));
		AssignmentSubmitPayload.setSubPathAttach3(xlutils.getCellData("AssignSubmitpostdata", 2, 4));
		AssignmentSubmitPayload.setSubPathAttach4(xlutils.getCellData("AssignSubmitpostdata", 2, 5));
		AssignmentSubmitPayload.setSubPathAttach5(xlutils.getCellData("AssignSubmitpostdata", 2, 6));
		AssignmentSubmitPayload.setSubDateTime(xlutils.getCellData("AssignSubmitpostdata", 2, 7));

		return AssignmentSubmitPayload;
	}

	//Assignment Submit Missing Body
	public static AssignmentSubmitPayload PostBodyForMissingUserID() throws IOException {			


		AssignmentSubmitPayload.setAssignmentId(AssignmentPayload.getAssignmentId());
		AssignmentSubmitPayload.setUserId("");
		AssignmentSubmitPayload.setSubDesc(xlutils.getCellData("AssignSubmitpostdata", 3, 0));
		AssignmentSubmitPayload.setSubComments(xlutils.getCellData("AssignSubmitpostdata", 3, 1));
		AssignmentSubmitPayload.setSubPathAttach1(xlutils.getCellData("AssignSubmitpostdata", 3, 2));
		AssignmentSubmitPayload.setSubPathAttach2(xlutils.getCellData("AssignSubmitpostdata", 3, 3));
		AssignmentSubmitPayload.setSubPathAttach3(xlutils.getCellData("AssignSubmitpostdata", 3, 4));
		AssignmentSubmitPayload.setSubPathAttach4(xlutils.getCellData("AssignSubmitpostdata", 3, 5));
		AssignmentSubmitPayload.setSubPathAttach5(xlutils.getCellData("AssignSubmitpostdata", 3, 6));
		AssignmentSubmitPayload.setSubDateTime(xlutils.getCellData("AssignSubmitpostdata", 3, 7));

		return AssignmentSubmitPayload;
	}

	//Assignment Submit Missing Body
	public static AssignmentSubmitPayload PostBodyForMissingSubDesc() throws IOException {			


		AssignmentSubmitPayload.setAssignmentId(AssignmentPayload.getAssignmentId());
		AssignmentSubmitPayload.setUserId(StudentUser);
		AssignmentSubmitPayload.setSubDesc(xlutils.getCellData("AssignSubmitpostdata", 4, 0));
		AssignmentSubmitPayload.setSubComments(xlutils.getCellData("AssignSubmitpostdata", 4, 1));
		AssignmentSubmitPayload.setSubPathAttach1(xlutils.getCellData("AssignSubmitpostdata", 4, 2));
		AssignmentSubmitPayload.setSubPathAttach2(xlutils.getCellData("AssignSubmitpostdata", 4, 3));
		AssignmentSubmitPayload.setSubPathAttach3(xlutils.getCellData("AssignSubmitpostdata", 4, 4));
		AssignmentSubmitPayload.setSubPathAttach4(xlutils.getCellData("AssignSubmitpostdata", 4, 5));
		AssignmentSubmitPayload.setSubPathAttach5(xlutils.getCellData("AssignSubmitpostdata", 4, 6));
		AssignmentSubmitPayload.setSubDateTime(xlutils.getCellData("AssignSubmitpostdata", 4, 7));

		return AssignmentSubmitPayload;
	}

	//Assignment Submit Missing Body
	public static AssignmentSubmitPayload PostBodyForMissingsubDateTime() throws IOException {			


		AssignmentSubmitPayload.setAssignmentId(AssignmentPayload.getAssignmentId());
		AssignmentSubmitPayload.setUserId(StudentUser);
		AssignmentSubmitPayload.setSubDesc(xlutils.getCellData("AssignSubmitpostdata", 5, 0));
		AssignmentSubmitPayload.setSubComments(xlutils.getCellData("AssignSubmitpostdata", 5, 1));
		AssignmentSubmitPayload.setSubPathAttach1(xlutils.getCellData("AssignSubmitpostdata", 5, 2));
		AssignmentSubmitPayload.setSubPathAttach2(xlutils.getCellData("AssignSubmitpostdata", 5, 3));
		AssignmentSubmitPayload.setSubPathAttach3(xlutils.getCellData("AssignSubmitpostdata", 5, 4));
		AssignmentSubmitPayload.setSubPathAttach4(xlutils.getCellData("AssignSubmitpostdata", 5, 5));
		AssignmentSubmitPayload.setSubPathAttach5(xlutils.getCellData("AssignSubmitpostdata", 5, 6));
		AssignmentSubmitPayload.setSubDateTime(xlutils.getCellData("AssignSubmitpostdata", 5, 7));

		return AssignmentSubmitPayload;
	}

	//ReSubmit Assignment by Submission ID
	public static AssignmentSubmitPayload ResubmitPutBody() throws IOException {			

		AssignmentSubmitPayload.setAssignmentId(AssignmentPayload.getAssignmentId());
		AssignmentSubmitPayload.setUserId(StudentUser);
		AssignmentSubmitPayload.setSubDesc(xlutils.getCellData("AssignSubmitputdata", 1, 0));
		AssignmentSubmitPayload.setSubComments(xlutils.getCellData("AssignSubmitputdata", 1, 1));
		AssignmentSubmitPayload.setSubPathAttach1(xlutils.getCellData("AssignSubmitputdata", 1, 2));
		AssignmentSubmitPayload.setSubPathAttach2(xlutils.getCellData("AssignSubmitputdata", 1, 3));
		AssignmentSubmitPayload.setSubPathAttach3(xlutils.getCellData("AssignSubmitputdata", 1, 4));
		AssignmentSubmitPayload.setSubPathAttach4(xlutils.getCellData("AssignSubmitputdata", 1, 5));
		AssignmentSubmitPayload.setSubPathAttach5(xlutils.getCellData("AssignSubmitputdata", 1, 6));
		AssignmentSubmitPayload.setSubDateTime(xlutils.getCellData("AssignSubmitputdata", 1, 7));//07-20-2023 18:07:30


		return AssignmentSubmitPayload;
	}

	//ReSubmit Assignment by Submission ID without mandatory fields
	public static AssignmentSubmitPayload ResubmitWithoutManFieldsPutBody() throws IOException {			

		AssignmentSubmitPayload.setSubDesc(xlutils.getCellData("AssignSubmitputdata", 3, 0));
		AssignmentSubmitPayload.setSubComments(xlutils.getCellData("AssignSubmitputdata", 3, 1));
		AssignmentSubmitPayload.setSubPathAttach1(xlutils.getCellData("AssignSubmitputdata", 3, 2));
		AssignmentSubmitPayload.setSubPathAttach2(xlutils.getCellData("AssignSubmitputdata", 3, 3));
		AssignmentSubmitPayload.setSubPathAttach3(xlutils.getCellData("AssignSubmitputdata", 3, 4));
		AssignmentSubmitPayload.setSubPathAttach4(xlutils.getCellData("AssignSubmitputdata", 3, 5));
		AssignmentSubmitPayload.setSubPathAttach5(xlutils.getCellData("AssignSubmitputdata", 3, 6));
		AssignmentSubmitPayload.setSubDateTime(xlutils.getCellData("AssignSubmitputdata", 3, 7));//07-20-2023 18:07:30


		return AssignmentSubmitPayload;
	}

	//Grade by Submission ID
	public static AssignmentSubmitPayload GradePutBody() throws IOException {			

		AssignmentSubmitPayload.setGradedBy(AdminUser);
		AssignmentSubmitPayload.setGrade(xlutils.getCellData("AssignSubmitputdata", 2, 8));

		return AssignmentSubmitPayload;
	}

	//Grade by Submission ID without mandatory fields
	public static AssignmentSubmitPayload GradePutBodyWithoutMandFields() throws IOException {			

		AssignmentSubmitPayload.setSubDesc(xlutils.getCellData("AssignSubmitputdata", 3, 0));
		AssignmentSubmitPayload.setSubComments(xlutils.getCellData("AssignSubmitputdata", 3, 1));
		AssignmentSubmitPayload.setSubPathAttach1(xlutils.getCellData("AssignSubmitputdata", 3, 2));
		AssignmentSubmitPayload.setSubPathAttach2(xlutils.getCellData("AssignSubmitputdata", 3, 3));
		AssignmentSubmitPayload.setSubPathAttach3(xlutils.getCellData("AssignSubmitputdata", 3, 4));
		AssignmentSubmitPayload.setSubPathAttach4(xlutils.getCellData("AssignSubmitputdata", 3, 5));
		AssignmentSubmitPayload.setSubPathAttach5(xlutils.getCellData("AssignSubmitputdata", 3, 6));
		AssignmentSubmitPayload.setSubDateTime(xlutils.getCellData("AssignSubmitputdata", 3, 7));

		return AssignmentSubmitPayload;
	}




}
