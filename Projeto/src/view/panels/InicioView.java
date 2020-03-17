package view.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.ControllerInicio;
import model.bo.MovimentoBO;
import model.vo.movimentos.MovimentoVO;
import net.miginfocom.swing.MigLayout;
import util.modifications.Modificacoes;

public class InicioView extends JPanel {

	private static final long serialVersionUID = -8394009250133780042L;
	private static final String DINHEIRO = "1 - DINHEIRO";
	private static final String CARTAO = "2 - CARTÃO";
	private Modificacoes modificacao = new Modificacoes();
	private ControllerInicio controller;

	private MaskFormatter mf1, mf2;
	private JComboBox<Object> cbFormaPgto;
	private ArrayList<String> formaPgto;
	private JScrollPane scrollPane;
	private JSplitPane splitPane;
	private JTable table;
	private JButton btnProcurar;
	private JButton btnCancelar;
	private JButton btnValidar;
	private JButton btnGerarTicket;
	private JButton btnImprimirComprovante;
	private JButton btnImprimirComprovanteTabela;
	private JButton btnRemover;
	private JTextField txtTicket;
	private JTextField txtProcurar;
	private JLabel lblTotalDeVeiculos;
	private JLabel lblValorPgto;
	private JLabel lblMetodo;

	private String[] colunas = new String[] { "Ticket / Cartão", "Carro", "Placa", "Cliente", "Entrada" };

	private String msg;

	public InicioView() {

		this.setBounds(100, 100, 1122, 789);
		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		this.setLayout(new MigLayout("",
				"[10px][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][10px]",
				"[10px][grow][grow][grow][grow][grow][grow][grow][grow][20px][grow][grow][grow][grow][grow][grow][10px][grow][grow][10px]"));

		this.initialize();
	}

