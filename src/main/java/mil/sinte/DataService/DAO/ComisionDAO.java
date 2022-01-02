/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanComision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author leonel
 */
public interface ComisionDAO extends JpaRepository<BeanComision, String> {

    @Query(nativeQuery = true, value = "SELECT NASIGNACION_COMISION_CODIGO CODIGO,\n"
            + "       VASIGNACION_COMISION_DESCRIPCI DESCRIPCION,\n"
            + "       UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) ESTADO,\n"
            + "       CPERIODO_CODIGO,\n"
            + "       NBRIGADA_CODIGO,\n"
            + "       CMES_CODIGO,\n"
            + "       NTIPO_ASIGNACION_CODIGO"
            + "  FROM SINTE_ASIGNACION_COMISION\n"
            + " WHERE CPERIODO_CODIGO = ?1\n"
            + "   AND NBRIGADA_CODIGO = ?2\n"
            + "   AND CMES_CODIGO = ?3\n"
            + "   AND NTIPO_ASIGNACION_CODIGO = ?4\n"
            + " ORDER BY CODIGO")
    List<BeanComision> findAll(String periodo, Integer brigada, String mes, Integer asignacion);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_ASIGNACION_COMISION(:codigo, :periodo, :brigada, :mes, :asignacion, "
            + ":descripcion,:lista, :usuario, :modo)}", nativeQuery = true)
    void sp_comision(
            @Param("codigo") Integer codigo,
            @Param("periodo") String periodo,
            @Param("brigada") Integer brigada,
            @Param("mes") String mes,
            @Param("asignacion") Integer asignacion,
            @Param("descripcion") String descripcion,
            @Param("lista") String lista,
            @Param("usuario") String usuario,
            @Param("modo") String modo);

}
