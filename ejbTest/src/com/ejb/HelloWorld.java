package com.ejb;

import javax.ejb.Remote;

/**
 * Created by gao on 16-3-27.
 */
@Remote
public interface HelloWorld {
    public String sayHello(String world);
}