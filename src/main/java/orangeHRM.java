import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class orangeHRM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				WebDriverManager.chromedriver().setup();
				WebDriver driver=new ChromeDriver();
				
				 try {
				driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		        // Get the Username and Password elements using XPaths (without hardcoding the values)
		        WebElement usernameLabel = driver.findElement(By.xpath("//input[contains(@name,'username')]"));
		        WebElement passwordLabel = driver.findElement(By.xpath("//input[contains(@name,'password')]"));

		        // Fetch the credentials from the labels
		        String username = usernameLabel.getAttribute("value");
		        String password = passwordLabel.getAttribute("value");

		        // Update the Username and Password fields
		        usernameLabel.clear();
		        usernameLabel.sendKeys(username);

		        passwordLabel.clear();
		        passwordLabel.sendKeys(password);

		        // Click the Login button
		        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		        loginButton.click();

		        // Navigate to the Admin page
		        WebElement adminMenu = driver.findElement(By.xpath("//span[text()='Admin']"));
		        adminMenu.click();

		        // Find the second record and click the Delete icon
		        WebElement secondRecordDeleteIcon = driver.findElement(By.xpath("(//i[@class='oxd-icon bi-trash'])[2]"));
		        secondRecordDeleteIcon.click();

		        // Confirm the deletion
		        WebElement confirmDeleteButton = driver.findElement(By.xpath("//button[text()='Yes, Delete']"));
		        confirmDeleteButton.click();

		        // Verify that the record has been deleted
		        String deletedUsername = "ayush123"; // Replace this with the actual username that was deleted
		        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		        searchBox.clear();
		        searchBox.sendKeys(deletedUsername);

		        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
		        searchButton.click();

		        // Validate that no record exists with the deleted username
		        boolean isRecordDeleted = driver.findElements(By.xpath("//a[text()='" + deletedUsername + "']")).isEmpty();
		        if (isRecordDeleted) {
		            System.out.println("Record with username '" + deletedUsername + "' was successfully deleted.");
		        } else {
		            System.out.println("Record with username '" + deletedUsername + "' still exists.");
		        }

		    } finally {
		         //Close the browser
		       driver.quit();
	}
	}
}
