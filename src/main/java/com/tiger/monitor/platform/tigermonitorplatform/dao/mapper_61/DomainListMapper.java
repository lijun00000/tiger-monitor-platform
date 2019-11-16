package com.tiger.monitor.platform.tigermonitorplatform.dao.mapper_61;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface DomainListMapper {
    Integer countDomainByPageType( @Param("pageTypes")List<String> pageTypes);
}
