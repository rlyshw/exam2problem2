package com.rlyshw.customer.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Labeled;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import com.rlyshw.customer.model.Customer;

public class CustomerFieldController {
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField middleInitial;
	@FXML
	private ToggleGroup gender;
	@FXML
	private TextField address;
	@FXML
	private ChoiceBox state;
	@FXML
	private TextField city;
	@FXML
	private PasswordField zip;
	
	private Stage customerStage;
	private Customer customer;
	private boolean submitClicked = false;
	
	@FXML
	private void initialize(){
		firstName.addEventFilter(KeyEvent.KEY_TYPED, maxLength(50));
		lastName.addEventFilter(KeyEvent.KEY_TYPED, maxLength(50));
		middleInitial.addEventFilter(KeyEvent.KEY_TYPED, maxLength(1));
		address.addEventFilter(KeyEvent.KEY_TYPED, maxLength(50));
		city.addEventFilter(KeyEvent.KEY_TYPED, maxLength(25));
		zip.addEventFilter(KeyEvent.KEY_TYPED, maxLength(9));

		ObservableList<String> states = FXCollections.observableArrayList();
		states.addAll("Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode","Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming");
		state.setItems(states);
		gender.getToggles().get(0).setSelected(true);;
	}
	
	public void setCustomerStage(Stage customerStage){
		this.customerStage = customerStage;
	}

	public CustomerFieldController() {
		// TODO Auto-generated constructor stub
	}
	
	@FXML
	private void handleClear(){
		firstName.setText("");;
		lastName.clear();
		middleInitial.clear();
		gender.selectToggle(null);
		address.clear();
		city.clear();
		state.setValue(null);
		zip.clear();
	}
	
	@FXML
	private void handleSave(){
		String first = firstName.getText();
		String last = lastName.getText();
		String middle = middleInitial.getText();
		String gend = ((Labeled) gender.getSelectedToggle()).getText();
		String addr = address.getText();
		String cit = city.getText();
		String stt = (String) state.getValue();
		String z = zip.getText();
		Customer newCustomer = new Customer(first, last, middle, gend, addr, stt, z, cit);
		System.out.println(newCustomer.toString());
	}
	public EventHandler<KeyEvent> maxLength(final Integer i) {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent arg0) {

                TextField tx = (TextField) arg0.getSource();
                if (tx.getText().length() >= i) {
                    arg0.consume();
                }

            }

        };

    }

}
