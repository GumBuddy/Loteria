package Model.Beans;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "datos_de_institucionales", schema = "loteria")
public class DatosDeInstitucionales_Bean {
    private String idInstitucionales;
    private String adscripcion;
    private String tipoUniversitario;
    private Collection<DatosParticipante_Bean> datosParticipantesByIdInstitucionales;

    public DatosDeInstitucionales_Bean(String idInstitucionales, String adscripcion, String tipoUniversitario) {
        this.idInstitucionales = idInstitucionales;
        this.adscripcion = adscripcion;
        this.tipoUniversitario = tipoUniversitario;
    }

    public DatosDeInstitucionales_Bean() {

    }

    @Id
    @Column(name = "id_institucionales", nullable = false, length = 20)
    public String getIdInstitucionales() {
        return idInstitucionales;
    }

    public void setIdInstitucionales(String idInstitucionales) {
        this.idInstitucionales = idInstitucionales;
    }

    @Basic
    @Column(name = "adscripcion", nullable = true, length = 50)
    public String getAdscripcion() {
        return adscripcion;
    }

    public void setAdscripcion(String adscripcion) {
        this.adscripcion = adscripcion;
    }

    @Basic
    @Column(name = "tipo_universitario", nullable = true, length = 20)
    public String getTipoUniversitario() {
        return tipoUniversitario;
    }

    public void setTipoUniversitario(String tipoUniversitario) {
        this.tipoUniversitario = tipoUniversitario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatosDeInstitucionales_Bean that = (DatosDeInstitucionales_Bean) o;
        return Objects.equals(idInstitucionales, that.idInstitucionales) &&
                Objects.equals(adscripcion, that.adscripcion) &&
                Objects.equals(tipoUniversitario, that.tipoUniversitario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInstitucionales, adscripcion, tipoUniversitario);
    }

    @OneToMany(mappedBy = "datosDeInstitucionalesByIdInstitucionales")
    public Collection<DatosParticipante_Bean> getDatosParticipantesByIdInstitucionales() {
        return datosParticipantesByIdInstitucionales;
    }

    public void setDatosParticipantesByIdInstitucionales(Collection<DatosParticipante_Bean> datosParticipantesByIdInstitucionales) {
        this.datosParticipantesByIdInstitucionales = datosParticipantesByIdInstitucionales;
    }
}
