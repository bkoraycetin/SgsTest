@sgs
Feature: Sgs Test
  Scenario: Download a Document
    * user goes to the homepage
    * user clicks the reject cookies button
    * user clicks the Our Services button
    * user hovers over Health Science and clicks
    * user clicks Clinical Research
    * user clicks Biometrics
    * user clicks the download button for the pdf file
    * take a screenshot
    * user navigates to another window that contains the pdf file
    * user clicks the final download button
    * validate the file is downloaded
