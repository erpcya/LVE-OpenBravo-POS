/**
 * com.openbravo.pos.fiscalprinter
 * FiscalPrinter.java
 * 15/04/2014
 * 
 */
package com.openbravo.pos.fiscalprinter;

import javax.swing.JComponent;

import org.fiscalprinter.model.PrintDocument;

import com.openbravo.pos.printer.DeviceFiscalPrinter;

/**
 * @author Dixon Martinez
 * 15/04/2014
 */
public class FiscalPrinter extends PrintDocument implements DeviceFiscalPrinter {
	
	/**
	 * @author Dixon Martinez
	 * FiscalPrinter.java
	 * 15/04/2014
	 */
	public FiscalPrinter(String port) {
		super("COM3");
	}
	
	
	/* (non-Javadoc)
	 * @author Dixon Martinez 
	 * @see com.openbravo.pos.printer.DeviceFiscalPrinter#getFiscalName()
	 */
	@Override
	public String getFiscalName() {
		return null;
	}

	/* (non-Javadoc)
	 * @author Dixon Martinez 
	 * @see com.openbravo.pos.printer.DeviceFiscalPrinter#getFiscalComponent()
	 */
	@Override
	public JComponent getFiscalComponent() {
		return null;
	}

	/* (non-Javadoc)
	 * @author Dixon Martinez 
	 * @see com.openbravo.pos.printer.DeviceFiscalPrinter#beginReceipt()
	 */
	@Override
	public void beginReceipt() {

	}

	/* (non-Javadoc)
	 * @author Dixon Martinez 
	 * @see com.openbravo.pos.printer.DeviceFiscalPrinter#endReceipt()
	 */
	@Override
	public void endReceipt() {
		totalizar(1, "01");
	}

	/* (non-Javadoc)
	 * @author Dixon Martinez 
	 * @see com.openbravo.pos.printer.DeviceFiscalPrinter#printLine(java.lang.String, double, double, int)
	 */
	@Override
	public void printLine(String sproduct, double dprice, double dunits,
			int taxinfo) {
		product(sproduct.trim(), dprice, dunits, taxinfo);		
	}

	/* (non-Javadoc)
	 * @author Dixon Martinez 
	 * @see com.openbravo.pos.printer.DeviceFiscalPrinter#printMessage(java.lang.String)
	 */
	@Override
	public void printMessage(String smessage) {
		dataClient(smessage);
	}

	/* (non-Javadoc)
	 * @author Dixon Martinez 
	 * @see com.openbravo.pos.printer.DeviceFiscalPrinter#printTotal(java.lang.String, double)
	 */
	@Override
	public void printTotal(String sPayment, double dpaid) {
		
	}

	/* (non-Javadoc)
	 * @author Dixon Martinez 
	 * @see com.openbravo.pos.printer.DeviceFiscalPrinter#printZReport()
	 */
	@Override
	public void printZReport() {
		printZReport();
	}

	/* (non-Javadoc)
	 * @author Dixon Martinez 
	 * @see com.openbravo.pos.printer.DeviceFiscalPrinter#printXReport()
	 */
	@Override
	public void printXReport() {
		printXReport();
	}
	
}
