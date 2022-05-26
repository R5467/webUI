import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class CabinetPage(driver: WebDriver?) : AbstractPage(driver) {
    var js: JavascriptExecutor = DriverManager.getDriver() as JavascriptExecutor

    @FindBy(xpath = "//a[@href='/cabinet/personal/']")
    private val personalBtt: WebElement? = null

    @FindBy(xpath = "//input[@name='NAME']")
    private val nameInputField: WebElement? = null

    @FindBy(xpath = "//input[@name='SECOND_NAME']")
    private val secondNameInputField: WebElement? = null

    @FindBy(xpath = "//input[@name='LAST_NAME']")
    private val lastNameInputField: WebElement? = null

    @FindBy(xpath = "//input[@name='NEW_PASSWORD']")
    private val newPasswordInputField: WebElement? = null

    @FindBy(xpath = "//input[@name='save']")
    private val applyBtt: WebElement? = null
    fun pressPersonlBtt(): CabinetPage {
        personalBtt.click()
        WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.urlContains("/cabinet/personal"))
        return this
    }

    @kotlin.Throws(InterruptedException::class)
    fun pressApplyBtt(): CabinetPage {
        // new Actions(getDriver()).moveToElement(this.applyBtt).click().perform();
        //        но этот фокус не проходит (в данном случае) и нужно делать скролл…
        js.executeScript("window.scrollTo(0, 900)")
        java.lang.Thread.sleep(1000)
        applyBtt.click()
        WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.urlContains("/cabinet/personal"))
        return this
    }

    fun setNameField(newName: String?): CabinetPage {
        nameInputField.click()
        nameInputField.clear()
        nameInputField.sendKeys(newName)
        return this
    }

    fun setSecondNameField(newValue: String?): CabinetPage {
        secondNameInputField.click()
        secondNameInputField.clear()
        secondNameInputField.sendKeys(newValue)
        return this
    }

    fun setLastNameField(newValue: String?): CabinetPage {
        lastNameInputField.click()
        lastNameInputField.clear()
        lastNameInputField.sendKeys(newValue)
        return this
    }

    fun clearNewPasswordField(): CabinetPage {
        newPasswordInputField.clear()
        return this
    }
}