	private void initialize() {

		// Mascara e PlaceHolder
		maskAndPlaceHolder();

		JSeparator separatorCima = new JSeparator();
		separatorCima.setBackground(Color.BLACK);
		separatorCima.setForeground(Color.BLACK);
		add(separatorCima, "flowx,cell 1 1 2 1,growx,aligny bottom");

		JSeparator separatorMeio = new JSeparator();
		separatorMeio.setBackground(Color.BLACK);
		separatorMeio.setForeground(Color.BLACK);
		separatorMeio.setOrientation(SwingConstants.VERTICAL);
		add(separatorMeio, "cell 3 1 1 18,alignx center,growy");

		JSeparator separatorBaixo = new JSeparator();
		separatorBaixo.setForeground(Color.BLACK);
		separatorBaixo.setBackground(Color.BLACK);
		add(separatorBaixo, "cell 1 3 2 1,growx,aligny top");

		JLabel lblRegistroSaida = new JLabel("Registro de Saída");
		lblRegistroSaida.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroSaida.setFont(new Font("Arial", Font.BOLD, 20));
		add(lblRegistroSaida, "cell 1 2 2 1,grow");

		JLabel lblImprimirLinhaSelecionada = new JLabel("Imprimir / Remover Linha Selecionada:");
		lblImprimirLinhaSelecionada.setFont(new Font("Arial", Font.BOLD, 16));
		lblImprimirLinhaSelecionada.setBackground(Color.WHITE);
		add(lblImprimirLinhaSelecionada, "cell 5 17 3 2,grow");

		lblTotalDeVeiculos = new JLabel("Total de Veiculos:");
		lblTotalDeVeiculos.setFont(new Font("Arial", Font.BOLD, 14));
		add(lblTotalDeVeiculos, "cell 4 1 2 1,grow");

		lblValorPgto = new JLabel("Valor a Ser Pago:");
		lblValorPgto.setFont(new Font("Arial", Font.BOLD, 16));
		lblValorPgto.setBackground(Color.WHITE);
		add(lblValorPgto, "cell 1 7 2 1,grow");

		splitPane = new JSplitPane();
		splitPane.setBorder(null);
		splitPane.setDividerSize(10);
		splitPane.setPreferredSize(new Dimension(500, 35));
		splitPane.setBackground(Color.WHITE);
		this.add(splitPane, "cell 4 2 11 1,grow");

		formaPgto = new ArrayList<String>();
		formaPgto.add(DINHEIRO);
		formaPgto.add(CARTAO);

		cbFormaPgto = new JComboBox<Object>(formaPgto.toArray());
		cbFormaPgto.setFont(new Font("Arial", Font.BOLD, 20));
		cbFormaPgto.setBackground(Color.WHITE);
		add(cbFormaPgto, "cell 1 8 2 1,grow");

		txtProcurar = new JFormattedTextField(mf2);
		txtProcurar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		txtProcurar.setText("Pesquisar... (F6)");
		txtProcurar.setFont(new Font("Arial", Font.BOLD, 16));
//		modificacao.txtConfig(txtProcurar, "Procurar... (F6)", new Font("Arial", Font.BOLD, 16),
//		Color.WHITE, Color.BLACK, new LineBorder(new Color(0, 0, 0), 1, true));
		txtProcurar.setFocusAccelerator((char) KeyEvent.VK_F6);
		txtProcurar.setColumns(10);
		modificacao.adicionarRemoverFocus(txtProcurar, "Pesquisar... (F6)");
		splitPane.setRightComponent(txtProcurar);

		txtTicket = new JFormattedTextField(mf1);
		txtTicket.setText("Digite o Número do Ticket");
		txtTicket.setFont(new Font("Arial", Font.BOLD, 20));
		txtTicket.setBorder(new LineBorder(Color.BLACK));
		txtTicket.setBackground(Color.WHITE);
		add(txtTicket, "cell 1 5 2 1,grow");
		txtTicket.setColumns(10);
		modificacao.adicionarRemoverFocus(txtTicket, "Digite o Número do Ticket");

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

//			modificacao.joptionConfig(1, this, mensagem, "VALIDAÇÃO", Modificacoes.JOPTION_ATENCAO,
//			Modificacoes.JOPTION_K_C, null, null);

			String ticket = txtTicket.getText().trim();
			controller = new ControllerInicio();
			msg = controller.validate(ticket);

			JOptionPane.showMessageDialog(this, modificacao.labelConfig(lblMetodo, msg), "VALIDAÇÃO",
					JOptionPane.WARNING_MESSAGE);
		});

		btnGerarTicket = new JButton("Gerar Ticket");
		btnGerarTicket.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnGerarTicket
				.setIcon(new ImageIcon(InicioView.class.getResource("/img/icons8-enviar-para-a-impressora-50.png")));
		btnGerarTicket.setFont(new Font("Arial", Font.BOLD, 16));
		add(btnGerarTicket, "cell 1 10 2 1,grow");
		btnGerarTicket.addActionListener(e -> {

			// TODO Gerar um numero aleatorio apartir da classe Math,
			// verificar se ele já existe, e se tem necessidade de existir somente uma vez
			// no banco/sistema
			// & mandar os dados para a JTable

		});

		btnImprimirComprovante = new JButton("Ultimo Recibo");
		btnImprimirComprovante.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnImprimirComprovante
				.setIcon(new ImageIcon(InicioView.class.getResource("/img/icons8-enviar-para-a-impressora-50.png")));
		btnImprimirComprovante.setFont(new Font("Arial", Font.BOLD, 16));
		add(btnImprimirComprovante, "cell 1 11 2 1,grow");
		btnImprimirComprovante.addActionListener(e -> {

			// TODO Selecionar A(uma por vez) linha, e gerar comprovante(Imprimir)

		});

		btnProcurar = new JButton("Procurar?");
		btnProcurar.setPreferredSize(new Dimension(300, 50));
		btnProcurar.setFont(new Font("Arial", Font.BOLD, 16));
		btnProcurar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnProcurar.setBackground(new Color(100, 149, 237));
		splitPane.setLeftComponent(btnProcurar);
		btnProcurar.addActionListener(e -> {
			MovimentoBO bo = new MovimentoBO();
			ArrayList<MovimentoVO> vo = bo.consultarTodos();
			atualizarTabela(vo);

//			limparTabela();

		});

		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBorder(null);

		table = new JTable();
		modificacao.tabelaConfig(table);
		scrollPane.setViewportView(table);
		add(scrollPane, "cell 4 3 11 13,grow");

		btnImprimirComprovanteTabela = new JButton("Imprimir Comprovante");
		btnImprimirComprovanteTabela.setFont(new Font("Arial", Font.BOLD, 16));
		btnImprimirComprovanteTabela.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnImprimirComprovanteTabela.setToolTipText("Imprime comprovante de Clientes ou Tickets na Tabela");
		add(btnImprimirComprovanteTabela, "cell 8 17 3 2,grow");
		btnImprimirComprovanteTabela.addActionListener(e -> {

		});

		btnRemover = new JButton("Remover Ticket / Cliente");
		btnRemover.setFont(new Font("Arial", Font.BOLD, 16));
		btnRemover.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnRemover.setToolTipText("Remove os Clientes ou Tickets na Tabela");
		add(btnRemover, "cell 11 17 3 2,grow");
		btnRemover.addActionListener(e -> {

			JOptionPane.showConfirmDialog(this, modificacao.labelConfig(lblMetodo, msg), "EXCLUIR CITKER / CARTÃO?",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);

		});

	}

	protected void atualizarTabela(ArrayList<MovimentoVO> vo) {

		// Limpa a tabela
		limparTabela();

		// Obtém o model da tabela
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		// Percorre os empregados para adicionar linha a linha na tabela (JTable)
		Object[] novaLinha = new Object[5];
		for (MovimentoVO movimento : vo) {
			novaLinha[0] = String.valueOf(movimento.getTicket().getNumero());
			novaLinha[1] = movimento.getTicket().getCliente().getCarro().getModelo().getDescricao();
			novaLinha[2] = movimento.getTicket().getCliente().getCarro().getPlaca();	
			novaLinha[3] = movimento.getTicket().getCliente().getNome();
			novaLinha[4] = String.valueOf(movimento.getHr_entrada().toLocalDate());

			// Adiciona a nova linha na tabela
			model.addRow(novaLinha);
		}
	}

