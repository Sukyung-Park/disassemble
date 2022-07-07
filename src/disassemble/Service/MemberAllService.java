package disassemble.Service;

import java.util.Collection;

import disassemble.DAO.MemberDAO;
import disassemble.DTO.MemberDTO;

public class MemberAllService {
	private MemberDAO memberDao;
	
	public MemberAllService(MemberDAO memberDao){
		this.memberDao = memberDao;
	}
	
	public void selectAll() {
		// MemberDAO 객체 내부 selectAll() 호출 후 회원 모든 정보 출력
		Collection<MemberDTO> members = memberDao.selectAll();
		if(members.isEmpty() == false) {
			System.out.println("이메일\t\t이름\t암호\t가입일");
			for(MemberDTO m : members) {
				System.out.printf("%s\t\t%s\t%s\t%s\n", m.getEmail(), m.getName(), m.getPassword(), m.getRegisterDate());
			}
		}else {
			System.out.println("등록된 회원이 없습니다.");
		}
	}

}
