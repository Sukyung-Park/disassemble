package disassemble.Service;

import disassemble.DAO.MemberDAO;
import disassemble.DTO.MemberDTO;

public class MemberDeleteService {
	
	private MemberDAO memberDao;
	
	public MemberDeleteService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	
	public void checkPassword(String email, String password, String confirmPassword) {
		// 패스워드 확인
		if(password.equals(confirmPassword)) {
		// MemberDAO 객체 내 selectEmail() 메소드를 호출 
		MemberDTO member = memberDao.selectEmail(email);
		if(member != null) {
		// 저장된 회원 정보와 입력된 회원 정보 검증
			if(member.getPassword().equals(password)) {
		// MemberDAO 객체 내 delete() 호출
			memberDao.delete(email);
			System.out.println(email + "의 정보를 삭제했습니다.");
			}else {
				System.out.println("등록되어 있는 비밀번호와 일치하지 않습니다.");
			}
		}else {
			System.out.println(email + "의 이메일은 미 등록된 정보입니다.");
		}
		}else {
			System.out.println("입력한 두 암호가 다른 암호입니다.");
		}
	}
}
