package book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.vo.BookVO;

public class BookDAO {
	Connection con;
	ArrayList<BookVO> bookVOList = new ArrayList<BookVO>();
	
	
	public ArrayList<BookVO> select(Connection con) {
		con = JDBCConnector.getCon();
		
		try {
			String sql = "select * from book";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				BookVO bookVO = new BookVO();
				bookVO.setIsbn(rs.getInt("isbn"));
				bookVO.setName(rs.getString("name"));
				bookVO.setPublish(rs.getString("publish"));
				bookVO.setAuthor(rs.getString("author"));
				bookVO.setPrice(rs.getInt("price"));
				bookVO.setCategory(rs.getInt("category"));
				bookVOList.add(bookVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookVOList;
	}
	

}
