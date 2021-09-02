package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.DermatologistDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDermatologistDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IDermatologistService;
import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdministrator;
import rs.ac.uns.ftn.informatika.jpa.repository.IDermatologistRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IPharmacyRepository;

@Service
public class DermatologistService implements IDermatologistService {

	private IDermatologistRepository _dermatologistRepository;
	private IPharmacyRepository _pharmacyRepository;

	@Autowired
	public DermatologistService(IDermatologistRepository iDermatologistRepository,
			IPharmacyRepository iPharmacyRepository) {
		this._dermatologistRepository = iDermatologistRepository;
		this._pharmacyRepository = iPharmacyRepository;
	}

	@Override
	public List<DermatologistDTO> getAllDermatologist() {
		List<Dermatologist> dermatologists = _dermatologistRepository.findAll();
		List<DermatologistDTO> dermatologistDTOs = new ArrayList<DermatologistDTO>();

		for (Dermatologist d : dermatologists) {

			StringBuilder pharmacyNames = new StringBuilder();

			List<Long> pharmacyIds = _dermatologistRepository.findAllPharmacyIdsByDermatologistId(d.getUserId());

			for (int i = 0; i < pharmacyIds.size(); i++) {
				Pharmacy p = _pharmacyRepository.getOne(pharmacyIds.get(i));

				if (i == 0) {
					pharmacyNames.append(p.getName());
				} else {
					pharmacyNames.append(", " + p.getName());
				}
			}

			DermatologistDTO dermatologistDTO = new DermatologistDTO(d.getFirstName(), d.getLastName(), d.getRating(),
					pharmacyNames.toString());

			dermatologistDTOs.add(dermatologistDTO);
		}

		return dermatologistDTOs;
	}

	@Override
	public List<DermatologistDTO> searchDermatologist(String firstName, String lastName) {
		List<Dermatologist> dermatologists = _dermatologistRepository.findAllByFirstNameAndLastName(firstName,
				lastName);
		List<DermatologistDTO> dermatologistDTOs = new ArrayList<DermatologistDTO>();
		for (Dermatologist d : dermatologists) {
			StringBuilder pharmacyNames = new StringBuilder();

			List<Long> pharmacyIds = _dermatologistRepository.findAllPharmacyIdsByDermatologistId(d.getUserId());

			for (int i = 0; i < pharmacyIds.size(); i++) {
				Pharmacy p = _pharmacyRepository.getOne(pharmacyIds.get(i));

				if (i == 0) {
					pharmacyNames.append(p.getName());
				} else {
					pharmacyNames.append(", " + p.getName());
				}
			}

			DermatologistDTO dermatologistDTO = new DermatologistDTO(d.getFirstName(), d.getLastName(), d.getRating(),
					pharmacyNames.toString());

			dermatologistDTOs.add(dermatologistDTO);

		}
		return dermatologistDTOs;
	}

	@Override
	public List<DermatologistDTO> searchDermatologistsByFirstName(String firstName) {
		List<Dermatologist> dermatologists = _dermatologistRepository.findAllByFirstName(firstName);
		List<DermatologistDTO> dermatologistDTOs = new ArrayList<DermatologistDTO>();
		for (Dermatologist d : dermatologists) {
			StringBuilder pharmacyNames = new StringBuilder();

			List<Long> pharmacyIds = _dermatologistRepository.findAllPharmacyIdsByDermatologistId(d.getUserId());

			for (int i = 0; i < pharmacyIds.size(); i++) {
				Pharmacy p = _pharmacyRepository.getOne(pharmacyIds.get(i));

				if (i == 0) {
					pharmacyNames.append(p.getName());
				} else {
					pharmacyNames.append(", " + p.getName());
				}
			}

			DermatologistDTO dermatologistDTO = new DermatologistDTO(d.getFirstName(), d.getLastName(), d.getRating(),
					pharmacyNames.toString());

			dermatologistDTOs.add(dermatologistDTO);

		}
		return dermatologistDTOs;
	}

