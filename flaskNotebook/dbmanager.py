from flask_sqlalchemy import SQLAlchemy
from flask import Flask
from bd_config import Config
app = Flask(__name__)
app.config.from_object(Config)
db = SQLAlchemy(app)
db.create_all()


class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(80), unique=True, nullable=False)
    email = db.Column(db.String(120), unique=True, nullable=False)
    passwd_hash = db.Column(db.String(280), nullable=False)

    def __repr__(self):
        return '<User %r>' % self.username


def add_user(userid, username, email, pswd_hash):
    user_object = User(id=userid, username=username, email=email, passwd_hash=pswd_hash)
    db.session.add(user_object)
    db.session.commit()

