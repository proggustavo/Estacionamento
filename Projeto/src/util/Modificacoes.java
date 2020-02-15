package util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Modificacoes {
	
	public JSeparator separatorConfig(JSeparator separator, Color colorBackground, Color colorForeground) {
		
		separator.setBackground(colorBackground);
		separator.setForeground(colorForeground);
		
		return separator;
	}
	
	public JTextField txtConfig(JTextField field, String txt, Font fonte, Color backGround, Color foreGround, Border borda) {
		
		field.setText(txt);
		field.setFont(fonte);
		field.setBackground(backGround);
		field.setForeground(foreGround);
		field.setBorder(borda);
		
		
		return field;
	}
	
	
	public JButton botaoConfig(JButton button) {
		
		button.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		button.setFont(new Font("Arial", Font.BOLD, 16));
		
		return button;
	}
	
	public JTable tabelaConfig(JTable table, DefaultTableModel model) {
		
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.getTableHeader().setBackground(Color.WHITE);
		table.getTableHeader().setForeground(Color.BLACK);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
		
		return table;
	}


}
