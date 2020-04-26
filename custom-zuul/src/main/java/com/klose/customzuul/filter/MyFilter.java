package com.klose.customzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取Request与Response接口对象
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String securityToken = request.getParameter("access_token");
        if (securityToken == null) {
            ctx.setSendZuulResponse(false);
            //状态码
            ctx.setResponseStatusCode(401);
            try {
                //返回响应
                ctx.getResponse().getWriter().write("request failure , you do not have security access_token ");
            } catch (Exception e) {
            }
        }
        //return null 表示直接越过此Filter
        return null;
    }
}
