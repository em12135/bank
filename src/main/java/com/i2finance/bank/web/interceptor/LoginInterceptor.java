package com.i2finance.bank.web.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.i2finance.bank.util.JwtTokenUtils;
import com.i2finance.bank.util.Result;
import com.i2finance.bank.util.StatusCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * 拦截器,实现HandlerInterceptor接口
 * 没有登录的用户无法访问其他资源
 */
//创建对象
@Component
public class LoginInterceptor implements HandlerInterceptor {

    //通过该对象可以手动的将 对象转为json字符串, 导入mvc启动器即可以使用
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;

    //请求到达资源前进行拦截判断
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*
        从请求头里把token获取到
         */
        String token = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        //请求头必须携带token
        if (StringUtils.isNotBlank(token)) {
            //通过请求头里的token解析出手机号, 并且redis里面的token不能够过期,
            String phone = JwtTokenUtils.getUsername(token);
            String redisToken = redisTemplate.opsForValue().get(phone);

            //没有过期,并且token一样 请求放行  否则走下面返回false
            if (StringUtils.isNotBlank(redisToken) && Objects.equals(token, redisToken)) {
                return true;
            }
        }
        //防止乱码
        response.setCharacterEncoding("utf-8");
        //返回数据格式为json
        response.setContentType("application/json;charset=utf-8");
        //该方法将对象转为json字符串                           //用户未登录,返回false即不放行
        String result = objectMapper.writeValueAsString(Result.fail(StatusCode.USER_NOT_LOGIN));
        //将失败的信息输出给客户端
        response.getWriter().println(result);
        return false;
    }
}
