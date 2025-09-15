package edu.westga.cs1302.bill.view;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillCalculator;

/** Supports displaying the information contained in a Bill.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class BillView {

	/** Return a String containing the list of bill items and total for the bill.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param bill the bill to be viewed
	 * 
	 * @return a String containing the list of bill items and total for the bill
	 */
	public static String getText(Bill[] bills) {
		String text = "ITEMS" + System.lineSeparator();
		double subTotal = 0.0;
		for (int i = 0; i <= bills.length; i++) {
			for (int j = 0; i <= bills[i].getItems().size(); j++) {
				text += bills[i].getItems().get(j).getName() + " - " 
			          + bills[i].getItems().get(j).getAmount() + System.lineSeparator();
				subTotal = BillCalculator.subTotalCalc(bills);
			}
		}
		text += System.lineSeparator();
		text += "SUBTOTAL - $" + subTotal + System.lineSeparator();
		double tax = BillCalculator.taxCalc(bills);
		double tip = BillCalculator.tipCalc(bills);
		double total = BillCalculator.totalCalc(bills);
		text += "TAX - $" + BillView.roundToNearestHundredth(tax) + System.lineSeparator();
		text += "TIP - $" + BillView.roundToNearestHundredth(tip) + System.lineSeparator();
		text += "TOTAL - $" + BillView.roundToNearestHundredth(total);
		
		return text;
	}
	
	private static double roundToNearestHundredth(double value) {
		return (int) (value * 100) / 100.0;
	}
}
