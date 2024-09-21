-- bean動作確認用テーブル
CREATE TABLE IF NOT EXISTS root_bean (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  beantext varchar(255) NOT NULL
);

-- トランザクション検証用ゲームポイントテーブル
CREATE TABLE IF NOT EXISTS root_gamepoint (
  user_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  point int NOT NULL
);

-- トランザクション管理用テーブル
CREATE TABLE IF NOT EXISTS plugin_gamepoint_transaction (
  user_id int NOT NULL ,
  change_point int NOT NULL ,
  description varchar(255) NOT NULL,
  transactional_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  FOREIGN KEY (user_id) REFERENCES root_gamepoint(user_id) ON DELETE CASCADE
);

-- 認可検証用シークレット情報格納テーブル
CREATE TABLE IF NOT EXISTS root_secret_infomation (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  info varchar(255) NOT NULL
);


