import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class SignupForm {

	private String custid;
    private String username;
    private String orgname;
    private String password;



   /* public Signup(){}

    public Signup(String custid,String username,String orgname,String password){
		this.custid = custid;
		this.username = username;
		this.orgname = orgname;
		this.password = password;
    }*/


	public String getCustid() {
    return custid;
	}

	public void setCustid(String custid) {
    this.custid = custid;

	}
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
