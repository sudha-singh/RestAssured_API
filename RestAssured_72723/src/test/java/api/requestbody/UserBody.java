package api.requestbody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import api.payload.UserPayload;
import api.payload.UserProgBatchIdRoleMap;
import api.payload.UserRoleMap;
import api.payload.UserWithoutRole;
import api.utilities.RestUtils;

public class UserBody extends RestUtils {

	//post body
	@SuppressWarnings("unchecked")
	public static UserPayload PostBody() throws IOException {

		UserPayload.setUserComments(xlutils.getCellData("userpostdata", 1, 0));
		UserPayload.setUserEduPg(xlutils.getCellData("userpostdata", 1, 1));
		UserPayload.setUserEduUg(xlutils.getCellData("userpostdata", 1, 2));
		UserPayload.setUserFirstName(xlutils.getCellData("userpostdata", 1, 3));
		UserPayload.setUserLastName(xlutils.getCellData("userpostdata", 1, 4));
		UserPayload.setUserLinkedinUrl(xlutils.getCellData("userpostdata", 1, 5));
		UserPayload.setUserLocation(xlutils.getCellData("userpostdata", 1, 6));
		UserPayload.setUserMiddleName(xlutils.getCellData("userpostdata", 1, 7));
		UserPayload.setUserPhoneNumber(xlutils.getCellData("userpostdata", 1, 8));

		List userRoleMaps = new ArrayList<>();
		userRoleMaps.add(UserRoleMap);
		UserRoleMap.setRoleId("R01");
		UserRoleMap.setUserRoleStatus("active");

		UserPayload.setUserRoleMaps(userRoleMaps);

		UserPayload.setUserTimeZone(xlutils.getCellData("userpostdata", 1, 11));
		UserPayload.setUserVisaStatus(xlutils.getCellData("userpostdata", 1, 12));

		return UserPayload;
	}

	//post existing value
	@SuppressWarnings("unchecked")
	public static UserPayload PostExtgPhnNumBody() throws IOException {

		UserPayload.setUserComments(xlutils.getCellData("userpostdata", 3, 0));
		UserPayload.setUserEduPg(xlutils.getCellData("userpostdata", 3, 1));
		UserPayload.setUserEduUg(xlutils.getCellData("userpostdata", 3, 2));
		UserPayload.setUserFirstName(UserPayload.getUserFirstName());
		UserPayload.setUserLastName(xlutils.getCellData("userpostdata", 3, 4));
		UserPayload.setUserLinkedinUrl(xlutils.getCellData("userpostdata", 3, 5));
		UserPayload.setUserLocation(xlutils.getCellData("userpostdata", 3, 6));
		UserPayload.setUserMiddleName(xlutils.getCellData("userpostdata", 3, 7));
		UserPayload.setUserPhoneNumber(UserPayload.getUserPhoneNumber());

		List userRoleMaps = new ArrayList<>();
		userRoleMaps.add(UserRoleMap);
		UserRoleMap.setRoleId("R01");
		UserRoleMap.setUserRoleStatus("active");

		UserPayload.setUserRoleMaps(userRoleMaps);

		UserPayload.setUserTimeZone(xlutils.getCellData("userpostdata", 3, 11));
		UserPayload.setUserVisaStatus(xlutils.getCellData("userpostdata", 3, 12));

		return UserPayload;
	}

	//post missing field value
	@SuppressWarnings("unchecked")
	public static UserPayload PostMissingFieldsBody() throws IOException {

		UserPayload.setUserComments(xlutils.getCellData("userpostdata", 2, 0));
		UserPayload.setUserEduPg(xlutils.getCellData("userpostdata", 2, 1));
		UserPayload.setUserEduUg(xlutils.getCellData("userpostdata", 2, 2));
		UserPayload.setUserFirstName(xlutils.getCellData("userpostdata", 2, 3));
		UserPayload.setUserLastName(xlutils.getCellData("userpostdata", 2, 4));
		UserPayload.setUserLinkedinUrl(xlutils.getCellData("userpostdata", 2, 5));
		UserPayload.setUserLocation(xlutils.getCellData("userpostdata", 2, 6));
		UserPayload.setUserMiddleName(xlutils.getCellData("userpostdata", 2, 7));
		UserPayload.setUserPhoneNumber(xlutils.getCellData("userpostdata", 2, 8));

		List userRoleMaps = new ArrayList<>();
		userRoleMaps.add(UserRoleMap);
		UserRoleMap.setRoleId("R01");
		UserRoleMap.setUserRoleStatus("active");

		UserPayload.setUserRoleMaps(userRoleMaps);

		UserPayload.setUserTimeZone(xlutils.getCellData("userpostdata", 2, 11));
		UserPayload.setUserVisaStatus(xlutils.getCellData("userpostdata", 2, 12));

		return UserPayload;

	}

