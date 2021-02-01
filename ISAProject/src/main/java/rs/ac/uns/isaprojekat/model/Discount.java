package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid ca45e718-4f20-4e5d-ac7f-1b3fa0e2d53f */
public class Discount {
   /** @pdOid 8aad686d-dad5-4008-8cb4-0e87fd2bf3a5 */
   private int percent;
   /** @pdOid 33fc2516-7ed9-42db-8db0-849d8db4d62a */
   private Long discountId;
   
   /** @pdRoleInfo migr=no name=LoyaltyCategory assc=association34 mult=0..1 */
   public LoyaltyCategory loyaltyCategory;

}