/**
 * com.openbravo.pos.printer.fiscal
 * ComandFactaura.java
 * 07/03/2013
 * 
 */
package com.openbravo.pos.printer.fiscal;


/**
 * @author Dixon Martinez
 * 07/03/2013
 */
public interface ComandFactaura {

	/**
	 * 
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Registro de Producto
	 * El registro de un producto solamente es posible si la tasa a la cual
	 * est� ligada se encuentra registrada.
	 * 	� Es posible registrar hasta BsF. 9999999,99 por transacci�n.
	 * 	� Es posible registrar hasta BsF. 9999999,99 por d�a.
	 * 	� Si se exceden el l�mite de los montos, el comando de registro de
	 * 	productos es rechazado.
	 * 	� Si el monto m�ximo que puede acumular la impresora es excedido,
	 * 	la impresora rechaza todos los comandos de ventas, en �ste caso ser�a
	 * 	necesario realizar un reporte Z para continuar las ventas.
	 * 	
	 * @param cmd
	 * 
	 * ***FACTURA******
	 * �tem Exento (20h) / (32) Espacio
	 * Item Tasa 1 (21h) / (33) !
	 * Item Tasa 2 (22h) / (34) "
	 * �tem Tasa 3 (23h) / (35) #
	 * 
	 ****NOTA DE CREDITO****
	 *					   Tasa
	 *�tem Exento 			0
	 *�tem Tasa 1 			1
	 *�tem Tasa 2 			2
	 *�tem Tasa 3 			3
	 * @param precio. El Precio Consta de 8 Enteros y 2 Decimales Fijos 10 D�gitos.
	 * @param cant. La Cantidad Consta de 5 Enteros y 3 Decimales Fijos 8 D�gitos.
	 * @param desc. Descripci�n del Producto 40 Caracteres.
	 *******COMANDO PARA UNA FACTURA*******
	 * cmd+precio+cant+desc
	 ********COMANDO PARA UNA NOTA DE CREDITO*******
	 * d+cmd+precio+cant+desc
	 */
	public void regProduct(char cmd, double precio, double cant, String desc);
	
	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Informaci�n adicional del Cliente
	 * �ste comando permite ingresar l�neas adicionales de informaci�n del 
	 * cliente en una Factura.
	 * @param nLine. Numero de l�nea 00 � 11.
	 * @param data.Indique la Informaci�n adicional, 40 Caracteres 
	 * por l�nea 40 Caracteres
	 */
	public void infClient(int nLine,String data);
}
