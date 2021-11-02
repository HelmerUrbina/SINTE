package mil.sinte.DataService.DAO;

import mil.sinte.BusinessServices.Beans.BeanEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Repository
public interface EstadoDAO extends JpaRepository<BeanEstado, String> {

    BeanEstado findByCodigo(String codigo);

}
