import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public  void testLogin() {
        app.user().login("Neuer@gmail.com", "Neuer2021");
    }
}
