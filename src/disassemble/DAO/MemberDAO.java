package disassemble.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import disassemble.DTO.MemberDTO;

public class MemberDAO implements IMemberDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public MemberDAO() {
		String ur1 = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "oracle";
		String pass = "oracle";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(ur1, user, pass);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
				
	@Override
	public Collection<MemberDTO> selectAll() {
		ArrayList<MemberDTO> members = new ArrayList<>();
		String sql = "SELECT * FROM concept04";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
				member.setRegisterDate(rs.getString("registerdate"));
				members.add(member);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return members;
	}

	@Override
	public MemberDTO selectEmail(String email) {
		String sql = "SELECT * FROM concept04 WHERE email =?";
		MemberDTO member = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if(rs.next()) {
				member = new MemberDTO();
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
				member.setRegisterDate(rs.getString("registerdate"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}

	@Override
	public void insert(MemberDTO member) {
		String sql = "INSERT INTO concept04 VALUES(concept04_seq.nextval, ?, ?, ?";
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1, member.getEmail());
		ps.setString(2, member.getName());
		ps.setString(3, member.getPassword());
		ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			if(ps != null)
				ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
	}
}
}
	@Override
	public int update(MemberDTO member) {
		String sql = "UPDATE concept04 SET password=? WHERE email = ?";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getPassword());
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
		return result;
	}

	@Override
	public int delete(String email) {
		String sql = "DELETE FROM concept04 WHERE email = ?";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			result = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	
}
