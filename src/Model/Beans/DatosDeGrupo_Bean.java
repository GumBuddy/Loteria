package Model.Beans;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "datos_de_grupo", schema = "loteria")
public class DatosDeGrupo_Bean {
    private String idGrupo;
    private DatosPersonales_Bean datosPersonalesByIdDatosPersonales;
    private Collection<DatosParticipante_Bean> datosParticipantesByIdGrupo;

    public DatosDeGrupo_Bean(String idGrupo, DatosPersonales_Bean datosPersonalesByIdDatosPersonales) {
        this.idGrupo = idGrupo;
        this.datosPersonalesByIdDatosPersonales = datosPersonalesByIdDatosPersonales;
    }

    public DatosDeGrupo_Bean() {

    }

    @Id
    @Column(name = "id_grupo", nullable = false, length = 6)
    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatosDeGrupo_Bean that = (DatosDeGrupo_Bean) o;
        return Objects.equals(idGrupo, that.idGrupo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGrupo);
    }

    @ManyToOne
    @JoinColumn(name = "id_datos_personales", referencedColumnName = "id_datos_personales")
    public DatosPersonales_Bean getDatosPersonalesByIdDatosPersonales() {
        return datosPersonalesByIdDatosPersonales;
    }

    public void setDatosPersonalesByIdDatosPersonales(DatosPersonales_Bean datosPersonalesByIdDatosPersonales) {
        this.datosPersonalesByIdDatosPersonales = datosPersonalesByIdDatosPersonales;
    }

    @OneToMany(mappedBy = "datosDeGrupoByIdGrupo")
    public Collection<DatosParticipante_Bean> getDatosParticipantesByIdGrupo() {
        return datosParticipantesByIdGrupo;
    }

    public void setDatosParticipantesByIdGrupo(Collection<DatosParticipante_Bean> datosParticipantesByIdGrupo) {
        this.datosParticipantesByIdGrupo = datosParticipantesByIdGrupo;
    }
}
