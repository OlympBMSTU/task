CREATE TABLE excercieses (
  id SERIAL PRIMARY KEY,
  question TEXT,
  answers TEXT[],
  rightAnswers TEXT[],
  image TEXT,
  type_ TEXT,
  level_ INTEGER
)