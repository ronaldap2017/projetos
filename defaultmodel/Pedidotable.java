package defaultmodel;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import modelo.Item;

public class Pedidotable extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Item> Items;
	public Pedidotable() {
		Items = new ArrayList<Item>();
	}
	public Pedidotable(List<Item> listaDeItem) {
		this();
		Items.addAll(listaDeItem);
		
	}
	public List<Item> getLinhas() {return Items;}  
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return Integer.class;
		case 1:
			return String.class;
		case 2:
			return Integer.class;
		case 3:
			return Float.class;
		case 4:
			return Float.class;
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}
	

    public String getColumnName(int coluna) {  
        switch (coluna) {  
        case 0:  
            return "Codigo";
        case 1:  
            return "Nome";
        case 2:  
            return "Quantidade";
       case 3:  
            return "Valor unitario";
        case 4:  
            return "Valor total";
        default:  
            return "";
        }  
    }  
	public int getRowCount() {
		return Items.size();
	}

	public Object getValueAt(int linha, int coluna) {
		Item Item = Items.get(linha);
		switch (coluna) {
		case 0:
			return Item.getProduto().getCod_produto();
		case 1:
			return Item.getProduto().getNome();
		case 2:
			return Item.getQtd();
		case 3:
			return Item.getValor_unit();
		case 4:
			return Item.getValor_total();
		default:
			return null;
		}
	}
	public List<Item> getItens(){
		return Items;
		
	}	
	
		public void setValueAt(Object valor, int linha, int coluna) {
			Item p = Items.get(linha);
			switch (coluna) {  
			 case 0:  
		            p.getProduto().setCod_produto(Integer.parseInt(valor.toString()));
		            break;  
			 case 1:  
		            p.getProduto().setNome(valor.toString());
		            break;  
			 case 2:  
		            p.setQtd(Integer.parseInt(valor.toString()));
		            break;  
			 case 3:  
		            p.setValor_unit(Float.valueOf(valor.toString()));
		            break;  
			 case 4:  
				 p.setValor_total(Float.valueOf(valor.toString()));
		            break;  
	        }  
	        fireTableDataChanged();  
	    }  
	
	public void adiciona(Item socio) {
		Items.add(socio);
		fireTableRowsInserted(Items.size() - 1, Items.size() - 1);  
	}
	public void removeSocio(int indiceLinha) {	
		Items.remove(indiceLinha);
		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}
	
	public void addListaDeSocios(List<Item> lista) {
		int i = Items.size();
		Items.addAll(lista);
		fireTableRowsInserted(i, i+ lista.size());
	}
    public void clear() {  
        Items.clear();  
        fireTableDataChanged();  
     }  
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	public Item getSocio(int indiceLinha) {
		return Items.get(indiceLinha);
	}
	public int getColumnCount() {
		return 5;
	}
    public void addRow( List<Item> it){  
        getLinhas().addAll(it);  
        // Informa a jtable de que houve linhas incluidas no modelo  
        // COmo adicionamos no final, pegamos o tamanho total do modelo  
        // menos 1 para obter a linha incluida.  
        int linha = getLinhas().size()-1;  
        fireTableRowsInserted(linha,linha);  
        return;  
    }  

}