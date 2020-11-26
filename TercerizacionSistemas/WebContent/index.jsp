<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/EstiloLogin.css">
<body>
	<%
		String x=(String) request.getAttribute("msj");
		String a="";
		if(x!=null)
		a=x;
	%>

	<div class="fondo">
        <section class="container">
            <div class="side">
                <div class="imagen">
                    <img src="img/img-01.png" alt="">
                </div>
            </div>
            <div class="side">
                <div class="login_form">
                    <form action="ServletUsuario" name="formlogin" method="POST">
                        <h1>Ingreso al Sistema</h1> 
                        <div  class="txt_user">
                            <input type="text" name="user" placeholder="Usuario" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Usuario'" required>
                            <span class="icon"><i class="fas fa-user"></i></span>
                        </div>
                        <div  class="txt_pass">
                            <input type="password" name="pass" placeholder="Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'" required>
                            <span class="icon"><i class="fas fa-lock"></i></span>
                        </div>
                        <div class="btn_login">
                            <button type="submit" value="ingresar">INGRESAR</button>
                        </div>
                        <p style="text-align:center; color:red"><%=a %></p>

                    </form>
                </div>
            </div>
        </section>
    </div>
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/login.js"></script>
    <script src="https://kit.fontawesome.com/8aa15a39f3.js"></script> 
</body>
</html>