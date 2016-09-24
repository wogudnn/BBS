package com.psy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.psy.vo.BulletinBoardSystemVO;

public class BulletinBoardSystemDaoImpl implements BulletinBoardSystemDao {

	@Override
	public void addPosting(BulletinBoardSystemVO boardSystemVO) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","BBS","BBS");
			StringBuffer query = new StringBuffer();
			query.append(" INSERT	INTO	BBS ( ");
			query.append(" 						 ID ");
			query.append(" 						, TITLE ");
			query.append(" 						, CONT ");
			query.append(" 						, HIT_CNT ");
			query.append(" 						, RCND_CNT ");
			query.append(" 						, CRTR_NM ");
			query.append(" 						, CRT_DT ) ");
			query.append(" VALUES 				( ");
			query.append(" 						ID_SEQ.NEXTVAL ");
			query.append(" 						, ? , ? , 0 , 0 , ? , SYSDATE ) ");
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, boardSystemVO.getTitle());
			pstmt.setString(2, boardSystemVO.getContents());
			pstmt.setString(3, boardSystemVO.getCreatorName());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally{
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public List<BulletinBoardSystemVO> getPostingOf() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBS", "BBS");
			StringBuffer query = new StringBuffer();
			
			query.append(" SELECT	ID ");
			query.append(" 			, TITLE ");
			query.append(" 			, CONT ");
			query.append(" 			, HIT_CNT ");
			query.append(" 			, RCND_CNT ");
			query.append(" 			, CRTR_NM ");
			query.append(" 			, TO_CHAR(CRT_DT, 'YYYY-MM-DD HH24:MI:SS') CRT_DT ");
			query.append(" FROM		BBS ");
			query.append(" ORDER	BY ID DESC ");
			
			pstmt = conn.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
					
			List<BulletinBoardSystemVO> boardSystems = new ArrayList<BulletinBoardSystemVO>();
			BulletinBoardSystemVO boardSystemVO = null;
			
			while(rs.next()) {
				boardSystemVO = new BulletinBoardSystemVO();
				boardSystemVO.setId(rs.getInt("ID"));
				boardSystemVO.setTitle(rs.getString("TITLE"));
				boardSystemVO.setContents(rs.getString("CONT"));
				boardSystemVO.setHitCount(rs.getInt("HIT_CNT"));
				boardSystemVO.setRecommendConunt(rs.getInt("RCND_CNT"));
				boardSystemVO.setCreatorName(rs.getString("CRTR_NM"));
				boardSystemVO.setCreateDate(rs.getString("CRT_DT"));
				
				boardSystems.add(boardSystemVO);
			}
			return boardSystems;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally{
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if(pstmt != null ){
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
		
	}

	@Override
	public BulletinBoardSystemVO getPostingAt(int Id) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBS", "BBS");
			StringBuffer query = new StringBuffer();
			query.append(" SELECT	ID ");
			query.append(" 			, TITLE ");
			query.append(" 			, CONT ");
			query.append(" 			, HIT_CNT ");
			query.append(" 			, RCND_CNT ");
			query.append(" 			, CRTR_NM ");
			query.append(" 			, TO_CHAR(CRT_DT, 'YYYY-MM-DD HH24:MI:SS') CRT_DT ");
			query.append(" FROM		BBS ");
			query.append(" WHERE	ID = ? ");
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, Id);
			rs = pstmt.executeQuery();
					
			BulletinBoardSystemVO boardSystemVO = null;
			if(rs.next()) {
				boardSystemVO = new BulletinBoardSystemVO();
				boardSystemVO.setId(rs.getInt("ID"));
				boardSystemVO.setTitle(rs.getString("TITLE"));
				boardSystemVO.setContents(rs.getString("CONT"));
				boardSystemVO.setHitCount(rs.getInt("HIT_CNT"));
				boardSystemVO.setRecommendConunt(rs.getInt("RCND_CNT"));
				boardSystemVO.setCreatorName(rs.getString("CRTR_NM"));
				boardSystemVO.setCreateDate(rs.getString("CRT_DT"));
				
			}
			return boardSystemVO;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally{
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if(pstmt != null ){
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}

	@Override
	public void updateRecommendCount(int Id) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","BBS","BBS");
			StringBuffer query = new StringBuffer();
			query.append(" UPDATE	BBS ");
			query.append(" SET	RCND_CNT = RCND_CNT+1 ");
			query.append(" WHERE	ID = ? ");
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, Id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally{
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public void deletePosting(int Id) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","BBS","BBS");
			StringBuffer query = new StringBuffer();
			query.append(" DELETE ");
			query.append(" FROM		BBS ");
			query.append(" WHERE	ID = ? ");
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, Id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally{
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	@Override
	public void updateHitCount(int Id) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","BBS","BBS");
			StringBuffer query = new StringBuffer();
			query.append(" UPDATE	BBS ");
			query.append(" SET	HIT_CNT = HIT_CNT+1 ");
			query.append(" WHERE	ID = ? ");
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, Id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally{
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}
}
