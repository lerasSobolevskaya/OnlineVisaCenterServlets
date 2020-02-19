package by.sobol.visacenter.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingUTF8 implements Filter {

	private String encoding;
	private static final String ENCODING = "encoding";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter(ENCODING);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String codeRequest = request.getCharacterEncoding();
		if (encoding != null && !encoding.equals(codeRequest)) {
				request.setCharacterEncoding(encoding);
					response.setCharacterEncoding(encoding);
			}
			chain.doFilter(request, response);
		}

	@Override
	public void destroy() {
		encoding = null;
	}

}
