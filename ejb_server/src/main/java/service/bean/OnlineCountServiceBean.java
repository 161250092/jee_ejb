package service.bean;

import dao.LoginDao;
import model.UserList;
import service.OnlineCountService;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class OnlineCountServiceBean implements OnlineCountService {


    public int getUserNumber() {
        return UserList.getUserCount()
                ;
    }

    public int getVisitorNumber() {
        return UserList.getVisitor();

    }

}
