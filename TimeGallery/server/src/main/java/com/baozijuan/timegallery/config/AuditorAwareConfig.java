package com.baozijuan.timegallery.config;

import com.baozijuan.timegallery.bean.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class AuditorAwareConfig implements AuditorAware<User> {

    @Override
    public Optional<User> getCurrentAuditor() {
        return Optional.empty();
    }

}
