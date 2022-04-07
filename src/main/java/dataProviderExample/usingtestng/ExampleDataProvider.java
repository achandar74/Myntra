package dataProviderExample.usingtestng;

import org.testng.annotations.Parameters;

public class ExampleDataProvider {
@Parameters({"url"})
	public void url(String urlname) {
		System.out.println(urlname);
	}

}
