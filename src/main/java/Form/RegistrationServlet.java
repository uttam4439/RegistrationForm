package Form;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.InputStream;

@WebServlet("/register")
@MultipartConfig(maxFileSize = 5 * 1024 * 1024) // 5 MB limit
public class RegistrationServlet extends HttpServlet {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // Get form fields
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String pinCode = request.getParameter("pinCode");
        String qualification = request.getParameter("qualification");
        String examCenter = request.getParameter("examCenter");
        String category = request.getParameter("category");
        String password = request.getParameter("password");

        // Handle file uploads
        Part photoPart = request.getPart("photo");
        Part signaturePart = request.getPart("signature");

        byte[] photoBytes = null;
        byte[] signatureBytes = null;

        try (InputStream photoInput = photoPart.getInputStream();
             InputStream signatureInput = signaturePart.getInputStream()) {
            photoBytes = photoInput.readAllBytes();
            signatureBytes = signatureInput.readAllBytes();
        }

        // Create and save object
        FormContent content = new FormContent(
                fullName, email, phone, gender, dob, address, city, state,
                pinCode, qualification, examCenter, category, password,
                photoBytes, signatureBytes
        );

        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(content);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