	//post admin  body
	@SuppressWarnings("unchecked")
	public static UserPayload PostAdminBody() throws IOException {

		UserPayload.setUserComments(xlutils.getCellData("userpostdata", 4, 0));
		UserPayload.setUserEduPg(xlutils.getCellData("userpostdata", 4, 1));
		UserPayload.setUserEduUg(xlutils.getCellData("userpostdata", 4, 2));
		UserPayload.setUserFirstName(xlutils.getCellData("userpostdata", 4, 3) + RandomStringUtils.randomNumeric(3));
		UserPayload.setUserLastName(xlutils.getCellData("userpostdata", 4, 4));
		UserPayload.setUserLinkedinUrl(xlutils.getCellData("userpostdata", 4, 5));
		UserPayload.setUserLocation(xlutils.getCellData("userpostdata", 4, 6));
		UserPayload.setUserMiddleName(xlutils.getCellData("userpostdata", 4, 7));
		UserPayload.setUserPhoneNumber(xlutils.getCellData("userpostdata", 4, 8) + RandomStringUtils.randomNumeric(10));

		List userRoleMaps = new ArrayList<>();
		userRoleMaps.add(UserRoleMap);
		UserRoleMap.setRoleId("R01");
		UserRoleMap.setUserRoleStatus("active");

		UserPayload.setUserRoleMaps(userRoleMaps);

		UserPayload.setUserTimeZone(xlutils.getCellData("userpostdata", 4, 11));
		UserPayload.setUserVisaStatus(xlutils.getCellData("userpostdata", 4, 12));

		return UserPayload;
	}

	//post staff body
	@SuppressWarnings("unchecked")
	public static UserPayload PostStaffBody() throws IOException {

		UserPayload.setUserComments(xlutils.getCellData("userpostdata", 5, 0));
		UserPayload.setUserEduPg(xlutils.getCellData("userpostdata", 5, 1));
		UserPayload.setUserEduUg(xlutils.getCellData("userpostdata", 5, 2));
		UserPayload.setUserFirstName(xlutils.getCellData("userpostdata", 5, 3) + RandomStringUtils.randomNumeric(3));
		UserPayload.setUserLastName(xlutils.getCellData("userpostdata", 5, 4));
		UserPayload.setUserLinkedinUrl(xlutils.getCellData("userpostdata", 5, 5));
		UserPayload.setUserLocation(xlutils.getCellData("userpostdata", 5, 6));
		UserPayload.setUserMiddleName(xlutils.getCellData("userpostdata", 5, 7));
		UserPayload.setUserPhoneNumber(xlutils.getCellData("userpostdata", 5, 8) + RandomStringUtils.randomNumeric(10));
		;

		List userRoleMaps = new ArrayList<>();
		userRoleMaps.add(UserRoleMap);
		UserRoleMap.setRoleId("R02");
		UserRoleMap.setUserRoleStatus("active");

		UserPayload.setUserRoleMaps(userRoleMaps);

		UserPayload.setUserTimeZone(xlutils.getCellData("userpostdata", 5, 11));
		UserPayload.setUserVisaStatus(xlutils.getCellData("userpostdata", 5, 12));

		return UserPayload;
	}

