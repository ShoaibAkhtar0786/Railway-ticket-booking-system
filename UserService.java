import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Map<String,User> usermap= new HashMap<>();

    private User CurrentUser=null;

    public Boolean registration(String username,String password , String fullname , String contact){
        if(usermap.containsKey(username)){
            System.out.println("user name is already taken please choose another");
            return false;
        }
        User user= new User(username,password,fullname,contact);
        usermap.put(username,user);
        System.out.println("Registration Successful");
        return true;
    }

    public boolean loginuser(String username, String password){
        if(!usermap.containsKey(username)){
            System.out.println("No user Found with this username");
            return false;
        }
        User user=usermap.get(username);
        if(!user.getPassword().equals(password)){
            System.out.println("Password is incorrect");
            return false;
        }

        CurrentUser= user;
        System.out.println("Welcome:"+CurrentUser.getFullName() + "!");
        return true;

    }
    public void Logout(){
        if(CurrentUser!=null){
            System.out.println("Logged out"+CurrentUser.getFullName());
        }
        CurrentUser=null;
    }

    public User getCurrentUser(){
        return CurrentUser;
    }

    public Boolean isLoggedIn(){
        return CurrentUser!=null;
    }

}
