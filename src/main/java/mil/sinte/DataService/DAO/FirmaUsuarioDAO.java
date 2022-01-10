/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanFirmaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Repository
public interface FirmaUsuarioDAO extends JpaRepository<BeanFirmaUsuario, String>{
    
    @Query(nativeQuery = true, value = "SELECT CPERIODO_CODIGO PERIODO,\n" +
                                        "       VUSUARIO_CODIGO USUARIO,\n" +
                                        "       VUSUARIO_NRO_SERIE SERIE,\n" +
                                        "       UTIL.FUN_USUARIO_NOMBRE(VUSUARIO_CODIGO) NOMBRE,\n" +
                                        "       NGRADO_CODIGO CODIGO_GRADO,\n" +
                                        "       UTIL.FUN_GRADO_ABREVIATURA(NGRADO_CODIGO) GRADO,\n" +
                                        "       UTIL.FUN_USUARIO_CARGO(VUSUARIO_CODIGO) CARGO,\n" +
                                        "       UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) ESTADO\n" +
                                        "  FROM SINTE_USUARIO_FIRMAS\n" +
                                        " WHERE CPERIODO_CODIGO = ?1\n" +
                                        " ORDER BY VUSUARIO_CODIGO")
    List<BeanFirmaUsuario> findAll(String periodo);
    
    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_FIRMA_USUARIO(:periodo, :usuario, :serie, :grado, :usuarioM, :modo)}", nativeQuery = true)
    void sp_firma(
            @Param("periodo") String periodo,
            @Param("usuario") String usuario,
            @Param("serie") String serie,
            @Param("grado") Integer grado,
            @Param("usuarioM") String usuarioM,
            @Param("modo") String modo);
    
}
