package Util;

public class JNDI {

    private  static final String loginServiceJNDI = "ejb:/ejb_server_ejb exploded/LoginManageServiceBean!service.LoginManageService";

    private  static final String productServiceJNDI="ejb:/ejb_server_ejb exploded/ProductManageServiceBean!service.ProductManageService";

    private static final String orderServiceJNDI ="ejb:/ejb_server_ejb exploded/OrderManageServiceBean!service.OrderManageService";

    private static final String onlineCountService="ejb:/ejb_server_ejb exploded/OnlineCountServiceBean!service.OnlineCountService";




    public static String getLoginServiceJNDI() {
        return loginServiceJNDI;
    }

    public static String getProductServiceJNDI() {
        return productServiceJNDI;
    }

    public static String getOrderServiceJNDI() {
        return orderServiceJNDI;
    }

    public static String getOnlineCountService() {
        return onlineCountService;
    }
}
