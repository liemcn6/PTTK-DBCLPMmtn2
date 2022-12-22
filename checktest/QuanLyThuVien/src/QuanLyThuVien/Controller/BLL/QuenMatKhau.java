package QuanLyThuVien.Controller.BLL;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QuanLyThuVien.model.DAL.DALTaiKhoan;
import QuanLyThuVien.model.DAL.Object.TaiKhoan;

/**
 * Servlet implementation class QuenMatKhau
 */
@WebServlet(name = "QuenMatKhau", urlPatterns = { "/QuenMatKhau" })
public class QuenMatKhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DALTaiKhoan dal_tk;
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuenMatKhau() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			dal_tk = new DALTaiKhoan("jdbc:sqlserver://localhost:1433;databaseName=QuanLyThuVien;user=sa;password=123;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		String email = request.getParameter("email");
		TaiKhoan tk = null;
		try {
			tk = dal_tk.getTaiKhoanTheoEmail(email);
			if(tk == null){
				response.getWriter().write("False");
			}
			else{
				// Generate new password
				String randomString="";
				Random rand = new Random();
				char text[] = new char[10];
				for (int i = 0; i < 10; i++){
					text[i] = ALPHA_NUMERIC_STRING.charAt(rand.nextInt(ALPHA_NUMERIC_STRING.length()));
					randomString += text[i];
				}
				
				//update new password
				dal_tk.changePassword(randomString, tk.getMaTaiKhoan());
				
				// send mail
				String host = "smtp.gmail.com";
		        String port = "587";
		        String mailFrom = "nguyentruongyen1998@gmail.com";
		        String password = "hfycnwcaerarqizi";

		        // outgoing message information
		        String mailTo = email;
		        String subject = "Yêu cầu cấp lại mật khẩu";
		        
		        String message = "Mật khẩu mới của bạn là: ";
		        message += randomString;
		        message += ". Vui lòng đăng nhập và đổi lại mật khẩu của bạn.";
		        try {
					sendHtmlEmail(host, port, mailFrom, password, mailTo,
					        subject, message);
					response.getWriter().write("True");
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendHtmlEmail(String host, String port, final String userName, final String password, String toAddress,
			String subject, String message) throws AddressException, MessagingException, IOException {

		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};

		Session session = Session.getInstance(properties, auth);
		//session.setDebug(true);
		session.setDebug(true);

		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(MimeUtility.encodeText(subject, "utf-8", "B"));
		msg.setSentDate(new Date());

		MimeMultipart multipart = new MimeMultipart("related");

		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(message, "text/html; charset=UTF-8");

		multipart.addBodyPart(messageBodyPart);


		msg.setContent(multipart);

		msg.saveChanges();

		Transport.send(msg);
	}

}
