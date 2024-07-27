package io.github.touchsun.tstudy.common.security.filter;


import org.springframework.web.server.WebFilter;

/**
 * filter factory, ensure one provider to one filter
 * 
 * @author lee 
 */
public interface IFilterFactory {

    /**
     * new filter instance.
     */
    WebFilter getInstance();
}
