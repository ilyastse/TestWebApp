import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

    @ManagedBean(name = "loginBean")
    @SessionScoped
    public class LoginBean {
        private String login ;
        private String password;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String checkUser(){
            if(this.login.equals("admin") && this.password.equals("admin")){
                return "success";
            }else{
                return "loginfailed";
            }
        }


    }
