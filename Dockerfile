FROM alpine

COPY build/native/nativeCompile/native-testing /native-testing

EXPOSE 8080

CMD ["/native-testing"]
