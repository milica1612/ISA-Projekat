package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid c4bbec17-2d1e-47e3-a4a1-f26ee1cb8557 */
public class AnswerPharmacy {
   /** @pdOid 34f8c29c-ec2b-4369-8863-9752a32011cf */
   private String textPh;
   /** @pdOid 736f346e-2810-4e7d-825f-4601c3c49a93 */
   private Long answPhId;
   
   /** @pdRoleInfo migr=no name=ComplaintPharmacy assc=association68 mult=0..1 */
   public ComplaintPharmacy complaintPharmacy;
   /** @pdRoleInfo migr=no name=SystemAdministrator assc=association69 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<SystemAdministrator> systemAdministrator;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<SystemAdministrator> getSystemAdministrator() {
      if (systemAdministrator == null)
         systemAdministrator = new java.util.HashSet<SystemAdministrator>();
      return systemAdministrator;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSystemAdministrator() {
      if (systemAdministrator == null)
         systemAdministrator = new java.util.HashSet<SystemAdministrator>();
      return systemAdministrator.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSystemAdministrator */
   public void setSystemAdministrator(java.util.Collection<SystemAdministrator> newSystemAdministrator) {
      removeAllSystemAdministrator();
      for (java.util.Iterator iter = newSystemAdministrator.iterator(); iter.hasNext();)
         addSystemAdministrator((SystemAdministrator)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSystemAdministrator */
   public void addSystemAdministrator(SystemAdministrator newSystemAdministrator) {
      if (newSystemAdministrator == null)
         return;
      if (this.systemAdministrator == null)
         this.systemAdministrator = new java.util.HashSet<SystemAdministrator>();
      if (!this.systemAdministrator.contains(newSystemAdministrator))
         this.systemAdministrator.add(newSystemAdministrator);
   }
   
   /** @pdGenerated default remove
     * @param oldSystemAdministrator */
   public void removeSystemAdministrator(SystemAdministrator oldSystemAdministrator) {
      if (oldSystemAdministrator == null)
         return;
      if (this.systemAdministrator != null)
         if (this.systemAdministrator.contains(oldSystemAdministrator))
            this.systemAdministrator.remove(oldSystemAdministrator);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSystemAdministrator() {
      if (systemAdministrator != null)
         systemAdministrator.clear();
   }

}