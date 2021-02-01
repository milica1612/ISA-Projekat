package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid b21a3aa7-a857-47eb-888f-db06be0b248a */
public class PriceTag {
   /** @pdOid 07fc5ec7-90f6-476f-9f8b-8e4c18d7c3e7 */
   private Double price;
   
   /** @pdRoleInfo migr=no name=TimeInterval assc=association46 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TimeInterval> timeInterval;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<TimeInterval> getTimeInterval() {
      if (timeInterval == null)
         timeInterval = new java.util.HashSet<TimeInterval>();
      return timeInterval;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTimeInterval() {
      if (timeInterval == null)
         timeInterval = new java.util.HashSet<TimeInterval>();
      return timeInterval.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTimeInterval */
   public void setTimeInterval(java.util.Collection<TimeInterval> newTimeInterval) {
      removeAllTimeInterval();
      for (java.util.Iterator iter = newTimeInterval.iterator(); iter.hasNext();)
         addTimeInterval((TimeInterval)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTimeInterval */
   public void addTimeInterval(TimeInterval newTimeInterval) {
      if (newTimeInterval == null)
         return;
      if (this.timeInterval == null)
         this.timeInterval = new java.util.HashSet<TimeInterval>();
      if (!this.timeInterval.contains(newTimeInterval))
         this.timeInterval.add(newTimeInterval);
   }
   
   /** @pdGenerated default remove
     * @param oldTimeInterval */
   public void removeTimeInterval(TimeInterval oldTimeInterval) {
      if (oldTimeInterval == null)
         return;
      if (this.timeInterval != null)
         if (this.timeInterval.contains(oldTimeInterval))
            this.timeInterval.remove(oldTimeInterval);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTimeInterval() {
      if (timeInterval != null)
         timeInterval.clear();
   }

}