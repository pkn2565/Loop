import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Loop extends Application{
	@Override
	public void start(Stage primaryStage){
	
		String knownUser = "Tanes";
		String knownPass = "CSC200";
		Optional<String> user;
		Optional<String> pass;
		
		
		int count = 0;
		final int LIMIT = 3;
		
		do {
			if(count!=0){
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Login");
				alert.setHeaderText("Wrong Username or Password");
				alert.setContentText("Try Again");
				alert.showAndWait();
			}
			
			TextInputDialog userName = new TextInputDialog();
			userName.setTitle("Login");
			userName.setContentText("Please enter your username");
			user = userName.showAndWait();

			TextInputDialog passWord = new TextInputDialog();
			passWord.setTitle("Login");
			passWord.setContentText("Please enter your password");
			pass = passWord.showAndWait();
				count++;
		}while((!(user.get()).equals(knownUser)) && (!(pass.get()).equals(knownPass)) && (count<LIMIT));

		if(count<LIMIT){
			TextInputDialog numPeople = new TextInputDialog();
			numPeople.setTitle("Number of People");
			numPeople.setContentText("Enter the Amount of People in your group");
			Optional<String> result = numPeople.showAndWait();
			
			double doubleVar = Double.parseDouble(result.get());
			int amount = (int) doubleVar;

			if ((11<= amount)&&(amount<=55)){
				int teamSize = amount/11;
			
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Team Size");
				alert.setContentText("The size of your team is " + teamSize);
				alert.show();
			}else if((3<= amount)&&(amount<11)){
				int secondSize = amount/3;
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Team Size");
				alert.setHeaderText("You have " + amount + "Players");
				alert.setContentText(secondSize + " teams can be made");
				alert.show();
			}else{
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("team Size");
				alert.setContentText("You must have more than 3");
			}
		}else{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Login Maximum Attempt Reached");
			alert.setContentText("Contact Administrator");
			alert.show();
		}
	}
}		
