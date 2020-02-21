package util.table;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

import com.sun.jmx.snmp.Timestamp;

import model.vo.MoveVO;

public class InicioAbstractTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 3751386493128161933L;
	
	private static final int TICKET_CARTAO = 0;
	private static final int CARRO = 1;
	private static final int PLACA = 2;
	private static final int CLIENTE = 3;
	private static final int ENTRADA = 4;
	private static final int REMOVER = 5;
	private static final int IMPRIMIR = 6;
	
	
	private ArrayList<MoveVO> linhas = new ArrayList<MoveVO>();
	private String[] colunas = new String[] { "Ticket / Cartão", "Carro", "Placa", "Cliente", "Entrada", "Remover", "Imprimir",};;
	
//	public void setColunas(String[] colunas) {
//		this.colunas = colunas;
//	}
	
	public InicioAbstractTableModel() {
		linhas = new ArrayList<MoveVO>();
	}
	
    @Override
    public int getRowCount() {
        return linhas.size();
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
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	@Override
	public Class<?> getColumnClass(int column) {
		 switch (column) {
         case TICKET_CARTAO:
             return String.class;
         case CARRO:
             return String.class;
         case PLACA:
             return String.class;
         case CLIENTE:
             return String.class;
         case ENTRADA:
             return Timestamp.class;
         case REMOVER:
             return Icon.class;
         case IMPRIMIR:
             return Icon.class;
         default:
             throw new IndexOutOfBoundsException("ERRO: AbstractModel.class >> Method line 60\nRevisar Código.");
     }
	}
	
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
//            case REMOVER:
//                return Icone;
//            case IMPRIMIR:
//                return Icone;
            default:
                throw new IndexOutOfBoundsException("ERRO: AbstractModel.class >> Method line 82\nRevisar Código.");
        }
    }
	
	
//	public void addCliente (ClienteVO clientes) {
//		this.linhas.add(clientes);
//		fireTableDataChanged();
//	}
//	
//	public void remover (int row) {
//		this.linhas.remove(row);
//	}
//	
//	public ClienteVO getCliente(int row) {
//		return this.linhas.get(row);
//	}
//	
//	
//	@Override
//	public void addTableModelListener(TableModelListener l) {
//		// TODO Auto-generated method stub
//		super.addTableModelListener(l);
//	}
//
//	@Override
//	public int findColumn(String columnName) {
//		// TODO Auto-generated method stub
//		return super.findColumn(columnName);
//	}
//
//	@Override
//	public void fireTableCellUpdated(int row, int column) {
//		// TODO Auto-generated method stub
//		super.fireTableCellUpdated(row, column);
//	}
//
//	@Override
//	public void fireTableChanged(TableModelEvent e) {
//		// TODO Auto-generated method stub
//		super.fireTableChanged(e);
//	}
//
//	@Override
//	public void fireTableDataChanged() {
//		// TODO Auto-generated method stub
//		super.fireTableDataChanged();
//	}
//
//	@Override
//	public void fireTableRowsDeleted(int firstRow, int lastRow) {
//		// TODO Auto-generated method stub
//		super.fireTableRowsDeleted(firstRow, lastRow);
//	}
//
//	@Override
//	public void fireTableRowsInserted(int firstRow, int lastRow) {
//		// TODO Auto-generated method stub
//		super.fireTableRowsInserted(firstRow, lastRow);
//	}
//
//	@Override
//	public void fireTableRowsUpdated(int firstRow, int lastRow) {
//		// TODO Auto-generated method stub
//		super.fireTableRowsUpdated(firstRow, lastRow);
//	}
//
//	@Override
//	public void fireTableStructureChanged() {
//		// TODO Auto-generated method stub
//		super.fireTableStructureChanged();
//	}
//
//	@Override
//	public <T extends EventListener> T[] getListeners(Class<T> listenerType) {
//		// TODO Auto-generated method stub
//		return super.getListeners(listenerType);
//	}
//
//	@Override
//	public TableModelListener[] getTableModelListeners() {
//		// TODO Auto-generated method stub
//		return super.getTableModelListeners();
//	}
//
//	@Override
//	public void removeTableModelListener(TableModelListener l) {
//		// TODO Auto-generated method stub
//		super.removeTableModelListener(l);
//	}
//
//	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//		// TODO Auto-generated method stub
//		super.setValueAt(aValue, rowIndex, columnIndex);
//	}
	
}