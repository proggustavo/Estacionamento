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

import net.miginfocom.swing.MigLayout;
import util.Modificacoes;

public class MovimentoView extends JPanel {

	private static final long serialVersionUID = -194366357031753318L;
	private Modificacoes modificacao = new Modificacoes();
	private JScrollPane scrollPane;
	private JTable table;

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
		add(lblMovimento, "cell 1 1 3 1,grow");
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setPreferredSize(new Dimension(80, 25));
		btnPesquisar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnPesquisar.setFont(new Font("Arial", Font.BOLD, 16));
		add(btnPesquisar, "cell 12 1 2 1,grow");
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.getViewport().setBackground(Color.WHITE);
		add(scrollPane, "cell 1 3 13 11,grow");
		
		String[] colunmName = {"Número", "Nome", "Plano", "Valor", "Entrada", "Saída"};
		Object[][] data = {};
		
		DefaultTableModel model = new DefaultTableModel(data, colunmName);
		table = new JTable(model);
		modificacao.tabelaConfig(table);
		scrollPane.setViewportView(table);
		
	}

}
