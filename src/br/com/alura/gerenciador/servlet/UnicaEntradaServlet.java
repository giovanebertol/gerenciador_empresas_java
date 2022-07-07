package br.com.alura.gerenciador.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresaForm;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
//@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String paramAcao = request.getParameter("acao"); 
        String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
     
	    String nome;
	    try {
	        Class classe = Class.forName(nomeDaClasse);//carrega a classe com o nome 
	        @SuppressWarnings("deprecation")
			Acao acao = (Acao) classe.newInstance(); 	        
	        nome = acao.executa(request, response);
	    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	        throw new ServletException(e);
	    }
	    	    
	    String[] tipoEEndereco = nome.split(":");
	    if(tipoEEndereco[0].equals("forward")) {
	        RequestDispatcher rd =          request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
	        rd.forward(request, response);
	    } else {
	        response.sendRedirect(tipoEEndereco[1]);
	    }
		/*if(paramAcao.equals("ListaEmpresas")) {    

	        ListaEmpresas acao = new ListaEmpresas();
	        nome  = acao.executa(request, response);

	    } else if(paramAcao.equals("RemoveEmpresa")) {

	        RemoveEmpresa acao = new RemoveEmpresa();
	        nome = acao.executa(request, response);
	        
	    } else if(paramAcao.equals("MostraEmpresa")) {

	        MostraEmpresa acao = new MostraEmpresa();
	        nome = acao.executa(request, response);

	    } else if (paramAcao.equals("AlteraEmpresa")) {

	        AlteraEmpresa acao = new AlteraEmpresa();
	        nome = acao.executa(request, response);

	    } else if (paramAcao.equals("NovaEmpresa")) {

	        NovaEmpresa acao = new NovaEmpresa();
	        nome = acao.executa(request, response);
	    }else if (paramAcao.equals("NovaEmpresaForm")) {

	        NovaEmpresaForm acao = new NovaEmpresaForm();
	        nome = acao.executa(request, response);
	    } */

	 
	}

}
