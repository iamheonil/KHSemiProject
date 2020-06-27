package web.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import web.dao.face.User_basicDao;
import web.dao.face.User_detailDao;
import web.dao.impl.User_basicDaoImpl;
import web.dao.impl.User_detailDaoImpl;
import web.dto.User_detail;
import web.service.face.User_detailService;

public class User_detailServiceImpl implements User_detailService {

	private User_basicDao user_basicDao = new User_basicDaoImpl();
	private User_detailDao user_detailDao = new User_detailDaoImpl();
	private User_detail user_detail = new User_detail();
	
	@Override
	public User_detail getUser_detail(HttpServletRequest req) {
		
		// 파싱
		if(req.getParameter("userid")!=null && !"".equals(req.getParameter("userid"))) {
			user_detail.setUserid(Integer.parseInt(req.getParameter("userid")));
		}
		
		user_detail.setUserpw(req.getParameter("userpw"));
		
		return user_detail;
	}
	@Override
	public void joinUser_detail(HttpServletRequest req) {
		// 1. 파일업로드 형태가 데이터가 맞는지 검사
		// 	요청메시지 Content-Type이 multpart/form-data 가 맞는지 확인한다
		
		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);
		
		// 1-1. multipart/form-data 인코딩으로 전송되지 않았을 경우 처리 중단하기
		if(!isMultipart) {
			return; // fileupload() 메소드 중단시키기
		}
		
		// 1-2. 여기 이후부터는 multipart/form-data로 요청된 상황
		
		
		// 2. 업로드된 파일을 처리하는 아이템팩토리 객체 생성
		
		// itemFactory : 업로드된 데이터(FileItem)를 처리하는 방식을 설정하는 클래스
		// Factory : 만들기 위해서 사전에 만들어지는 클래스
		// FileItem : 클라이언트로부터 전송된 데이터를 객체화시킨 것
		
		// DiskFileItemFactory class
		// 	> 디스크(HDD) 기반의 파일아이템 처리 API
		// 	> 업로드된 파일을 디스크(HDD)에 임시 저장하고 나중에 처리한다
		DiskFileItemFactory factory = new  DiskFileItemFactory();
		
		// 3. 업로드된 파일아이템의 용량이 적당히 작으면 메모리에서 하도록 설정
		int maxMem = 1 * 1024 * 1024; // 1MB
		factory.setSizeThreshold(maxMem);
		
		// 4. 용량이 적당히 크면 임시파일(HDD) 만들어서 처리하도록 설정
		// 	> 임시파일 폴더 설정
		
		ServletContext context = req.getServletContext();
		String path = context.getRealPath("tmp");
		
		File repository = new File(path); // 임시 저장 폴더
		
		System.out.println("repository : " + repository); // 경로 TEST
		
		factory.setRepository(repository);
		
		
		// 5. 업로드 허용 용량 기준을 넘지 않을 경우에만 파일 업로드 처리되도록 설정
		// 	> 기준을 넘으면 업로드 차단됨
		
		int maxFile = 10 * 1024 * 1024; // 10MB
		
		// 6. 파일업로드 수행 객체 생성
		// 	DiskFileItemFactory 객체 이용해서 생성함
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// 파일 업로드 용량제한 설정 : 10MB
		upload.setFileSizeMax(maxFile);
		
		
		// -------------------- 파일 업로드 준비 완료 ------------------------
		
		// 6. 업로드된 데이터 추출(파싱)
		// 	임시 파일 업로드도 같이 수행된다
		List<FileItem> items = null;
		
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		// 파일아이템 반복자
		Iterator<FileItem> iter = items.iterator();
			
		// 객체 생성
		String birthday = "";
		String address = "";
		
