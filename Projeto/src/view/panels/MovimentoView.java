package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import net.miginfocom.swing.MigLayout;
import util.modifications.Modificacoes;

public class MovimentoView extends JPanel {

	private static final long serialVersionUID = -194366357031753318L;
	private Modificacoes modificacao = new Modificacoes();

	private DatePicker dtInicio;
	private DatePicker dtFinal;
	private JScrollPane scrollPane;
	private JTable table;
	
	private String[] colunas = {"Número", "Nome", "Plano", "Placa", "Valor", "Entrada", "Saída"};

	public MovimentoView() {
		
		this.setBounds(100, 100, 1065, 812);
		this.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		this.setLayout(new MigLayout("", "[10px][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][10px]", "[10px][grow][20px][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][10px]"));
		
		this.initialize();
	}

	private void initialize() {
		
		JLabel lblMovimento = new JLabel("Movimento:");
		lblMovimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovimento.setFont(new Font("Arial", Font.BOLD, 18));
		lblMovimento.setBackground(Color.WHITE);
		this.add(lblMovimento, "cell 1 1 3 1,grow");
		
//		BUGANDO....
//		
		DatePickerSettings dateSettings = new DatePickerSettings();
		dateSettings.setAllowKeyboardEditing(false);
		
		dtInicio = new DatePicker();
////		TXT
		dtInicio.getComponentDateTextField().setBackground(Color.WHITE);
		dtInicio.getComponentDateTextField().setFont(new Font("Arial", Font.BOLD, 16));
		dtInicio.getComponentDateTextField().setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		dtInicio.getComponentDateTextField().setHorizontalAlignment(SwingConstants.CENTER);
////		BOTAO
		dtInicio.getComponentToggleCalendarButton().setText("Início");
		dtInicio.getComponentToggleCalendarButton().setPreferredSize(new Dimension(50, 20));
		dtInicio.getComponentToggleCalendarButton().setFont(new Font("Arial", Font.BOLD, 16));
		dtInicio.getComponentToggleCalendarButton().setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		this.add(dtInicio, "cell 10 1,grow");

		dtFinal = new DatePicker();
//		TXT
		dtFinal.getComponentDateTextField().setBackground(Color.WHITE);
		dtFinal.getComponentDateTextField().setFont(new Font("Arial", Font.BOLD, 16));
		dtFinal.getComponentDateTextField().setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		dtFinal.getComponentDateTextField().setHorizontalAlignment(SwingConstants.CENTER);
//		BOTAO
		dtFinal.getComponentToggleCalendarButton().setText("Fim");
		dtFinal.getComponentToggleCalendarButton().setPreferredSize(new Dimension(50, 20));
		dtFinal.getComponentToggleCalendarButton().setFont(new Font("Arial", Font.BOLD, 16));
		dtFinal.getComponentToggleCalendarButton().setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		this.add(dtFinal, "cell 11 1,grow");
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setPreferredSize(new Dimension(80, 25));
		btnPesquisar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnPesquisar.setFont(new Font("Arial", Font.BOLD, 16));
		this.add(btnPesquisar, "cell 12 1 2 1,grow");
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.getViewport().setBackground(Color.WHITE);
		this.add(scrollPane, "cell 1 3 13 11,grow");
		
//		String[] colunmName = {"Número", "Nome", "Plano", "Placa", "Valor", "Entrada", "Saída"};
//		Object[][] data = { {"", "", "", "", "", "", ""}, };
		
//		DefaultTableModel model = new DefaultTableModel(data, colunmName);
		table = new JTable();
		modificacao.tabelaConfig(table);
		scrollPane.setViewportView(table);
		limparTabela();
		
	}
	
	private void limparTabela() {
		table.setModel(new DefaultTableModel(new Object[][] { colunas, }, colunas));
	}
	
	private void preencherDados() {
		
	}

}
