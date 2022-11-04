package mvc.simple;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class SimpleControl extends HttpServlet {
	
	// * 절대경로 위치 확인
	private String jspDir = "/05_mvc_class/1_mvcSimple";
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	
	//1104 방금만든함수
	   private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      String value ="안녕하세요";
	      
	      //파라미터 값 저장 셋어트리빗
	      request.setAttribute("param", value);
	      
	      //forward <jsp:forward> 이태그를 다시 자바로 변환하는코딩
	         //즉 jspDir + "/simpleView.jsp" 이페이지로 포워딩한다
	      RequestDispatcher dispatcher =
	            request.getRequestDispatcher(jspDir + "/simpleView.jsp");
	      
	      dispatcher.forward(request, response);
	      
	      //즉 벨류로 지정한 값을  jspDir + "/simpleView.jsp 여기서도 볼수있게 한다는것
	      //그리고 이 서블릿 파일은 등록을해야 사용할 수 있다
	      
	   }
}
