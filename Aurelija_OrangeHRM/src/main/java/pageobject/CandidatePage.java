package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CandidatePage extends BasePage {
    public CandidatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "form[class='oxd-form'] h6[class='oxd-text oxd-text--h6 orangehrm-main-title']")
    private WebElement titletextInput;

    @FindBy(css = ".oxd-table-header-cell")
    private WebElement historyHeadersTableInput;

    @FindBy(css = ".oxd-table-header-cell")
    private List<WebElement> historyHeadersTableInputs;

    @FindBy(css = ".oxd-switch-input.oxd-switch-input--active.--label-left")
    private WebElement switchBtnInput;

    @FindBy(css = "input[placeholder='First Name']")
    private WebElement isFirstNameClickableInput;

    @FindBy(css = "button[type=\"submit\"].oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
    private WebElement saveBtn;

    public List<WebElement> getTableHeaders() {

        waitForVisibility(titletextInput);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        waitForVisibility(historyHeadersTableInput);

        return historyHeadersTableInputs;
    }

    public void clickSwitchBtn() {
        waitForVisibility(isFirstNameClickableInput);
        switchBtnInput.click();
    }

    public boolean checkThatISClickable() {
        waitForVisibility(titletextInput);
        return isFirstNameClickableInput.isEnabled();
    }

    public void setEditFirstName(String editedfirstname) {
        String text = isFirstNameClickableInput.getAttribute("value");
        for (int i = 0; i < (text != null ? text.length() : 0); i++) {
            isFirstNameClickableInput.sendKeys(Keys.BACK_SPACE);
        }

        isFirstNameClickableInput.sendKeys(editedfirstname);
    }

    public void clickSaveBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        waitForVisibility(saveBtn);
        saveBtn.click();
    }

    public String  checkIsFirstNameEdited() {
        return isFirstNameClickableInput.getAttribute("value");
    }
}
