package api.requestbody;
import api.utilities.RestUtils;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;

import api.payload.BatchPayload;


public class BatchBody extends RestUtils{

	//post body
	public static BatchPayload PostBody() throws IOException {

		BatchPayload.setBatchDescription(xlutils.getCellData("batchpostdata", 1, 0));
		BatchPayload.setBatchName(ProgramPayload.getProgramName() + xlutils.getCellData("batchpostdata", 1, 1)+RandomStringUtils.randomNumeric(3));
		BatchPayload.setBatchNoOfClasses(xlutils.getCellData("batchpostdata", 1, 2));
		BatchPayload.setBatchStatus(xlutils.getCellData("batchpostdata", 1, 3));
		BatchPayload.setProgramId(ProgramPayload.getProgramId());

		return BatchPayload;
	}	

	//post existing value
	public static BatchPayload ExistingPostBody() throws IOException {

		BatchPayload.setBatchDescription(BatchPayload.getBatchDescription());
		BatchPayload.setBatchName(BatchPayload.getBatchName());
		BatchPayload.setBatchNoOfClasses(BatchPayload.getBatchNoOfClasses());
		BatchPayload.setBatchStatus(BatchPayload.getBatchStatus());
		BatchPayload.setProgramId(ProgramPayload.getProgramId());

		return BatchPayload;
	}

	//post body empty
	public static BatchPayload PostBodyEmpty() throws IOException {

		BatchPayload.setBatchDescription(xlutils.getCellData("batchpostdata", 2, 0));
		BatchPayload.setBatchName(ProgramPayload.getProgramName() + xlutils.getCellData("batchpostdata", 2, 1));//+RandomStringUtils.randomNumeric(3));
		BatchPayload.setBatchNoOfClasses(xlutils.getCellData("batchpostdata", 2, 2));
		BatchPayload.setBatchStatus(xlutils.getCellData("batchpostdata", 2, 3));
		BatchPayload.setProgramId(ProgramPayload.getProgramId());

		return BatchPayload;
	}

	//put invalid body
	public static BatchPayload PutBodyInvalidID () throws IOException {

		BatchPayload.setBatchId(Integer.parseInt(xlutils.getCellData("batchpostdata", 2, 4)));

		return BatchPayload;

	}

	//get batch by invalid id
	public static BatchPayload GetBatchbyInvalidProgID () throws IOException {

		BatchPayload.setProgramId(Integer.parseInt(xlutils.getCellData("batchpostdata", 3, 5)));

		return BatchPayload;

	}

	//get batch by invalid name
	public static BatchPayload GetBatchbyInvalidBatchName () throws IOException {

		BatchPayload.setBatchName(xlutils.getCellData("batchpostdata", 4, 6));

		return BatchPayload;

	}
}
