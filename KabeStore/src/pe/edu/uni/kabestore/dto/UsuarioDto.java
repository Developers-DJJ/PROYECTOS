package pe.edu.uni.kabestore.dto;

public class UsuarioDto extends EmpleadoDto{
    
    private EmpleadoDto dto;
    private String usuario;
    private String clave;
    private int activo;

    public UsuarioDto() {
    }

    public EmpleadoDto getDto() {
        return dto;
    }

    public void setDto(EmpleadoDto dto) {
        this.dto = dto;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    

}
