/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanReporteUsuario;
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
public interface ReporteUsuarioDAO extends JpaRepository<BeanReporteUsuario, String>{
    
    @Query(nativeQuery = true, value = "SELECT CPERIODO_CODIGO PERIODO,\n" +
                                        "       CREPORTE_CODIGO CODIGO_REPORTE,\n" +
                                        "       UTIL.FUN_REPORTE(CREPORTE_CODIGO) REPORTE,\n" +
                                        "       VUSUARIO_CODIGO USUARIO,\n" +
                                        "       NREPORTE_USUARIO_NIVEL NIVEL,\n" +
                                        "       UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) ESTADO\n" +
                                        "  FROM SINTE_REPORTE_USUARIO\n" +
                                        " WHERE CPERIODO_CODIGO = ?1\n" +
                                        "   AND CREPORTE_CODIGO = ?2\n" +
                                        " ORDER BY VUSUARIO_CODIGO")
    public List<BeanReporteUsuario> findAll(String periodo, String reporte);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_REPORTE_USUARIO(:periodo, :reporte, :usuario, :nivel, :usuarioM, :modo)}", nativeQuery = true)
    void sp_reporte (
            @Param("periodo") String periodo,
            @Param("reporte") String reporte,
            @Param("usuario") String usuario,
            @Param("nivel") Integer nivel,
            @Param("usuarioM") String usuarioM,
            @Param("modo") String modo);
    
}
