package pe.edu.uni.kabestore.prueba;

import pe.edu.uni.kabestore.dto.PromocionDto;
import pe.edu.uni.kabestore.service.PromocionService;

public class PruebaPromocion {
    
    public static void main(String[] args) {
        try {
            PromocionService service = new PromocionService();
				        PromocionDto dto = service.getPorcentajePromocion(21);
				 System.out.println("el porcentaje es: " + dto.getPorcentaje());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  
        
        
    }
}
