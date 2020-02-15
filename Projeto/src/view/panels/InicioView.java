package view.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.JSplitPane;
import java.awt.Dimension;

public class InicioView extends JPanel {

	private static final long serialVersionUID = -8394009250133780042L;
	private JTextField txtTicket;
	private JTextField txtProcurar;

	
	public InicioView() {
		
		this.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		this.setBackground(Color.WHITE);
		this.setBounds(100, 100, 1122, 789);
		this.setLayout(new MigLayout("", "[10px][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][10px]", "[10px][grow][grow][grow][][grow][grow][grow][grow][20px][grow][grow][grow][grow][grow][grow][grow][grow][10px]"));
		
		
		this.initialize();
	}

	private void initialize() {
		
		JLabel lblTotalDeVeiculos = new JLabel("Total de Veiculos:");
		lblTotalDeVeiculos.setFont(new Font("Arial", Font.BOLD, 14));
		add(lblTotalDeVeiculos, "cell 4 1 2 1,grow");
		
		JSeparator separatorCima = new JSeparator();
		separatorCima.setBackground(Color.BLACK);
		separatorCima.setForeground(Color.BLACK);
		add(separatorCima, "flowx,cell 1 2 2 1,growx,aligny top");
		
		JLabel lblRegistroSaida = new JLabel("Registro de Saída");
		lblRegistroSaida.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroSaida.setFont(new Font("Arial", Font.BOLD, 20));
		add(lblRegistroSaida, "cell 1 3 2 1,grow");
		
		txtTicket = new JTextField("Digite o Ticket");
		txtTicket.setFont(new Font("Arial", Font.BOLD, 20));
		txtTicket.setBorder(new LineBorder(Color.BLACK));
		txtTicket.setBackground(Color.WHITE);
		add(txtTicket, "cell 1 7 2 1,grow");
		txtTicket.setColumns(10);
		txtTicket.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTicket.getText().trim().toLowerCase().equals("digite o ticket")) {
					txtTicket.setText("");
				}
				txtTicket.setForeground(Color.BLACK);
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTicket.getText().trim().toLowerCase().equals("")) {
					txtTicket.setText("Digite o Ticket");
				}
				txtTicket.setForeground(Color.BLACK);
			}
		});
		
		JSeparator separatorBaixo = new JSeparator();
		separatorBaixo.setForeground(Color.BLACK);
		separatorBaixo.setBackground(Color.BLACK);
		add(separatorBaixo, "cell 1 4 2 1,growx,aligny bottom");
		
		JSeparator separatorMeio = new JSeparator();
		separatorMeio.setBackground(Color.BLACK);
		separatorMeio.setForeground(Color.BLACK);
		separatorMeio.setOrientation(SwingConstants.VERTICAL);
		add(separatorMeio, "cell 3 1 1 17,alignx center,growy");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(InicioView.class.getResource("/img/icons8-excluir-50.png")));
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 16));
		btnCancelar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCancelar.setBackground(Color.decode("#F85C50"));
		btnCancelar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(btnCancelar, "cell 1 8,grow");
		btnCancelar.addActionListener(e -> {
			
			
			
			
		});
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.setIcon(new ImageIcon(InicioView.class.getResource("/img/icons8-selecionado-50.png")));
		btnValidar.setFont(new Font("Arial", Font.BOLD, 16));
		btnValidar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnValidar.setBackground(Color.decode("#35D073"));
		btnValidar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnValidar.addActionListener(e -> {
			
			
			
			
		});
		add(btnValidar, "cell 2 8,grow");
		
		JButton btnGerarTicket = new JButton("Gerar Ticket");
		btnGerarTicket.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnGerarTicket.setIcon(new ImageIcon(InicioView.class.getResource("/img/icons8-enviar-para-a-impressora-50.png")));
		btnGerarTicket.setFont(new Font("Arial", Font.BOLD, 16));
		add(btnGerarTicket, "cell 1 10 2 1,grow");
		btnGerarTicket.addActionListener(e -> {
			
			
			
			
		});
		
		JButton btnImprimirComprovante = new JButton("Ultimo Recibo");
		btnImprimirComprovante.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnImprimirComprovante.setIcon(new ImageIcon(InicioView.class.getResource("/img/icons8-enviar-para-a-impressora-50.png")));
		btnImprimirComprovante.setFont(new Font("Arial", Font.BOLD, 16));
		add(btnImprimirComprovante, "cell 1 11 2 1,grow");
		btnImprimirComprovante.addActionListener(e -> {
			
			
			
			
			
		});
		
		
		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setRowHeader(arg0);
		add(scrollPane, "cell 4 2 11 16,grow");
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setPreferredSize(new Dimension(210, 50));
		splitPane.setBackground(Color.WHITE);
		scrollPane.setColumnHeaderView(splitPane);
		
		txtProcurar = new JTextField();
		txtProcurar.setFont(new Font("Arial", Font.BOLD, 16));
		txtProcurar.setText("Procurar...");
		splitPane.setRightComponent(txtProcurar);
		txtProcurar.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setPreferredSize(new Dimension(250, 23));
		btnProcurar.setFont(new Font("Arial", Font.BOLD, 16));
		splitPane.setLeftComponent(btnProcurar);
		
	}
 
}
