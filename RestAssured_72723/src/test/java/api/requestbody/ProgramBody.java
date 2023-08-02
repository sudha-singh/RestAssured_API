package api.requestbody;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;

import api.payload.ProgramPayload;
import api.utilities.RestUtils;

public class ProgramBody extends RestUtils {

	//post body
	public static ProgramPayload PostBody() throws IOException {

		ProgramPayload.setProgramName(xlutils.getCellData("programpostdata", 1, 0)+RandomStringUtils.randomNumeric(3));	
		ProgramPayload.setProgramDescription(xlutils.getCellData("programpostdata", 1, 1));
		ProgramPayload.setProgramStatus(xlutils.getCellData("programpostdata", 1, 2));
		System.out.println("ProgramPayload is :"+ProgramPayload);

		return ProgramPayload;
	}


	//PostBody_existingValues
	public static ProgramPayload PostBodywithExistingFields() throws IOException {

		ProgramPayload.setProgramName(ProgramPayload.getProgramName());
		ProgramPayload.setProgramDescription(ProgramPayload.getProgramDescription());
		ProgramPayload.setProgramStatus(ProgramPayload.getProgramStatus());

		return ProgramPayload;
	}


	//PostBody_Missing_MandatoryValues
	public static ProgramPayload PostBodywithMissingFields() throws IOException {

		ProgramPayload.setProgramName(xlutils.getCellData("programpostdata", 3, 0)+RandomStringUtils.randomNumeric(3));
		ProgramPayload.setProgramDescription(xlutils.getCellData("programpostdata", 3, 1));
		ProgramPayload.setProgramStatus(xlutils.getCellData("programpostdata", 3, 2));

		return ProgramPayload;
	}


	//Update with Valid ProgramID
	public static ProgramPayload UpdateBodywithValidID() throws IOException {

		ProgramPayload.setProgramName(xlutils.getCellData("putprogramdata", 1, 0)+RandomStringUtils.randomNumeric(3));
		ProgramPayload.setProgramDescription(xlutils.getCellData("putprogramdata", 1, 1));
		ProgramPayload.setProgramStatus(xlutils.getCellData("putprogramdata", 1, 2));

		return ProgramPayload;
	}


	//Update with Valid Program Name
	public static ProgramPayload UpdateBodywithValidProgramName() throws IOException {

		ProgramPayload.setProgramName(ProgramPayload.getProgramName());
		ProgramPayload.setProgramDescription(xlutils.getCellData("putprogramdata", 2, 1));
		ProgramPayload.setProgramStatus(xlutils.getCellData("putprogramdata", 2, 2));

		return ProgramPayload;
	}


	//Update with Valid ID and Missing Mandatory Fields
	public static ProgramPayload UpdateBodywithValidIDandMissingField() throws IOException {

		ProgramPayload.setProgramName(xlutils.getCellData("putprogramdata", 3, 0)+RandomStringUtils.randomNumeric(3));
		ProgramPayload.setProgramDescription(xlutils.getCellData("putprogramdata", 3, 1));
		ProgramPayload.setProgramStatus(xlutils.getCellData("putprogramdata", 3, 2));

		return ProgramPayload;
	}

	//Update with Valid Program Name and Missing Mandatory Fields
	public static ProgramPayload UpdateBodywithProgramNameandMissingField() throws IOException {

		ProgramPayload.setProgramName("");
		ProgramPayload.setProgramDescription(xlutils.getCellData("putprogramdata", 4, 1));
		ProgramPayload.setProgramStatus(xlutils.getCellData("putprogramdata", 4, 2));

		return ProgramPayload;
	}

	//Update with InValid ProgramID
	public static ProgramPayload UpdateBodywithInvalidID() throws IOException {

		ProgramPayload.setProgramName(ProgramPayload.getProgramName());
		ProgramPayload.setProgramDescription(xlutils.getCellData("putprogramdata", 5, 1));
		ProgramPayload.setProgramStatus(xlutils.getCellData("putprogramdata", 5, 2));

		return ProgramPayload;
	}


	//Update with InValid Program Name
	public static ProgramPayload UpdateBodywithInvalidProgramName() throws IOException {

		ProgramPayload.setProgramName(ProgramPayload.getProgramName());
		ProgramPayload.setProgramDescription(xlutils.getCellData("putprogramdata", 6, 1));
		ProgramPayload.setProgramStatus(xlutils.getCellData("putprogramdata", 6, 2));

		return ProgramPayload;
	}
}
