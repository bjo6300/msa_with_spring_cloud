package com.example.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class ZuulLoggingFilter extends ZuulFilter {

    @Override
    public Object run() throws ZuulException {
        log.info("**************** printing logs: ");

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest(); 
        log.info("**************** " + request.getRequestURI());

        return null;
    }

    @Override
    public String filterType() { // 사전 필터
        return "pre";
    }

    @Override
    public int filterOrder() { // 필터 순서
        return 1;
    }

    @Override
    public boolean shouldFilter() { // 필터 사용 유무
        return true;
    }
}
