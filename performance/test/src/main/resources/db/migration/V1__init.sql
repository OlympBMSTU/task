CREATE TABLE excercieses (
  id SERIAL PRIMARY KEY,
  question TEXT,
  answers json[],
  rightAnswers json[],
  image TEXT,
  type_ TEXT,
  level_ INTEGER
)