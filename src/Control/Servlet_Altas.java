package Control;

import Model.Beans.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@javax.servlet.annotation.WebServlet(name = "Servlet_Altas")
public class Servlet_Altas extends javax.servlet.http.HttpServlet {
    DatosPersonales_Bean Build_Bean;
    DatosDeGrupo_Bean Build_Bean_G;
    DatosDeInstitucionales_Bean Build_Bean_I;
    DatosDeContacto_Bean Build_Bean_C;
    Integer idDatosPersonales;

    protected void altas_DatosPersonales(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        idDatosPersonales = Integer.parseInt(request.getParameter("ID"));
        String folio = String.valueOf(idDatosPersonales);
        String Nombres = request.getParameter("Nombres");
        String Apellido_P = request.getParameter("Apellido_P");
        String Apellido_M = request.getParameter("Apellido_M");
        Integer Edad = Integer.valueOf(request.getParameter("Edad"));
        Byte Asistencia = null;
        Build_Bean = new DatosPersonales_Bean
                (idDatosPersonales, folio, Apellido_P, Apellido_M, Nombres, Edad, Asistencia);

    }


    protected void altas_Grupo(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String idGrupo = request.getParameter("ID");
        Build_Bean_G = new DatosDeGrupo_Bean
                (idGrupo, Build_Bean);
    }

    protected void altas_Contacto(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Integer Id = idDatosPersonales;
        String Correo, Direccion, NumeroCelular;
        Correo = request.getParameter("Correo");
        Direccion = request.getParameter("Direccion");
        NumeroCelular = request.getParameter("Celular");
        Build_Bean_C = new DatosDeContacto_Bean
                (Id, Correo, Direccion, NumeroCelular);


    }

    protected void altas_institucionales(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String ID, adscripcion, tipo;
        ID = request.getParameter("ID_Institucion");
        adscripcion = request.getParameter("adscripcion");
        tipo = request.getParameter("tipo");
        Build_Bean_I = new DatosDeInstitucionales_Bean
                (ID, adscripcion, tipo);
    }

    protected void altas_Participante(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        DatosParticipante_Bean Bean_Final = new DatosParticipante_Bean
                (idDatosPersonales, Build_Bean_C, Build_Bean_I, Build_Bean_G);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        altas_Contacto(request, response);
        altas_institucionales(request, response);
        altas_DatosPersonales(request, response);
        altas_Grupo(request, response);
        altas_Participante(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
