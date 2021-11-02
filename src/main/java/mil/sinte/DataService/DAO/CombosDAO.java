package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanCombos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Repository
public interface CombosDAO extends CrudRepository<BeanCombos, String> {

    @Query(nativeQuery = true, value = "SELECT "
            + "a.CPERIODO_CODIGO AS CODIGO, a.CPERIODO_CODIGO AS DESCRIPCION "
            + "FROM SINTE_PERIODOS a WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getPeriodos();

    @Query(nativeQuery = true, value = "SELECT "
            + "a.NDIVISION_EJERCITO_CODIGO AS CODIGO, "
            + "a.VDIVISION_EJERCITO_ABREVIATURA AS DESCRIPCION "
            + "FROM SINTE_DIVISION_EJERCITO a WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getDivisionEjercito();

    @Query(nativeQuery = true, value = "SELECT "
            + "a.NTIPO_COMBUSTIBLE_CODIGO AS CODIGO, "
            + "a.VTIPO_COMBUSTIBLE_ABREVIATURA AS DESCRIPCION  "
            + "FROM SINTE_TIPO_COMBUSTIBLE a WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getTipoCombustible();

    @Query(nativeQuery = true, value = "SELECT "
            + "a.CDEPARTAMENTO_CODIGO AS CODIGO, "
            + "a.VDEPARTAMENTO_NOMBRE AS DESCRIPCION "
            + "FROM SINTE_DEPARTAMENTO a WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getDepartamentos();

    @Query(nativeQuery = true, value = "SELECT "
            + "a.CPROVINCIA_CODIGO AS CODIGO, "
            + "a.VPROVINCIA_NOMBRE AS DESCRIPCION "
            + "FROM SINTE_PROVINCIA a WHERE "
            + "CDEPARTAMENTO_CODIGO=?1 AND "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getProvincias(String departamento);

    @Query(nativeQuery = true, value = "SELECT "
            + "a.CUBIGEO_CODIGO AS CODIGO, "
            + "a.VUBIGEO_NOMBRE AS DESCRIPCION "
            + "FROM SINTE_UBIGEO a WHERE "
            + "a.CDEPARTAMENTO_CODIGO=?1 AND "
            + "a.CPROVINCIA_CODIGO=?2 AND "
            + "a.CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getUbigeo(String departamento, String provincia);

    @Query(nativeQuery = true, value = "SELECT "
            + "a.NTIPO_DEPENDENCIA_CODIGO AS CODIGO, "
            + "a.VTIPO_DEPENDENCIA_ABREVIATURA AS DESCRIPCION  "
            + "FROM SINTE_TIPO_DEPENDENCIA a WHERE "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getTipoDependencia();

    @Query(nativeQuery = true, value = "SELECT "
            + "NTIPO_ASIGNACION_CODIGO AS CODIGO, "
            + "VTIPO_ASIGNACION_ABREVIATURA AS DESCRIPCION "
            + "FROM SINTE_TIPO_ASIGNACION WHERE "
            + "NTIPO_ASIGNACION_CODIGO NOT IN (SELECT NTIPO_ASIGNACION_CODIGO "
            + "FROM SINTE_PERIODO_TIPO_ASIGNACION WHERE CPERIODO_CODIGO=?1) AND "
            + "CESTADO_CODIGO='AC' "
            + "ORDER BY CODIGO")
    List<BeanCombos> getPeriodoTipoAsignacionPendiente(String periodo);

}
