package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid 68a96368-2d67-47a4-a074-5ae30d107676 */
public class Medicine {
   /** @pdOid f0e7117b-7089-4944-bdb3-11af02b96136 */
   private Long medicineId;
   /** @pdOid 0c5998ba-05b2-463d-bd57-adbce6e0575d */
   private String name;
   /** @pdOid ee54ce74-f206-46dc-b9de-a89a5b417f12 */
   private String type;
   /** @pdOid 145c4a48-dc6b-4547-a8e0-2aa2e3bde1fb */
   private String manufacturer;
   /** @pdOid f4a6fc16-bebd-47dc-a310-1d73727a85ef */
   private String precautions;
   /** @pdOid 8214c2ad-1b1d-4c6c-a361-a712ef0a541b */
   private int loyaltyPoints;
   
   /** @pdRoleInfo migr=no name=MedicineSpecification assc=association38 mult=0..1 type=Composition */
   public MedicineSpecification medicineSpecification;
   /** @pdRoleInfo migr=no name=Medicine assc=association41 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Medicine> medicineB;
   /** @pdRoleInfo migr=no name=MedicineForm assc=association44 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<MedicineForm> medicineForm;
   /** @pdRoleInfo migr=no name=PrescriptionType assc=association45 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<PrescriptionType> prescriptionType;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Medicine> getMedicineB() {
      if (medicineB == null)
         medicineB = new java.util.HashSet<Medicine>();
      return medicineB;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorMedicineB() {
      if (medicineB == null)
         medicineB = new java.util.HashSet<Medicine>();
      return medicineB.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newMedicineB */
   public void setMedicineB(java.util.Collection<Medicine> newMedicineB) {
      removeAllMedicineB();
      for (java.util.Iterator iter = newMedicineB.iterator(); iter.hasNext();)
         addMedicineB((Medicine)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMedicine */
   public void addMedicineB(Medicine newMedicine) {
      if (newMedicine == null)
         return;
      if (this.medicineB == null)
         this.medicineB = new java.util.HashSet<Medicine>();
      if (!this.medicineB.contains(newMedicine))
         this.medicineB.add(newMedicine);
   }
   
   /** @pdGenerated default remove
     * @param oldMedicine */
   public void removeMedicineB(Medicine oldMedicine) {
      if (oldMedicine == null)
         return;
      if (this.medicineB != null)
         if (this.medicineB.contains(oldMedicine))
            this.medicineB.remove(oldMedicine);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllMedicineB() {
      if (medicineB != null)
         medicineB.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<MedicineForm> getMedicineForm() {
      if (medicineForm == null)
         medicineForm = new java.util.HashSet<MedicineForm>();
      return medicineForm;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorMedicineForm() {
      if (medicineForm == null)
         medicineForm = new java.util.HashSet<MedicineForm>();
      return medicineForm.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newMedicineForm */
   public void setMedicineForm(java.util.Collection<MedicineForm> newMedicineForm) {
      removeAllMedicineForm();
      for (java.util.Iterator iter = newMedicineForm.iterator(); iter.hasNext();)
         addMedicineForm((MedicineForm)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMedicineForm */
   public void addMedicineForm(MedicineForm newMedicineForm) {
      if (newMedicineForm == null)
         return;
      if (this.medicineForm == null)
         this.medicineForm = new java.util.HashSet<MedicineForm>();
      if (!this.medicineForm.contains(newMedicineForm))
         this.medicineForm.add(newMedicineForm);
   }
   
   /** @pdGenerated default remove
     * @param oldMedicineForm */
   public void removeMedicineForm(MedicineForm oldMedicineForm) {
      if (oldMedicineForm == null)
         return;
      if (this.medicineForm != null)
         if (this.medicineForm.contains(oldMedicineForm))
            this.medicineForm.remove(oldMedicineForm);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllMedicineForm() {
      if (medicineForm != null)
         medicineForm.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<PrescriptionType> getPrescriptionType() {
      if (prescriptionType == null)
         prescriptionType = new java.util.HashSet<PrescriptionType>();
      return prescriptionType;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPrescriptionType() {
      if (prescriptionType == null)
         prescriptionType = new java.util.HashSet<PrescriptionType>();
      return prescriptionType.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPrescriptionType */
   public void setPrescriptionType(java.util.Collection<PrescriptionType> newPrescriptionType) {
      removeAllPrescriptionType();
      for (java.util.Iterator iter = newPrescriptionType.iterator(); iter.hasNext();)
         addPrescriptionType((PrescriptionType)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPrescriptionType */
   public void addPrescriptionType(PrescriptionType newPrescriptionType) {
      if (newPrescriptionType == null)
         return;
      if (this.prescriptionType == null)
         this.prescriptionType = new java.util.HashSet<PrescriptionType>();
      if (!this.prescriptionType.contains(newPrescriptionType))
         this.prescriptionType.add(newPrescriptionType);
   }
   
   /** @pdGenerated default remove
     * @param oldPrescriptionType */
   public void removePrescriptionType(PrescriptionType oldPrescriptionType) {
      if (oldPrescriptionType == null)
         return;
      if (this.prescriptionType != null)
         if (this.prescriptionType.contains(oldPrescriptionType))
            this.prescriptionType.remove(oldPrescriptionType);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPrescriptionType() {
      if (prescriptionType != null)
         prescriptionType.clear();
   }

}