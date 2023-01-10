package pe.edu.uni.app.services;

import java.util.List;

import pe.edu.uni.app.model.invoceModel;

public interface IInvoceService {

	List<invoceModel> listarPorID(String numero_otorgante);
	List<invoceModel> listar();
	
}
