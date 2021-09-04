package com.example.polynomialgeneratorfx.Controllers;

import com.example.polynomialgeneratorfx.GeneratorModel.PolynomialGenerator;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class PolyHomeController implements Initializable
{

	@FXML
	private JFXButton exitButton;

	@FXML
	private JFXButton generateButton;

	@FXML
	private JFXRadioButton uniRadioButton;

	@FXML
	private JFXRadioButton bivarRadioButton;

	@FXML
	private JFXRadioButton triRadioButton;

	@FXML
	private JFXComboBox<Integer> degreeComboBox;

	@FXML
	private JFXTextArea displayPolyLabel;

	private final Integer[] DEGREE_ARRAY = {1, 2, 3, 4, 5, 6, 7, 8, 9};

	private int degree = 0;

	/**
	 * Initializes the application
	 * @param url URL
	 * @param resourceBundle ResourceBundle
	 */
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle)
	{
		ToggleGroup toggleGroup = new ToggleGroup();
		uniRadioButton.setToggleGroup(toggleGroup);
		bivarRadioButton.setToggleGroup(toggleGroup);
		triRadioButton.setToggleGroup(toggleGroup);

		degreeComboBox.getItems().addAll(List.of(DEGREE_ARRAY));

	}

	/**
	 * Fills the degree list combo box
	 * @param event Mouse Event
	 */
	@FXML
	public void onComboBoxClicked(ActionEvent event)
	{
		degree = degreeComboBox.getSelectionModel().getSelectedItem();
	}

	/**
	 * Processes the user action and generates a polynomial
	 * @param event Mouse Event
	 */
	@FXML
	public void onGenerateButtonClicked(ActionEvent event)
	{
		if(event.getSource().equals(generateButton)) {
			int mode = getMode();
			PolynomialGenerator polynomialGenerator = new PolynomialGenerator();
			polynomialGenerator.setDegree(degree);
			if (mode == 1)
				polynomialGenerator.univariateMode();
			if (mode == 2)
				polynomialGenerator.bivariateMode();
			if (mode == 3)
				polynomialGenerator.trivariateMode();
			String generatedPoly = polynomialGenerator.generatePolynomial();
			displayPolyLabel.setText(generatedPoly);
		}

	}

	/**
	 * Gets the mode of the polynomial in terms of indeterminates
	 * @return Mode
	 */
	private int getMode()
	{
		if(uniRadioButton.isSelected()){
			return 1;
		}
		if(bivarRadioButton.isSelected()){
			return 2;
		}
		if(triRadioButton.isSelected()){
			return 3;
		}
		else{
			return 1;
		}
	}

	/**
	 * Exits the application
	 * @param event Mouse Event
	 */
	@FXML
	public void onExitButtonClicked(ActionEvent event)
	{
		if (event.getSource().equals(exitButton)) {
			System.exit(0);
		}
	}

}