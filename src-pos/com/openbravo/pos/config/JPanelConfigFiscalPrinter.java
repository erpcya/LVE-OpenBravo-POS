/**
 * com.openbravo.pos.config
 * JPanelConfigFiscalPrinter.java
 * 15/04/2014
 * 
 */
package com.openbravo.pos.config;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.openbravo.data.user.DirtyManager;
import com.openbravo.pos.forms.AppConfig;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.util.StringParser;

/**
 * @author Dixon Martinez
 * 15/04/2014
 */
public class JPanelConfigFiscalPrinter extends JPanel implements PanelConfig {

	/**
	 * @author Dixon Martinez
	 * JPanelConfigFiscalPrinter.java
	 * 17/04/2014
	 */
	private static final long serialVersionUID = 1L;

	private DirtyManager dirty = 
			new DirtyManager();
	
	private JLabel jLabelFiscalPrinter, jLabelModelFiscalPrinter, jLabelPortFiscalPrinter;
	
	private JPanel jPanelFiscalPrinter, jPanelButtons;
	
	private JComboBox jComboBoxFiscalPrinter, jComboBoxModelFiscalPrinter, jComboBoxPortFiscalPrinter;
	
	private JButton jButtonCheckPrinter, jButtonOpenConnection;//, jButtonReportsStatus;
	
	
	/**
	 * @author Dixon Martinez
	 * JPanelConfigFiscalPrinter.java
	 * 15/04/2014
	 */
	public JPanelConfigFiscalPrinter() {
		//	Initialize Panel Fiscal Printer
		jPanelFiscalPrinter =
					new JPanel();
		
		//	Add Border Panel Principal
		jPanelFiscalPrinter.setBorder(
			BorderFactory.createTitledBorder(
					AppLocal.getIntString("Label.MachineFiscalPrinter")));


		//	Initialize Elements
		//	Initialize Label Fiscal Printer
		jLabelFiscalPrinter =
				new JLabel(AppLocal.getIntString("Label.MachineFiscalPrinter"));
		
		//	Initialize Combo Box Fiscal Printer and add Action Listener
		jComboBoxFiscalPrinter =
				new JComboBox();
		jComboBoxFiscalPrinter.addActionListener(dirty);
		
		//	Add List Fiscal Printer
		getListFiscalPrinter(jComboBoxFiscalPrinter);
		
		//	Initialize Mode Connection Fiscal Printer
		jLabelModelFiscalPrinter =
				new JLabel("Modo");
		jComboBoxModelFiscalPrinter =
				new JComboBox();
		jComboBoxModelFiscalPrinter.addActionListener(dirty);
		getListModeFiscalPrinter(jComboBoxModelFiscalPrinter);
		
		
		//	Initialize Port Fiscal Printer
		jLabelPortFiscalPrinter =
				new JLabel("Puerto");
		jComboBoxPortFiscalPrinter =
				new JComboBox();
		jComboBoxPortFiscalPrinter.addActionListener(dirty);
		getListPortFiscalPrinter(jComboBoxPortFiscalPrinter);

		//	Add Components Panel Fiscal Printer
		jPanelFiscalPrinter.add(jLabelFiscalPrinter);
		jPanelFiscalPrinter.add(jComboBoxFiscalPrinter);
		jPanelFiscalPrinter.add(jLabelModelFiscalPrinter);
		jPanelFiscalPrinter.add(jComboBoxModelFiscalPrinter);
		jPanelFiscalPrinter.add(jLabelPortFiscalPrinter);
		jPanelFiscalPrinter.add(jComboBoxPortFiscalPrinter);
		
		
		//	Initialize Panel Buttons
		jPanelButtons =
				new JPanel();

		//	Initialize Button Check Printer
		jButtonCheckPrinter =
				new JButton(AppLocal.getIntString("Button.CheckPrinter"));
		jButtonCheckPrinter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Hola");
				
			}
		});
		
		jButtonOpenConnection =
				new JButton(AppLocal.getIntString("Button.OpenConnection"));
		jButtonOpenConnection.addActionListener(dirty);
		
		//	Add components to panel 
		jPanelButtons.add(jButtonCheckPrinter);
		jPanelButtons.add(jButtonOpenConnection);
		
			
		//	Add Components
		this.add(jPanelFiscalPrinter,BorderLayout.NORTH);
		this.add(jPanelButtons,BorderLayout.SOUTH);
	}

	private void getListPortFiscalPrinter(JComboBox jComboBoxPortFiscalPrinter) {
		
		String lisPrinter [] = {"COM1","COM2","COM3","COM4"};
		
		for (String list : lisPrinter) {
			jComboBoxPortFiscalPrinter.addItem(list);
		}	
	}

	private void getListModeFiscalPrinter(JComboBox jComboBoxModelFiscalPrinter) {
		String lisPrinter [] = {
				AppLocal.getIntString("Label.Serial"),
				AppLocal.getIntString("Label.File")
				};
		
		for (String list : lisPrinter) {
			jComboBoxModelFiscalPrinter.addItem(list);
		}	
	}

	private void getListFiscalPrinter(JComboBox jComboBoxFiscalPrinter) {
		String lisPrinter [] = {
					AppLocal.getIntString("Label.Notdefined"),
					AppLocal.getIntString("Label.Fiscal_Printer")};
		
		for (String list : lisPrinter) {
			jComboBoxFiscalPrinter.addItem(list);
		}
	}

	private String comboValue(Object value) {
		 return value == null ? "" : value.toString();
	 }
	
	private String unifySerialInterface(String sparam) {
		// for backward compatibility
		return ("rxtx".equals(sparam))
				? "serial"
						: sparam;
	}
	   
	   
	/* (non-Javadoc)
	 * @author Dixon Martinez 
	 * @see com.openbravo.pos.config.PanelConfig#loadProperties(com.openbravo.pos.forms.AppConfig)
	 */
	@Override
	public void loadProperties(AppConfig config) {
		
		StringParser p = new StringParser(config.getProperty("machine.fiscalprinter"));
		String sparam = unifySerialInterface(p.nextToken(':'));
		
		if(AppLocal.getIntString("Label.Serial").equals(sparam)
				|| AppLocal.getIntString("Label.File").equals(sparam)){
			jComboBoxFiscalPrinter.setSelectedItem(AppLocal.getIntString("Label.Fiscal_Printer"));
			jComboBoxModelFiscalPrinter.setSelectedItem(sparam);
			jComboBoxPortFiscalPrinter.setSelectedItem(p.nextToken(','));
		}
		
		dirty.setDirty(false);
	}

	/* (non-Javadoc)
	 * @author Dixon Martinez 
	 * @see com.openbravo.pos.config.PanelConfig#saveProperties(com.openbravo.pos.forms.AppConfig)
	 */
	@Override
	public void saveProperties(AppConfig config) {
		String sMachinePrinter = comboValue(jComboBoxFiscalPrinter.getSelectedItem());
		
		
        if (AppLocal.getIntString("Label.Fiscal_Printer").equals(sMachinePrinter)) {
            config.setProperty("machine.fiscalprinter", sMachinePrinter + ":" + comboValue(jComboBoxModelFiscalPrinter.getSelectedItem()) + "," + comboValue(jComboBoxPortFiscalPrinter.getSelectedItem()));
        }else {
            config.setProperty("machine.printer", sMachinePrinter);
        }
        
        dirty.setDirty(false);
	}

	/* (non-Javadoc)
	 * @author Dixon Martinez 
	 * @see com.openbravo.pos.config.PanelConfig#hasChanged()
	 */
	@Override
	public boolean hasChanged() {
		return dirty.isDirty();
	}

	/* (non-Javadoc)
	 * @author Dixon Martinez 
	 * @see com.openbravo.pos.config.PanelConfig#getConfigComponent()
	 */
	@Override
	public Component getConfigComponent() {
		return this;
	}

}
