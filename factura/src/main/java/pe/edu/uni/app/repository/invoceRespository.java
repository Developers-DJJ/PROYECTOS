package pe.edu.uni.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.uni.app.model.invoceModel;

@Repository

public interface invoceRespository extends JpaRepository<invoceModel, Integer> {

	//@Query(nativeQuery = true, value = "select * from fat_prefactura_agrupado_201212 where numero_otorgante =:numero_otorgante")
	List<invoceModel> findBynumeroOtorgante(String numeroOtorgante);
	
}
