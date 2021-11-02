package mil.sinte.BusinessServices.Beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Entity
@Table(name = "SINTE_ESTADOS")
@Data
public class BeanCombos implements Serializable {

    @Id
    @Column(name = "CODIGO", nullable = false)
    private String codigo;

    @Column(name = "DESCRIPCION")
    private String descripcion;

}
