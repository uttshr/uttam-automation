package context;

import manager.PageObjectManager;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.IOException;

public class TestContext {

	
	private PageObjectManager pageObjectManager;
	private ScenarioContext scenarioContext;
	
	public TestContext() {
		 this.pageObjectManager = new PageObjectManager();
		 this.scenarioContext=new ScenarioContext();
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}
	//	public void createScenario(String scenarioName) {
//		test = report.createTest(scenarioName);
//		this.pageObjectManager.getWebDriverManager().init(test);
//	}
	
	public void endScenario() {
		this.pageObjectManager.getWebDriverManager().quit();
	}

//	public void log(String msg) {
//		this.pageObjectManager.getWebDriverManager().log(msg);
//	}

	public JSONObject readJsonFile(String fileName,String field){
		//JSON parser object to parse read file
		JSONObject obj = null;
		try {
			System.out.println(pageObjectManager.getWebDriverManager().getTestDataResourcePath()+fileName);
			try {
				obj=(JSONObject)new JSONParser().parse(new FileReader(pageObjectManager.getWebDriverManager().getTestDataResourcePath()+fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(field.contains("."))
		{
			String[] path=field.split("\\.");
			for(String p:path)
				obj= (JSONObject) obj.get(p);
			return obj;
		}
		obj= (JSONObject) obj.get(field);
		return obj;
	}
	
	
}
