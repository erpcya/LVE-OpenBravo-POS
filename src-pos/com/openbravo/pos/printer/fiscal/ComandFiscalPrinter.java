/**
 * com.openbravo.pos.printer.fiscal
 * ComandVisor.java
 * 06/03/2013
 * 
 */
package com.openbravo.pos.printer.fiscal;

import tfhka.PrinterExeption;
import tfhka.Tfhka;

/**
 * @author Dixon Martinez
 * 06/03/2013
 */
public class ComandFiscalPrinter {

	private Tfhka tf = new Tfhka();
	/**
	 * @author Dixon Martinez
	 * ComandVisor.java
	 * 06/03/2013
	 */
	public ComandFiscalPrinter() {
	}
	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Comandos utilizados para configurar el visor
	 */
	
	/** 
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Mostrar Hora y Fecha 
	 * Muestra en el Visor la hora y la fecha. 
	 * No es posible ejecutar �ste comando durante una transacci�n.
	 */
	public void viewDateTime(){
		try {
			tf.SendCmd("a");
		} catch (PrinterExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * @param s. Mensaje a mostrar.
	 * Programaci�n de Mensajes Comerciales en el Visor
	 * �ste comando permite programar el mensaje comercial que se muestra en 
	 * el Visor.
	 * Tama�o maximo del mensaje 50 caracteres
	 */
	public void progViewMessage(String s){
		try {
			tf.SendCmd("PI");
		} catch (PrinterExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Mostrar Mensaje Comercial.
	 * Muestra en la parte superior del Visor el mensaje comercial programado. 
	 * No es posible ejecutar �ste comando durante una transacci�n.
	 */
	public void mostarMensajeVisor(){
		try {
			tf.SendCmd("b");
		} catch (PrinterExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Mostrar Mensaje.
	 * Muestra un mensaje en el Visor.
	 * @param lineType. Puede ser L�nea Superior del Visor "U" � L�nea Inferior 
	 * del Visor "L"
	 * @param msg. Mensaje en el Visor 20 Caracteres como maximo
	 */
	public void mostrarMensaje(char lineType, String msg){		
		try {
			tf.SendCmd("c"+lineType+msg);
		} catch (PrinterExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Comandos utilizados para configurar los parametros de la impresora Fiscal.
	 */
	
	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Datos del Cajero
	 * Este comando permite programar hasta 32 cajeros con un c�digo y 
	 * descripci�n.
	 * El uso de este	comando es opcional.
	 * @param id. N�mero de Cajero 00 � 31.
	 * @param cod. Indique un c�digo secreto del Cajero (num�rico) 5 D�gitos.
	 * @param name. Indique la Descripci�n o Nombre del Cajero 16 Caracteres.
	 */
	public void datCaj(int id, int cod, String name){
		try {
			tf.SendCmd("PC"+id+cod+name);
		} catch (PrinterExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Medios de Pago
	 * Este comando permite definir los descriptores para cada medio de pago.
	 * La impresora maneja	hasta 16 medios de pago.
	 * @param id. N�mero del Medio de Pago 01 � 16.
	 * @param name.Descriptor del Medio de Pago 14 Caracteres.
	 */
	public void medDePago(int id, String name){
		try {
			tf.SendCmd("PE"+id+name);
		} catch (PrinterExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Hora
	 * Este comando permite programar la hora.
	 * Para ello debe realizar previamente un Reporte Z.
	 * @param hh. Hora 2 d�gitos
	 * @param mm. Minuto 2 d�gitos
	 * @param ss. Segundo 2 d�gitos
	 */
	public void hora(int hh, int mm, int ss){
		try {
			tf.SendCmd("PF"+hh+mm+ss);
		} catch (PrinterExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Fecha
	 * Este comando permite programar la Fecha. 
	 * Para ello debe realizar previamente un Reporte Z.
	 * Debe tenerse en cuenta de que una vez fiscalizada la impresora, 
	 * no se puede retroceder la fecha a una fecha anterior a la fecha
	 * de emisi�n del �ltimo reporte Z.
	 * @param dd. D�a 2 d�gitos.
	 * @param mm. Mes 2 d�gitos.
	 * @param yy. Year 2 d�gitos.
	 */
	public void fecha(int dd, int mm, int yy){
		try {
			tf.SendCmd("PG"+dd+mm+yy);
		} catch (PrinterExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
