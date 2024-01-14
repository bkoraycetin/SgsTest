package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SgsPage {
    public SgsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "onetrust-reject-all-handler")
    public WebElement rejectCookiesButton;

    @FindBy (xpath = "//span[normalize-space(text())='Our Services']")
    public WebElement ourServicesButton;


    @FindBy (xpath = "//a[text()='Health Science']")
    public WebElement healthScience;

    @FindBy (xpath = "//h3[normalize-space()='Clinical Research']")
    public WebElement clinicalResearch;

    @FindBy (xpath = "//h3[normalize-space()='Biometrics']")
    public WebElement biometrics;

    @FindBy (xpath = "//div[@class='DownloadListItem_m-download-list-item__content__lGK2b flex flex-row justify-between items-center']//*[name()='svg']")
    public WebElement downloadButton;







}
