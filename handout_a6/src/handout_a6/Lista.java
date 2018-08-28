package handout_a6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lista")
public class Lista extends HttpServlet {
	protected void service(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException {
		DAO dao = new DAO();
		List<Pessoas> pessoas = dao.getLista();
		PrintWriter out = response.getWriter();
		out.println("<html><body><table border='1'>");
		out.println("<tr><td>ID</td><td>Nome</td>" +
		 "<td>Nascimento</td><td>Altura</td></tr>");
		for (Pessoas pessoa : pessoas) {
			out.println("<tr><td>" + pessoa.getId() + "</td>");
			out.println("<td>" + pessoa.getNome() + "</td>");
			out.println("<td>" + pessoa.getNascimento().getTime() + "</td>");
			out.println("<td>" + pessoa.getAltura() + "</td></tr>");
		}
		out.println("</table></body></html>");
		
		dao.close();
	}
}
