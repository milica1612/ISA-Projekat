package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid 0e2e9f59-d8a7-4df8-83b6-aa3007136427 */
public final class Patient extends User {
   /** @pdOid 80669cf4-44ea-476d-b069-53abe9e02016 */
   private int penalty;
   
   /** @pdRoleInfo migr=no name=Allergy assc=association28 mult=1..1 */
   public Allergy allergy;

}