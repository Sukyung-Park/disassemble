package disassemble.DAO;

import java.util.Collection;

import disassemble.DTO.MemberDTO;

public interface IMemberDAO {
	public Collection<MemberDTO> selectAll() ;
	public MemberDTO selectEmail(String email);
	public void insert(MemberDTO member);
	public int update(MemberDTO member);
	public int delete(String email);
}
