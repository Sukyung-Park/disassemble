package disassemble.DTO;

public class MemberDTO implements IMemberDTO {

		private String email;
		private String password;
		private String name;
		private String registerDate;
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getRegisterDate() {
			return registerDate;
		}
		public void setRegisterDate(String registerDate) {
			this.registerDate = registerDate;
		}
		
	}

