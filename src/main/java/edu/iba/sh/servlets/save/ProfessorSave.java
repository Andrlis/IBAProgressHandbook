package edu.iba.sh.servlets.save;

import edu.iba.sh.bean.Professor;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ProfessorSave")
public class ProfessorSave extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int oldId = Integer.parseInt(request.getParameter("oldId"));

            Professor professor = createProfessor(request);

            if (oldId == 0) {
                DAOFactory.getProfessorDao().saveProfessor(professor);
            } else {
                DAOFactory.getProfessorDao().updateProfessor(oldId, professor);
            }

            request.setAttribute("professor", professor);
            request.getRequestDispatcher("JSP/ProfessorForm.jsp").forward(request, response);
        } catch (DAOException e){
            throw new ServletException(e);
        }
    }

    private Professor createProfessor(HttpServletRequest request) {
        Professor professor = new Professor();

        String firstName = request.getParameter("firstName");
        String fatherName = request.getParameter("fatherName");
        String secondName = request.getParameter("secondName");
        String birthDate = request.getParameter("birthDate");
        double avgMark = Double.parseDouble(request.getParameter("avgMark"));

        professor.setFirstName(firstName);
        professor.setFatherName(fatherName);
        professor.setSecondName(secondName);
        professor.setBirthDate(birthDate);
        professor.setAvgMark(avgMark);

        return professor;
    }
}
