package pe.edu.uni.kabestore.controller;

import pe.edu.uni.kabestore.dto.UsuarioDto;
import pe.edu.uni.kabestore.service.UsuarioService;



import pe.edu.uni.kabestore.util.Session;
public class LogonController {

    public void validarUsuario(String usuario, String clave) {
        UsuarioService service = new UsuarioService();
        UsuarioDto dto = service.validarUsuario(usuario, clave);
        Session.put("USUARIO", dto);
       
    }
}
