# VYBZ Admin Service

VYBZ 플랫폼의 관리자 서비스를 담당하는 마이크로서비스입니다.

## 📋 목차

-   [개요](#개요)
-   [기술 스택](#기술-스택)
-   [주요 기능](#주요-기능)
-   [프로젝트 구조](#프로젝트-구조)
-   [API 문서](#api-문서)
-   [설치 및 실행](#설치-및-실행)
-   [환경 설정](#환경-설정)
-   [아키텍처](#아키텍처)
-   [개발 가이드](#개발-가이드)

## 🎯 개요

VYBZ Admin Service는 다음과 같은 기능을 제공합니다:

-   **카테고리 관리**: 카테고리 CRUD 작업
-   **관리자 인증**: 관리자 계정 관리
-   **데이터 관리**: 플랫폼 데이터 관리
-   **API 제공**: 관리자용 REST API 제공
-   **서비스 디스커버리**: Eureka Client를 통한 서비스 등록
-   **API 문서화**: Swagger를 통한 API 문서 제공

## 🛠 기술 스택

### Backend

![Spring Cloud](https://img.shields.io/badge/Spring_Cloud-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![JPA](https://img.shields.io/badge/JPA-59666C?style=for-the-badge)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)

### Infra

![GitHub Actions](https://img.shields.io/badge/GitHub_Actions-2088FF?style=for-the-badge&logo=githubactions&logoColor=white)
![Amazon EC2](https://img.shields.io/badge/Amazon_EC2-FF9900?style=for-the-badge&logo=amazonaws&logoColor=white)
![Nginx](https://img.shields.io/badge/Nginx-009639?style=for-the-badge&logo=nginx&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

### 협업

![Discord](https://img.shields.io/badge/Discord-5865F2?style=for-the-badge&logo=discord&logoColor=white)
![Notion](https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=notion&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)

### Database

-   **MySQL 8.0**: 카테고리 및 관리자 데이터 저장

### Documentation

-   **Swagger/OpenAPI 3.0**: API 문서화

### Build & Deploy

-   **Gradle**: 빌드 도구
-   **Docker**: 컨테이너화

## 🚀 주요 기능

### 1. 카테고리 관리

-   **카테고리 추가**: 새로운 카테고리 생성
-   **카테고리 조회**: ID, 이름, 전체 카테고리 조회
-   **카테고리 수정**: 기존 카테고리 정보 수정
-   **카테고리 삭제**: 카테고리 삭제 (Soft Delete)

### 2. 관리자 계정 관리

-   **관리자 정보 관리**: 관리자 계정 정보 관리
-   **권한 관리**: 관리자 권한 설정

### 3. API 제공

-   **RESTful API**: 표준 REST API 제공
-   **응답 표준화**: 통일된 응답 형식 제공
-   **예외 처리**: 체계적인 예외 처리

### 4. 서비스 디스커버리

-   **Eureka Client**: 마이크로서비스 디스커버리에 등록
-   **서비스 등록**: 자동 서비스 등록 및 헬스체크

## 📁 프로젝트 구조

```
src/main/java/com/vybz/admin_service/
├── admin/                    # 관리자 도메인
│   └── domain/
│       └── Admin.java       # 관리자 엔티티
├── category/                 # 카테고리 도메인
│   ├── application/          # 카테고리 서비스 로직
│   │   ├── CategoryService.java
│   │   └── CategoryServiceImpl.java
│   ├── domain/               # 카테고리 도메인 모델
│   │   └── Category.java
│   ├── dto/                  # 카테고리 DTO
│   │   ├── request/
│   │   │   ├── RequestAddCategoryDto.java
│   │   │   ├── RequestDeleteCategoryDto.java
│   │   │   └── RequestUpdateCategoryDto.java
│   │   └── response/
│   │       └── ResponseCategoryDto.java
│   ├── infrastructure/       # 카테고리 리포지토리
│   │   └── CategoryRepository.java
│   ├── presentation/         # 카테고리 컨트롤러
│   │   └── CategoryController.java
│   └── vo/                   # 카테고리 VO
│       ├── request/
│       │   ├── RequestAddCategoryVo.java
│       │   ├── RequestDeleteCategoryVo.java
│       │   └── RequestUpdateCategoryVo.java
│       └── response/
│           └── ResponseCategoryVo.java
├── common/                   # 공통 모듈
│   ├── config/               # 설정 클래스들
│   │   └── SwaggerConfig.java
│   ├── entity/               # 공통 엔티티
│   │   ├── BaseEntity.java
│   │   ├── BaseResponseEntity.java
│   │   ├── BaseResponseStatus.java
│   │   └── SoftDeletableEntity.java
│   └── exception/            # 예외 처리
│       ├── AsyncExceptionHandler.java
│       ├── BaseException.java
│       ├── BaseExceptionHandler.java
│       └── BaseExceptionHandlerFilter.java
└── AdminServiceApplication.java
```

## 📚 API 문서

Swagger UI를 통해 API 문서를 확인할 수 있습니다:

-   **URL**: `http://localhost:8000/admin-service/swagger-ui.html`
-   **API 그룹**: Category-Service

### 주요 API 엔드포인트

#### 카테고리 API

-   `POST /api/v1/category` - 카테고리 추가
-   `GET /api/v1/category/{id}` - ID로 카테고리 조회
-   `GET /api/v1/category/search?name={name}` - 이름으로 카테고리 조회
-   `GET /api/v1/category/list` - 전체 카테고리 조회
-   `PUT /api/v1/category` - 카테고리 수정
-   `DELETE /api/v1/category` - 카테고리 삭제

### API 요청/응답 예시

#### 카테고리 추가 요청

```json
{
    "name": "음악"
}
```

#### 카테고리 추가 응답

```json
{
    "status": "SUCCESS",
    "message": "요청이 성공적으로 처리되었습니다.",
    "data": null
}
```

#### 카테고리 조회 응답

```json
{
    "status": "SUCCESS",
    "message": "요청이 성공적으로 처리되었습니다.",
    "data": {
        "id": 1,
        "name": "음악",
        "createdAt": "2024-01-01T00:00:00",
        "updatedAt": "2024-01-01T00:00:00"
    }
}
```

#### 전체 카테고리 조회 응답

```json
{
    "status": "SUCCESS",
    "message": "요청이 성공적으로 처리되었습니다.",
    "data": [
        {
            "id": 1,
            "name": "음악",
            "createdAt": "2024-01-01T00:00:00",
            "updatedAt": "2024-01-01T00:00:00"
        },
        {
            "id": 2,
            "name": "미술",
            "createdAt": "2024-01-01T00:00:00",
            "updatedAt": "2024-01-01T00:00:00"
        }
    ]
}
```

#### 카테고리 수정 요청

```json
{
    "id": 1,
    "name": "음악/댄스"
}
```

#### 카테고리 삭제 요청

```json
{
    "id": 1
}
```

## 🚀 설치 및 실행

### 1. 사전 요구사항

-   Java 17
-   Gradle 8.4+
-   Docker (선택사항)
-   MySQL 8.0

### 2. 로컬 실행

```bash
# 프로젝트 클론
git clone <repository-url>
cd vybz-admin

# Gradle 빌드
./gradlew clean build

# 애플리케이션 실행
./gradlew bootRun
```

### 3. Docker 실행

```bash
# Docker 이미지 빌드
docker build -t vybz-admin-service .

# Docker 컨테이너 실행
docker run -p 8080:8080 vybz-admin-service
```

## ⚙️ 환경 설정

### 주요 설정 파일

-   `application.yml`: 기본 설정
-   `application-dev.yml`: 개발 환경 설정
-   `application-db.yml`: 데이터베이스 설정

### 환경 변수

```yaml
# 데이터베이스 설정
spring:
  datasource:
    url: jdbc:mysql://${DB_HOST}:${DB_PORT}/admin_service?useSSL=true&allowPublicKeyRetrieval=true&serverTimezone=Asia/Seoul
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
```

## 🏗️ 아키텍처

### Hexagonal Architecture (Clean Architecture)

-   **Domain Layer**: 카테고리, 관리자 도메인 모델과 비즈니스 로직
-   **Application Layer**: 카테고리 서비스 로직과 유스케이스
-   **Infrastructure Layer**: 데이터베이스 접근과 외부 시스템 연동
-   **Presentation Layer**: REST API 엔드포인트

### 마이크로서비스 패턴

-   **Service Discovery**: Eureka Client를 통한 서비스 등록
-   **Stateless**: 상태 없는 서비스 설계
-   **API Gateway**: 통합 API 게이트웨이 연동

### 데이터베이스 설계

-   **MySQL**: 카테고리, 관리자 정보 저장
-   **Soft Delete**: 논리적 삭제 지원
-   **Auditing**: 생성/수정 시간 자동 관리

### 공통 모듈

-   **BaseEntity**: 공통 엔티티 속성
-   **BaseResponseEntity**: 통일된 응답 형식
-   **BaseException**: 체계적인 예외 처리
-   **SwaggerConfig**: API 문서화 설정

## 🔧 개발 가이드

### 코드 컨벤션

-   **패키지 구조**: 도메인별 계층 분리
-   **네이밍**: 명확하고 일관된 네이밍 규칙
-   **예외 처리**: BaseException을 통한 통일된 예외 처리
-   **로깅**: Slf4j를 통한 구조화된 로깅

### DTO/VO 패턴

-   **DTO**: 내부 서비스 간 데이터 전송
-   **VO**: 외부 API 요청/응답 데이터
-   **변환 메서드**: DTO ↔ VO 변환 메서드 제공

### 테스트

```bash
# 단위 테스트 실행
./gradlew test

# 통합 테스트 실행
./gradlew integrationTest
```

### 빌드

```bash
# Gradle 빌드
./gradlew clean build

# JAR 파일 생성
./gradlew bootJar
```

빌드된 JAR 파일은 `build/libs/` 디렉토리에 생성됩니다.

## 📝 라이선스

이 프로젝트는 VYBZ 팀의 내부 프로젝트입니다.

## 👥 팀

-   **개발팀**: VYBZ Backend Team

---

**VYBZ Admin Service** - 효율적인 관리자 서비스
