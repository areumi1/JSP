package mvc.guest.control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.guest.command.Command;
import mvc.guest.command.CommandDelete;
import mvc.guest.command.CommandException;
import mvc.guest.command.CommandInput;
import mvc.guest.command.CommandList;
import mvc.guest.command.CommandNull;

/**
 * Servlet implementation class GuestControl
 */
public class GuestControl extends HttpServlet {
	
	private HashMap commandMap;
	private String	jspDir = "/05_mvc_class/2_mvcGuest/";
	private String  error = "error.jsp";
	

    public GuestControl() {
        super();       
		initCommand();
	}

	private void initCommand(){
		commandMap = new HashMap(); // 키,벨류 저장 

		commandMap.put("main-page",	new CommandNull("main.jsp") );
		commandMap.put("list-page",	new CommandList("listMessage.jsp") );
		// 나머지도 추가하기	
		commandMap.put("input-form" , new CommandNull("insertMessage.jsp"));  // DB 확인을 안하는 객체
		commandMap.put("input-do"	, new CommandInput("saveMessage.jsp"));
		commandMap.put("delete-form", new CommandNull("deleteMessage.jsp")); 		// 화면만 띄우는 객체로 DB확인 안함
		commandMap.put("delete-do"	, new CommandDelete("deleteConfirm.jsp"));
		
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글처리

		String nextPage = "";
		String cmdKey	= request.getParameter("cmd");  //파라메타값을 받아 변수에 저장
		if( cmdKey == null ){
			cmdKey = "main-page";
		}
		
		
		Command cmd = null;

		try{
			
			if( commandMap.containsKey( cmdKey ) ){			// cmdKey 해당하는 키가 있는지 확인
				cmd = (Command)commandMap.get( cmdKey); // 해당하는 값을 가져온다.
			}else{
				throw new CommandException("지정할 명령어가 존재하지 않음");
			}

			nextPage = cmd.execute( request, response  );
			
		}catch( CommandException e ){
			request.setAttribute("javax.servlet.jsp.jspException", e );
			nextPage = error;
			System.out.println("오류 : " + e.getMessage() );
		}

		RequestDispatcher reqDp = getServletContext().getRequestDispatcher( jspDir + nextPage );
		reqDp.forward( request, response );
		
	}

}
