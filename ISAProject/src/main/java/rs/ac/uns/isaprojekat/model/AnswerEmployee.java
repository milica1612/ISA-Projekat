package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid b1f8756d-8ddc-4701-8bd8-e85e402aecf7 */
public class AnswerEmployee {
   /** @pdOid d5069970-09e6-4819-ad9c-e7a49dde7a55 */
   private String textEmp;
   /** @pdOid ec74f63f-bca3-4223-b55e-4a7791503733 */
   private Long answEmpId;
   
   /** @pdRoleInfo migr=no name=SystemAdministrator assc=association20 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<SystemAdministrator> systemAdministrator;
   /** @pdRoleInfo migr=no name=ComplaintEmployee assc=association42 mult=0..1 */
   public ComplaintEmployee complaintEmployee;
   
   
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