FROM quay.io/riku_hashiki/tomcat:9.0-jdk17 AS build-env
RUN rm -rvf /usr/local/tomcat/webapps/ROOT

ENV BASEDIR /usr/local/tomcat

RUN mkdir ${BASEDIR}/project && \
    mkdir ${BASEDIR}/project/src && \
    mkdir ${BASEDIR}/project/WebContent
COPY ./src/main/java ${BASEDIR}/project/src
COPY ./src/main/webapp ${BASEDIR}/project/WebContent
COPY ./src/main/webapp/WEB-INF/lib/*.jar ${BASEDIR}/lib/
COPY ./build.sh ${BASEDIR}/project
RUN chmod -R 777 ${BASEDIR}/project/src && \
    chmod -R 777 ${BASEDIR}/project/WebContent && \
    chmod +x ${BASEDIR}/project/build.sh && \
    sed -i 's/\r//' ${BASEDIR}/project/build.sh

RUN cd ${BASEDIR}/project/ && ./build.sh

RUN cd ${BASEDIR}/project/ && jar cvf .war -C WebContent .
RUN cp -p ${BASEDIR}/project/.war ${BASEDIR}/webapps/

FROM quay.io/riku_hashiki/tomcat:9.0-jre17
RUN apt-get update && \
    apt-get install -y --no-install-recommends && \
    apt-get upgrade -y --allow-unauthenticated && \
    apt-get clean -y && \
    rm -rvf /usr/local/tomcat/webapps
ENV BASEDIR /usr/local/tomcat

COPY --from=build-env ${BASEDIR}/project ${BASEDIR}/project
COPY --from=build-env ${BASEDIR}/webapps ${BASEDIR}/webapps

EXPOSE 8080
