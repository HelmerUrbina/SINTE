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
@Table(name = "SINTE_PROG_CNV")
@Data
public class BeanProgramacionCNV implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "CPERIODO_CODIGO", nullable = false)
    private String periodo;

    @Column(name = "NTIPO_ASIGNACION_CODIGO", nullable = false)
    private Integer tipoAsignacion;

    @Column(name = "NBRIGADA_CODIGO", nullable = false)
    private Integer brigada;

    @Column(name = "VEVENTO_PRINCIPAL_CODIGO", nullable = false)
    private String eventoPrincipal;

    @Column(name = "NEVENTO_FINAL_CODIGO", nullable = false)
    private Integer eventoFinal;

    @Column(name = "NDEPENDENCIA_CODIGO", nullable = false)
    private String dependencia;

    @Column(name = "NVEHICULO_CODIGO", nullable = false)
    private String vehiculo;

    @Column(name = "NTIPO_COMBUSTIBLE_CODIGO", nullable = false)
    private String tipoCombustible;

    @Id
    @Column(name = "CODIGO", nullable = false)
    private String codigo;

    @Column(name = "NCNV_CANTIDAD")
    private Double cantidad;

    @Column(name = "NCNV_DEMANDA_GLOBAL")
    private Double demandaGlobal;

    @Column(name = "NCNV_PRECIO")
    private Double precio;
    
    @Column(name = "NCNV_TOTAL")
    private Double total;
    
    @Column(name = "NCNV_TOTAL_DEMANDA_GLOBAL")
    private Double totalDemandaGlobal;

    @Column(name = "CESTADO_CODIGO")
    private String estado;

}
