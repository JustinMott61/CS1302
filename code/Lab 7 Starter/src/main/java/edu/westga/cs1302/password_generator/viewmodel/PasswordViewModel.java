package edu.westga.cs1302.password_generator.viewmodel;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**Links the PasswordGenerator class in the model package the MainWindow class in the view package
 * 
 * @author Justin Mott
 * @version Fall 2025
 */
public class PasswordViewModel {
	private PasswordGenerator password;

	private IntegerProperty minimumLengthProperty;
	private StringProperty resultedPasswordProperty;
	private BooleanProperty lowercaseProperty;
	private BooleanProperty uppercaseProperty;
	private BooleanProperty mustIncludeDigitsProperty;
	
	/**
	 * Instantiates a new PasswordGenerator info view model.
	 */
	public PasswordViewModel() {
		this.password = new PasswordGenerator(0);
		
		this.minimumLengthProperty = new SimpleIntegerProperty();
		this.resultedPasswordProperty = new SimpleStringProperty();
		this.lowercaseProperty = new SimpleBooleanProperty();
		this.uppercaseProperty = new SimpleBooleanProperty();
		this.mustIncludeDigitsProperty = new SimpleBooleanProperty();
	}
	
	/**Gets the minimum length property
	 * 
	 * @return the minimumLengthProperty
	 */
	public IntegerProperty minimumLength() {
		return this.minimumLengthProperty;
	}
	
	/**Gets the password generated
	 * 
	 * @return the resulted password property
	 */
	public StringProperty resultedPassword() {
		return this.resultedPasswordProperty;
	}
	
	/**Gets whether or not the user wants LowerCase letters in password
	 * 
	 * @return the LowerCase property
	 */
	public BooleanProperty lowercaseNeeded() {
		return this.lowercaseProperty;
	}
	
	/**Gets whether or not the user wants UpperCase letters in password
	 * 
	 * @return the UpperCase property
	 */
	public BooleanProperty uppercaseNeeded() {
		return this.uppercaseProperty;
	}
	
	/**Gets whether or not the user wants Digits in password
	 * 
	 * @return the mustIncludeDigits property
	 */
	public BooleanProperty digitsNeeded() {
		return this.mustIncludeDigitsProperty;
	}
	
	/**
	 * Update password with data that user entered in the UI.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void updatePassword() {
		this.password.setMinimumLength(this.minimumLength().getValue());
		this.password.setMustHaveAtLeastOneLowerCaseLetter(this.lowercaseNeeded().getValue());
		this.password.setMustHaveAtLeastOneUpperCaseLetter(this.uppercaseNeeded().getValue());
		this.password.setMustHaveAtLeastOneDigit(this.digitsNeeded().getValue());
		this.resultedPassword().set(this.password.generatePassword());
	}
}
