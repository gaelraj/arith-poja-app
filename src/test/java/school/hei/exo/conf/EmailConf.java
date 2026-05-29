package school.hei.exo.conf;

import org.springframework.test.context.DynamicPropertyRegistry;
import school.hei.exo.PojaGenerated;

@PojaGenerated
public class EmailConf {

  void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("aws.ses.source", () -> "dummy-ses-source");
  }
}
