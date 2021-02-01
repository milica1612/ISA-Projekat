package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class PriceTag {
   private Double price;
   
   public java.util.Collection<TimeInterval> timeInterval;
   
   public PriceTag(Double price, Collection<TimeInterval> timeInterval) {
	super();
	this.price = price;
	this.timeInterval = timeInterval;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

public java.util.Collection<TimeInterval> getTimeInterval() {
      if (timeInterval == null)
         timeInterval = new java.util.HashSet<TimeInterval>();
      return timeInterval;
   }
   
   public java.util.Iterator getIteratorTimeInterval() {
      if (timeInterval == null)
         timeInterval = new java.util.HashSet<TimeInterval>();
      return timeInterval.iterator();
   }
   
   public void setTimeInterval(java.util.Collection<TimeInterval> newTimeInterval) {
      removeAllTimeInterval();
      for (java.util.Iterator iter = newTimeInterval.iterator(); iter.hasNext();)
         addTimeInterval((TimeInterval)iter.next());
   }
   
   public void addTimeInterval(TimeInterval newTimeInterval) {
      if (newTimeInterval == null)
         return;
      if (this.timeInterval == null)
         this.timeInterval = new java.util.HashSet<TimeInterval>();
      if (!this.timeInterval.contains(newTimeInterval))
         this.timeInterval.add(newTimeInterval);
   }
   
   public void removeTimeInterval(TimeInterval oldTimeInterval) {
      if (oldTimeInterval == null)
         return;
      if (this.timeInterval != null)
         if (this.timeInterval.contains(oldTimeInterval))
            this.timeInterval.remove(oldTimeInterval);
   }
   
   public void removeAllTimeInterval() {
      if (timeInterval != null)
         timeInterval.clear();
   }

}