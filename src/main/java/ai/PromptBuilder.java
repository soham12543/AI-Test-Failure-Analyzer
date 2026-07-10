package ai;

public class PromptBuilder {

    public static String buildPrompt(String testName,
                                     String exception,
                                     String currentURL,
                                     String pageTitle,
                                     String screenshotPath,
                                     String locator) {

        return """
You are a Senior QA Automation Engineer with expertise in Selenium, Java, TestNG and API Testing.

Analyze the following Selenium automation test failure and generate a professional QA bug report.

========================================================

Test Name:
%s

Current URL:
%s

Page Title:
%s

Screenshot Path:
%s

Exception:
%s

Locator:
%s

========================================================

Instructions:

1. Analyze the exception carefully.
2. Use the URL and Page Title to understand where the test failed.
3. Infer the most likely reason for failure.
4. Assume this report will be shared with Developers and QA Leads.

Return ONLY the following format.

--------------------------------------------------------

🔍 ROOT CAUSE
(Explain in 2-3 lines.)

🎯 CONFIDENCE
(Percentage)

🐞 BUG TITLE
(One short meaningful title.)

📝 DESCRIPTION
(Explain what happened.)

📋 STEPS TO REPRODUCE
1.
2.
3.

✅ EXPECTED RESULT

❌ ACTUAL RESULT

🛠 SUGGESTED FIX
• Point 1
• Point 2
• Point 3

📌 ISSUE TYPE
(Test Issue / Application Issue)

⚠ SEVERITY
(Low / Medium / High)

🚨 PRIORITY
(Low / Medium / High)

💡 PREVENTION
(How can this type of failure be avoided in future?)

--------------------------------------------------------

Rules:
- Keep the response under 250 words.
- Do not return JSON.
- Do not mention that you are an AI.
- Give direct and professional answers.

"""
.formatted(
                testName,
                currentURL,
                pageTitle,
                screenshotPath,
                exception,
                locator);
    }
}