//	private void atualizarTable() {
//		
//		
//		
//		Object row[] = new Object[5];
//		ArrayList<MoveVO> array = new ArrayList<MoveVO>();
//		MoveVO vo = new MoveVO();
//		for (int i = 0; i < array.size(); i++) {
//			
//			row[0] = vo.getTicket_cartao();
//			row[1] = vo.getCarro().getDescricao();
//			row[2] = vo.getCarro().getPlaca();
//			row[3] = vo.getCliente().getNome();
//			row[4] = vo.getEntrada();
//			row[5] = vo.isCbx();
//			
//			model.addRow(row);
//			
//		}
//	}

	private void limparTabela() {
		table.setModel(new DefaultTableModel(new Object[][] { colunas }, colunas));
	}

//	private void consultarTabela(ArrayList<FluxoVO> vo) {
		// TODO Consultar a Tabela com Seletor
//	}

	/**
	 * Criação de uma mascara para o campo, e um place holder(Palavras que somem ao
	 * digitar)
	 */
	private void maskAndPlaceHolder() {

		try {
			mf1 = new MaskFormatter("#############################################");
			mf1.setPlaceholder("Digite o Número do Ticket");
			mf2 = new MaskFormatter("#############################################");
			mf2.setPlaceholder("Pesquisar... (F6)");
		} catch (ParseException e) {
			e.getMessage();
			e.printStackTrace();
			e.getStackTrace();
		}
	}

}