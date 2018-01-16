package com.newb.eureka_zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class AccessFilter extends ZuulFilter {
    /**
     * 拦截类型
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 多个拦截器时的 拦截 顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 可以判断 是否拦截
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 1. 如果有异常 必须 捕获，
     * 不然 进入 SendErrorFilter
     *
     * 2. 或者 创建 error 类型的 过滤器
     * 自己捕获 抛出
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        /**
         * 验证 accessToken
         */
        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("error! access token is Error.");
            return null;
        }
        log.info("access token ok");

        return null;
    }
}
