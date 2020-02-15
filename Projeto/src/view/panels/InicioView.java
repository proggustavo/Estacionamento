package view.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import util.Modificacoes;

public class InicioView extends JPanel {

	private static final long serialVersionUID = -8394009250133780042L;
	private static final String DINHEIRO = "1 - DINHEIRO";
	private static final String CARTAO = "2 - CARTÃO";

	private JComboBox<Object> comboBox;
	private ArrayList<String> tiposPagamento;
	private JScrollPane scrollPane;
	private JSplitPane splitPane;
	private JTable table;
	private JButton btnProcurar;
	private JButton btnCancelar;
	private JButton btnValidar;
	private JButton btnGerarTicket;
	private JButton btnImprimirComprovante;
	private JTextField txtTicket;
	private JTextField txtProcurar;
	private Component lblTotalDeVeiculos;
	private Modificacoes modificacao = new Modificacoes();

	
	public InicioView() {
		
		this.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		this.setBackground(Color.WHITE);
		this.setBounds(100, 100, 1122, 789);
		this.setLayout(new MigLayout("", "[10px][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][10px]", "[10px][grow][grow][grow][grow][grow][grow][grow][20px][grow][grow][grow][grow][grow][grow][grow][grow][10px]"));
		
		
		this.initialize();
	}

