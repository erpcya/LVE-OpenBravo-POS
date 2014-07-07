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
	 * está ligada se encuentra registrada.
	 * 	• Es posible registrar hasta BsF. 9999999,99 por transacción.
	 * 	• Es posible registrar hasta BsF. 9999999,99 por día.
	 * 	• Si se exceden el límite de los montos, el comando de registro de
	 * 	productos es rechazado.
	 * 	• Si el monto máximo que puede acumular la impresora es excedido,
	 * 	la impresora rechaza todos los comandos de ventas, en éste caso sería
	 * 	necesario realizar un reporte Z para continuar las ventas.
	 * 	
	 * @param cmd
	 * 
	 * ***FACTURA******
	 * Ítem Exento (20h) / (32) Espacio
	 * Item Tasa 1 (21h) / (33) !
	 * Item Tasa 2 (22h) / (34) "
	 * Ítem Tasa 3 (23h) / (35) #
	 * 
	 ****NOTA DE CREDITO****
	 *					   Tasa
	 *Ítem Exento 			0
	 *Ítem Tasa 1 			1
	 *Ítem Tasa 2 			2
	 *Ítem Tasa 3 			3
	 * @param precio. El Precio Consta de 8 Enteros y 2 Decimales Fijos 10 Dígitos.
	 * @param cant. La Cantidad Consta de 5 Enteros y 3 Decimales Fijos 8 Dígitos.
	 * @param desc. Descripción del Producto 40 Caracteres.
	 *******COMANDO PARA UNA FACTURA*******
	 * cmd+precio+cant+desc
	 ********COMANDO PARA UNA NOTA DE CREDITO*******
	 * d+cmd+precio+cant+desc
	 */
	public void regProduct(char cmd, double precio, double cant, String desc);
	
	/**
	 * @author Dixon Martinez
	 * 06/03/2013
	 * Información adicional del Cliente
	 * Éste comando permite ingresar líneas adicionales de información del 
	 * cliente en una Factura.
	 * @param nLine. Numero de línea 00 – 11.
	 * @param data.Indique la Información adicional, 40 Caracteres 
	 * por línea 40 Caracteres
	 */
	public void infClient(int nLine,String data);
}
