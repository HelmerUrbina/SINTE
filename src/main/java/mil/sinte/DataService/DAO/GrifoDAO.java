package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanGrifo;
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
public interface GrifoDAO extends JpaRepository<BeanGrifo, String> {

    @Query(nativeQuery = true, value = "SELECT "
            + "NGRIFO_CODIGO, NBRIGADA_CODIGO, "
            + "UTIL.FUN_BRIGADA_ABREVIATURA(NBRIGADA_CODIGO) AS VBRIGADA_DESCRIPCION, "
            + "VGRIFO_NOMBRE, VGRIFO_DIRECCION, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO, "
            + "UTIL.FUN_DEPARTAMENTO_NOMBRE(SUBSTR(CUBIGEO_CODIGO,1,2)) DEPARTAMENTO, "
            + "UTIL.FUN_PROVINCIA_NOMBRE(SUBSTR(CUBIGEO_CODIGO,1,2), SUBSTR(CUBIGEO_CODIGO,3,2)) PROVINCIA, "
            + "UTIL.FUN_UBIGEO_NOMBRE(CUBIGEO_CODIGO) UBIGEO "
            + "FROM SINTE_GRIFO "
            + "ORDER BY NGRIFO_CODIGO")
    @Override
    List<BeanGrifo> findAll();

    @Query(nativeQuery = true, value = "SELECT "
            + "NGRIFO_CODIGO, NBRIGADA_CODIGO, '' VBRIGADA_DESCRIPCION, VGRIFO_NOMBRE, "
            + "CESTADO_CODIGO, SUBSTR(CUBIGEO_CODIGO,1,2) DEPARTAMENTO, SUBSTR(CUBIGEO_CODIGO,3,2) PROVINCIA, "
            + "CUBIGEO_CODIGO UBIGEO, VGRIFO_DIRECCION "
            + "FROM SINTE_GRIFO WHERE "
            + "NGRIFO_CODIGO=?1 ")
    public BeanGrifo findByCodigo(Integer codigo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_GRIFO(:codigo, :brigada, :grifoNombre, :ubigeo, :grifoDireccion, :usuario, :modo)}", nativeQuery = true)
    void sp_grifo(
            @Param("codigo") Integer codigo,
            @Param("brigada") Integer brigada,
            @Param("grifoNombre") String grifoNombre,
            @Param("ubigeo") String ubigeo,
            @Param("grifoDireccion") String grifoDireccion,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
}
