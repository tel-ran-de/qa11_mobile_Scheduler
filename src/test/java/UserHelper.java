import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class UserHelper extends HelperBase{

    public UserHelper(AppiumDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        //log_email_input
        //log_password_input
        //login_btn
        type(By.id("log_email_input"), email);
        type(By.id("log_password_input"), password);

        tap(By.id("login_btn"));


    }
}
