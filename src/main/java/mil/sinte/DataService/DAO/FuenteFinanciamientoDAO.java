package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanFuenteFinanciamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Repository
public interface FuenteFinanciamientoDAO extends JpaRepository<BeanFuenteFinanciamiento, String> {

    @Query(nativeQuery = true, value = "SELECT CODIGO, DESCRIPCION, ABREVIATURA, ESTADO "
            + "FROM OPREDB.V_FUENTE_FINANCIAMIENTO@DBLINK_OPRE "
            + "ORDER BY CODIGO")
    @Override
    List<BeanFuenteFinanciamiento> findAll();

}
