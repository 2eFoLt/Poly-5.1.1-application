from flask import Flask, render_template, request, session
from flask_login import LoginManager
from werkzeug.security import generate_password_hash
# check_password_hash
# from dbmanager import User
# import random
app = Flask(__name__)
app._static_folder = "static"
app.secret_key = generate_password_hash("IWasHere")
login_manager = LoginManager()
login_manager.init_app(app)


@login_manager.user_loader
def load_user(user_id):
    return session['cur_usr']


@app.route('/', methods=['GET', 'POST'])
def index():
    return render_template('newStartPage.html')


@app.route('/checkout', methods=['GET'])
def checkout():
    return render_template('newCheckoutPage.html')


@app.route('/login')
def login():
    if 'cur_usr' in session:
        render_template('newMainPage.html', login=session['cur_usr'])
    return render_template('newLoginPage.html')


@app.route('/log-success', methods=['POST'])
def success():
    if request.method == 'POST':
        email = request.form['email']
        passwd = request.form['password']
        if 'cur_usr' not in session:
            session['cur_usr'] = email
        return render_template('newMainPage.html', login=session['cur_usr'])
    else:
        pass


"""
Route template:
@app.route(<html-route>, <methods>)
def <html-name>():
    return render_template('<html-file')
"""
if __name__ == '__main__':
    app.run(
         host='0.0.0.0', port=5151
    )
