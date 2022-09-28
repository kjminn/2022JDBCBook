package book.controller;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JFrame;

import book.dao.BookDAO;
import book.dao.JDBCConnector;
import book.view.BookSearchView;
import book.vo.BookVO;

public class BookController extends JFrame {
	
	public BookController() {
		Connection con = JDBCConnector.getCon();
		BookDAO bookDAO = new BookDAO();
		ArrayList<BookVO> bookVOList = bookDAO.select(con);
		add("Center",new BookSearchView(bookVOList));
		
		setTitle("도서 검색 시스템");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(1000, 200, 800, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BookController();

	}

}
