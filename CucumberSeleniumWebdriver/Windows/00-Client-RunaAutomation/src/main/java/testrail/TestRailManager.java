package testrail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestRailManager {
    public static String TEST_RUN_ID                = "31";
    public static String TESTRAIL_USERNAME          = "uttam.shresta@runahr.com";
    public static String TESTRAIL_PASSWORD          = "Seva1046";
    public static String RAILS_ENGINE_URL           =  "https://runahr.testrail.io/";
    public static final int TEST_CASE_PASSED_STATUS = 1;
    public static final int TEST_CASE_FAILED_STATUS = 5;

    public static void addResultForTestCase(String testCaseId, int status,String error) throws IOException, APIException {

        String testRunId = TEST_RUN_ID;

        APIClient client = new APIClient(RAILS_ENGINE_URL);
        client.setUser(TESTRAIL_USERNAME);
        client.setPassword(TESTRAIL_PASSWORD);
        Map data = new HashMap();
        data.put("status_id", status);
        data.put("comment", "Test Executed - Status updated automatically from Selenium test automation."+error);
        client.sendPost("add_result_for_case/"+testRunId+"/"+testCaseId+"",data );

    }
}
