FROM debian:12-slim
USER root
RUN apt-get update && apt-get install -y docker.io curl

ARG TARGETARCH

# Install GraalVM SDK
ARG GRAALVM_VERSION=21.0.2
RUN if [ "$TARGETARCH" = "arm64" ]; then graalArch=aarch64; else graalArch=x64; fi; \
   curl -L https://github.com/graalvm/graalvm-ce-builds/releases/download/jdk-${GRAALVM_VERSION}/graalvm-community-jdk-${GRAALVM_VERSION}_linux-${graalArch}_bin.tar.gz | \
   tar xz -C /opt && ln -s /opt/graalvm-community-openjdk-${GRAALVM_VERSION}* /opt/graalvm-community-openjdk-${GRAALVM_VERSION}
ENV JAVA_HOME="/opt/graalvm-community-openjdk-${GRAALVM_VERSION}"
ENV PATH="$JAVA_HOME/bin:$PATH"

COPY ./ /native-testing
WORKDIR /native-testing
RUN chown -R root:root /native-testing
ENTRYPOINT ["/bin/bash"]
