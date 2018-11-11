
public class HelloWorld {
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String execute() {
		if (getName().equals("Tom") && getPassword().equals("123")) {
			return "success";
		} else {
			return "error";
		}
	}
}
