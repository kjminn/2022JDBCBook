package book.view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import book.vo.BookVO;


public class BookSearchView extends JPanel {
	JTable table;
	DefaultTableModel model;
	ArrayList<BookVO> aList;
	String[] header = {"도서번호","도서명", "출판사", "저자명", "도서가격", "카테고리"};
	JLabel lblSearch = new JLabel("검색어: ");
	JTextField textSearch = new JTextField(20);
	JButton btnSearch = new JButton("검색");
	ArrayList<BookVO> bookVOList;
	String searchWord = "";
	
	public BookSearchView() {
	
	}
	
	public void initView() {
		setLayout(new BorderLayout(10,10));
		JPanel panN = new JPanel();
		panN.add(lblSearch);
		panN.add(textSearch);
		panN.add(btnSearch);
		
		model = new DefaultTableModel(header, bookVOList.size()) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		putSearchResult();
		
		add("North", panN);
		add("Center", scroll);
	}
	
	public void setBookVOList(ArrayList<BookVO> bookVOList) {
		this.bookVOList = bookVOList;
	}
	
	public String getSearchWord() {
		return textSearch.getText();
	}

	public void putSearchResult() {
		BookVO bookVO = null;
		for (int i = 0; i < bookVOList.size(); i++) {
			bookVO = bookVOList.get(i);
			System.out.println(bookVO.toString());
			model.setValueAt(bookVO.getIsbn(), i, 0);
			model.setValueAt(bookVO.getName(), i, 1);
			model.setValueAt(bookVO.getPublish(), i, 2);
			model.setValueAt(bookVO.getAuthor(), i, 3);
			model.setValueAt(bookVO.getPrice(), i, 4);
			model.setValueAt(bookVO.getCategory(), i, 5);
		}
		
	}



}