	@Override
	public List<DermatologistDTO> searchDermatologistsByLastName(String lastName) {
		List<Dermatologist> dermatologists = _dermatologistRepository.findAllByLastName(lastName);
		List<DermatologistDTO> dermatologistDTOs = new ArrayList<DermatologistDTO>();
		for (Dermatologist d : dermatologists) {
			StringBuilder pharmacyNames = new StringBuilder();

			List<Long> pharmacyIds = _dermatologistRepository.findAllPharmacyIdsByDermatologistId(d.getUserId());

			for (int i = 0; i < pharmacyIds.size(); i++) {
				Pharmacy p = _pharmacyRepository.getOne(pharmacyIds.get(i));

				if (i == 0) {
					pharmacyNames.append(p.getName());
				} else {
					pharmacyNames.append(", " + p.getName());
				}
			}

			DermatologistDTO dermatologistDTO = new DermatologistDTO(d.getFirstName(), d.getLastName(), d.getRating(),
					pharmacyNames.toString());

			dermatologistDTOs.add(dermatologistDTO);

		}
		return dermatologistDTOs;
	}

	@Override
	public List<DermatologistDTO> filterDermatologistByRating(Double minRating, Double maxRating) {
		List<Dermatologist> dermatologists = _dermatologistRepository.findAll();
		List<DermatologistDTO> dermatologistDTOs = new ArrayList<DermatologistDTO>();

		for (Dermatologist d : dermatologists)
			if (d.getRating() >= minRating && d.getRating() <= maxRating) {
				StringBuilder pharmacyNames = new StringBuilder();

				List<Long> pharmacyIds = _dermatologistRepository.findAllPharmacyIdsByDermatologistId(d.getUserId());

				for (int i = 0; i < pharmacyIds.size(); i++) {
					Pharmacy p = _pharmacyRepository.getOne(pharmacyIds.get(i));

					if (i == 0) {
						pharmacyNames.append(p.getName());
					} else {
						pharmacyNames.append(", " + p.getName());
					}
				}

				DermatologistDTO dermatologistDTO = new DermatologistDTO(d.getFirstName(), d.getLastName(),
						d.getRating(), pharmacyNames.toString());

				dermatologistDTOs.add(dermatologistDTO);
			}

		return dermatologistDTOs;
	}

	public Set<Dermatologist> getAllDermatologistByPharmacyId(Long pharmacyId) {

		Pharmacy pharmacy = _pharmacyRepository.getOne(pharmacyId);
		Set<Dermatologist> dermatologists = pharmacy.getDermatologist();

		return dermatologists;
	}

	@Override
	public void updateRating(Long userId, Double newRating) {
		Dermatologist existing = _dermatologistRepository.findById(userId).orElse(null);
		if (existing != null) {
			existing.setRating(newRating);
			_dermatologistRepository.save(existing);
		}

	}

	@Override
	public List<PharmacyDermatologistDTO> findDermatologistsByPharmacy() {
		PharmacyAdministrator pAdmin = (PharmacyAdministrator) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		List<Dermatologist> dermatologists = _dermatologistRepository.findAll();
		List<PharmacyDermatologistDTO> dermatologistDTOs = new ArrayList<PharmacyDermatologistDTO>();

		for (Dermatologist d : dermatologists) {

			StringBuilder pharmacyNames = new StringBuilder();

			List<Long> pharmacyIds = _dermatologistRepository.findAllPharmacyIdsByDermatologistId(d.getUserId());

			if (pharmacyIds.contains(pAdmin.getPharmacy().getPharmacyId())) {

				for (int i = 0; i < pharmacyIds.size(); i++) {
					Pharmacy p = _pharmacyRepository.getOne(pharmacyIds.get(i));

					if (i == 0) {
						pharmacyNames.append(p.getName());
					} else {
						pharmacyNames.append(", " + p.getName());
					}
				}
				
				PharmacyDermatologistDTO dermatologistDTO = new PharmacyDermatologistDTO(d.getUserId(), d.getFirstName(), d.getLastName(), d.getPhoneNumber(), d.getEmail(), d.getAddress().getStreet(), d.getAddress().getStreetNumber(), d.getAddress().getCity(), d.getRating(), pharmacyNames.toString());

				dermatologistDTOs.add(dermatologistDTO);
			}
		}

		return dermatologistDTOs;
	}

}
