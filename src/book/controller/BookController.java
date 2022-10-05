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
		BookSearchView searchPan = new BookSearchView();
	
		BookDAO bookDAO = new BookDAO();
		//System.out.println("test:"+searchPan.getSearchWord());
		ArrayList<BookVO> bookVOList = bookDAO.select(con, searchPan.getSearchWord());
		searchPan.setBookVOList(bookVOList);
		searchPan.initView();
		add("Center",searchPan);
		
		setTitle("도서 검색 시스템");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(2500, 200, 800, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BookController();
	}

}
