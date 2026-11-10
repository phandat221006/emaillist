# ==========================================
# Giai đoạn 1: Build mã nguồn thành file WAR
# ==========================================
FROM maven:3-eclipse-temurin-25 AS build

WORKDIR /app

# Copy pom.xml trước để tận dụng cache layer khi tải dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B || true

# Copy toàn bộ mã nguồn và thực hiện đóng gói WAR
COPY src ./src
RUN mvn clean package -DskipTests -B

# ==========================================
# Giai đoạn 2: Môi trường chạy Apache Tomcat 10.1
# ==========================================
FROM tomcat:10.1-jdk25-temurin

WORKDIR /usr/local/tomcat

# Xóa các ứng dụng mặc định trong thư mục webapps của Tomcat
RUN rm -rf webapps/*

# Copy file email.war đã build sang thư mục webapps dưới tên ROOT.war
# (ROOT.war giúp truy cập trực tiếp tại http://localhost:8080/)
COPY --from=build /app/target/email.war webapps/ROOT.war

# Mở cổng 8080
EXPOSE 8080

# Khởi chạy Tomcat
CMD ["catalina.sh", "run"]


# Khởi chạy Tomcat
CMD ["catalina.sh", "run"]