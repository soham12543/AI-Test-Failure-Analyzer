package ai;

public class AIService{

	public String analyzeFailure(String testName,
            String exception,
            String currentURL,
            String pageTitle,
            String screenshotPath,
            String locator) throws Exception {

String prompt = PromptBuilder.buildPrompt(
testName,
exception,
currentURL,
pageTitle,
screenshotPath,
locator);

GeminiClient client = new GeminiClient();

return client.getAnalysis(prompt);
}
    
}