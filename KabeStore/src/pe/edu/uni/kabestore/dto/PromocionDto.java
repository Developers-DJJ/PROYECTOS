
package pe.edu.uni.kabestore.dto;


 // @author BANISTER
 
public class PromocionDto {
  private int idPromocion;
  private int cantMin;
  private int cantMax;
  private double porcentaje;  
  
  public PromocionDto(){
  
  }

    public PromocionDto(int cantMin, int cantMax, double porcentaje) {
        this.cantMin = cantMin;
        this.cantMax = cantMax;
        this.porcentaje = porcentaje;
    }

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public int getCantMin() {
        return cantMin;
    }

    public void setCantMin(int cantMin) {
        this.cantMin = cantMin;
    }

    public int getCantMax() {
        return cantMax;
    }

    public void setCantMax(int cantMax) {
        this.cantMax = cantMax;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
  
}
