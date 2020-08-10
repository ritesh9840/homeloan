package Loan.Loanview.beans;

import oracle.adf.share.ADFContext;
import oracle.adf.share.security.SecurityContext;

public class SQLAuthenticatorAdapterClient {
    private SQLAuthenticatorAdapter adapter = new SQLAuthenticatorAdapter();
    public static void main(String[] args) {
    SQLAuthenticatorAdapterClient client = new SQLAuthenticatorAdapterClient();
  
       try {
            client.connect();
            client.testCreateUser();
            client.testCreateGroup();
            client.testAddMemberTopGroup();
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: Add catch code
            client.close();
            e.printStackTrace();
        }
    }
    
    
    String getUsername() {
        ADFContext adfCtx = ADFContext.getCurrent();  
             SecurityContext secCntx = adfCtx.getSecurityContext();  
             String user = secCntx.getUserPrincipal().getName();  
             String _user = secCntx.getUserName();  
        return _user;
    }
    
   
    
    
    public void testCreateUser()throws Exception{
        String username = "ritesh";
        String password = "ritesh@123";
        String displayName = "Ritesh Singh";
        adapter.createUser(username, password, displayName);
    }
    
    public void testCreateGroup()throws Exception{
        String groupName = "AdminGroup";
        String description = "This is a especial group created through SQLAuthenticatorAdapter";
        adapter.createGroup(groupName, description);
        
    }
    
    public void testAddMemberTopGroup()throws Exception{
        String username = "ritesh";
        String groupName = "SOADevGroup1";
        adapter.addMemberToGroup(groupName, username);
        
    }
    
    
    public void changePassword(String username, String oldPassword,String newPassword) throws Exception {
        adapter.changeUserPassword(username, oldPassword, newPassword);
    }
    
    public void close(){
        adapter.close();
    }
    public void connect(){
        adapter.connect();
    }
}