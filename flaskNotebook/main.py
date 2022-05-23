from flask import Flask, render_template, request, session, redirect, url_for
from bd_config import Config
from flask_sqlalchemy import SQLAlchemy
from werkzeug.security import generate_password_hash
from dbmanager import add_user, User
import random

app = Flask(__name__)
app._static_folder = "static"
app.secret_key = generate_password_hash("IWasHere")
app.config.from_object(Config)
db = SQLAlchemy(app)


@app.route('/', methods=['GET', 'POST'])
def index():
    if 'email' in session:
        return redirect(url_for('main'))
    else:
        return render_template('newStartPage.html')


@app.route('/checkout', methods=['GET'])
def checkout():
    return render_template('newCheckoutPage.html')


@app.route('/login')
def login():
    if 'email' in session:
        return redirect(url_for('main'))
    return render_template('newLoginPage.html')


@app.route('/main')
def main():
    if 'email' in session:
        return render_template('newMainPage.html', login=session['name'])
    else:
        return redirect(url_for('login'))


@app.route('/user', methods=['GET'])
def user_page():
    if 'email' in session:
        return render_template('user_page.html', first_name=session['name'], second_name=session['surname'],
                               login=session['email'])
    else:
        return redirect(url_for('login'))


@app.route('/logout')
def logout():
    session.pop('email', None)
    session.pop('hash', None)
    session.pop('id', None)
    session.pop('name', None)
    return redirect(url_for('index'))


@app.route('/log-success', methods=['POST'])
def success():
    if request.method == 'POST':
        name = request.form['name']
        email = request.form['email']
        pswd_hash = generate_password_hash(request.form['password'])
        userid = random.randint(1, 1000)
        if email not in session:
            session['email'] = email
            session['surname'] = name.split(' ')[0]
            session['name'] = name.split(' ')[1]
            session['hash'] = pswd_hash
            session['id'] = userid
        user_found = User.query.filter_by(email=email).first()
        if user_found is None:
            add_user(userid, name, email, pswd_hash)
            print('new_user')
        else:
            print('user_exists')
            pass
        return redirect(url_for('main'))
    else:
        pass


"""
Route template:
@app.route(<html-route>, <methods>)
def <html-name>():
    return render_template('html-file')
"""
if __name__ == '__main__':
    app.run(
         # host='0.0.0.0', port=5151
    )