	//post student body
	@SuppressWarnings("unchecked")
	public static UserPayload PostStudentBody() throws IOException {

		UserPayload.setUserComments(xlutils.getCellData("userpostdata", 6, 0));
		UserPayload.setUserEduPg(xlutils.getCellData("userpostdata", 6, 1));
		UserPayload.setUserEduUg(xlutils.getCellData("userpostdata", 6, 2));
		UserPayload.setUserFirstName(xlutils.getCellData("userpostdata", 6, 3) + RandomStringUtils.randomNumeric(3));
		UserPayload.setUserLastName(xlutils.getCellData("userpostdata", 6, 4));
		UserPayload.setUserLinkedinUrl(xlutils.getCellData("userpostdata", 6, 5));
		UserPayload.setUserLocation(xlutils.getCellData("userpostdata", 6, 6));
		UserPayload.setUserMiddleName(xlutils.getCellData("userpostdata", 6, 7));
		UserPayload.setUserPhoneNumber(xlutils.getCellData("userpostdata", 6, 8) + RandomStringUtils.randomNumeric(10));

		List userRoleMaps = new ArrayList<>();
		userRoleMaps.add(UserRoleMap);
		UserRoleMap.setRoleId("R03");
		UserRoleMap.setUserRoleStatus("active");

		UserPayload.setUserRoleMaps(userRoleMaps);

		UserPayload.setUserTimeZone(xlutils.getCellData("userpostdata", 6, 11));
		UserPayload.setUserVisaStatus(xlutils.getCellData("userpostdata", 6, 12));

		return UserPayload;
	}

	//put user body
	public static UserWithoutRole PutUserBody() throws IOException {

		UserWithoutRole.setUserComments(xlutils.getCellData("userputdata", 1, 0));
		UserWithoutRole.setUserEduPg(xlutils.getCellData("userputdata", 1, 1));
		UserWithoutRole.setUserEduUg(xlutils.getCellData("userputdata", 1, 2));
		UserWithoutRole.setUserFirstName(UserPayload.getUserFirstName());
		UserWithoutRole.setUserLastName(xlutils.getCellData("userputdata", 1, 4));
		UserWithoutRole.setUserLinkedinUrl(xlutils.getCellData("userputdata", 1, 5));
		UserWithoutRole.setUserLocation(xlutils.getCellData("userputdata", 1, 6));
		UserWithoutRole.setUserMiddleName(xlutils.getCellData("userputdata", 1, 7));
		UserWithoutRole.setUserPhoneNumber(UserPayload.getUserPhoneNumber());

		UserProgBatchIdRoleMap.setUserId(AdminUser);
		// UserPayload.setUserId(AdminUser);
		UserWithoutRole.setUserTimeZone(xlutils.getCellData("userputdata", 1, 11));
		UserWithoutRole.setUserVisaStatus(xlutils.getCellData("userputdata", 1, 12));

		return UserWithoutRole;
	}

	//put missing field body
	public static UserWithoutRole PutUserMissingFieldsBody() throws IOException {

		UserWithoutRole.setUserComments(xlutils.getCellData("userputdata", 4, 0));
		UserWithoutRole.setUserEduPg(xlutils.getCellData("userputdata", 4, 1));
		UserWithoutRole.setUserEduUg(xlutils.getCellData("userputdata", 4, 2));
		UserWithoutRole.setUserFirstName(xlutils.getCellData("userputdata", 4, 3));
		UserWithoutRole.setUserLastName(xlutils.getCellData("userputdata", 4, 4));
		UserWithoutRole.setUserLinkedinUrl(xlutils.getCellData("userputdata", 4, 5));
		UserWithoutRole.setUserLocation(xlutils.getCellData("userputdata", 4, 6));
		UserWithoutRole.setUserMiddleName(xlutils.getCellData("userputdata", 4, 7));
		UserWithoutRole.setUserPhoneNumber(xlutils.getCellData("userputdata", 4, 8));

		UserProgBatchIdRoleMap.setUserId(AdminUser);
		// UserPayload.setUserId(AdminUser);
		UserWithoutRole.setUserTimeZone(xlutils.getCellData("userputdata", 4, 11));
		UserWithoutRole.setUserVisaStatus(xlutils.getCellData("userputdata", 4, 12));

		return UserWithoutRole;
	}

	//Put User Role Status Body
	public static UserRoleMap PutUserRoleStatusBody() throws IOException {

		UserRoleMap.setRoleId(xlutils.getCellData("userputdata", 1, 9));
		UserRoleMap.setUserRoleStatus(xlutils.getCellData("userputdata", 1, 10));
		// UserPayload.getUserId();

		return UserRoleMap;
	}

