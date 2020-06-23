package mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.User_basic;
import web.dto.User_detail;
import web.service.face.User_basicService;
import web.service.face.User_detailService;
import web.service.impl.User_basicServiceImpl;
import web.service.impl.User_detailServiceImpl;
import web.util.MailAuth;

@WebServlet("/send")
public class MailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private User_basicService user_basicService = new User_basicServiceImpl();
	private User_detailService user_detailService = new User_detailServiceImpl();
	
	private User_basic user_basic = new User_basic();
	private User_detail user_detail = new User_detail();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/login/findpwres.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 사번가지고 정보가져오기
		user_basic = user_basicService.getUser_basic(req);
		user_basic = user_basicService.selectAllByUserid(user_basic);
		
		// 사번, 이름, 이메일 변수에 저장
		int userid = user_basic.getUserid();
		String uesrname = user_basic.getUsername();
		String useremail = req.getParameter("useremail");
		
		// 임시비밀번호 생성
		String password = user_detailService.createTempPassword(10);
		
		
		// user_detail 객체에 임시비밀번호, 사번저장
		user_detail.setUserid(userid);
		user_detail.setUserpw(password);
		
		// 비밀변호 update 서비스
		user_detailService.updatePassword(user_detail);
		
		
		// FROM
		final String FROM = "activeware01@gmail.com"; // <<------------------------------수정하세요
		final String FROMNAME = "액티브웨어"; // <<------------------------------수정하세요

		// TO
		final String TO = useremail; // <<------------------------------수정하세요

		// 메일 제목
		final String SUBJECT = uesrname + "님의 임시비밀번호입니다."; // <<------------------------------수정하세요

		// 메일 본문
		final String BODY = String.join(
				"",
				"<div align='center' style='border:1px solid black; font-size: 16px; font-family: nanumbarungothic; width: 600px;'>",
				"<h3 style='color: blue;'>" + uesrname + "님에게 발급된 임시비밀번호입니다.</h3>",
				"<div><a href='http://localhost:8088/'>로그인페이지</a>로 돌아가 임시비밀번호 <strong>" + user_detail.getUserpw() +
				"</strong> 를 입력해주세요.<br></div>",
				"<div>로그인 후 마이페이지에서 비밀번호변경을 해주세요.<br></div></div>"); // <<------------------------------수정하세요

		// 인증 객체
		Authenticator auth = new MailAuth("activeware01@gmail.com", "active@123"); // <<------------------------------수정하세요

		
		
		
		// 연결 설정
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		
		// 메일 세션 객체 생성
		Session session = Session.getDefaultInstance(props, auth);

		// 메시지 생성
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(FROM, FROMNAME));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
			msg.setSubject(SUBJECT);
			msg.setContent(BODY, "text/html;charset=utf-8");

			System.out.println("Sending...");

			//메시지 보내기
			Transport.send(msg);
			
			System.out.println("Email sent!");

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
			
		} catch (MessagingException e) {
			e.printStackTrace();
			
			System.out.println("The email was not sent.");
			System.out.println("Error message: " + e.getMessage());
			
		}
		
		resp.sendRedirect("/send");
	}
}
