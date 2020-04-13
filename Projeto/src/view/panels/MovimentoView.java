package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import javafx.scene.control.DatePicker;
import model.vo.movimentos.FluxoVO;
import net.miginfocom.swing.MigLayout;
import util.modifications.Modificacoes;

public class MovimentoView extends JPanel {

	private static final long serialVersionUID = -194366357031753318L;
	private Modificacoes modificacao = new Modificacoes();

	private DatePicker dtInicio;
	private DatePicker dtFinal;
	private JScrollPane scrollPane;
	private JTable table;

	private ArrayList<FluxoVO> lista = null;
	private String[] colunas = { "Número", "Nome", "Plano", "Placa", "Valor", "Entrada", "Saída" };
	private DefaultTableModel model;

	public MovimentoView() {

		this.setBounds(100, 100, 1065, 812);
		this.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		this.setLayout(new MigLayout("",
				"[10px][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][10px]",
				"[10px][grow][20px][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][10px]"));

		this.initialize();
	}

	private void initialize() {

		setJLabels_JSeparator();

		setInputFields();

		setValidationButtons();

		setJTable_And_Componentes();

		//atualizarTabela(lista);

	}

	/**
	 * Adiciona os JLabels a tela & JSeparators
	 */
	private void setJLabels_JSeparator() {

		JLabel lblMovimento = new JLabel("Movimento:");
		lblMovimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovimento.setFont(new Font("Arial", Font.BOLD, 18));
		lblMovimento.setBackground(Color.WHITE);
		this.add(lblMovimento, "cell 1 1 3 1,grow");

	}

	/**
	 * Adiciona os campos de validação na tela;
	 */
	private void setInputFields() {
/*		DatePickerSettings dateSettings = new DatePickerSettings();
		dateSettings.setAllowKeyboardEditing(false);

		dtInicio = new DatePicker(dateSettings);
//		TXT
		dtInicio.getComponentDateTextField().setBackground(Color.WHITE);
		dtInicio.getComponentDateTextField().setFont(new Font("Arial", Font.BOLD, 16));
		dtInicio.getComponentDateTextField().setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		dtInicio.getComponentDateTextField().setHorizontalAlignment(SwingConstants.CENTER);
//		BOTAO
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
		this.add(dtFinal, "cell 11 1,grow");*/
	}

	/**
	 * Adiciona os Botões para validação dos campos de entrada
	 */
	private void setValidationButtons() {
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setPreferredSize(new Dimension(80, 25));
		btnPesquisar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnPesquisar.setFont(new Font("Arial", Font.BOLD, 16));
		this.add(btnPesquisar, "cell 12 1 2 1,grow");
	}

	/**
	 * Adiciona a JTable com ALGUNS campos que intaragem com ela
	 */
	private void setJTable_And_Componentes() {
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.getViewport().setBackground(Color.WHITE);
		this.add(scrollPane, "cell 1 3 13 11,grow");

		table = new JTable(model) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		modificacao.tableLookAndFiel(table);
		scrollPane.setViewportView(table);

	}

	private void atualizarTabela(ArrayList<FluxoVO> vo) {

//		 Limpa a tabela
		limparTabela();

//		 Obtém o model da tabela
		model = (DefaultTableModel) table.getModel();

//		 Percorre os empregados para adicionar linha a linha na tabela (JTable)
		Object[] novaLinha = new Object[5];

//		"Número", "Nome", "Plano", "Placa", "Valor", "Entrada", "Saída"
		for (FluxoVO fluxo : vo) {
			novaLinha[0] = fluxo.getMovimento().getTicket();
			novaLinha[1] = fluxo.getMovimento().getPlano().getDescircao();
			novaLinha[2] = fluxo.getMovimento().getPlano().getDescircao();
			novaLinha[3] = fluxo.getMovimento().getPlano().getCliente().getCarro().getPlaca();
			novaLinha[4] = fluxo.getMovimento().getPlano().getContrato().getValor();
			novaLinha[5] = fluxo.getMovimento().getHr_entrada();
			novaLinha[6] = fluxo.getMovimento().getHr_saida();

//			 Adiciona a nova linha na tabela
			model.addRow(novaLinha);

		}
	}

	private void limparTabela() {
		table.setModel(new DefaultTableModel(new Object[][] {}, colunas));
	}

}
