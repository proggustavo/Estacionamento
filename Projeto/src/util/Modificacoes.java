package util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Modificacoes {
	
	public static final int JOPTION_ATENCAO = JOptionPane.WARNING_MESSAGE;
	public static final int JOPTION_INFORMACAO = JOptionPane.INFORMATION_MESSAGE;
	public static final int JOPTION_ERRO = JOptionPane.ERROR_MESSAGE;
	public static final int JOPTION_PERGUNTA = JOptionPane.QUESTION_MESSAGE;
	public static final int JOPTION_NO_ICON = JOptionPane.PLAIN_MESSAGE;
	public static final int JOPTION_Y_N_C = JOptionPane.YES_NO_CANCEL_OPTION;
	public static final int JOPTION_Y_N = JOptionPane.YES_NO_OPTION;
	public static final int JOPTION_Y = JOptionPane.YES_OPTION;
	public static final int JOPTION_K_C = JOptionPane.OK_CANCEL_OPTION;
	
	public static final int TIPO_MENSAGEM = 1;
	public static final int TIPO_CONFIRMACAO = 2;
	public static final int TIPO_DIALOGO = 3;
	public static final int TIPO_INTERNO = 4;
	
	
	public JSeparator separatorConfig(JSeparator separator, Color colorBackground, Color colorForeground) {

		separator.setBackground(colorBackground);
		separator.setForeground(colorForeground);

		return separator;
	}

	public JTextField txtConfig(JTextField field, String txt, Font fonte, Color backGround, Color foreGround,
			Border borda) {

		field.setText(txt);
		field.setFont(fonte);
		field.setBackground(backGround);
		field.setForeground(foreGround);
		field.setBorder(borda);

		return field;
	}

	public JButton botaoConfig(JButton button, Border borda, Font fonte) {

		button.setBorder(borda);
		button.setFont(fonte);

		return button;
	}

	public JLabel labelConfig(JLabel label, String text) {

		label = new JLabel();
		label.setText(text);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBackground(Color.WHITE);
		label.setForeground(Color.BLACK);

		return label;
	}

	public void joptionConfig(int tipo, Component parentesco, String txt, String title, int iconeMensagem,
			int yes_no_cancel, Object[] valores, Object valorInicial) {

		switch (tipo) {
		case TIPO_MENSAGEM:
			JOptionPane.showMessageDialog(parentesco, txt, title, iconeMensagem, null);

		case TIPO_CONFIRMACAO:
			JOptionPane.showConfirmDialog(parentesco, txt, title, iconeMensagem, yes_no_cancel, null);

		case TIPO_DIALOGO:
			JOptionPane.showInputDialog(parentesco, txt, title, yes_no_cancel, null, valores, valorInicial);

		case TIPO_INTERNO:
			JOptionPane.showInternalConfirmDialog(parentesco, txt, title, iconeMensagem, yes_no_cancel, null);
		}
	}

	public JTable tabelaConfig(JTable table) {

		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.getTableHeader().setBackground(Color.WHITE);
		table.getTableHeader().setForeground(Color.BLACK);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));

		return table;
	}

}
