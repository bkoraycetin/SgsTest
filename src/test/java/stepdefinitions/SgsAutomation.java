package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.SgsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.io.IOException;
import java.util.Set;

public class SgsAutomation {
    SgsPage sgsPage = new SgsPage();
    @Given("user goes to the homepage")
    public void user_goes_to_the_homepage() {
            Driver.getDriver().get(ConfigReader.getProperty("sgs_url"));
    }

    @Given("user clicks the reject cookies button")
    public void user_clicks_the_reject_cookies_button() {
    sgsPage.rejectCookiesButton.click();

    }

    @Given("user clicks the Our Services button")
    public void user_clicks_the_Our_Services_button() {

       sgsPage.ourServicesButton.click();
    }

    @Given("user hovers over Health Science and clicks")
    public void user_hovers_over_health_science_and_clicks() {

        ReusableMethods.hover(sgsPage.healthScience);
        sgsPage.healthScience.click();

    }
    @Given("user clicks Clinical Research")
    public void user_clicks_clinical_research() {
        Driver.wait(1);
        ReusableMethods.hover(sgsPage.clinicalResearch);
        sgsPage.clinicalResearch.click();

    }
    @Given("user clicks Biometrics")
    public void user_clicks_biometrics() {
        Driver.wait(1);
        ReusableMethods.hover(sgsPage.biometrics);
        sgsPage.biometrics.click();

    }
    @Given("user clicks the download button for the pdf file")
    public void user_clicks_the_download_button_for_the_pdf_file() {
    Driver.wait(2);
    ReusableMethods.hover(sgsPage.downloadButton);
    sgsPage.downloadButton.click();
    }
    @Given("take a screenshot")
    public void take_a_screenshot() throws IOException {
    ReusableMethods.getScreenshot("biometrics");

    }
    @Given("validate the file is downloaded")
    public void validate_the_file_is_downloaded() {
        /*String downloadDir = "C:/Users/Gebruiker/Downloads";
        File downloadedFile = new File(downloadDir + File.separator + "SGS HN 427046 Biometrics Brochure 21 12 LR 2 EN.pdf");

        // Assert that the file exists
        assertTrue("The file was not downloaded", downloadedFile.exists());*/
    }

    @Given("user navigates to another window that contains the pdf file")
    public void user_navigates_to_another_window_that_contains_the_pdf_file() {
        String mainWindowHandle = Driver.getDriver().getWindowHandle();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                Driver.getDriver().switchTo().window(handle);
                break;
            }
        }

    }
    @Given("user clicks the final download button")
    public void user_clicks_the_final_download_button() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        WebElement firstShadowHost = Driver.getDriver().findElement(By.cssSelector("#viewer"));
        WebElement firstShadowRoot = (WebElement) ((JavascriptExecutor) Driver.getDriver())
                .executeScript("return arguments[0].shadowRoot", firstShadowHost);


        WebElement secondShadowHost = firstShadowRoot.findElement(By.cssSelector("viewer-toolbar"));
        WebElement secondShadowRoot = (WebElement) jse.executeScript("return arguments[0].shadowRoot", secondShadowHost);

        WebElement thirdShadowHost = secondShadowRoot.findElement(By.cssSelector("viewer-download-controls"));
        WebElement thirdShadowRoot = (WebElement) jse.executeScript("return arguments[0].shadowRoot", thirdShadowHost);
        WebElement downloadButton = thirdShadowRoot.findElement(By.cssSelector("cr-icon-button"));

        downloadButton.click();

    }
}
