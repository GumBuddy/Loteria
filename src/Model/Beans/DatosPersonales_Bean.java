package Model.Beans;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "datos_personales", schema = "loteria")
public class DatosPersonales_Bean {
    private Integer idDatosPersonales;
    private String folio;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private Integer edad;
    private Byte asistencia;
    private Collection<DatosDeGrupo_Bean> datosDeGruposByIdDatosPersonales;

    public DatosPersonales_Bean(Integer idDatosPersonales, String folio, String apellidoPaterno, String apellidoMaterno, String nombres, Integer edad, Byte asistencia) {
        this.idDatosPersonales = idDatosPersonales;
        this.folio = folio;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
        this.edad = edad;
        this.asistencia = asistencia;
    }

    public DatosPersonales_Bean() {

    }

    @Id
    @Column(name = "id_datos_personales", nullable = false)
    public Integer getIdDatosPersonales() {
        return idDatosPersonales;
    }

    public void setIdDatosPersonales(Integer idDatosPersonales) {
        this.idDatosPersonales = idDatosPersonales;
    }

    @Basic
    @Column(name = "folio", nullable = false, length = 6)
    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    @Basic
    @Column(name = "apellido_paterno", nullable = false, length = 15)
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    @Basic
    @Column(name = "apellido_materno", nullable = false, length = 15)
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    @Basic
    @Column(name = "Nombres", nullable = false, length = 50)
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Basic
    @Column(name = "edad", nullable = false)
    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Basic
    @Column(name = "asistencia", nullable = true)
    public Byte getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Byte asistencia) {
        this.asistencia = asistencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatosPersonales_Bean that = (DatosPersonales_Bean) o;
        return Objects.equals(idDatosPersonales, that.idDatosPersonales) &&
                Objects.equals(folio, that.folio) &&
                Objects.equals(apellidoPaterno, that.apellidoPaterno) &&
                Objects.equals(apellidoMaterno, that.apellidoMaterno) &&
                Objects.equals(nombres, that.nombres) &&
                Objects.equals(edad, that.edad) &&
                Objects.equals(asistencia, that.asistencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDatosPersonales, folio, apellidoPaterno, apellidoMaterno, nombres, edad, asistencia);
    }

    @OneToMany(mappedBy = "datosPersonalesByIdDatosPersonales")
    public Collection<DatosDeGrupo_Bean> getDatosDeGruposByIdDatosPersonales() {
        return datosDeGruposByIdDatosPersonales;
    }

    public void setDatosDeGruposByIdDatosPersonales(Collection<DatosDeGrupo_Bean> datosDeGruposByIdDatosPersonales) {
        this.datosDeGruposByIdDatosPersonales = datosDeGruposByIdDatosPersonales;
    }
}
