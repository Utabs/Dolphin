package ir.dolphin.base;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class ServiceContext implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    private short authenticationMethodId;
    private short channelId;
    private String ticketId;
    private long requestId;
    private String mac;
    private String method;
    private String ipAddressClient;
    private String ipAddressServer;
    private String macSeed;
    private boolean encryptionEnabled;
    private int userId;
    private int unitActivity;
    private short methodID;
    private String loginId;
    private int roleId;


    private short company;



    public static HTTPMethod HTTPMethod;

    public enum HTTPMethod {GET, POST, PUT, DELETE};

    public ServiceContext() {
    }

    public short getMethodID() {
        return methodID;
    }

    public void setMethodID(short methodID) {
        this.methodID = methodID;
    }

    public ServiceContext(short channelId, String ticketId, String mac, long requestId, short company) {
        this.channelId = channelId;
        this.mac = mac;
        this.requestId = requestId;
        this.ticketId = ticketId;
        this.company = company;
    }

    public void setChannelId(short channelId) {
        this.channelId = channelId;
    }

    public boolean isEncryptionEnabled() {
        return encryptionEnabled;
    }

    public void setEncryptionEnabled(boolean encryptionEnabled) {
        this.encryptionEnabled = encryptionEnabled;
    }

    public void setMacSeed(String macSeed) {
        this.macSeed = macSeed;
    }

    public String getMacSeed() {
        return macSeed;
    }

    public short getChannelId() {
        return channelId;
    }

    public String getMac() {
        return mac;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTicketId() {
        return ticketId;
    }

    public long getRequestId() {
        return requestId;
    }

    public String getIpAddressClient() {
        return ipAddressClient;
    }

    public String getIpAddressServer() {
        return ipAddressServer;
    }

    public void setIpAddressClient(String ipAddressClient) {
        this.ipAddressClient = ipAddressClient;
    }

    public void setIpAddressServer(String ipAddressServer) {
        this.ipAddressServer = ipAddressServer;
    }

    public int getUnitActivity() {
        return unitActivity;
    }

    public int getUserId() {
        return userId;
    }

    protected String getBaseParameters() {
        return "" + channelId + ticketId + requestId;
    }

    public void setUnitActivity(int unitActivity) {
        this.unitActivity = unitActivity;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginId() {
        return loginId;
    }

    public HTTPMethod getHTTPMethod() {
        return HTTPMethod;
    }

    public void setHTTPMethod(HTTPMethod HTTPMethod) {
        this.HTTPMethod = HTTPMethod;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    @Override
    public String toString() {
        return "CoreSecurityContext Model [" + "channelid=" + channelId + ", ticketid=" + ticketId + ", requestid=" + requestId + ", mac=" + mac + ", method=" + method + ", ipAddressClient=" + ipAddressClient + ", ipAddressServer=" + ipAddressServer + ", macSeed=" + macSeed + ", encryptionEnabled=" + encryptionEnabled + ", userId=" + userId + ", unitActivity=" + unitActivity + ", loginid=" + loginId + ']';
    }


    public short getAuthenticationMethodId() {
        return authenticationMethodId;
    }

    public void setAuthenticationMethodId(short authenticationMethodId) {
        this.authenticationMethodId = authenticationMethodId;
    }



    //From Accounting
    public short getCompany() {
        return company;
    }

    public void setCompany(short company) {
        this.company = company;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
