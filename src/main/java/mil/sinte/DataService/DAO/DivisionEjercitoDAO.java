package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanDivisionEjercito;
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
public interface DivisionEjercitoDAO extends JpaRepository<BeanDivisionEjercito, Integer> {

    @Query(nativeQuery = true, value = "SELECT NDIVISION_EJERCITO_CODIGO, "
            + "VDIVISION_EJERCITO_DESCRIPCION, VDIVISION_EJERCITO_ABREVIATURA, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_DIVISION_EJERCITO "
            + "ORDER BY NDIVISION_EJERCITO_CODIGO")
    @Override
    List<BeanDivisionEjercito> findAll();

    public BeanDivisionEjercito findByCodigo(Integer codigo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_DIVISION_EJERCITO(:codigo, :descripcion, :abreviatura, :usuario, :modo)}", nativeQuery = true)
    void sp_divisionEjercito(
            @Param("codigo") int codigo,
            @Param("descripcion") String descripcion,
            @Param("abreviatura") String abreviatura,
            @Param("usuario") String usuario,
            @Param("modo") String modo);

}
