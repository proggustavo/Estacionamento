package view.panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import util.Modificacoes;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ClientView extends JPanel {

	private static final long serialVersionUID = 1729741232577251804L;
	private Modificacoes modificacao = new Modificacoes();
	private JTextField txtProcurar;

	public ClientView() {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		this.setBounds(100, 100, 1028, 747);
		this.setBackground(Color.WHITE);
		this.setLayout(new MigLayout("", "[20px][grow][grow][grow][grow][grow][grow][grow][20px,fill]", "[20px][80px][grow][grow][grow][grow][grow][grow][20px]"));
		
		
		this.initialize();
	}

	private void initialize() {
		
		JLabel lblSelecionar = new JLabel("<html><body>Selecione o Cliente<br>para Cadastrar ou Atualizar</body></html>");
		lblSelecionar.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelecionar.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblSelecionar, "cell 1 1,grow");
		
		JButton btnCadastrar = new JButton("<html><body>Cadastrar<br>Atualizar</body></html>");
		btnCadastrar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 20));
		add(btnCadastrar, "cell 2 1 2 1,grow");
		
		txtProcurar = new JTextField();
		txtProcurar.setFont(new Font("Arial", Font.BOLD, 16));
		txtProcurar.setBorder(new LineBorder(Color.BLACK, 1, true));
		txtProcurar.setBackground(Color.WHITE);
		txtProcurar.setText("Pesquisar");
		add(txtProcurar, "cell 5 1 2 1,grow");
		txtProcurar.setColumns(10);
		
		JButton btnProcurar = new JButton("Pesquisar");
		btnProcurar.setFont(new Font("Arial", Font.BOLD, 16));
		btnProcurar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(btnProcurar, "cell 7 1,grow");
		
	}

}
