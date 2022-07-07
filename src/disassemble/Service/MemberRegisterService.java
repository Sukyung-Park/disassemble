package disassemble.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import disassemble.DAO.MemberDAO;
import disassemble.DTO.MemberDTO;
import disassemble.DTO.RegisterRequest;

public class MemberRegisterService {
	private MemberDAO memberDao;
	
	public MemberRegisterService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	public void regist(RegisterRequest req) {
		// password == confirmPassword
		if(req.getPassword().equals(req.getConfirmPassword()) ) {
		// email로 계정 등록 여부 확인
		MemberDTO member = memberDao.selectEmail(req.getEmail());
		if(member == null) {
			member = new MemberDTO();
			member.setEmail(req.getEmail());
			member.setName(req.getName());
			member.setPassword(req.getPassword());
			
			Date date = new Date();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String registerDate = sdf.format(date);
			member.setRegisterDate(registerDate);
			
			// memberDao.insert() 계정 등록
			memberDao.insert(member);
			System.out.println(req.getEmail() + "의 정보를 등록했습니다.");
		}else {
			System.out.println(req.getEmail() + "의 이메일은 등록된 이메일입니다.");
		}
	}else {
		System.out.println("입력한 두 암호가 다른 암호입니다.");
	}
}

}
