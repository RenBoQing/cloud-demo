package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author RenBoQing
 * @date 2022年05月09日 20:02
 * @Description
 */
@Data
@ConfigurationProperties(prefix = "pattern")
@Component
public class PatternProperties {
    private String enlSharedvalue;
}
