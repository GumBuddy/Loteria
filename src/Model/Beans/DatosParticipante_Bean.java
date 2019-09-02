package Model.Beans;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "datos_participante", schema = "loteria")
public class DatosParticipante_Bean {
    private Integer idParticipante;
    private DatosDeContacto_Bean datosDeContactoByIdContacto;
    private DatosDeInstitucionales_Bean datosDeInstitucionalesByIdInstitucionales;
    private DatosDeGrupo_Bean datosDeGrupoByIdGrupo;

    public DatosParticipante_Bean(Integer idParticipante, DatosDeContacto_Bean datosDeContactoByIdContacto, DatosDeInstitucionales_Bean datosDeInstitucionalesByIdInstitucionales, DatosDeGrupo_Bean datosDeGrupoByIdGrupo) {
        this.idParticipante = idParticipante;
        this.datosDeContactoByIdContacto = datosDeContactoByIdContacto;
        this.datosDeInstitucionalesByIdInstitucionales = datosDeInstitucionalesByIdInstitucionales;
        this.datosDeGrupoByIdGrupo = datosDeGrupoByIdGrupo;
    }

    public DatosParticipante_Bean() {

    }

    @Id
    @Column(name = "id_participante", nullable = false)
    public Integer getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(Integer idParticipante) {
        this.idParticipante = idParticipante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatosParticipante_Bean that = (DatosParticipante_Bean) o;
        return Objects.equals(idParticipante, that.idParticipante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idParticipante);
    }

    @ManyToOne
    @JoinColumn(name = "id_contacto", referencedColumnName = "id_contacto", nullable = false)
    public DatosDeContacto_Bean getDatosDeContactoByIdContacto() {
        return datosDeContactoByIdContacto;
    }

    public void setDatosDeContactoByIdContacto(DatosDeContacto_Bean datosDeContactoByIdContacto) {
        this.datosDeContactoByIdContacto = datosDeContactoByIdContacto;
    }

    @ManyToOne
    @JoinColumn(name = "id_institucionales", referencedColumnName = "id_institucionales", nullable = false)
    public DatosDeInstitucionales_Bean getDatosDeInstitucionalesByIdInstitucionales() {
        return datosDeInstitucionalesByIdInstitucionales;
    }

    public void setDatosDeInstitucionalesByIdInstitucionales(DatosDeInstitucionales_Bean datosDeInstitucionalesByIdInstitucionales) {
        this.datosDeInstitucionalesByIdInstitucionales = datosDeInstitucionalesByIdInstitucionales;
    }

    @ManyToOne
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo", nullable = false)
    public DatosDeGrupo_Bean getDatosDeGrupoByIdGrupo() {
        return datosDeGrupoByIdGrupo;
    }

    public void setDatosDeGrupoByIdGrupo(DatosDeGrupo_Bean datosDeGrupoByIdGrupo) {
        this.datosDeGrupoByIdGrupo = datosDeGrupoByIdGrupo;
    }
}
