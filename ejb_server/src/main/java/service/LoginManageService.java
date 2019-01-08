package service;

import javax.ejb.Remote;

@Remote
public interface LoginManageService {

    public int Login_in(String user, String pw);

    public void exit(String user);

    public boolean deductFare(String account, double fare);


}
