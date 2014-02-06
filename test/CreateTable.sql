CREATE TABLE IF NOT EXISTS lyrics(
  lyric_id INTEGER PRIMARY KEY AUTOINCREMENT,
  title TEXT,
  subtitle TEXT
);

CREATE TEMP TABLE IF NOT EXISTS strophes(
  strophe_id INTEGER PRIMARY KEY ASC ON CONFLICT ROLLBACK,
  lyric_id   INTEGER,
  annotation TEXT NOT NULL,
  content    TEXT UNIQUE,
  is_bold    TINYINT CHECK(is_bold = 1),
  FOREIGN KEY (lyric_id) REFERENCES lyrics(lyric_id) ON DELETE CASCADE
);

CREATE TEMPORARY TABLE main.tags(
  tag_id   INTEGER PRIMARY KEY DESC AUTOINCREMENT,
  name TEXT DEFAULT 'def'
);

CREATE TABLE IF NOT EXISTS main.lyrics_tags(
  lyric_id INTEGER DEFAULT 1,
  tag_id CONSTRAINT tag_k,
  PRIMARY KEY (lyric_id, tag_id),
  FOREIGN KEY (lyric_id) REFERENCES lyrics(lyric_id) ON DELETE CASCADE,
  FOREIGN KEY (tag_id) REFERENCES tags(tag_id) ON DELETE CASCADE
);

CREATE TABLE select_table AS
  SELECT;