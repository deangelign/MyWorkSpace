package br.com.projetobase.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetobase.arq.util.DadosSessao;

public class ManagerFilter implements Filter{
	
	private static final String HOME_PAGE = "/paginas/home.jsf";
	
	@Inject
	private DadosSessao dadosSessao;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;

		if (dadosSessao.getUsuarioDaSessao() != null && dadosSessao.getUsuario().isAdmin()) {
			chain.doFilter(req, res);
		} else {
			response.sendRedirect(request.getContextPath() + HOME_PAGE);
		}

		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
