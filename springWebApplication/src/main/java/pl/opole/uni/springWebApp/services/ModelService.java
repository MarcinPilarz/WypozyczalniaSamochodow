package pl.opole.uni.springWebApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.opole.uni.springWebApp.models.ModelSamochodu;
import pl.opole.uni.springWebApp.repositories.ModelRepository;

@Service
public class ModelService implements MainService<ModelSamochodu> {

	
	@Autowired
	private ModelRepository modelRepo;
	
	@Override
	public List<ModelSamochodu> findAllItems() {
		// TODO Auto-generated method stub
		return modelRepo.findAll();
	}

	@Override
	public void addItem(ModelSamochodu modelSamochodu) {
		// TODO Auto-generated method stub
		modelRepo.save(modelSamochodu);
	}

	@Override
	public void deleteItem(ModelSamochodu modelSamochodu) {
		// TODO Auto-generated method stub
		modelRepo.delete(modelSamochodu);
	}

	@Override
	public void updateItem(ModelSamochodu modelSamochodu) {
		// TODO Auto-generated method stub
		modelRepo.save(modelSamochodu);
	}

	@Override
	public ModelSamochodu findById(Long id) {
		// TODO Auto-generated method stub
		return modelRepo.findById(id).orElse(null);
	}

}
