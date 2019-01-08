package service;

import javax.ejb.Remote;

@Remote
public interface OnlineCountService {

    public int getUserNumber();

    public int getVisitorNumber();
}
