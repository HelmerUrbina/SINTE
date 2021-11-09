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
    
    @Query(nativeQuery = true, value =  "SELECT NVEHICULO_TIPO_CODIGO CODIGO,\n" +
                                        "       VVEHICULO_TIPO_DESCRIPCION DESCRIPCION\n" +
                                        "  FROM SINTE_VEHICULO_TIPO\n" +
                                        " WHERE CESTADO_CODIGO = 'AC'\n" +
                                        " ORDER BY CODIGO")
    List<BeanCombos> getTipoVehiculo();

    
    @Query(nativeQuery = true, value =  "SELECT NVEHICULO_CLASE_CODIGO CODIGO,\n" +
                                        "       VVEHICULO_CLASE_DESCRIPCION DESCRIPCION\n" +
                                        "  FROM SINTE_VEHICULO_CLASE\n" +
                                        " WHERE CESTADO_CODIGO = 'AC'\n" +
                                        " ORDER BY CODIGO")
    List<BeanCombos> getClaseVehiculo();

    
    @Query(nativeQuery = true, value =  " SELECT NMARCA_CODIGO CODIGO,\n" +
                                        "        VMARCA_NOMBRE DESCRIPCION\n" +
                                        "  FROM SINTE_MARCAS\n" +
                                        " WHERE CESTADO_CODIGO = 'AC'\n" +
                                        " ORDER BY CODIGO")
    List<BeanCombos> getMarca();

    
    @Query(nativeQuery = true, value =  " SELECT NMARCA_MODELO_CODIGO CODIGO,\n" +
                                        "        VMARCA_MODELO_DESCRIPCION DESCRIPCION\n" +
                                        "  FROM SINTE_MARCAS_MODELOS\n" +
                                        " WHERE CESTADO_CODIGO = 'AC'\n" +
                                        "   AND NMARCA_CODIGO =?1 \n" +
                                        " ORDER BY CODIGO")
    List<BeanCombos> getModelo(String marca);

    
    @Query(nativeQuery = true, value =  " SELECT NCOLOR_CODIGO CODIGO,\n" +
                                        "        VCOLOR_DESCRIPCION DESCRIPCION\n" +
                                        "  FROM SINTE_COLORES\n" +
                                        " WHERE CESTADO_CODIGO = 'AC'\n" +
                                        " ORDER BY CODIGO")
    List<BeanCombos> getColor();
    
    
    @Query(nativeQuery = true, value =  "SELECT NSOAT_ASEGURADORA_CODIGO CODIGO,\n" +
                                        "       VSOAT_ASEGURADORA_NOMBRE DESCRIPCION\n" +
                                        "  FROM SINTE_SOAT_ASEGURADORA\n" +
                                        " WHERE CESTADO_CODIGO = 'AC'\n" +
                                        " ORDER BY CODIGO")
    List<BeanCombos> getSoat();
    
    @Query(nativeQuery = true, value =  "SELECT NBRIGADA_CODIGO CODIGO,\n" +
                                        "       VBRIGADA_DESCRIPCION DESCRIPCION\n" +
                                        " FROM SINTE_BRIGADAS\n" +
                                        "WHERE CESTADO_CODIGO = 'AC'\n" +
                                        "ORDER BY CODIGO")
    List<BeanCombos> getBrigada();
    
    @Query(nativeQuery = true, value =  "SELECT NAREA_LABORAL_CODIGO CODIGO,\n" +
                                        "       VAREA_LABORAL_DESCRIPCION DESCRIPCION\n" +
                                        " FROM SINTE_AREA_LABORAL\n" +
                                        "WHERE CESTADO_CODIGO = 'AC'\n" +
                                        "ORDER BY CODIGO")
    List<BeanCombos> getAreaLaboral();
    
    @Query(nativeQuery = true, value =  "SELECT NUSUARIO_ROL_CODIGO CODIGO,\n" +
                                        "       VUSUARIO_ROL_NOMBRE DESCRIPCION\n" +
                                        " FROM SINTE_USUARIOS_ROLES\n" +
                                        "WHERE CESTADO_CODIGO = 'AC'\n" +
                                        "ORDER BY CODIGO")
    List<BeanCombos> getRol();
    
    @Query(nativeQuery = true, value =  "SELECT NVEHICULO_CODIGO CODIGO,\n" +
                                        "      VVEHICULO_PLACA DESCRIPCION\n" +
                                        " FROM SINTE_VEHICULOS\n" +
                                        "WHERE NVEHICULO_CODIGO NOT IN (SELECT NVEHICULO_CODIGO\n" +
                                        "                                FROM SINTE_VEHICULOS_BRIGADAS\n" +
                                        "                               WHERE NBRIGADA_CODIGO =?2 \n" +
                                        "                                 AND CPERIODO_CODIGO =?1) \n" +
                                        "ORDER BY CODIGO")
    List<BeanCombos> getVehiculosByBrigadaAndPeriodo(String periodo, Integer brigada);
    
    @Query(nativeQuery = true, value =  "SELECT NDEPENDENCIA_CODIGO CODIGO,\n" +
                                        "      VDEPENDENCIA_ABREVIATURA DESCRIPCION \n" +
                                        " FROM SINTE_DEPENDENCIAS\n" +
                                        "WHERE NDEPENDENCIA_CODIGO NOT IN (SELECT NDEPENDENCIA_CODIGO\n" +
                                        "                                    FROM SINTE_VEHICULOS_BRIGADAS\n" +
                                        "                                   WHERE NBRIGADA_CODIGO =?2\n" +
                                        "                                     AND CPERIODO_CODIGO = ?1\n" +
                                        "                                     AND NVEHICULO_CODIGO = ?3) \n" +
                                        "  AND NBRIGADA_CODIGO = ?2\n" +
                                        "ORDER BY CODIGO")
    List<BeanCombos> getDependenciaByVehiAndBrigAndPeri(String periodo, Integer brigada, Integer vehiculo);


}
