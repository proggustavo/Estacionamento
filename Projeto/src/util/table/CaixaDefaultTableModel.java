package util.table;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.vo.CaixaVO;

public class CaixaDefaultTableModel extends DefaultTableModel {

	private static final long serialVersionUID = -7525679140571690171L;

	private static final int TICKET_CARTAO = 0;
	private static final int DESCRICAO = 1;
	private static final int HR_ENTRADA = 2;
	private static final int HR_VAlIDACAO = 3;
	private static final int FORMA_PGTO = 4;
	private static final int VALOR = 5;
	private static final int IMPRIMIR = 6;

	private ArrayList<CaixaVO> linhas = new ArrayList<CaixaVO>();
	private String[] colunas = new String[] { "Ticket / Cartão", "Descrição", "Hora de Entrada", "Hora de Validação",
			"Forma de Pagamento", "Valor", "Imprimir" };

	// Construtor
	public CaixaDefaultTableModel(List<CaixaVO> caixa) {
		linhas = new ArrayList<CaixaVO>(caixa);
	}

	// Construtor
	public CaixaDefaultTableModel() {
		linhas = new ArrayList<CaixaVO>();
	}

	public LocalTime getHoraEntrada(int row) {
		return linhas.get(row).getMoveVO().getEntrada().toLocalTime();
	}

	public LocalTime getHoraValidacao(int row) {
		return linhas.get(row).getHoraValidacao().toLocalTime();
	}

	public CaixaVO getCaixa(int row) {
		return linhas.get(row);
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}

	@Override
	public boolean isCellEditable(int row, int column) {

		switch (column) {
		case TICKET_CARTAO:
			return false;
		case DESCRICAO:
			return false;
		case HR_ENTRADA:
			return false;
		case HR_VAlIDACAO:
			return false;
		case FORMA_PGTO:
			return false;
		case VALOR:
			return false;
		case IMPRIMIR:
			return true;
		default:
			throw new IndexOutOfBoundsException(
					"ERRO: CaixaDefaultTableModel.class" + "\n>> Method line 62 \nReview Code.");
		}
	}

	@Override
	public Class<?> getColumnClass(int column) {

		switch (column) {
		case TICKET_CARTAO:
			return String.class;
		case DESCRICAO:
			return String.class;
		case HR_ENTRADA:
			return LocalTime.class;
		case HR_VAlIDACAO:
			return LocalTime.class;
		case FORMA_PGTO:
			return String.class;
		case VALOR:
			return Double.class;
		case IMPRIMIR:
			return Boolean.class;

		default:
			throw new IndexOutOfBoundsException(
					"ERRO: CaixaDefaultTableModel.class" + "\n>> Method line 89 \nReview Code.");
		}
	}

	@Override
	public Object getValueAt(int row, int column) {
		CaixaVO caixa = linhas.get(row);
		switch (column) {
		case TICKET_CARTAO:
			return caixa.getMoveVO().getTicket_cartao();
		case DESCRICAO:
			return caixa.getDescricao();
		case HR_ENTRADA:
			return caixa.getMoveVO().getEntrada();
		case HR_VAlIDACAO:
			return caixa.getHoraValidacao();
		case FORMA_PGTO:
			return caixa.getFormaPgto();
		case VALOR:
			return caixa.getValorTicket();
		case IMPRIMIR:
			return caixa.isCbx();

		default:
			throw new IndexOutOfBoundsException(
					"ERRO: CaixaDefaultTableModel.class" + "\n>> Method line 114 \nReview Code.");
		}
	}

}
