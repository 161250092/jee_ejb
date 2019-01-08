package service.bean;

import Factory.DaoFactory;
import dao.LoginDao;
import model.UserList;
import service.LoginManageService;

import javax.ejb.Stateless;

@Stateless

public class LoginManageServiceBean implements LoginManageService{
    LoginDao loginDao = DaoFactory.getLoginDao();

    public int Login_in(String user, String pw) {


        return loginDao.Login_in(user,pw);

    }

    @Override
    public void exit(String user) {
         UserList.removeUser(user);
    }

    public boolean deductFare(String account, double fare) {
        return loginDao.deductFare(account,fare);
    }

}
