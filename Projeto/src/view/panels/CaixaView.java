package view.panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import util.Modificacoes;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CaixaView extends JPanel {

	private static final long serialVersionUID = -4789193934965387787L;
	private Modificacoes modificacao = new Modificacoes();
	
	private JTable table;
	private JScrollPane scrollPane;

	public CaixaView() {
		
		this.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		this.setBounds(100, 100, 886, 658);
		this.setLayout(new MigLayout("", "[10px][grow][grow][grow][grow][grow][grow][grow][grow][5px][grow][grow][5px][grow][grow][5px][grow][grow][10px]", "[10px][80px][20px][35px][20px][grow][grow][grow][grow][grow][grow][grow][10px]"));
		
		this.initialize();
	}

	private void initialize() {
		
		JLabel lblCaixa = new JLabel("Caixa");
		lblCaixa.setFont(new Font("Arial", Font.BOLD, 20));
		add(lblCaixa, "cell 1 1 2 1,grow");
		
		JLabel lblDados = new JLabel("Dados:");
		lblDados.setFont(new Font("Arial", Font.BOLD, 14));
		lblDados.setBackground(Color.WHITE);
		add(lblDados, "cell 1 3,grow");
		
		JLabel lblSaldoEmDinheiror = new JLabel("Saldo em Dinheiro(R$):");
		lblSaldoEmDinheiror.setFont(new Font("Arial", Font.BOLD, 14));
		lblSaldoEmDinheiror.setForeground(Color.BLACK);
		lblSaldoEmDinheiror.setBackground(Color.WHITE);
		add(lblSaldoEmDinheiror, "cell 13 3,grow");
		
		JLabel lblSaldoEmCarto = new JLabel("Saldo em Cartão:");
		lblSaldoEmCarto.setFont(new Font("Arial", Font.BOLD, 14));
		lblSaldoEmCarto.setForeground(Color.BLACK);
		lblSaldoEmCarto.setBackground(Color.WHITE);
		add(lblSaldoEmCarto, "cell 16 3 2 1,grow");
		
		JButton btnRelatorio = new JButton("<html><body>Relatorio do<br align=Center>Último Caixa</body></html>");
		btnRelatorio.setIcon(new ImageIcon(CaixaView.class.getResource("/img/icons8-enviar-para-a-impressora-50.png")));
//		btnRelatorioDoltimo.setBackground(new Color(100, 149, 237));
		btnRelatorio.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnRelatorio.setFont(new Font("Arial", Font.BOLD, 16));
		add(btnRelatorio, "cell 7 1 2 1,grow");
		btnRelatorio.addActionListener(e -> {
			
			
		});
		
		JButton btnAdicionarValor = new JButton("Adicionar Valor");
		btnAdicionarValor.setIcon(new ImageIcon(CaixaView.class.getResource("/img/icons8-mais-50.png")));
//		btnAdicionarValor.setBackground(new Color(100, 149, 237));
		btnAdicionarValor.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnAdicionarValor.setFont(new Font("Arial", Font.BOLD, 16));
		add(btnAdicionarValor, "cell 10 1 2 1,grow");
		btnAdicionarValor.addActionListener(e -> {
			
			
		});
		
		JButton btnRetirarValor = new JButton("Retirar Valor");
		btnRetirarValor.setIcon(new ImageIcon(CaixaView.class.getResource("/img/icons8-menos-50.png")));
//		btnRetirarValor.setBackground(new Color(100, 149, 237));
		btnRetirarValor.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnRetirarValor.setFont(new Font("Arial", Font.BOLD, 16));
		add(btnRetirarValor, "cell 13 1 2 1,grow");
		btnRetirarValor.addActionListener(e -> {
			
			
		});
		
		JButton btnFecharCaixa = new JButton("Fechar Caixa");
		btnFecharCaixa.setIcon(new ImageIcon(CaixaView.class.getResource("/img/icons8-cadeado-2-50.png")));
//		btnFecharCaixa.setBackground(new Color(100, 149, 237));
		btnFecharCaixa.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnFecharCaixa.setFont(new Font("Arial", Font.BOLD, 16));
		add(btnFecharCaixa, "cell 16 1 2 1,grow");
		btnFecharCaixa.addActionListener(e -> {
			
			
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBorder(null);
		add(scrollPane, "cell 1 5 17 7,grow");
		
		String[] colunmName = {"#", "Descrição", "Forma de Pagamento", "Valor", "Imprimir"};
		Object[][] data = {};
		
		DefaultTableModel model = new DefaultTableModel(data, colunmName);
		table = new JTable(model);
		modificacao.tabelaConfig(table);
		scrollPane.setViewportView(table);
		
	}
}