	//Put User Role Status Missing ID Body
	public static UserRoleMap PutUserRoleStatusMissingIDBody() throws IOException {

		UserRoleMap.setRoleId(xlutils.getCellData("userputdata", 5, 9));
		UserRoleMap.setUserRoleStatus(xlutils.getCellData("userputdata", 5, 10));
		// UserPayload.getUserId();

		return UserRoleMap;
	}

	//Put User Role Status Missing Stats Body
	public static UserRoleMap PutUserRoleStatusMissingStatsBody() throws IOException {

		UserRoleMap.setRoleId(xlutils.getCellData("userputdata", 6, 9));
		UserRoleMap.setUserRoleStatus(xlutils.getCellData("userputdata", 6, 10));
		// UserPayload.getUserId();

		return UserRoleMap;
	}

	//Put User Role Status Different Role Id Body
	public static UserRoleMap PutUserRoleStatusDifferentRoleIdBody() throws IOException {

		UserRoleMap.setRoleId(xlutils.getCellData("userputdata", 8, 9));
		UserRoleMap.setUserRoleStatus(xlutils.getCellData("userputdata", 8, 10));
		// UserPayload.getUserId();

		return UserRoleMap;
	}


	//Assign User To Prog Batch Body
	@SuppressWarnings("unchecked")
	public static UserProgBatchIdRoleMap AssignUserToProgBatchBody() throws IOException {

		UserProgBatchIdRoleMap.setProgramId(ProgramPayload.getProgramId());
		// UserProgBatchIdRoleMap.setRoleId(UserRoleMap.getRoleId());
		UserProgBatchIdRoleMap.setRoleId("R01");
		UserProgBatchIdRoleMap.setUserId(AdminUser);

		List uRoleProgramBatches = new ArrayList<>();
		uRoleProgramBatches.add(userRoleProgramBatches);

		userRoleProgramBatches.setBatchId(BatchPayload.getBatchId());
		userRoleProgramBatches.setUserRoleProgramBatchStatus(xlutils.getCellData("userputdata", 1, 13));
		UserProgBatchIdRoleMap.setUserRoleProgramBatches(uRoleProgramBatches);

		// UserPayload.setUserRoleMaps(userRoleMaps);

		return UserProgBatchIdRoleMap;
	}

	//Assign User To Prog Batch Msng Field Body
	@SuppressWarnings("unchecked")
	public static UserProgBatchIdRoleMap AssignUserToProgBatchMsngFieldBody() throws IOException {

		UserProgBatchIdRoleMap.setProgramId(ProgramPayload.getProgramId());
		UserProgBatchIdRoleMap.setRoleId(UserRoleMap.getRoleId());
		UserProgBatchIdRoleMap.setUserId(AdminUser);

		List uRoleProgramBatches = new ArrayList<>();
		uRoleProgramBatches.add(userRoleProgramBatches);

		userRoleProgramBatches.setBatchId(BatchPayload.getBatchId());
		userRoleProgramBatches.setUserRoleProgramBatchStatus(xlutils.getCellData("userputdata", 7, 13));
		UserProgBatchIdRoleMap.setUserRoleProgramBatches(uRoleProgramBatches);

		// UserPayload.setUserRoleMaps(userRoleMaps);

		return UserProgBatchIdRoleMap;
	}

	//Assign User To Prog Batch Invalid Body
	@SuppressWarnings("unchecked")
	public static UserProgBatchIdRoleMap AssignUserToProgBatchInvalidBody() throws IOException {

		UserProgBatchIdRoleMap.setProgramId(ProgramPayload.getProgramId());
		// UserProgBatchIdRoleMap.setRoleId(UserRoleMap.getRoleId());
		UserProgBatchIdRoleMap.setRoleId("R03");
		UserProgBatchIdRoleMap.setUserId(AdminUser);

		List uRoleProgramBatches = new ArrayList<>();
		uRoleProgramBatches.add(userRoleProgramBatches);

		userRoleProgramBatches.setBatchId(BatchPayload.getBatchId());
		userRoleProgramBatches.setUserRoleProgramBatchStatus(xlutils.getCellData("userputdata", 1, 13));
		UserProgBatchIdRoleMap.setUserRoleProgramBatches(uRoleProgramBatches);

		// UserPayload.setUserRoleMaps(userRoleMaps);

		return UserProgBatchIdRoleMap;
	}
}
