package api.utilities;


import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import api.payload.*;
import api.payload.AssignmentPayload;
import api.payload.AssignmentSubmitPayload;
import api.payload.BatchPayload;
import api.payload.ProgramPayload;
import api.payload.UserPayload;
import api.payload.UserRoleMap;
import io.restassured.response.Response;

public class RestUtils {

	public static ResourceBundle routes = ResourceBundle.getBundle("Routes");

	public static Logger log = LogManager.getLogger();

	//Schema and xcell path
	public static ResourceBundle path = ResourceBundle.getBundle("path");
	public static XLUtils xlutils=new XLUtils(path.getString("Xlpath"));

	//program schema path
	public static File programPutjson = xlutils.getJSONFile(path.getString("programPutSchemajson"));
	public static File programPostjson = xlutils.getJSONFile(path.getString("programPostSchemajson"));	

	//batch schema path
	public static File postbatchJson = xlutils.getJSONFile(path.getString("postbatchJson"));			
	public static File getbatchbynameJson = xlutils.getJSONFile(path.getString("getbatchbynameJson"));
	public static File getbatchIDJson = xlutils.getJSONFile(path.getString("getbatchIDJson"));
	public static File updatebatchIDJson = xlutils.getJSONFile(path.getString("batchupdatebyIDJson"));

	//user schema path
	public static File getAllUserjson= xlutils.getJSONFile(path.getString("getAllUserjson"));
	public static File getUserByIDjson= xlutils.getJSONFile(path.getString("getUserByIDjson"));
	public static File getUserByRolejson= xlutils.getJSONFile(path.getString("getUserByRolejson"));
	public static File postUserjson= xlutils.getJSONFile(path.getString("postUserjson"));
	public static File putUserByIdjson= xlutils.getJSONFile(path.getString("putUserByIdjson"));
	public static File putUserStatusRolejson= xlutils.getJSONFile(path.getString("putUserStatusRolejson"));

	//assignment schema path
	public static File postAssignmentJson = xlutils.getJSONFile(path.getString("postAssignmentJson"));	
	public static File GetByIdJson = xlutils.getJSONFile(path.getString("GetByIdJson"));

	//assignment schema path
	public static File AssignSubmitPostjson = xlutils.getJSONFile(path.getString("AssignSubmitPostjson"));
	public static File AssignSubmitUserIDjson = xlutils.getJSONFile(path.getString("AssignSubUserIDjson"));
	public static File AssignSubmitgradeIDjson = xlutils.getJSONFile(path.getString("AssignSubGradeIDjson"));


	//payload objects
	public static ProgramPayload ProgramPayload = new ProgramPayload();
	public static BatchPayload BatchPayload = new BatchPayload();
	public static UserPayload UserPayload = new UserPayload();
	public static UserRoleMap UserRoleMap = new UserRoleMap();
	public static UserWithoutRole UserWithoutRole=new UserWithoutRole();
	public static UserProgBatchIdRoleMap UserProgBatchIdRoleMap =new UserProgBatchIdRoleMap();
	public static userRoleProgramBatches userRoleProgramBatches=new userRoleProgramBatches();
	public static AssignmentPayload AssignmentPayload = new AssignmentPayload();
	public static AssignmentSubmitPayload AssignmentSubmitPayload = new AssignmentSubmitPayload();


	public static Response response;
	public static String AdminUser;
	public static String StudentUser;	
	public static String StaffUser; 

}
