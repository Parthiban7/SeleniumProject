package Tests;

import com.microsoft.playwright.*;

public class AppTest {

	public static void main(String[] args) {
		try(Playwright pw = Playwright.create()){
		Browser br = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
		Page page = br.newPage();
		page.navigate("https://www.google.com");
		System.out.println(page.title());
		}
	}

}
