package rs.ac.uns.ftn.informatika.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.informatika.jpa.model.WorkSchedulePharmacist;

@Repository
public interface IWorkSchedulePharmacistRepository extends JpaRepository<WorkSchedulePharmacist, Long> {

}
