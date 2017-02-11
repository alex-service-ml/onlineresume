package me.onlineresu.config;

import me.onlineresu.converters.PersonalDetailsConverter;
import me.onlineresu.converters.ResumeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

// Customization only needed for local.
// spring.thymeleaf.template-location defines the file-path for templates
@Configuration("local")
public class ThymeleafConfig extends WebMvcConfigurerAdapter{
    private final ThymeleafProperties properties;

    @Value("${resume.template-path}")
    private String templatePath;

    @Value("${resume.resource-path}")
    private String resourcePath;

    private final ResumeConverter resumeConverter;

    @Autowired
    public ThymeleafConfig(ThymeleafProperties properties, ResumeConverter resumeConverter, PersonalDetailsConverter personalDetailsConverter) {
        this.properties = properties;
        this.resumeConverter = resumeConverter;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/**")
                .addResourceLocations("file:///" + resourcePath)
                .setCachePeriod(0);
    }

    @Bean
    public ITemplateResolver defaultTemplateResolver() {
        TemplateResolver resolver = new FileTemplateResolver();
        resolver.setSuffix(properties.getSuffix());
        resolver.setPrefix(templatePath);
        resolver.setTemplateMode(properties.getMode());
        resolver.setCharacterEncoding(properties.getEncoding().toString());
        resolver.setCacheable(properties.isCache());
        return resolver;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(resumeConverter);
    }
}