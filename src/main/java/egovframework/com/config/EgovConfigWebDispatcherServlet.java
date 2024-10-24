package egovframework.com.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import egovframework.com.cmm.interceptor.AuthenticInterceptor;
import egovframework.com.cmm.interceptor.AuthorizInterceptor;
import egovframework.com.cmm.interceptor.BusinessInterceptor;
import egovframework.com.cmm.interceptor.CSRFInterceptor;
import egovframework.com.cmm.interceptor.NonceInterceptor;

/**
 * @ClassName : EgovConfigWebDispatcherServlet.java
 * @Description : DispatcherServlet 설정
 *
 * @author : 윤주호
 * @since  : 2021. 7. 20
 * @version : 1.0
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일              수정자               수정내용
 *  -------------  ------------   ---------------------
 *   2021. 7. 20    윤주호               최초 생성
 * </pre>
 *
 */
@Configuration
@ComponentScan(basePackages = "com.rds.adams.web", excludeFilters = {
	@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Service.class),
	@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Repository.class),
	@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)
})
public class EgovConfigWebDispatcherServlet implements WebMvcConfigurer {
	
	@Autowired
	AuthenticInterceptor authenticInterceptor;
	
	@Autowired
	AuthorizInterceptor authorizInterceptor;
	
	@Autowired
	BusinessInterceptor businessInterceptor;
	
	@Autowired
	CSRFInterceptor csrfInterceptor;
	
	@Autowired
	NonceInterceptor nonceInterceptor;

	//final static String RESOLVER_DEFAULT_ERROR_VIEW = "cmm/error/egovError";

	//final static int URL_BASED_VIEW_RESOLVER_ORDER = 1;
	//final static String URL_BASED_VIEW_RESOLVER_PREFIX = "/WEB-INF/jsp/";
	//final static String URL_BASED_VIEW_RESOLVER_SUFFIX = ".jsp";

	//private final String[] CORS_ORIGIN_SERVER_URLS = {"http://127.0.0.1:3000", "http://localhost:3000"};

	// =====================================================================
	// RequestMappingHandlerMapping 설정
	// =====================================================================
	// -------------------------------------------------------------
	// RequestMappingHandlerMapping 설정 - Interceptor 추가
	// -------------------------------------------------------------
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		List<String> commonExcludePathList = new ArrayList<String>();
		List<String> resourceExcludePathList = new ArrayList<String>();
		List<String> excludePathList = new ArrayList<String>();
		
		// 에러화면
		commonExcludePathList.add("/error/*");
		
		// 인증 예외대상
		commonExcludePathList.add("/");
		commonExcludePathList.add("/login");
		commonExcludePathList.add("/adminLogin");
		commonExcludePathList.add("/auth/**");
		commonExcludePathList.add("/logout");
		commonExcludePathList.add("/TokenRefresh");
		commonExcludePathList.add("/error");
		commonExcludePathList.add("/FailAuthentic");
		
		// 웹자원
		resourceExcludePathList.add("/css/**");
		resourceExcludePathList.add("/images/**");
		resourceExcludePathList.add("/js/**");
		resourceExcludePathList.add("/*.ico");
		
		excludePathList.addAll(commonExcludePathList);
		excludePathList.addAll(resourceExcludePathList);
		
		registry.addInterceptor(authenticInterceptor)
			.addPathPatterns("/**/*", "/*")
			.excludePathPatterns(excludePathList);
		registry.addInterceptor(authorizInterceptor)
			.addPathPatterns("/menuLink")
			.excludePathPatterns(excludePathList);
		registry.addInterceptor(businessInterceptor)
			.addPathPatterns("/menuLink")
			.excludePathPatterns(excludePathList);
		registry.addInterceptor(csrfInterceptor)
			.addPathPatterns("/**/*", "/*")
			.excludePathPatterns(resourceExcludePathList);
		
		//// Nonce 인터셉터 추후 적용을 위한 코멘트 처리
		//registry.addInterceptor(nonceInterceptor)
		//	.addPathPatterns("/**/*", "/*")
		//	.excludePathPatterns(excludePathList);
	}

	// -------------------------------------------------------------
	// RequestMappingHandlerMapping 설정 View Controller 추가
	// -------------------------------------------------------------
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/cmmn/validator.do")
			.setViewName("cmmn/validator");
		registry.addViewController("/index.html").setViewName("forward:/login.html");
		registry.addViewController("/").setViewName("login");
	}

	// -------------------------------------------------------------
	// HandlerExceptionResolver 설정
	// -------------------------------------------------------------
	/*
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();

		simpleMappingExceptionResolver.setDefaultErrorView(RESOLVER_DEFAULT_ERROR_VIEW);

		Properties mappings = new Properties();
		mappings.setProperty("org.springframework.dao.DataAccessException", "cmm/error/dataAccessFailure");
		mappings.setProperty("org.springframework.transaction.TransactionException", "cmm/error/transactionFailure");
		mappings.setProperty("org.egovframe.rte.fdl.cmmn.exception.EgovBizException", "cmm/error/egovError");
		mappings.setProperty("org.springframework.security.AccessDeniedException", "cmm/error/accessDenied");

		simpleMappingExceptionResolver.setExceptionMappings(mappings);

		exceptionResolvers.add(simpleMappingExceptionResolver);
	}
	
	*/
	// -------------------------------------------------------------
	// View Resolver 설정
	// -------------------------------------------------------------
	/*
	 * @Bean public UrlBasedViewResolver urlBasedViewResolver() {
	 * UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
	 * urlBasedViewResolver.setOrder(URL_BASED_VIEW_RESOLVER_ORDER);
	 * urlBasedViewResolver.setViewClass(JstlView.class);
	 * urlBasedViewResolver.setPrefix(URL_BASED_VIEW_RESOLVER_PREFIX);
	 * urlBasedViewResolver.setSuffix(URL_BASED_VIEW_RESOLVER_SUFFIX); return
	 * urlBasedViewResolver; }
	 */

	// -------------------------------------------------------------
	// CORS 설정 추가
	// -------------------------------------------------------------
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("*.do").allowedOrigins(CORS_ORIGIN_SERVER_URLS);
//	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
	    registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");
	    registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
	    registry.addResourceHandler("/layout/**").addResourceLocations("classpath:/templates/layout/");
	    registry.addResourceHandler("/views/**").addResourceLocations("classpath:/templates/views/");
	    //registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/egovframework/templates/");
	}

	@Bean
	public SessionLocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("language");
		return interceptor;
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
		Properties prop = new Properties();
		prop.setProperty("org.springframework.dao.DataAccessException", "egovSampleError");
		prop.setProperty("org.springframework.transaction.TransactionException", "egovSampleError");
		prop.setProperty("org.egovframe.rte.fdl.cmmn.exception.EgovBizException", "egovSampleError");
		prop.setProperty("org.springframework.security.AccessDeniedException", "egovSampleError");
		prop.setProperty("java.lang.Throwable", "error/error");

		Properties statusCode = new Properties();
		statusCode.setProperty("error/error_400", "400");
		statusCode.setProperty("error/error_500", "500");
		statusCode.setProperty("error/error_400", "404");
		statusCode.setProperty("error/error_400", "403");
		statusCode.setProperty("error/error_500", "503");

		SimpleMappingExceptionResolver smer = new SimpleMappingExceptionResolver();
		smer.setDefaultErrorView("error/error");
		smer.setExceptionMappings(prop);
		smer.setStatusCodes(statusCode);
		resolvers.add(smer);
	}

}
