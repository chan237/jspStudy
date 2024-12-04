package co.kh.dev;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "myfirstServlet", urlPatterns = { "/myfirstServlet" })
public class MyfirstServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	//디생
    public MyfirstServlet() {
        super();
        System.out.println("처음으로 한번만 초기화");
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request,response);
		//System.out.println("서비스 작동");
		requestTest(request,response);
	}
	
	protected void requestTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서비스 작동");
		//0. 사용자 요청정보를 받아야한다. request 이후 DB연동(CURD진행)
		//1. 서버에서 클라이언트 문자를 보내기 위한 문자셋 진행
		response.setCharacterEncoding("UTF-8");
		//2. 브라우저에게 text/html charset = UTF-8 이라고 보냄
		response.setContentType("text/html;charset=UTF-8");
		//3. 출력스트림 (1Byte, 2Byte)
		PrintWriter out = response.getWriter();
		Date date = new Date();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>My First Servlet Program !!!</h1>");
        out.println("<br>");
        out.println(date.toString());
        out.println("</body>");
        out.println("</html>");
        out.flush();System.out.println("서비스 작동");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}