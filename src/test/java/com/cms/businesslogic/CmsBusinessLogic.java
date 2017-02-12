package com.cms.businesslogic;

import java.awt.AWTException;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.cms.Configurations.BrowserConfig;
import com.cms.objectproperties.Admin;
import com.cms.utilities.Helpers;

public class CmsBusinessLogic {

	public static String postname;
	private WebDriver driver;
	private Helpers helper;
	
	BrowserConfig BrowserCofig = new BrowserConfig();
	Admin adminproperties = new Admin();
	
	
	
	public CmsBusinessLogic()
	{
		this.driver = BrowserCofig.getDriver();
		helper = new Helpers(this.driver);
		
	}
	/*	Method Name: LaunchApplication
		Description : Launch Application
		Creation Date:2/06/2017
		Modified Date:NA
		Parameters:
	 */	
	public void LaunchApplication(String Appurl,String Env){
		
		helper.openURL(Appurl,Env);
		String pagetitile = helper.getPageTitle();
		if(pagetitile.equals("Sign In - Crossover TechTrial Blog")&&(helper.elementexists(adminproperties.Admin_Txt_EmailAdd)))
		{
			BrowserCofig.SuccessReport("Sucessfuly Launched  CrossOver Tech Trail Blog application");
		}else{
			BrowserCofig.FailureReport("Unable to Launch CrossOver Tech Trail Blog application");
		}
		
		
	}
	/*	Method Name: CMSLogin
		Description : Launch Application
		Creation Date:2/06/2017
		Modified Date:NA
		Parameters : username,Password
	 */	
	public void CMSLogin(String username,String Password) 
	{		
		boolean falg=false;
		helper.setValue(adminproperties.Admin_Txt_EmailAdd, username,"UserName");
		helper.setValue(adminproperties.Admin_Txt_Password, Password,"Password");
//		helper.click(adminproperties.Admim_btn_SignIn,"SignIn");
		helper.JSclick(adminproperties.Admim_btn_SignIn);
		try {
			helper.waitUntilElementVisible(adminproperties.Adim_Btn_Newpost, 2);
			if(helper.elementexists(adminproperties.Adim_Btn_Newpost)){
				falg= true;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			falg= false;
		}
		if(falg){
			BrowserCofig.SuccessReport("Sucessfully Logged in CrossOver Tech Trail Blog");
		}else{
			BrowserCofig.FailureReport("Unable to Logged in  CrossOver Tech Trail Blog");
		}
		
}	

	/*	Method Name: LaunchApplication
		Description : Fill New post details 
		Creation Date:2/06/2017
		Modified Date:NA
		Parameters : PostName,PostDescription
	 */	
	public void NewPost(String PostName,String PostDescription){
		postname = PostName;
//		helper.click(adminproperties.Adim_Btn_Newpost, "NewPost");
		helper.JSclick(adminproperties.Adim_Btn_Newpost);
		if(helper.elementexists(adminproperties.Admin_Txt_Posttitle)){
			BrowserCofig.SuccessReport("Sucessfully verified the Post Title");
			helper.setValue(adminproperties.Admin_Txt_Posttitle, PostName, "PostTitle");
			helper.click(adminproperties.Admin_Txt_PostDescription, "PostDescription");
			helper.setValue(adminproperties.Admin_Txt_PostDescription, PostDescription, "PostDescription");
		}else{
			BrowserCofig.FailureReport("Post Title field does not Exists on Page");
		}
		
	}
	/*	Method Name: NewPostGeneralSettings
		Description : Enter General Settings details for new post
		Creation Date:2/06/2017
		Modified Date:NA
		Parameters : NA
    */	
	public void NewPostGeneralSettings() 
	{
		
		helper.click(adminproperties.Admin_Btn_PostSettings, "PostSettings");
				
		helper.click(adminproperties.Admin_Btn_PostSettings);
		
		helper.click(adminproperties.Admin_file_Uploadfile,"UploadFile");
		
		File f = new File("images/Rockstar_New_England_logo.svg.png");
		helper.copydatatoclipboard(f.getAbsolutePath());
		try {
			helper.uploadfile();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String imagefile= helper.getAttributeValue(adminproperties.Admin_file_Src, "src");
		
		if(!imagefile.isEmpty()){
			BrowserCofig.SuccessReport("Sucessfully Uploaded file in post Settings");
		}else{
			BrowserCofig.FailureReport("Unable to Upload file in post Settings");
			}
		
		helper.JSclick(adminproperties.Admin_Btn_PostSettingsClose);
			
		helper.click(adminproperties.Admin_Btn_Togglebutton,"ToggleButton");
		
		helper.click(adminproperties.Admin_lnk_PublishNow,"PublishNowLink");
		
		helper.click(adminproperties.Admin_btn_PublishNow,"PublishNowButton");
		
		try {
			helper.waitForMilliSeconds(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String strvalue = helper.getText(adminproperties.Admin_btn_PublishNow);
		if(strvalue.equals("UPDATE POST")){
			BrowserCofig.SuccessReport("Sucessfully Posted NewPost "+postname);
		}else{
			BrowserCofig.FailureReport("Unable to Posted NewPost "+postname);
		}
	}
	
	/*Method Name: SearchPost
	  Description : Search a created Post
	  Creation Date:2/06/2017
	  Modified Date:NA
	  Parameters : PostName
	 */
	public void SearchPost(String PostName){
		
	}
	/*Method Name: DeletePost
	  Description : Delete a created Post
	  Creation Date:2/06/2017
	  Modified Date:NA
	  Parameters : PostName
	 */
	public void DeletePost(String PostName){
		
	}
}
