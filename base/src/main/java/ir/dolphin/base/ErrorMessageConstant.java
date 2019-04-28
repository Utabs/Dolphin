package ir.dolphin.base;


public class ErrorMessageConstant {

    public final static Integer APPROVED_CODE = 0;

    /************************ Common ******************************************/
    public static final Integer COMMON_GENERAL_ERROR_CODE = -1;
    public static final String COMMON_GENERAL_ERROR_MESSAGE = "common.error.general";

    public static final Integer COMMON_TRANSACTION_ERROR_CODE = -2;
    public static final String COMMON_TRANSACTION_ERROR_MESSAGE = "common.error.transaction";

    public static final Integer COMMON_PARAM_IS_NULL_CODE = 80001;
    public static final String COMMON_PARAM_IS_NULL_MESSAGE = "common.error.paramIsNull";

    public static final Integer COMMON_TODATE_LESS_THAN_FROMDATE_CODE = 80006;
    public static final String COMMON_TODATE_LESS_THAN_FROMDATE_MESSAGE = "common.error.todateLessThanFromdate";

    public static final Integer COMMON_DATA_NOT_FOUND_CODE = 20004;
    public static final String COMMON_DATA_NOT_FOUND_MESSAGE = "common.error.dataNotFound";

    public static final Integer COMMON_JSON_MODEL_NOT_FOUND_CODE = 20009;
    public static final String COMMON_JSON_MODEL_NOT_FOUND_MESSAGE = "common.error.JsonModelNotFound";

    public static final Integer COMMON_PARAMETER_NOT_VALID_CODE = 20010;
    public static final String COMMON_PARAMETER_NOT_VALID_MESSAGE = "common.error.ParameterNotValid";

    /************************ DataBase ****************************************/

    public static final Integer DB_CONNECTION_FAILED_CODE = 50001;
    public static final String DB_CONNECTION_FAILED_MESSAGE = "db.error.connectionFail";

    public static final Integer DB_RECORD_NOT_FOUND_CODE = 50002;
    public static final String DB_RECORD_NOT_FOUND_MESSAGE = "db.error.recordNotFound";

    public static final Integer DB_RECORD_NOT_INSERTED_CODE = 50003;
    public static final String DB_RECORD_NOT_INSERTED_MESSAGE = "db.error.recordNotInserted";

    public static final Integer DB_RECORD_NOT_UPDATED_CODE = 50004;
    public static final String DB_RECORD_NOT_UPDATED_MESSAGE = "db.error.recordNotUpdated";

    public static final Integer DB_RECORD_NOT_DELETED_CODE = 50005;
    public static final String DB_RECORD_NOT_DELETED_MESSAGE = "db.error.recordNotDeleted";

    public static final Integer DB_RECORD_IS_DUPLICATE_CODE = 50006;
    public static final String DB_RECORD_IS_DUPLICATE_MESSAGE = "db.error.recordIsDuplicate";

    public static final Integer DB_RECORD_HAS_RELATIONSHIP_CODE = 50007;
    public static final String DB_RECORD_HAS_RELATIONSHIP_MESSAGE = "db.error.recordHasRelationship";

    public static final Integer DB_INVALID_DATA_CODE = 50008;
    public static final String DB_INVALID_DATA_MESSAGE = "db.error.invalidData";

    public static final Integer DB_NOT_SUCCESSFULL_QUERY_CODE = 50009;
    public static final String DB_NOT_SUCCESSFULL_QUERY_MESSAGE = "db.error.notSuccessfullQuery";


}
