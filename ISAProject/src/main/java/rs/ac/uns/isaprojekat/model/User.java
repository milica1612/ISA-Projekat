package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid bb0171d3-4ef2-4f76-a602-938457765ab5 */
public class User extends PharmacyEmployee {
   /** @pdOid 2ed748dd-b5e3-43b1-865f-a4838d6f0ced */
   protected String firstName;
   /** @pdOid 452799bc-5706-4d6b-a728-7acb76497dfb */
   protected String lastName;
   /** @pdOid dda63aaa-4566-4bd2-9695-6cc89839e53c */
   protected String userName;
   /** @pdOid 5f2ace11-2a19-428c-b6b3-8d8bbda306fa */
   protected String password;
   /** @pdOid f525c180-d0c2-45ec-a137-efab76d17381 */
   protected String email;
   /** @pdOid 53ae5836-cf4d-4217-92d5-632ee0d03dee */
   protected String phoneNumber;
   /** @pdOid b55db711-bfba-4d26-9088-47918662c3bc */
   protected Long userId;
   
   /** @pdRoleInfo migr=no name=UserType assc=association29 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<UserType> userType;
   /** @pdRoleInfo migr=no name=Address assc=association30 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Address> address;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<UserType> getUserType() {
      if (userType == null)
         userType = new java.util.HashSet<UserType>();
      return userType;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorUserType() {
      if (userType == null)
         userType = new java.util.HashSet<UserType>();
      return userType.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newUserType */
   public void setUserType(java.util.Collection<UserType> newUserType) {
      removeAllUserType();
      for (java.util.Iterator iter = newUserType.iterator(); iter.hasNext();)
         addUserType((UserType)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newUserType */
   public void addUserType(UserType newUserType) {
      if (newUserType == null)
         return;
      if (this.userType == null)
         this.userType = new java.util.HashSet<UserType>();
      if (!this.userType.contains(newUserType))
         this.userType.add(newUserType);
   }
   
   /** @pdGenerated default remove
     * @param oldUserType */
   public void removeUserType(UserType oldUserType) {
      if (oldUserType == null)
         return;
      if (this.userType != null)
         if (this.userType.contains(oldUserType))
            this.userType.remove(oldUserType);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllUserType() {
      if (userType != null)
         userType.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Address> getAddress() {
      if (address == null)
         address = new java.util.HashSet<Address>();
      return address;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAddress() {
      if (address == null)
         address = new java.util.HashSet<Address>();
      return address.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAddress */
   public void setAddress(java.util.Collection<Address> newAddress) {
      removeAllAddress();
      for (java.util.Iterator iter = newAddress.iterator(); iter.hasNext();)
         addAddress((Address)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAddress */
   public void addAddress(Address newAddress) {
      if (newAddress == null)
         return;
      if (this.address == null)
         this.address = new java.util.HashSet<Address>();
      if (!this.address.contains(newAddress))
         this.address.add(newAddress);
   }
   
   /** @pdGenerated default remove
     * @param oldAddress */
   public void removeAddress(Address oldAddress) {
      if (oldAddress == null)
         return;
      if (this.address != null)
         if (this.address.contains(oldAddress))
            this.address.remove(oldAddress);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAddress() {
      if (address != null)
         address.clear();
   }

}