	private void initialize() {
		
		JSeparator separatorCima = new JSeparator();
		separatorCima.setBackground(Color.BLACK);
		separatorCima.setForeground(Color.BLACK);
		add(separatorCima, "flowx,cell 1 1 2 1,growx,aligny bottom");
		
		JSeparator separatorMeio = new JSeparator();
		separatorMeio.setBackground(Color.BLACK);
		separatorMeio.setForeground(Color.BLACK);
		separatorMeio.setOrientation(SwingConstants.VERTICAL);
		add(separatorMeio, "cell 3 1 1 16,alignx center,growy");
		
		JSeparator separatorBaixo = new JSeparator();
		separatorBaixo.setForeground(Color.BLACK);
		separatorBaixo.setBackground(Color.BLACK);
		add(separatorBaixo, "cell 1 3 2 1,growx,aligny top");
		
		JLabel lblRegistroSaida = new JLabel("Registro de Saída");
		lblRegistroSaida.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroSaida.setFont(new Font("Arial", Font.BOLD, 20));
		add(lblRegistroSaida, "cell 1 2 2 1,grow");

		lblTotalDeVeiculos = new JLabel("Total de Veiculos:");
		lblTotalDeVeiculos.setFont(new Font("Arial", Font.BOLD, 14));
		add(lblTotalDeVeiculos, "cell 4 1 2 1,grow");
		
		splitPane = new JSplitPane();
		splitPane.setBorder(null);
		splitPane.setDividerSize(10);
		splitPane.setPreferredSize(new Dimension(500, 35));
		splitPane.setBackground(Color.WHITE);
		this.add(splitPane, "cell 4 2 11 1,grow");
		
		tiposPagamento = new ArrayList<String>();
		tiposPagamento.add(DINHEIRO);
		tiposPagamento.add(CARTAO);
		comboBox = new JComboBox<Object>(tiposPagamento.toArray());
		comboBox.setFont(new Font("Arial", Font.BOLD, 26));
		comboBox.setBackground(Color.WHITE);
		add(comboBox, "cell 1 7 2 1,grow");
		
		txtProcurar = new JTextField();
		txtProcurar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		txtProcurar.setText("Pesquisar... (F6)");
		txtProcurar.setFont(new Font("Arial", Font.BOLD, 16));
//		modificacao.txtConfig(txtProcurar, "Procurar... (F6)", new Font("Arial", Font.BOLD, 16),
//		Color.WHITE, Color.BLACK, new LineBorder(new Color(0, 0, 0), 1, true));
		txtProcurar.setFocusAccelerator((char) KeyEvent.VK_F6);
		txtProcurar.setColumns(10);
		splitPane.setRightComponent(txtProcurar);
		txtProcurar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtProcurar.getText().trim().toLowerCase().equals("pesquisar... (f6)")) {
					txtProcurar.setText("");
				}
				txtProcurar.setForeground(Color.BLACK);
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtProcurar.getText().trim().toLowerCase().equals("")) {
					txtProcurar.setText("Pesquisar... (F6)");
				}
				txtProcurar.setForeground(Color.BLACK);
			}
		});
		
		txtTicket = new JTextField("Digite o Número do Ticket");
		txtTicket.setFont(new Font("Arial", Font.BOLD, 26));
		txtTicket.setBorder(new LineBorder(Color.BLACK));
		txtTicket.setBackground(Color.WHITE);
		add(txtTicket, "cell 1 5 2 1,grow");
		txtTicket.setColumns(10);
		txtTicket.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTicket.getText().trim().toLowerCase().equals("digite o número do ticket")) {
					txtTicket.setText("");
				}
				txtTicket.setForeground(Color.BLACK);
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTicket.getText().trim().toLowerCase().equals("")) {
					txtTicket.setText("Digite o Número do Ticket");
				}
				txtTicket.setForeground(Color.BLACK);
			}
		});
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(InicioView.class.getResource("/img/icons8-excluir-50.png")));
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 18));
		btnCancelar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCancelar.setBackground(Color.decode("#F85C50"));
		btnCancelar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(btnCancelar, "cell 1 6,grow");
		btnCancelar.addActionListener(e -> {
			
			txtTicket.setText("Digite o Número do Ticket");
			
		});
		
		btnValidar = new JButton("Validar");
		btnValidar.setIcon(new ImageIcon(InicioView.class.getResource("/img/icons8-selecionado-50.png")));
		btnValidar.setFont(new Font("Arial", Font.BOLD, 18));
		btnValidar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnValidar.setBackground(Color.decode("#35D073"));
		btnValidar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(btnValidar, "cell 2 6,grow");
		btnValidar.addActionListener(e -> {
			
			
			
			
		});
		
		btnGerarTicket = new JButton("Gerar Ticket");
		btnGerarTicket.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnGerarTicket.setIcon(new ImageIcon(InicioView.class.getResource("/img/icons8-enviar-para-a-impressora-50.png")));
		btnGerarTicket.setFont(new Font("Arial", Font.BOLD, 16));
		add(btnGerarTicket, "cell 1 9 2 1,grow");
		btnGerarTicket.addActionListener(e -> {
			
			
			
			
		});
		
		btnImprimirComprovante = new JButton("Ultimo Recibo");
		btnImprimirComprovante.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnImprimirComprovante.setIcon(new ImageIcon(InicioView.class.getResource("/img/icons8-enviar-para-a-impressora-50.png")));
		btnImprimirComprovante.setFont(new Font("Arial", Font.BOLD, 16));
		add(btnImprimirComprovante, "cell 1 10 2 1,grow");
		btnImprimirComprovante.addActionListener(e -> {
			
			
			
			
			
		});
		
		btnProcurar = new JButton("Procurar?");
		btnProcurar.setPreferredSize(new Dimension(300, 50));
		btnProcurar.setFont(new Font("Arial", Font.BOLD, 16));
		btnProcurar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnProcurar.setBackground(new Color(100, 149, 237));
		splitPane.setLeftComponent(btnProcurar);
		btnProcurar.addActionListener(e -> {
			
			
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBorder(null);
		add(scrollPane, "cell 4 3 11 14,grow");
		
		String[] colunmName = { "Número", "Placa", "Cliente", "Entrada", "Remover", "Imprimir" };
		Object[][] data = {};
		
		DefaultTableModel model = new DefaultTableModel(data, colunmName);
		table = new JTable(new DefaultTableModel(data, colunmName));
		modificacao.tabelaConfig(table, model);
		
	}
}
