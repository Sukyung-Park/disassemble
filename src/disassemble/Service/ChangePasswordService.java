package disassemble.Service;

import disassemble.DAO.MemberDAO;
import disassemble.DTO.MemberDTO;

public class ChangePasswordService {
	private MemberDAO memberDao;
	
	public ChangePasswordService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	public void changePassword(String email, String oldPw, String newPw) {
		// 이메일 등록여부 확인.
		MemberDTO member = memberDao.selectEmail(email);
		if(member != null) {
		// 패스워드 확인 및 MemberDAO.update() 호출 
			if(member.getPassword().equals(oldPw)) {
				member.setPassword(newPw);
				memberDao.update(member);
				System.out.println(email + "의 비밀번호를 변경했습니다.");
			}else {
				System.out.println("등록되어 있는 비밀번호와 일치하지 않습니다.");
			}
		}else {
			System.out.println(email + "의 이메일은 미 등록된 정보입니다.");
		}
	}

}
