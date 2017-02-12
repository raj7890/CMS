package com.cms.TestScripts;


import org.testng.annotations.Test;

import com.cms.Configurations.BrowserConfig;
import com.cms.businesslogic.CmsBusinessLogic;

public class VerifyNewPost extends BrowserConfig{
	
	@Test
	public void VerifyLoginCrossOverPage(){
		
		CmsBusinessLogic blogic = new CmsBusinessLogic();
		
		
			blogic.LaunchApplication("http://localhost:2368/ghost/signin/",this.getEnvrironment());
		
			blogic.CMSLogin("admin@test.com", "1q2w3e4r");
		
			blogic.NewPost("TestPost", "TestPostDescription");
			
			blogic.NewPostGeneralSettings();
		
		
	}

}
