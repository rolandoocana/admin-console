/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.web.filter;

import com.gestor.bots.admin.console.web.CredencialesBean;
import java.io.IOException;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hendrix
 */
@WebFilter(filterName = "SecureFilter", urlPatterns = {"/*"})
public class SecureFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(SecureFilter.class.getName());

    private FilterConfig filterConfig = null;
    @Inject
    private CredencialesBean credenciales;

    public SecureFilter() {
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        String path = req.getRequestURI();
        if (path.endsWith(".xhtml") && !path.contains("javax.faces.resource") && !path.contains("index.xhtml")) {
            LOG.info("Path solicitado: "+req.getRequestURI()+" user:"+this.credenciales.getUser()); 
            if (this.credenciales.getUser()!=null) {
                chain.doFilter(request, response);
            } else {
                LOG.warning("Acceso indebido, redirecciono al index");
                String urlRed="http://"+req.getServerName()+":"+req.getServerPort()+"/admin-console-web/";
                res.sendRedirect(urlRed+"index.xhtml");
            }
        } else {
            chain.doFilter(request, response);
        }
        
        
        
        

    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {

        }
    }

}
