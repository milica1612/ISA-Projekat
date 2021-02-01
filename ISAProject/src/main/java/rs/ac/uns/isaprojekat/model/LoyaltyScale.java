package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid d7e68f0a-9cc6-41ac-9889-b9c91054c1f4 */
public class LoyaltyScale {
   /** @pdOid cabe3170-897c-49ee-a93c-55d03b5c7a6e */
   private Long scaleId;
   /** @pdOid 6e22dc61-f7a0-4ad2-a2d2-06ad4ae1cdd8 */
   private int from;
   /** @pdOid 5506ae38-b03e-418c-b377-f6260ad95925 */
   private int to;
   
   /** @pdRoleInfo migr=no name=LoyaltyCategory assc=association32 mult=0..1 */
   public LoyaltyCategory loyaltyCategory;

}