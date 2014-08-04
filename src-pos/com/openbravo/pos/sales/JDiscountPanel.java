/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JDiscountPanel.java
 *
 * Created on 19/08/2011, 09:49:02 AM
 */
package com.openbravo.pos.sales;

import com.openbravo.pos.forms.AppLocal;

/**
 *Panel management for discounts on the sales window
 * @author Carlos Prieto - SmartJSP S.A.S.
 */
public class JDiscountPanel extends javax.swing.JPanel {

    /** Creates new form JDiscountPanel */
    public JDiscountPanel() {
        initComponents();
        initLabels();
    }

    /**
     * get notes at a discount
     * @return 
     */
    public String getNote(){
        return txtNote.getText();
    }
    
    /**
     * get the string value of the discount
     * @return 
     */
    public String getDiscount(){
        return txtDiscontPercent.getText();
    }
    
    /**
     * ask if is a global discount
     * @return 
     */
    public boolean isGlobalDiscount(){
        return jCheckBox1.isSelected();
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDiscontPercent = new javax.swing.JTextField();
        txtNote = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();

        jLabel2.setText("% Descuento");

        jLabel3.setText("Notas");

        txtDiscontPercent.setText("-10");

        jCheckBox1.setText("Global");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNote, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(txtDiscontPercent, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiscontPercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtDiscontPercent;
    private javax.swing.JTextField txtNote;
    // End of variables declaration//GEN-END:variables

    /**
     * initializes the labels
     */
    private void initLabels() {
        jLabel2.setText(AppLocal.getIntString("label.discountpanel.discount")); 
        jLabel3.setText(AppLocal.getIntString("label.discountpanel.notes"));
        jCheckBox1.setText(AppLocal.getIntString("label.discountpanel.global"));
    }
    

	/*if(ticket.getTicketId() == 0 ){
	    JDiscountPanel jDiscountPanel = new JDiscountPanel();

	    if((ticket.getLine(sales.getSelectedIndex()).getProperty("discount-rate") == null 
	           || ticket.getLine(sales.getSelectedIndex()).getProperty("discount-rate").equals("")))
	        action = JOptionPane.showConfirmDialog(null,jDiscountPanel,LocalRes.getIntString("message.discount"),JOptionPane.OK_CANCEL_OPTION);
	    else
	        action = 5;
	    
	    if(action == 0){
	        if(!jDiscountPanel.isGlobalDicount() ){
	            discountrate = jDiscountPanel.getDicount(); 
	            notes = jDiscountPanel.getNotes(); 

	            float rate =  ( Math.abs(Float.parseFloat(discountrate)) / 100 * 1 );
	            total = ticket.getTotal();  
	            titu = "Desc." ;

	            if (total > 0.0) {
	                sdiscount = Formats.PERCENT.formatValue(rate);  
	                int indexTicketLine =0;
	                double totalP =0;
	                taxes = ticket.getTaxLines();

	                if (taxes.length > 0 ) {
	                    taxline = taxes[0];
	                    indexTicketLine = sales.getSelectedIndex();
	                    selLine =ticket.getLine(sales.getSelectedIndex());

	                    if(selLine.getProductName().indexOf("Desc") >= 0 || selLine.getProductName().indexOf("Propina") >= 0){
	                        javax.swing.JOptionPane.showMessageDialog(null, LocalRes.getIntString("message.notDiscount"));	
	                        break;
	                    }
	                    indexTicketLine ++;
	                    titu = titu + sdiscount + " de " + ticket.getLine(sales.getSelectedIndex()).getProductName();
	                    totalP = -ticket.getLine(sales.getSelectedIndex()).getPrice() * rate * ticket.getLine(sales.getSelectedIndex()).getMultiply();

	                    TicketLineInfo tlineInfo = new TicketLineInfo(
	                        titu,   
	                        TCId,          
	                        1.0, 
	                        totalP,
	                        taxline.getTaxInfo());

	                    selLine.setProperty("discount-value",Double.toString(totalP));
	                    selLine.setProperty("discount-rate",Double.toString(rate));
	                    ticket.insertLine(indexTicketLine,tlineInfo);
	                    tlineInfo.setProperty("sendstatus","Yes");
	                    tlineInfo.setProperty("notes",notes);
	                    tlineInfo.setProperty("discount",discountrate);
	                }
	                sales.setSelectedIndex(indexTicketLine);
	                ticket.recalculateTip();
	            } else {  
	                java.awt.Toolkit.getDefaultToolkit().beep();  
	            }
	        }else if(jDiscountPanel.isGlobalDicount()){
	            discountrate = jDiscountPanel.getDicount(); 
	            float rate =  ( Math.abs(Float.parseFloat(discountrate)) / 100 * 1 );
	            ticket.setGlobalTicket(rate,TCId,jDiscountPanel.getNotes());
	        }else{
	            javax.swing.JOptionPane.showMessageDialog(null, LocalRes.getIntString("message.notDiscount"));	
	            break;
	        }
	    }
	}*/

}