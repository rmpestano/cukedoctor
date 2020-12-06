FROM openjdk:8u111-jre-alpine
ARG VERSION
ADD target/cukedoctor-main-$VERSION.jar cukedoctor.jar
ADD docker/entrypoint.sh /

VOLUME /output

ENV JAVA_OPTS=""

ENTRYPOINT ["/entrypoint.sh"]