		// 모든 요청 정보 처리하는 반복문
		while(iter.hasNext()) {
			// 요청 정보 객체
			FileItem item = iter.next();
			
			// 1) 빈파일에 대한 처리
			if(item.getSize() <= 0)	continue; // 건너뛰기
			
			
			
			// 2) 기본 전달 파라미터에 대한 처리
			if(item.isFormField()) {
				
				// ------------ 파라미터 처리 개요 -------------
				// form-data(form field)는 key=value 쌍으로 전달됨
				
				// key는 item.getFieldName() 으로 얻어옴
				// value는 item.getString() 으로 얻어옴
				
				// * 전달값이 한글일 경우 인코딩 설정 방법
				//  item.getString("UTF-8")
				
				// * req.setCharacterEncoding("UTF-8")이 적용되지 않는다
				
				// ---------------------------------------------
				
				// --------------- 기본 처리 방식 --------------
				
//						out.println("- - - 폼 빌드 - - - <br>");
//						out.println(" 키 : " + item.getFieldName() + "<br>");
//						
//						try {
//							out.println(" 값 : " + item.getString("UTF-8") + "<br>");
//						} catch (UnsupportedEncodingException e) {
//							e.printStackTrace();
//						}
				
				// -----------------------------------------------
				
				// -------- 키 값에 따라 처리하는 방식 -----------
				
				// 키값 꺼내기
				String key = item.getFieldName();
				
				if("userpw".equals(key)) { // 전달파라미터 name이 "userpw"
					try {
						user_detail.setUserpw(item.getString("UTF-8"));
						System.out.println(user_detail);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				} else if("birth-YY".equals(key)) { // 전달파라미터 name이 "birth-YY"
					try {
						birthday += item.getString("UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				} else if("birth-MM".equals(key)) { // 전달파라미터 name이 "birth-MM"
					try {
						birthday += "-";
						birthday += item.getString("UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				} else if("birth-DD".equals(key)) { // 전달파라미터 name이 "birth-DD"
					try {
						birthday += "-";
						birthday += item.getString("UTF-8");
						user_detail.setUserbirth(birthday);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				} else if("usergender".equals(key)) { // 전달파라미터 name이 "usergender"
					try {
						user_detail.setUsergender(item.getString("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				} else if("userphone".equals(key)) { // 전달파라미터 name이 "userphone"
					try {
						user_detail.setUserphone(item.getString("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				} else if("useraddr".equals(key)) { // 전달파라미터 name이 "useraddr"
					try {
						address += item.getString("UTF-8");
						user_detail.setUseraddr(address);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				} else if("useraddrDetail".equals(key)) { // 전달파라미터 name이 "useraddrDetail"
					try {
						address += " ";
						address += item.getString("UTF-8");
						user_detail.setUseraddr(address);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
				// -----------------------------------------------
				
			} // item.isFormField() end
			
			
			// 3) 파일 처리
			if(!item.isFormField()) {
				
				// 서버에 저장되는 파일명을 "년월일시분초밀리초.확장자"로 변경하기
				
				// 파일명 - 년월일시분초밀리초
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssS");
				String rename = sdf.format(new Date());
				
				// 확장자
				String origin = item.getName(); // 원본파일명
				String ext = origin.substring(item.getName().lastIndexOf(".")+1);
				
				// 저장될 이름
				String stored = rename + "." + ext;
				
//				System.out.println("[TEST] stored file name : " + stored);
				
				// ----------- DB에 업로드된 파일에 대한 정보 기록하기 -----------
				user_detail.setUserphoto_origin(origin); // 원본명 저장
				user_detail.setUserphoto_rename(stored); // 수정명 저장
				
				// 사번 객체에 저장하자마자 세션 지우기
				user_detail.setUserid((int)req.getSession().getAttribute("userid"));
				req.getSession().removeAttribute("userid");
				// ---------------------------------------------------------------				
				
				// 실제 업로드 파일
				File up = new File(
						context.getRealPath("upload") // 업로드될 폴더
//								, item.getName() // 원본 파일의 이름
						, stored // 저장 파일의 이름
						); 
				
				try {
					item.write(up); // 실제 업로드(최종 결과 파일 생성)
					item.delete(); // 임시 파일 삭제
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} // !item.isFormField() end
			
			
		}// while(iter.hasnext()) end
		
		user_detailDao.insertUser_detail(user_detail);
	}
	
	@Override
	public User_detail getUser_detailById(HttpServletRequest req) {
		
		user_detail = new User_detail();
		user_detail.setUserid((int)req.getSession().getAttribute("userid"));
				
		return user_detailDao.selectUser_detailById(user_detail);
	}

	@Override
	public void modifyUser_detail(User_detail user_detail) {
		
	}
	@Override
	public String createTempPassword(int len) {
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7',
				'8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
				'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
				'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		
		int idx = 0;
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i<len; i++) {
			idx = (int) (charSet.length * Math.random()); // 36 * 생성된 난수를 Int로 추출 (소숫점제거)
			sb.append(charSet[idx]);
		}
		
		return sb.toString();
	}
	
	@Override
	public void updatePassword(User_detail user_detail) {
		user_detailDao.updatePassword(user_detail);
		
	}
	
}