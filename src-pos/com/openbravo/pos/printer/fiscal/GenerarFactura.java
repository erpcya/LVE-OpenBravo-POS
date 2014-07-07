/**
 * com.openbravo.pos.printer.fiscal
 * GenerarFactura.java
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
public class GenerarFactura implements ComandFactaura {

	private Tfhka tf = new Tfhka();
	/**
	 * @author Dixon Martinez
	 * GenerarFactura.java
	 * 07/03/2013
	 */
	public GenerarFactura() {
		
	}
	
	/*
	 * COMANDOS PARA GENERAR LA FACTURA
	 */
	
	
	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Inicio de Cajero
	 * Éste comando permite iniciar un cajero. 
	 * No se puede utilizar éste comando si existe una transacción abierta. 
	 * Este comando es de uso opcional.
	 * @param password. Clave Secreta del Cajero (ASCII) 00000 - 99999.
	 */
	public void initCajero(String password){
		try {
			tf.SendCmd("5"+password);
		} catch (PrinterExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Fin de Cajero
	 * Éste comando finaliza el cajero que este activo en ese momento y 
	 * restablece el cajero #1 como el cajero por defecto. 
	 * No se puede utilizar éste comando si existe una transacción
	 * abierta. 
	 * No es necesario ejecutar éste comando para reasignar el cajero.
	 */
	public void finishCajero(){
		try {
			tf.SendCmd("6");
		} catch (PrinterExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Comentario
	 * Éste comando permite imprimir mensajes comerciales adicionales 
	 * para la descripción de un artículo.
	 * @param msg. Indicador de Mensaje en la factura 40 Caracteres.
	 */
	public void coment(String msg){
		try {
			tf.SendCmd("@"+msg);
		} catch (PrinterExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			tf.SendCmd(cmd+precio+cant+desc);
		} catch (PrinterExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Corrección
	 * Éste comando cancela la última entrada de un ítem o de un descuento.
	 */
	public void corregir(){
		try {
			tf.SendCmd("k");
		} catch (PrinterExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Subtotal
	 * Estos comandos permiten imprimir o mostrar en pantalla el monto 
	 * correspondiente al subtotal de las ventas. 
	 * Éste comando debe ser ejecutado antes de realizar un descuento del 
	 * subtotal.
	 * @param cmd
	 * Subtotal Impreso "3"
	 * El Subtotal se Muestra en el Display "4"
	 */
	public void subTotal(int cmd){
		try {
			tf.SendCmd(""+cmd);
		} catch (PrinterExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Descuento y/o Recargo
	 * Realiza un descuento sobre el último Ítem registrado o 
	 * sobre el subtotal.
	 * 
	 * Para realizar un descuento sobre el subtotal, se debe ejecutar
	 * previamente el comando "Subtotal", y el monto del descuento se 
	 * aplica de forma proporcional	sobre todos los	artículos.
	 * Se puede hacer descuento de dos maneras, por porcentaje y por cantidad. 
	
	 * @param cmd. 
	 * "p" para el Descriptor para el Descuento o Recargo por porcentaje  
	 * @param signo
	 * "+" para recargo
	 * "-" para descuento
	 * @param porcentaje
	 * El Porcentaje consta de 2 Enteros y 2 Decimales 4 Dígitos
	 */
	public void descRecarPorc(char cmd,char signo,double porcentaje){
		try {
			tf.SendCmd(""+cmd+signo+porcentaje);
		} catch (PrinterExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Descuento y/o Recargo por monto
	 * Realiza un descuento sobre el último Ítem registrado o 
	 * sobre el subtotal.
	 * 
	 * Para realizar un descuento sobre el subtotal, se debe ejecutar
	 * previamente el comando "Subtotal", y el monto del descuento se 
	 * aplica de forma proporcional	sobre todos los	artículos.
	 * Se puede hacer descuento de dos maneras, por porcentaje y por cantidad. 
	
	 * @param cmd.
	 * "q" para el Descriptor para el Descuento o Recargo por monto
	 * @param signo
	 * "-" para descuento
	 * @param monto
	 * El monto consta de 7 Enteros y 2 Decimales 9 Dígitos
	 */
	public void descRecarMont(char cmd,char signo,double monto){
		try {
			tf.SendCmd(""+cmd+signo+monto);
		} catch (PrinterExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Anulación de un ítem en la Factura
	 * La anulación de un ítem es posible si la tasa a la cual está ligada
	 * está registrada.
	 * @param cmd
	 * " " (A0h) Ítem Exento
	 * "¡" (A1h) Ítem Tasa 1
	 * "¢" (A2h) Ítem Tasa 2
	 * "£" (A3h) Ítem Tasa 3  
	 * @param precio. El Precio Consta de 8 Enteros y 2 Decimales 
	 * Fijos 10 Dígitos.
	 * @param cantidad. La Cantidad Consta de 5 Enteros y 3 Decimales 
	 * Fijos 8 Dígitos
	 * @param descrip. Descripción del Producto 40 Caracteres.
	 */
	public void anulItem(char cmd, double precio, double cantidad, String descrip){
		try {
			tf.SendCmd(cmd+precio+cantidad+descrip);
		} catch (PrinterExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Anulación de Factura
	 * Éste comando permite anular una factura.
	 */
	public void anulFact(){
		try {
			tf.SendCmd("7");
		} catch (PrinterExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Código de Barras
	 * Éste comando permite imprimir un código de barra como referencia 
	 * de un producto dentro de la factura y en el pie de la factura.
	 * @param cmd
	 * "Y" Código de Barra impreso dentro de la Factura como descriptor 
	 * de un Producto.
	 * "y" Código de Barra impreso al pie de la Factura.
	 * @param cod
	 * Código numérico referente al código de la barra 32 Caracteres
	 * 
	 * NOTA
	 * Para el tipo de codificación del código de barra se debe emplear 
	 * el "Flag 43" y colocarlo	en el valor de uso según la siguiente tabla:
	 * Valor 				Características
	 * 	00 			EAN 13 (12 Caracteres Numéricos)
	 * 	01 			ITF (1 a 32 Caracteres Numéricos)
	 * 	02 			CODE 128 (1 a 32 Caracteres Alfanuméricos)
	 * 
	 * Para que el Código numérico asociado al código de barra se 
	 * muestre debajo del código de barras, el "Flag 30" debe de 
	 * tener el valor "01".
	 */
	public void codBarras(char cmd,int cod){
		try {
			tf.SendCmd(cmd+""+cod);
		} catch (PrinterExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Pago Directo
	 * Éste comando permite cerrar una factura y asignar el monto total a 
	 * un medio de pago.
	 * Al ejecutar éste comando se abre la gaveta de dinero.
	 * @param nMedio
	 * Indicador del Medio de Pago Asociado 01 – 16
	 * Los descriptores programados por defecto para los 
	 * medios de pago, son los siguientes:
	 * 	Medio  				N Medio
	 * Efectivo				'01'-'04'
	 * Cheque				'05'-'08'
	 * Tarjeta1				'09'-'12'
	 * Tarjeta2				'13'-'16'
	 */
	public void pagoDirec(int nMedio){
		try {
			tf.SendCmd("1"+nMedio);
		} catch (PrinterExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Pago Parcial
	 * Éste comando permite asignar parte del monto total de una factura a 
	 * un medio de pago	parcial. Si el monto ingresado es mayor o igual al 
	 * monto del total, se cierra la factura y se abre la gaveta de dinero.
	 * @param nMedio
	 * Indicador del Medio de Pago Parcial 01 – 16
	 * @param montPago
	 * El Monto de Pago Consta de 10 Enteros y 2 Decimales 12 Dígitos
	 */
	public void pagoParcial(int nMedio,double montPago){
		try {
			tf.SendCmd("2"+nMedio+montPago);
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
