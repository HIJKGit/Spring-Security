package idv.vin.tutorial.web.manager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // 允許的前端源
                .allowCredentials(true) // 允許攜帶憑證(cookies)
                .allowedMethods("*") // 允許的HTTP方法
                .maxAge(3600); // 預檢請求的緩存時間(秒)
    }
}
