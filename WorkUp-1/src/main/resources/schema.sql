-- テーブルが既に存在する場合に削除
DROP TABLE IF EXISTS jquery_validate CASCADE;
DROP TABLE IF EXISTS contents_status_root CASCADE;

-- JQuery動作確認用
CREATE TABLE jquery_validate (
    id serial NOT NULL PRIMARY KEY,
    name varchar(255) UNIQUE NOT NULL
);

-- Cache動作確認用
CREATE TABLE contents_status_root (
    id serial NOT NULL PRIMARY KEY,
    status status_type NOT NULL
);
