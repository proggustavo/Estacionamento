package view.panels.cadastro;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;

public class DadosCadastroView extends JPanel {

	private static final long serialVersionUID = 8795512428702538815L;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtRG;
	private JTextField textField;
	private JTextField txtTelefone;

	public DadosCadastroView() {
		
		this.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		this.setBackground(Color.WHITE);
		this.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		this.initialize();
	}

	private void initialize() {
		
		
		JLabel lblNome = new JLabel("Nome *");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Arial", Font.BOLD, 14));
		this.add(lblNome, "cell 0 1 2 1,grow");
		
		JLabel lblCpf = new JLabel("CPF *");
		lblCpf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpf.setFont(new Font("Arial", Font.BOLD, 14));
		this.add(lblCpf, "cell 0 2 2 1,grow");
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setHorizontalAlignment(SwingConstants.CENTER);
		lblRg.setFont(new Font("Arial", Font.BOLD, 14));
		this.add(lblRg, "cell 0 3 2 1,grow");
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		this.add(lblEmail, "cell 0 5 2 1,grow");
		
		JLabel lblTelefone = new JLabel("Fone *");
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 14));
		this.add(lblTelefone, "cell 0 6 2 1,grow");
		
		txtNome = new JTextField();
		txtNome.setBorder(new LineBorder(Color.BLACK, 1, true));
		txtNome.setFont(new Font("Arial", Font.BOLD, 14));
		this.add(txtNome, "cell 2 1 3 1,grow");
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBorder(new LineBorder(Color.BLACK, 1, true));
		txtCpf.setFont(new Font("Arial", Font.BOLD, 14));
		txtCpf.setHorizontalAlignment(SwingConstants.LEFT);
		this.add(txtCpf, "cell 2 2 3 1,grow");
		txtCpf.setColumns(10);
		
		txtRG = new JTextField();
		txtRG.setFont(new Font("Arial", Font.BOLD, 14));
		txtRG.setBorder(new LineBorder(Color.BLACK, 1, true));
		this.add(txtRG, "cell 2 3 3 1,grow");
		txtRG.setColumns(10);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(Color.BLACK, 1, true));
		textField.setFont(new Font("Arial", Font.BOLD, 14));
		this.add(textField, "cell 2 5 3 1,grow");
		textField.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Arial", Font.BOLD, 14));
		txtTelefone.setBorder(new LineBorder(Color.BLACK, 1, true));
		this.add(txtTelefone, "cell 2 6 3 1,grow");
		txtTelefone.setColumns(10);
		
		JCheckBox chckbxBloquear = new JCheckBox("Bloquear?");
		chckbxBloquear.setBackground(Color.WHITE);
		chckbxBloquear.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxBloquear.setFont(new Font("Arial", Font.BOLD, 14));
		this.add(chckbxBloquear, "cell 0 8 2 1,grow");
		
	}
}
