package util.modifications;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;

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

	/**
	 * Modifica e retorna Label contendo uma Mensagem, com fonte, cor e tamanhos padronizados.
	 * @param label
	 * @param text
	 * @return label+text
	 */
	public JLabel labelConfig(JLabel label, String text) {

		label = new JLabel();
		label.setText(text);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBackground(Color.WHITE);
		label.setForeground(Color.BLACK);
		
		if (text.trim().isEmpty() || text.trim().equals("")) {
			label.setText("<html><body>Erro: Line 76 >> Modificacoes.class<br>Method: labelConfig.<br>Motivo: Campo Vazio</body></html>");
			return label;
		}

		return label;
	}

//	public void joptionConfig(int tipo, Component parentesco, String txt, String title, int iconeMensagem,
//			int yes_no_cancel, Object[] valores, Object valorInicial) {
//
//		switch (tipo) {
//		case TIPO_MENSAGEM:
//			JOptionPane.showMessageDialog(parentesco, txt, title, iconeMensagem, null);
//
//		case TIPO_CONFIRMACAO:
//			JOptionPane.showConfirmDialog(parentesco, txt, title, iconeMensagem, yes_no_cancel, null);
//
//		case TIPO_DIALOGO:
//			JOptionPane.showInputDialog(parentesco, txt, title, yes_no_cancel, null, valores, valorInicial);
//
//		case TIPO_INTERNO:
//			JOptionPane.showInternalConfirmDialog(parentesco, txt, title, iconeMensagem, yes_no_cancel, null);
//		}
//	}

	/**
	 * Modifica e retorna fonte, cor, e tamanho, padronizados.
	 * @param table
	 * @return table(Style of Table)
	 */
	public JTable tabelaConfig(JTable table) {
		
		DefaultTableCellRenderer centerRendererLeft = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centerRendererCenter = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centerRendererRight = new DefaultTableCellRenderer();
		
		// Tentativa para mudar o cellRender dependendo da view
//		MainView view = new MainView();
//		InicioView inicioView = new InicioView();
//		CaixaView caixaView = new CaixaView();
//		MovimentoView movimentoView = new MovimentoView();
		
//		if (inicioView instanceof InicioView) {
//			if (inicioView.contains(table)) {
//				
//			}
//		}
		
//		Renderizar os valores dentro da celular
		for (int i = 0; i < table.getModel().getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer( centerRendererCenter );
			if (i == 2) {
				table.getColumnModel().getColumn(1).setCellRenderer( centerRendererLeft );
			}
		}

		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Arial", Font.BOLD, 16));
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
		table.getTableHeader().setBackground(Color.WHITE);
		table.setColumnSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		table.setRowHeight(35);
		table.setShowGrid(true);
		table.setGridColor(Color.BLACK);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(false);
		

		return table;
	}
	
	/**
	 * Método para criar um ComboBox dentro da JTable
	 * @param table tabela
	 * @param sportColumn escolher a coluna
	 */
//	 Fiddle with the Sport column's cell editors/renderers.
	public void mostrarComboBoxJTable(JTable table, TableColumn sportColumn) {
		// Set up the editor for the sport cells.
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("TESTE 1");
		comboBox.addItem("TESTE 2");
		comboBox.addItem("TESTE 3");
		comboBox.addItem("TESTE 4");
		comboBox.addItem("TESTE 5");
		comboBox.addItem("TESTE 6");
		sportColumn.setCellEditor(new DefaultCellEditor(comboBox));

//		 Set up tool tips for the sport cells.
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setToolTipText("CLIQUE PARA O COMBO BOX APARECER");
		sportColumn.setCellRenderer(renderer);
	}
	
	/**
	 * Método para reenderizar a JTable e criar uma mascara
	 * com campo formatado em uma coluna especifica
	 * 
	 * @param table
	 * @param TableColumn escolher a coluna
	 */
	public void maskFormJTable(JTable table, TableColumn sportColumn) {
		
		JFormattedTextField placa = new JFormattedTextField();
		MaskFormatter mascara;
		try {
			mascara = new MaskFormatter("HHHHHHHHHH");
			mascara.setPlaceholderCharacter('?');
			mascara.install(placa);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sportColumn.setCellEditor(new DefaultCellEditor(placa));

	}
	
	/**
	 * Adicionar e Remover o PlaceHolder
	 * @param JTextField field
	 * @param Strign mensagem
	 */
	public JFormattedTextField adicionarRemoverFocus(JTextField field, String mensagem) {
		
		field.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (field.getText().trim().toLowerCase().equals(mensagem.toLowerCase())) {
					field.setText("");
				}
				field.setForeground(Color.BLACK);
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (field.getText().trim().toLowerCase().equals("")) {
					field.setText(mensagem);
				}
				field.setForeground(Color.BLACK);
			}
		});
		return (JFormattedTextField) field;
	}
	
	/**
	 * Criação de uma mascara para o campo, e um place holder(Palavras que somem ao digitar)
	 * @param MaskFormatter mask
	 * @param int tipo
	 * @param String text
	 * 
	 */
	public MaskFormatter maskAndPlaceHolder(MaskFormatter mask, int tipo, String text) {
		
			try {
				if (tipo == 1) {
					mask = new MaskFormatter("###################################");
				}
				
				if (tipo == 2) {
					mask = new MaskFormatter("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
				}
				
				if (tipo == 3) {
					mask = new MaskFormatter("***********************************");
				}
				mask.setPlaceholder(text);
			} catch (ParseException e) {
				e.getMessage();
				e.printStackTrace();
				e.getStackTrace();
			}
			return mask;
	}
	
	/**
	 * Remove os espaçoes em branco do campo, iniciando a digitação no começo do campo.
	 * @param JTextField field
	 * @return cast(JFormatedTextField)
	 */
//	public JFormattedTextField caretPosition (JTextField txt) {
//		txt.addInputMethodListener(new InputMethodListener() {
//			public void caretPositionChanged(InputMethodEvent event) {
//
//				txt = (JFormattedTextField) event.getSource();
//				int offset = txt.viewToModel((Point) event.getText());
//				txt.setCaretPosition(offset);
//			}
//
//			public void inputMethodTextChanged(InputMethodEvent event) {
//
//			}
//		});
//		return (JFormattedTextField) txt;
//	}
}
