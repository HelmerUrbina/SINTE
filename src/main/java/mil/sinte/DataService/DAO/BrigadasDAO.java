package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanBrigadas;
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
public interface BrigadasDAO extends JpaRepository<BeanBrigadas, String> {

    @Query(nativeQuery = true, value = "SELECT "
            + "a.NBRIGADA_CODIGO, a.CBRIGADA_CODIGO, "
            + "a.VBRIGADA_DESCRIPCION, a.VBRIGADA_ABREVIATURA , "
            + "UTIL.FUN_DIVISION_EJERCITO_ABREVIAT(NDIVISION_EJERCITO_CODIGO) AS DIVISION_EJERCITO, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(a.CESTADO_CODIGO) CESTADO_CODIGO, "
            + "UTIL.FUN_DEPARTAMENTO_NOMBRE(SUBSTR(CUBIGEO_CODIGO,1,2)) DEPARTAMENTO, "
            + "UTIL.FUN_PROVINCIA_NOMBRE(SUBSTR(CUBIGEO_CODIGO,1,2), SUBSTR(CUBIGEO_CODIGO,3,2)) PROVINCIA, "
            + "UTIL.FUN_UBIGEO_NOMBRE(CUBIGEO_CODIGO) UBIGEO "
            + "FROM SINTE_BRIGADAS a "
            + "ORDER BY a.NBRIGADA_CODIGO")
    @Override
    List<BeanBrigadas> findAll();

    @Query(nativeQuery = true, value = "SELECT "
            + "a.NBRIGADA_CODIGO, a.CBRIGADA_CODIGO, "
            + "a.VBRIGADA_DESCRIPCION, a.VBRIGADA_ABREVIATURA , "
            + "''||NDIVISION_EJERCITO_CODIGO AS DIVISION_EJERCITO, CESTADO_CODIGO, "
            + "SUBSTR(CUBIGEO_CODIGO,1,2) DEPARTAMENTO, SUBSTR(CUBIGEO_CODIGO,3,2) PROVINCIA, CUBIGEO_CODIGO UBIGEO "
            + "FROM SINTE_BRIGADAS a WHERE "
            + "a.NBRIGADA_CODIGO=?1 ")
    public BeanBrigadas findByCodigo(Integer codigo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_BRIGADA(:codigo, :brigadaCodigo, :divisionEjercito,"
            + " :descripcion, :abreviatura, :ubigeo, :usuario, :modo)}", nativeQuery = true)
    void sp_brigada(
            @Param("codigo") int codigo,
            @Param("brigadaCodigo") String brigadaCodigo,
            @Param("divisionEjercito") String divisionEjercito,
            @Param("descripcion") String descripcion,
            @Param("abreviatura") String abreviatura,
            @Param("ubigeo") String ubigeo,
            @Param("usuario") String usuario,
            @Param("modo") String modo);

}
