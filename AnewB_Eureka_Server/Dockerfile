FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
#使用idea docker 插件 push jar 文件 和 dockerfile 文件不在一起 因此需配置 为编译文件夹
ADD /target/MyEureka-0.0.1-SNAPSHOT.jar app.jar
ADD /target/classes/application.yml /conf/application.yml
ENV JAVA_OPTS=""
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN sh -c 'touch /app.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

EXPOSE 8500

