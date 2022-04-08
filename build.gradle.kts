import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.6"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
}

group = "io.github.akiyasui189"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2021.0.1"
extra["hystrixVersion"] = "2.2.10.RELEASE"
extra["mybatisVersion"] = "2.2.2"
extra["groovyVersion"] = "3.0.10"
//extra["groovyVersion"] = "4.0.1"
extra["spockVersion"] = "2.1-groovy-3.0"
//extra["spockVersion"] = "2.2-M1-groovy-4.0"

dependencies {
	// kotlin
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	// spring boot
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-cache")
	implementation("org.springframework.boot:spring-boot-starter-data-redis") {
		// using jedis instead of lettuce
		exclude("io.lettuce", "lettuce-core")
	}
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	// spring cloud
	implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
	implementation("org.springframework.cloud:spring-cloud-stream")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-hystrix:${property("hystrixVersion")}")
	// http client for open feign
	implementation("io.github.openfeign:feign-okhttp")
	implementation("io.github.openfeign:feign-hc5")
	// spring framework
	//implementation("org.springframework.retry:spring-retry")
	// database
	implementation("org.flywaydb:flyway-core")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:${property("mybatisVersion")}")
	runtimeOnly("mysql:mysql-connector-java")
	// nosql
	implementation("redis.clients:jedis")
	// monitoring
	implementation("io.micrometer:micrometer-registry-prometheus")
	// test (include junit5)
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	// groovy
	testImplementation("org.codehaus.groovy:groovy-all:${property("groovyVersion")}")
	//testImplementation("org.apache.groovy:groovy:${property("groovyVersion")}")
	// spock
	testImplementation("org.spockframework:spock-core:${property("spockVersion")}")
	testImplementation("org.spockframework:spock-spring:${property("spockVersion")}")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
