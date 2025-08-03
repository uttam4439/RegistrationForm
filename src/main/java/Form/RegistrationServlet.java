package Form;

import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/register")
@MultipartConfig
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FormContent form = new FormContent();

        form.setFullName(request.getParameter("fullName"));
        form.setEmail(request.getParameter("email"));
        form.setPhone(request.getParameter("phone"));
        form.setGender(request.getParameter("gender"));
        form.setDob(request.getParameter("dob"));
        form.setCity(request.getParameter("city"));
        form.setState(request.getParameter("state"));
        form.setPinCode(request.getParameter("pinCode"));
        form.setQualification(request.getParameter("qualification"));
        form.setExamCenter(request.getParameter("examCenter"));
        form.setCategory(request.getParameter("category"));
        form.setPassword(request.getParameter("password"));

        // Handle Photo Upload
        Part photoPart = request.getPart("photo");
        if (photoPart != null && photoPart.getSize() > 0) {
            try (InputStream photoStream = photoPart.getInputStream()) {
                form.setPhoto(photoStream.readAllBytes());
            }
        }

        // Handle Signature Upload
        Part signaturePart = request.getPart("signature");
        if (signaturePart != null && signaturePart.getSize() > 0) {
            try (InputStream signatureStream = signaturePart.getInputStream()) {
                form.setSignature(signatureStream.readAllBytes());
            }
        }

        // Save Data using Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(form);

        tx.commit();
        session.close();

        response.getWriter().println("Registration Successful!");
    }
}
