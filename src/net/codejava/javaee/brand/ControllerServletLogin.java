
  package net.codejava.javaee.brand;
  import java.io.*; import java.sql.SQLException;
  import javax.servlet.*; 
  import javax.servlet.annotation.WebServlet;
  import javax.servlet.http.*;
  
  
  
 @WebServlet(urlPatterns = {"/Login"}) 
 public class ControllerServletLogin extends HttpServlet { 
	 

  
  public ControllerServletLogin() {
	  super(); // TODO Auto-generated constructor
  }
   
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  { 
	  String email_id =request.getParameter("email_id"); 
	  String password =request.getParameter("password"); 
	  LoginDAO LoginDAO = new LoginDAO();
  
	  try {
 
 
		  String destPage = "index.jsp"; 
		  Login login = LoginDAO.checkLogin(email_id,password); 
		  if (login != null) {
  
			  	HttpSession session = request.getSession(); session.setAttribute("login",login); 
//  if (rememberMe) { UserAuthentication newToken = new
//  UserAuthentication();
//  
//  String selector = RandomStringUtils.randomAlphanumeric(12); String
//  rawValidator = RandomStringUtils.randomAlphanumeric(64);
//  
//  String hashedValidator = HashGenerator.generateSHA256(rawValidator);
//  
//  newToken.setSelector(selector); newToken.setValidator(hashedValidator);
//  
//  newToken.UserSetting(login);
//  
//  // save the token into the database
//  
//  // create a cookie to store the selector
//  
//  // create a cookie to store the validator
//  
//  }
//  
			  	destPage = "Welcome.jsp";
			  	request.setAttribute("first_name", login.getFirst_name());
			  	request.setAttribute("last_name", login.getFirst_name());
//  
//  
  } else 
  	{ 
	  String message = "Invalid email/password";
	  request.setAttribute("message", message);
//  
  	} 
  RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
  dispatcher.forward(request, response); 
  }
  
  catch(SQLException |ClassNotFoundException ex) { 
	  ex.printStackTrace(); 
	  throw new ServletException(ex); 
	  }
  }
  
  
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
  }
  }
 