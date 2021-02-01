package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid 39a6ff09-366a-4b5c-88fb-9f440a02145a */
public class Pharmacy {
   /** @pdOid e7d07fbd-6a4c-458a-bec0-9a1c557b71b6 */
   private Long pharmacyId;
   
   /** @pdOid 6a6f1c76-02ae-41c0-b684-4b54c07b35a0 */
   protected String name;
   /** @pdOid c3675539-17e2-49e9-b4ad-501dd54b7c14 */
   protected Double rating;
   
   /** @pdRoleInfo migr=no name=Pharmacist assc=association12 mult=1..1 */
   public Pharmacist pharmacist;
   /** @pdRoleInfo migr=no name=MedicineItem assc=association43 mult=1..1 */
   public MedicineItem medicineItem;
   /** @pdRoleInfo migr=no name=Dermatologist assc=association19 mult=0..* side=A */
   public Dermatologist[] dermatologist;

}