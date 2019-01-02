FROM openjdk:8u111-jre-alpine

ADD target/cukedoctor*.jar cukedoctor.jar
ADD docker/entrypoint.sh /

VOLUME /output

ENV JAVA_OPTS=""

ENTRYPOINT ["/entrypoint.sh"]
