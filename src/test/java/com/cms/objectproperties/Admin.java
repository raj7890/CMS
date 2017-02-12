package com.cms.objectproperties;

import org.openqa.selenium.By;

public class Admin {

	
	//Admin page object properties
	public By Admin_Txt_EmailAdd = By.name("identification");
	
	public By Admin_Txt_EmailAdd1= By.name("identification");
	
	public By Admin_Txt_Password = By.name("password");
	
	public By Admim_btn_SignIn = By.xpath("//button[@type='submit']");
	
	//public By Admim_btn_SignIn = By.id("ember631");
	
	public By Adim_Btn_Newpost = By.xpath("//a[@title='New Post']");
	
	public By Admin_Txt_Posttitle = By.id("entry-title");
	
	public By Admin_file_Src = By.xpath("//div[@class='gh-image-uploader -with-image']/div/img");
	
	public By Admin_Txt_PostDescription = By.xpath("//textarea[contains(@tabindex,'1')]");
	
	public By Admin_Btn_PostSettings = By.xpath("//button[@title='Post Settings']");
	
	public By Admin_file_Uploadfile =By.xpath("html/body/div[3]/div/div/div[2]/div/div[1]/div[2]/div/section");
	
//	public By Admin_file_Uploadfile =By.xpath("//div[@class='ember-view']/section[@class='ember-view gh-image-uploader']//input[@id='aaedu8']");
	
	public By Admin_file_UploadfileDescription = By.xpath("//label/div[@class='description']");
	
	public By Admin_Txt_Posturl = By.name("post-setting-slug");
	
	public By Admin_Txt_PublishDate = By.name("post-setting-date");
	
	public By Admin_txt_tagname = By.id("tag-input-selectized");
	
	public By Admin_txt_Author = By.xpath("//select[@class=' firepath-matching-node']");
	
	public By Admin_lbl_PostSettings =By.xpath("//h4[contains(.,'Post Settings')]");
	
	public By Admin_Btn_PostSettingsClose = By.xpath("//button[@class='close icon-x settings-menu-header-action']");
	//*[@id='entry-controls']/div[1]/div[1]/button
	
	public By Admin_Btn_Togglebutton = By.xpath("//button[@role='button']//span[contains(text(),'Toggle Settings Menu')]");
	
	public By Admin_lnk_PublishNow = By.xpath("//a[contains(text(),'Publish Now')]");
	
	public By Admin_btn_PublishNow = By.xpath("//section/section/button[1]");
	
	public By Admin_lnk_DeletePost = By.xpath("//a[contains(text(),'Delete Post')]");
	
	public By Admin_Txt_Search = By.xpath("//input[@type='search']");
	
	public By Admin_Txt_UpdatePost = By.xpath("//button[contains(text(),'Update Post')]");
	
	public By Admin_Txt_Publish = By.xpath("//button[contains(text(),'Publish Now')]");
	
	
	
	
			
	
}
