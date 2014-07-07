/**
 * com.openbravo.pos.printer.fiscal
 * GenerarNotaCredito.java
 * 07/03/2013
 * 
 */
package com.openbravo.pos.printer.fiscal;

import tfhka.PrinterExeption;
import tfhka.Tfhka;

/**
 * @author Dixon Martinez
 * 07/03/2013
 */
public class GenerarNotaCredito implements ComandFactaura{

	Tfhka tf = new Tfhka();
	/**
	 * @author Dixon Martinez
	 * GenerarNotaCredito.java
	 * 07/03/2013
	 */
	public GenerarNotaCredito() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void regProduct(char cmd, double precio, double cant, String desc) {
		String dPrice = String.valueOf(precio);
		String pEntera = dPrice.substring(0,dPrice.indexOf("."));
		String pDecimal = dPrice.substring(dPrice.lastIndexOf(".")+1);
		while(pDecimal.length() < 2){
			pDecimal = "0".concat(pDecimal);
		}
		dPrice = pEntera+pDecimal;
		while(dPrice.length() < 10){
			dPrice = "0".concat(dPrice);
		}

		String dUnits = String.valueOf(cant);
		String pEnteraCantidad = dUnits.substring(0,dUnits.indexOf("."));
		String pDecimalCantidad = dUnits.substring(dUnits.lastIndexOf(".")+1);
		while(pDecimalCantidad.length() < 3){
			pDecimalCantidad = "0".concat(pDecimalCantidad);
		}
		dUnits = pEnteraCantidad+pDecimalCantidad;
		while(dUnits.length() < 8){
			dUnits = "0".concat(dUnits);
		}
		try {
			tf.SendCmd("d"+cmd+precio+cant+desc);
		} catch (PrinterExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void infClient(int nLine, String data) {
		// TODO Auto-generated method stub
		
	}
	
	

	
}
