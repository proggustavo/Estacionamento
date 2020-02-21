package util.table;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import model.vo.ClienteVO;
import model.vo.MoveVO;

public class InicioDefaultTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 552983872027492612L;

	private static final int TICKET_CARTAO = 0;
	private static final int CARRO = 1;
	private static final int PLACA = 2;
	private static final int CLIENTE = 3;
	private static final int ENTRADA = 4;
	private static final int REMOVER = 5;

	private ArrayList<MoveVO> linhas = new ArrayList<MoveVO>();
	private String[] colunas = new String[] { "Ticket / Cartão", "Carro", "Placa", "Cliente", "Entrada", "Remover" };

	// Construtor
	public InicioDefaultTableModel(List<MoveVO> movimento) {
		linhas = new ArrayList<MoveVO>(movimento);
	}

	// Construtor
	public InicioDefaultTableModel() {
		linhas = new ArrayList<MoveVO>();
	}

	public LocalTime getHorario(int rowIndex) {
		return linhas.get(rowIndex).getEntrada().toLocalTime();
	}

	public MoveVO getMovimento (int row) {
		return linhas.get(row);
	}
	
//	public MoveVO getMove(int rowIndex) {
//		return linhas.get(rowIndex).getVo();
//	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

	
//	@Override
//	public int getRowCount() {
//		return linhas.size();
//	}

	@Override
	public boolean isCellEditable(int row, int column) {

		switch (column) {
		case TICKET_CARTAO:
			return false;
		case CARRO:
			return false;
		case PLACA:
			return false;
		case CLIENTE:
			return false;
		case ENTRADA:
			return false;
		case REMOVER:
			return true;

		default:
			throw new IndexOutOfBoundsException(
					"ERRO: ClienteDefaultTableModel.class" + "\n>> Method line 67 \nReview Code3.");
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {

		switch (columnIndex) {

		case TICKET_CARTAO:
			return String.class;
		case CARRO:
			return String.class;
		case PLACA:
			return String.class;
		case CLIENTE:
			return ClienteVO.class;
		case ENTRADA:
			return LocalTime.class;
		case REMOVER:
			return Boolean.class;

		default:
			throw new IndexOutOfBoundsException(
					"ERRO: ClienteDefaultTableModel.class" + "\n>> Method line 67 \nReview Code.");
		}
	}

//	@Override
//	public void insertRow(int row, Object[] rowData) {
//		// TODO Auto-generated method stub
//		super.insertRow(row, rowData);
//	}
//
//	@Override
//	public void insertRow(int row, Vector rowData) {
//		// TODO Auto-generated method stub
//		super.insertRow(row, rowData);
//	}
//
//	@Override
//	public void removeRow(int row) {
//		// TODO Auto-generated method stub
//		super.removeRow(row);
//	}
//
//	@Override
//	public void setColumnIdentifiers(Object[] newIdentifiers) {
//		// TODO Auto-generated method stub
//		super.setColumnIdentifiers(newIdentifiers);
//	}
//
//	@Override
//	public void setColumnIdentifiers(Vector columnIdentifiers) {
//		// TODO Auto-generated method stub
//		super.setColumnIdentifiers(columnIdentifiers);
//	}

	@Override
	public Object getValueAt(int row, int column) {
		MoveVO moveVO = linhas.get(row);
		switch (column) {
		case TICKET_CARTAO:
			return moveVO.getTicket_cartao();
		case CARRO:
			return moveVO.getCliente().getCarro().getDescricao();
		case PLACA:
			return moveVO.getCliente().getCarro().getPlaca();
		case CLIENTE:
			return moveVO.getCliente().getNome();
		case ENTRADA:
			return moveVO.getEntrada();
		case REMOVER:
			return moveVO.isCbx();
		default:
			throw new IndexOutOfBoundsException("ERRO: InicioDefaultTableModel.class\n"
					+ ">> Method line 145 \nReview Code.");
		}
	}
}
