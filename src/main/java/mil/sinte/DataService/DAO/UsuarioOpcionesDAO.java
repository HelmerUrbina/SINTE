/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanUsuarioOpciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface UsuarioOpcionesDAO extends JpaRepository<BeanUsuarioOpciones,String> {
    
    @Query(nativeQuery = true, value =  " SELECT MO.NMODULO_CODIGO||M.NMENU_CODIGO VUSUARIO_CODIGO, \n" +
                                        "       MO.NMODULO_CODIGO NMODULO_CODIGO,\n" +
                                        "       MO.VMODULO_NOMBRE VUSUARIO_CREADOR,\n" +
                                        "       M.VMENU_NOMBRE NMENU_CODIGO\n" +
                                        "  FROM SINTE_MENU M\n" +
                                        "       INNER JOIN SINTE_MODULOS MO ON (M.NMODULO_CODIGO=MO.NMODULO_CODIGO)\n" +
                                        " ORDER BY VUSUARIO_CODIGO")
    List<BeanUsuarioOpciones> getOpcionesUsuario();
    
    @Query(nativeQuery = true, value =  "SELECT NMODULO_CODIGO||NMENU_CODIGO VUSUARIO_CODIGO,\n" +
                                        "       '' NMODULO_CODIGO,'' VUSUARIO_CREADOR,'' NMENU_CODIGO\n" +
                                        "  FROM SINTE_USUARIOS_MENU\n" +
                                        " WHERE VUSUARIO_CODIGO =?1 \n" +
                                        " ORDER BY VUSUARIO_CODIGO")
    List<BeanUsuarioOpciones> getOpcionesOfUsuario(String usuario);
}
