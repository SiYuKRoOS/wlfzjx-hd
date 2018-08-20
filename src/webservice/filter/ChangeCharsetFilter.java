package webservice.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class ChangeCharsetFilter implements Filter {
	protected String encoding = null;
	protected FilterConfig filterConfig = null;
@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");
	}

	protected String getEncoding() {
		return (this.encoding);
	}
@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (request.getCharacterEncoding() == null) {
			String encoding = getEncoding();
			if (encoding != null) {
				request.setCharacterEncoding(encoding);
			}
		}
		System.out.println("doFilter方法中得到/设置的编码方式" + encoding);
		chain.doFilter(request, response);
	}
@Override
	public void destroy() {
		this.encoding = null;
		this.filterConfig = null;
	}
}
