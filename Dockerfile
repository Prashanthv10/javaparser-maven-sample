#jboss/wildfly
FROM prashanthprv/base_image_1:version1.0
ADD target/*.jar /opt/jboss/wildfly/standalone/deployments/
RUN ls -ltr /opt/jboss/wildfly/bin #temparary
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
