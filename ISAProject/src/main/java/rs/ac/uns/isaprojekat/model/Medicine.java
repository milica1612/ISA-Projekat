package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Medicine {
   private Long medicineId;
   private String name;
   private String type;
   private String manufacturer;
   private String precautions;
   private int loyaltyPoints;
   
   public MedicineSpecification medicineSpecification;
   public java.util.Collection<Medicine> medicineB;
   public java.util.Collection<MedicineForm> medicineForm;
   public java.util.Collection<PrescriptionType> prescriptionType;
   
   public Medicine(Long medicineId, String name, String type, String manufacturer, String precautions, int loyaltyPoints,
		MedicineSpecification medicineSpecification, Collection<Medicine> medicineB,
		Collection<MedicineForm> medicineForm, Collection<PrescriptionType> prescriptionType) {
	super();
	this.medicineId = medicineId;
	this.name = name;
	this.type = type;
	this.manufacturer = manufacturer;
	this.precautions = precautions;
	this.loyaltyPoints = loyaltyPoints;
	this.medicineSpecification = medicineSpecification;
	this.medicineB = medicineB;
	this.medicineForm = medicineForm;
	this.prescriptionType = prescriptionType;
}

public Long getMedicineId() {
	return medicineId;
}

public void setMedicineId(Long medicineId) {
	this.medicineId = medicineId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getManufacturer() {
	return manufacturer;
}

public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
}

public String getPrecautions() {
	return precautions;
}

public void setPrecautions(String precautions) {
	this.precautions = precautions;
}

public int getLoyaltyPoints() {
	return loyaltyPoints;
}

public void setLoyaltyPoints(int loyaltyPoints) {
	this.loyaltyPoints = loyaltyPoints;
}

public MedicineSpecification getMedicineSpecification() {
	return medicineSpecification;
}

public void setMedicineSpecification(MedicineSpecification medicineSpecification) {
	this.medicineSpecification = medicineSpecification;
}

public java.util.Collection<Medicine> getMedicineB() {
      if (medicineB == null)
         medicineB = new java.util.HashSet<Medicine>();
      return medicineB;
   }
   
   public java.util.Iterator getIteratorMedicineB() {
      if (medicineB == null)
         medicineB = new java.util.HashSet<Medicine>();
      return medicineB.iterator();
   }
   
   public void setMedicineB(java.util.Collection<Medicine> newMedicineB) {
      removeAllMedicineB();
      for (java.util.Iterator iter = newMedicineB.iterator(); iter.hasNext();)
         addMedicineB((Medicine)iter.next());
   }
   
   public void addMedicineB(Medicine newMedicine) {
      if (newMedicine == null)
         return;
      if (this.medicineB == null)
         this.medicineB = new java.util.HashSet<Medicine>();
      if (!this.medicineB.contains(newMedicine))
         this.medicineB.add(newMedicine);
   }
   
   public void removeMedicineB(Medicine oldMedicine) {
      if (oldMedicine == null)
         return;
      if (this.medicineB != null)
         if (this.medicineB.contains(oldMedicine))
            this.medicineB.remove(oldMedicine);
   }
   
   public void removeAllMedicineB() {
      if (medicineB != null)
         medicineB.clear();
   }
   public java.util.Collection<MedicineForm> getMedicineForm() {
      if (medicineForm == null)
         medicineForm = new java.util.HashSet<MedicineForm>();
      return medicineForm;
   }
   
   public java.util.Iterator getIteratorMedicineForm() {
      if (medicineForm == null)
         medicineForm = new java.util.HashSet<MedicineForm>();
      return medicineForm.iterator();
   }
   
   public void setMedicineForm(java.util.Collection<MedicineForm> newMedicineForm) {
      removeAllMedicineForm();
      for (java.util.Iterator iter = newMedicineForm.iterator(); iter.hasNext();)
         addMedicineForm((MedicineForm)iter.next());
   }
   
   public void addMedicineForm(MedicineForm newMedicineForm) {
      if (newMedicineForm == null)
         return;
      if (this.medicineForm == null)
         this.medicineForm = new java.util.HashSet<MedicineForm>();
      if (!this.medicineForm.contains(newMedicineForm))
         this.medicineForm.add(newMedicineForm);
   }
   
   public void removeMedicineForm(MedicineForm oldMedicineForm) {
      if (oldMedicineForm == null)
         return;
      if (this.medicineForm != null)
         if (this.medicineForm.contains(oldMedicineForm))
            this.medicineForm.remove(oldMedicineForm);
   }
   
   public void removeAllMedicineForm() {
      if (medicineForm != null)
         medicineForm.clear();
   }

   public java.util.Collection<PrescriptionType> getPrescriptionType() {
      if (prescriptionType == null)
         prescriptionType = new java.util.HashSet<PrescriptionType>();
      return prescriptionType;
   }
   
   public java.util.Iterator getIteratorPrescriptionType() {
      if (prescriptionType == null)
         prescriptionType = new java.util.HashSet<PrescriptionType>();
      return prescriptionType.iterator();
   }
   
   public void setPrescriptionType(java.util.Collection<PrescriptionType> newPrescriptionType) {
      removeAllPrescriptionType();
      for (java.util.Iterator iter = newPrescriptionType.iterator(); iter.hasNext();)
         addPrescriptionType((PrescriptionType)iter.next());
   }
   
   public void addPrescriptionType(PrescriptionType newPrescriptionType) {
      if (newPrescriptionType == null)
         return;
      if (this.prescriptionType == null)
         this.prescriptionType = new java.util.HashSet<PrescriptionType>();
      if (!this.prescriptionType.contains(newPrescriptionType))
         this.prescriptionType.add(newPrescriptionType);
   }
   
   public void removePrescriptionType(PrescriptionType oldPrescriptionType) {
      if (oldPrescriptionType == null)
         return;
      if (this.prescriptionType != null)
         if (this.prescriptionType.contains(oldPrescriptionType))
            this.prescriptionType.remove(oldPrescriptionType);
   }
   
   public void removeAllPrescriptionType() {
      if (prescriptionType != null)
         prescriptionType.clear();
   }
}