package edu.westga.cs1302.bill.model;


/** Does all the calculations for a bill
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class BillCalculator {
	
	/**Creates a new Calculator for a Bill
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public BillCalculator() {
		
	}
	
	/**Calculates the subtotal for an array of a BillItem
	 * 
	 * @precondition bills cannot contain a null value
	 * @postcondition gives the subtotal for each bill 
	 * 
	 * @param bills an Array of bills to find subtotal of
	 * @return 
	 * 
	 */
	public static double subTotalCalc(Bill[] bills) {
		double subTotal = 0.0;
		for (int i = 0; i < bills.length; i++) {
			if (bills[i] == null) {
				throw new IllegalArgumentException("Array of bills can't contain a null bill");
			} else {
				for (int j = 0; j < bills[i].getItems().size(); j++) {
					subTotal += bills[i].getItems().get(j).getAmount();
				}
			}
		}
		return subTotal;
	}
	
	/**Calculates the tax of an array of bills
	 * 
	 * @precondition bills cannot contain a null value
	 * @precondition none
	 * 
	 * @param bills an array of bills to find tax of
	 * @return 
	 */
	public static double taxCalc(Bill[] bills) {
		double tax = 0.0;
		for (int i = 0; i < bills.length; i++) {
			if (bills[i] == null) {
				throw new IllegalArgumentException("Array of bills can't contain a null bill");
			} else {
				tax = BillCalculator.subTotalCalc(bills) * Bill.TAX_RATE;
			}
		}
		return tax;
	}
	/**Calculates the tip of an array of bills
	 * 
	 * @precondition bills cannot contain a null value
	 * @precondition none
	 * 
	 * @param bills an array of bills to find tip of
	 * @return 
	 */
	public static double tipCalc(Bill[] bills) {
		double tip = 0.0;
		for (int i = 0; i < bills.length; i++) {
			if (bills[i] == null) {
				throw new IllegalArgumentException("Array of bills can't contain a null bill");
			} else {
				tip = BillCalculator.subTotalCalc(bills) * Bill.TIP_RATE;
			}
		}
		return tip;
	}
	
	/**Calculates the total of an array of bills
	 * 
	 * @precondition bills cannot contain a null value
	 * @precondition none
	 * 
	 * @param bills an array of bills to find total of
	 * @return 
	 */
	public static double totalCalc(Bill[] bills) {
		double total = 0.0;
		for (int i = 0; i < bills.length; i++) {
			if (bills[i] == null) {
				throw new IllegalArgumentException("Array of bills can't contain a null bill");
			} else {
				total = BillCalculator.subTotalCalc(bills) + BillCalculator.taxCalc(bills) + BillCalculator.tipCalc(bills);
			}
		}
		return total;
	}
	
}
