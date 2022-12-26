package projet;
import java.util.*;

class Compte {
    String login;
    int password;
    public Compte(String login, int password){
        this.login = login;
        this.password = password;
    }
    public String getLogin() {
        return login;
    }
    public int getPassword() {
        return password;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString(){
      return "Username: "+this.login+" Password: "+this.password;
    }

  //  @Override
	// public String toString() {
	// 	return "Compte [login=" + login + ", password=" + password + "]";
	// }

}