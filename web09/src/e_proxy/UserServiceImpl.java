package e_proxy;

public class UserServiceImpl implements UserService {

    @Override
    public int register(String user) {
        System.out.println(user + " register");
        return user.length();
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    public void login() {
        System.out.println("login");
    }

    @Override
    public void modify() {
        System.out.println("modify");
    }
}
