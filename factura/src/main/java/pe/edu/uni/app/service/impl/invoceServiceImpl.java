package pe.edu.uni.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.uni.app.model.invoceModel;
import pe.edu.uni.app.repository.invoceRespository;
import pe.edu.uni.app.services.IInvoceService;

@Service
public class invoceServiceImpl implements IInvoceService {

	@Autowired
	private invoceRespository invoceRespository;
	
	@Override
	public List<invoceModel> listarPorID(String numeroOtorgante) {

		return invoceRespository.findBynumeroOtorgante(numeroOtorgante);
	}

	@Override
	public List<invoceModel> listar() {
		// TODO Auto-generated method stub
		return (List<invoceModel>) invoceRespository.findAll();
	}

}
