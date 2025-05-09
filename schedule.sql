-- 데이터베이스가 존재한다면 해당 데이터베이스를 사용하도록 설정 (선택 사항, MySQL 클라이언트에서 직접 USE db_name; 실행 가능)
-- USE your_database_name;

-- 기존에 'schedule' 테이블이 존재하면 삭제합니다. (개발 중 반복 테스트 시 유용)
DROP TABLE IF EXISTS schedule;

-- 'schedule' 테이블 생성
CREATE TABLE schedule (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '일정 고유 ID',
    todo VARCHAR(200) NOT NULL COMMENT '할일 내용',
    writer VARCHAR(50) NOT NULL COMMENT '작성자명',
    password VARCHAR(100) NOT NULL COMMENT '비밀번호',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
    modified_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시'
) COMMENT '일정 관리 테이블';

-- (선택 사항) 초기 테스트 데이터 삽입
-- 애플리케이션 실행 전, 또는 테스트를 위해 미리 데이터를 넣어두고 싶을 때 사용합니다.
INSERT INTO schedule (todo, writer, password, created_at, modified_at) VALUES
    ('스프링 부트 강의 완강하기', '홍길동', 'pass1234', '2024-05-01 10:00:00', '2024-05-01 10:00:00'),
    ('매일 TIL 작성하기', '이순신', 'securePW', '2024-05-02 14:30:00', '2024-05-02 15:00:00'),
    ('개인 과제 제출하기', '유관순', 'mysecret', '2024-05-03 09:00:00', '2024-05-03 09:15:00');

-- 데이터 확인 (선택 사항)
-- SELECT * FROM schedule;